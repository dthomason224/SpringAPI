# Image API:
## Description:
## Use Cases:
## ERD Diagram:
![Diagram](Project_ERD)
## Endpoints:
|Request Type|URL|Body|Header|Description|Access|
|---|---|---|---|---|---|
|POST|/api/auth/users/register/|username, email, password, createdAt|none|creates new user|Public|
|POST|/api/auth/users/login/|email, password|JPA token|user login|Private|
|POST|/api/tags/|name|none|creates new tag|Public|
|GET|/api/tags/|none|none|get all tags|Public|
|GET|/api/tags/{tagId}/|none|none|get tag by tagId|Public|
|PUT|/api/tags/{tagId}/|name|none|update specified tag by id|Public|
|DELETE|/api/tags/{tagId}/|none|none|delete specified tag by id|Public|
|POST|/api/images/|title, createdAt, views|none|creates image|Public|
|GET|/api/images/|none|none|get all images|Public|
|GET|/api/images/{imageId}/|none|none|get specified image by id|Public|
|PUT|/api/images/{imageId}/|title, views|none|update specified image|Public|
|DELETE|/api/images/{imageId}/|none|none|delete specified image by id|Public|
|POST|/api/images/{imageId}/tags/{tagId}/|none|none|adds new tag to image|Public|
|POST|/api/user/{userId}/image/{imageId}/|none|none|add user to image|Public|
|POST|/api/user/profile/|firstName, lastName|none|creates new user profile|Public|
|POST|/api/user/{userId}/profile/{profileId}/|none|none|adds user profile to user|Public|
|PUT|/api/user/profile/{profileId}/|firstName, lastName|none|updates specified user profile by id|Public|
|DELETE|/api/user/profile/{profileId}/|none|none|deletes user profile by id|Public|
|GET|/api/user/{userId}/|none|none|gets specified user by id|Public|
## Problems
## Future
