# Mission Control: Satellite-Astronaut Tracker

A Java Spring Boot application for managing astronauts, satellites, and their assignments.

---

## Overview
- Built with Java 21, Spring Boot, JPA, PostgreSQL
- Tracks many-to-many assignments between astronauts and satellites
- Validations, DTOs, and exception handling included

---

## Run PostgreSQL via Docker
```bash
docker compose up -d
```

- DB: `missiondb`
- Port: `5435`

---

## API Endpoints

### Astronauts
- `POST /api/v1/astronauts`
- `GET /api/v1/astronauts`

### Satellites
- `POST /api/v1/satellites`
- `PUT /api/v1/satellites/{id}`
- `GET /api/v1/satellites`

---

##  Testing with Postman
Screenshots are available in `postman-screenshots/`:
- GET astronauts (empty)
- POST satellite
- POST astronaut with satellites

---

##  Run the App
```bash
./gradlew bootRun
```

Then open Postman:
```
GET http://localhost:8080/api/v1/astronauts
```

---

##  Repo Submission
- GitHub: https://github.com/jamesbali/mission-control
- 

