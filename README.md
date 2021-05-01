# TravelWeather - In process...

Restful application about planning journey and show current and future weather in place where you go.

## Description
Always when you going for journey you will check current and future weather in this place. Applications which offers view to weather in one place just working for one city on this time. This application will offer you add your trip and there is possible to add few destinations. You will get information about weather 72 hours forward hour by hour, for few places on one time.

Example.

You start your journey frow Airport in Warsaw. Your aircraft start 10 may at 8 am and will arrive 10 am in Paris this same day. Next day you will fly to Madrid and you decide stay there to next day where you will fly to London. By this Application you can add this places with dates and see whats weather will be there. Also you will get information about weather few hours before your target.


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

