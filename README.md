# General 

## Tech stack:
- Java 17
- Spring boot
- Gradle
- H2 in-memory database as it made sense for test assingnment, easier to test - but can switch to any other if needed

## From author
This is very simple solution to provided requirements - it can be extended by:

- adding load balancing in code (but recommended to use ready solutions)
- placing the Github API information to separate config file
- prevent DDOS by implementing Cloudflare like request filtering
- Docker image for quick deploy
- Feature branches on Github for rollback option
- admin token to alter the config via API 
- security measures for parsing the logins input from users
- more security to check github API - if it's up, if the current URLs are correct etc.
- API for changing the Github API source
- API for deleting the users from repository
- API for altering the users in repository
- API for displaying the current sources
- API for statistics etc.

Generally there are countless of improvements to be added, but I have followed strictly the requirements of the task to:
- reduce the time needed for bringing the value of the product (time-to-market)
- reduce the cost of the product

# Quick test URLs
## http://localhost:8080/users/octocat

`{
  "id": 583231,
  "login": "octocat",
  "name": "The Octocat",
  "type": "User",
  "avatarUrl": "https://avatars.githubusercontent.com/u/583231?v=4",
  "createdAt": "2011-01-25T18:44:36Z",
  "calculations": 0.00571646341463415
}`

### http://localhost:8080/users/octocat111111

`Could not find user Failed to retrieve data from GitHub API: 404`

## http://localhost:8080/users/statistics/583231
*additional feature to check the database saving, remember to use githubId not login*

`{"login":"octocat","requestCount":2}`

## http://localhost:8080/users/statistics/123
*additional feature to check the database saving*

`null`

## http://localhost:8080/users/statistics/abc
*known issue with additional feature to check the database saving*

non-Long value will result in error, but not fixing as feature is only for testing 

