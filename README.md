# myAirline
Portfolio project simulating a flight booking system.<br>
Api uses React.js for frontend, Spring-Boot for backend and MySQL as database. 

Features not yet included: 
- User login/register
- Generating pdf ticket and sending it to email adress
- Admin pages for altering flight data

## Run
1. > ```docker-compose up```

with 'docker-compose.yml' file from this repo.

2. Got to http://localhost:3000.


## Postman
Some endpoints: <br>
https://www.postman.com/grey-shuttle-863417/workspace/myairline/collection/23751197-f9d2f14d-902a-4721-99b2-2fc597c86abe?action=share&creator=23751197


## GitHub
Backend: 
- https://github.com/flobbe10/myAirline-flightService 
- https://github.com/flobbe10/myAirline-userService

Frontend: 
- https://github.com/flobbe10/myAirline-frontend 


## Docker
Backend:
> ```docker pull flobbe10/myairline-flightservice```

> ```docker pull flobbe10/myairline-db```

Frontend: 
> ```docker pull flobbe10/myairline-frontend```