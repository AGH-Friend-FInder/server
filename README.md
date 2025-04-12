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
  "group_name": "string",
  "is_public": "bool"
}

```

GET /groups/{id} to get a group by ID


