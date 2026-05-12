# Mars Rover Project

A full-stack Mars Rover simulation built using Spring Boot, HTML, CSS, and JavaScript.

## Features
- Move rover using commands
- 10x10 visual grid
- Direction indicators
- Reset rover
- REST APIs

## Technologies Used
- Java
- Spring Boot
- HTML
- CSS
- JavaScript
- Maven

## Commands
- F → Move Forward
- L → Turn Left
- R → Turn Right

## API Endpoints

GET /api/status

POST /api/move?commands=FFRFF

POST /api/reset

## Run Project

```bash
mvn spring-boot:run
```

