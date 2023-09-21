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

