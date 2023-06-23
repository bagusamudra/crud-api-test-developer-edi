# Data User API Spec

## Insert Data User

Endpoint : POST /api/users

Request Body :

```json
{
  "data": {
    "userid": "43f0e647-9b2d-4a60-86a0-62e79c96622b",
    "namalengkap": "Joko Kendil",
    "username": "joko123",
    "password": "rahasia",
    "status": "Active"
  },
  "errors": null
}
```

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Invalid Data"
}
```

## Get Data User

Endpoint : GET /api/users/current

Response Body (Success) :

```json
{
  "data" : {
    "username" : "bagusamudra",
    "name" : "Bagus Adji Samudra"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors" : "Unauthorized"
}
```

## Delete Data User

Endpoint : DELETE /api/auth/delete

Response Body (Success) :

```json
{
  "data" : "OK"
}
```