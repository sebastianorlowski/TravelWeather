# TravelWeather - In process...

Restful application about planning journey and show current and future weather in place where you go.

## Description
Always when you going for journey you will check current and future weather in this place. Applications which offers view to weather in one place just working for one city on this time. This application will offer you add your trip and there is possible to add few destinations. You will get information about weather 72 hours forward hour by hour, for few places on one time.

Example.

You start your journey from Airport in Warsaw. Your aircraft start 10 may at 8 am and will arrive 10 am in Paris this same day. Next day you will fly to Madrid and you decide stay there to next day where you will fly to London. By this Application you can add this places with dates and see whats weather will be there. Also you will get information about weather few hours before your target.


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
- send to user information about weather in his destinations


## Setup

You need to have IDE(e.g. Intellij), unpacked Maven, mySQL.
- Upload application, go to application.properties.
- Make sure you are
    spring.jpa.hibernate.ddl-auto=create
    (After first start you can change it for update/validate)
  
- Go to weatherapi.com and generate your own API KEY.
- Paste it to 'api.key=' in application.properties
- Next step is you need to create database for app in mySQL, after doing this go to application.properties
  change code below:
  spring.datasource.url=jdbc:mysql://
  localhost:3306/{yourdatabasename}?serverTimezone=Europe/Warsaw&useLegacyDatetimeCode=true
    in 'yourdatabasename' change it for your database
  
- Now you can start app and test it in swagger(front-end in progress).

Account to first login: 
Login: test123
Password: Test12345

You can create your own account by api/v1/registration path.

After login, you can add trips and destinations to this trips.
If youre ready for you trip you can generate 3 days before start weather in this place,
hour by hour for three days. 

e.g. If you add two, three or more destinations for 3 days then
application will generate weather for every location 3 days before date which you add to destination.


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
*   "date": "string",
*   "id": 0,
*   "place": "string"
* }

## Status
Project is: _in progress_.

In future add front-end and upload to heroku.

