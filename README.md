# PinPals server




## enpoints
### GET /users/{id} to get a user by ID

```
http://localhost:8080/users/{id}
```
Response 
```json
{
  "id": "number",
  "email": "string",
  "username": "string",
  "password": "string"
}

```

### POST /users to create a user
```
http://localhost:8080/users
```
Request:
```json
{
  "email": "string",
  "username": "string",
  "password": "string"
}
```


### GET /groups/{id} to get a group by ID
```
http://localhost:8080/group/{id}
```
Response:
```json
{
  "id": "number",
  "color": "string",
  "groupName": "string",
  "isPublic": "bool"
}

```

### GET /groups/public to get list of public groups
```
http://localhost:8080/groups/public
```
Response:
```json
[{
  "id": "number",
  "color": "string",
  "groupName": "string",
  "isPublic": "bool"
}, ...]
```

### POST /users/register to register user
```
http://localhost:8080/users/register
```
Request:
```json
{
"email": "string",
"username": "string",
"password": "string"
}
```
Response:
```json
{
  "id": 999,
  "email": "string",
  "username": "string",
  "password": "string",
  "groups": []
}
```

### POST /users/logic to register user
```
http://localhost:8080/users/login
```
Either email or username must be provided

Request:
```json
{
"email": "string",
"username": "string",
"password": "string"
}
```
Response:
```json
{
  "id": 999,
  "email": "string",
  "username": "string",
  "password": "string",
  "groups": []
}
```
### GET /pin/{id}

```
http://localhost:8080/pin/{id}

```

Response:
```json
{
  "id": "number",
  "numberOfPeople":"number",
  "pin": "string",
  "latitude": "number",
  "longitude": "number",
  "expireAt": "date"
}

```
### DELETE pin/{id}

```
http://localhost:8080/pin/{id}

```

### GET pin/visible/{user_id} 
get pins visible for a user with {id}

```
http://localhost:8080/pin/visible/{id}
```

Response:
```
[
    {
        "id": 1,
        "numberOfPeople": 3,
        "pin": "piwo piwo",
        "latitude": 123.0,
        "longitude": 123.0,
        "expireAt": "2025-04-13T13:24:14.000+00:00"
    }, 
    ... 
]
```

### GET users/group/{user_id}

get user groups
```
http://localhost:8080/users/group/{id}
```

Response:
```json
[
    {
        "id": "number",
        "groupName": "string",
        "isPublic": "bool",
        "color": "255.255.255"
    },
  ...
]
```

### POST /pin

```
http://localhost:8080/users/group/{id}
```

Request:
```json
{
    "numberOfPeople":"number",
    "hostUserId": "number",
    "pin":"string",
    "latitude": "number",
    "longitude":"number",
    "expireAtMinutes":"number",
    "groupsId":"list<number>"
}
```
### POST /groups

```
http://localhost:8080/groups
```

Request
```
{
"groupName": "string",
"isPublic": true,
"color": "255.255.255"
}
```

### POST users/{user_id}/{group_id}"

```
http://localhost:8080/users/{user_id}/{group_id}
```

### POST users/{user_id}/{group_id}"

```
http://localhost:8080/users/{user_id}/{group_id}
```
