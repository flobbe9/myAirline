# myAirline
Portfolio project simulating a flight booking system.<br>
Api uses React.js for frontend, Spring-Boot for backend and Postgres as database. 

Features not yet included: 
- User login/register
- Generating pdf ticket and sending it to email adress
- Admin pages for altering flight data

## Run
1. ```docker-compose up``` with 'docker-compose.yml' file from this repo.
2. Go to http://localhost:3000.
3. Searches  that'll work: <br> 
- Berlin airport -> Dortmund airport
- Muenchner airport -> Hamburg airport
- Dresden airport -> Muenchner airport
- Hannover airport -> Nuernberg airport
- Erfurt airport -> Koeln airport
- Friedrichshaven airport -> Mannheim airport

## Postman
<a href="https://www.postman.com/grey-shuttle-863417/workspace/myairline/collection/23751197-f9d2f14d-902a-4721-99b2-2fc597c86abe?action=share&creator=23751197">myAirlineCollection</a>

## GitHub
Backend: 
- https://github.com/flobbe9/myAirline-flightService 
- https://github.com/flobbe9/myAirline-userService

Frontend: 
- https://github.com/flobbe9/myAirline-frontend 


## Docker images
Backend: <br>
```docker pull flobbe9/myairline-flightservice``` <br>
```docker pull postgres```

Frontend: <br>
```docker pull flobbe9/myairline-frontend```