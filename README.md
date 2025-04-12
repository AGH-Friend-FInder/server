# PinPals server


POST /users to create a user

GET /users/{id} to get a user by ID

POST /groups to create a group

GET /groups/{id} to get a group by ID

## enpoints
### GET /users/{id} to get a user by ID
zwracana odpowiedź
```json
{
  "id": "number",
  "email": "string",
  "username": "string",
  "password": "string"
}

```

### POST /users to create a user
zapytanie w formie:
```json
{
  "email": "string",
  "username": "string",
  "password": "string"
}
```


### GET /groups/{id} to get a group by ID
zwracana odpowiedź
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


