package com.example.empikzadanierekrutacyjne.service;

import com.example.empikzadanierekrutacyjne.model.User;
import com.example.empikzadanierekrutacyjne.model.UserNotFoundException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class UserService {
    public User getUserViaLogin(String login) throws IOException {
        // Construct the URL for the GitHub API
        String apiUrl = "https://api.github.com/users/" + login;
        URL url = new URL(apiUrl);

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        // Check for a successful response code (200 OK)
        if (connection.getResponseCode() != 200) {
            throw new UserNotFoundException("Failed to retrieve data from GitHub API: " + connection.getResponseCode());
        }

        // Read the response from the API
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return createUserOfJson(new JSONObject(content.toString()), login);

        } finally {
            connection.disconnect();
        }
    }

    private User createUserOfJson(JSONObject userJson, String searchedLogin) throws UserNotFoundException {
        User user = new User();
        user.setLogin(searchedLogin);
        user.setId(userJson.optLong("id", 0));
        user.setName(getStringOrDefault(userJson, "name", "not_found"));
        user.setType(getStringOrDefault(userJson, "type", "not_found"));
        user.setAvatarUrl(getStringOrDefault(userJson, "avatar_url", "not_found"));
        user.setCreatedAt(getStringOrDefault(userJson, "created_at", "not_found"));
        user.setCalculations(userJson.optLong("followers", 0), userJson.optLong("public_repos", 0));

        return user;
    }

    private String getStringOrDefault(JSONObject jsonObject, String key, String defaultValue) {
        return jsonObject.optString(key, defaultValue);
    }
}
