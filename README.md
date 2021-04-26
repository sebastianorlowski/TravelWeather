# TravelWeather - In process...

Restful application about planning journey and show current and future weather in place where you go.

## Tools
* Spring Boot
* Hibernate
* Maven
* mySQL

## Features

- registration user
- authentication process by JWT
- authentication user can add trips and destinations inside this trip
- crud operations on trips and destionations
- connect with external API (weatherapi.com)
- send to user information about weather in his destinations(in process...)

## Code Examples
Registration by JSON:
/api/v1/registration
Post request:
* {
*  "email": "string",
*  "id": 0,
*  "password": "string",
*  "username": "string"
* }

Add destination by JSON:
* {
*  "day": 0,
*  "hours": 0,
*  "id": 0,
*  "month": 0,
*  "place": "string",
*  "year": 0
}

## Status
Project is: _in progress_.

In future add front-end and upload to heroku.

