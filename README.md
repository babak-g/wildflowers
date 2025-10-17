# Wildflowers of Mt. Rainier - REST API

Take-home assignment for Health-e Pro.

## Overview

This project implements RESTful API endpoints for displaying and filtering wildflowers of Mt. Rainier by color, elevational zone, and scientific name.

## Project Structure

```
WILDFLOWERS/
├── README.md                          # This file
├── pom.xml                            # Maven configuration
├── tasks/
│   ├── 1/
│   │   └── wildflowers_schema.sql    # Task 1: Database schema design
│   ├── 3/
│   │   └── example_responses.json    # Task 3: Example API payloads
│   └── 4/
│       └── design_explanation.md     # Task 4: Schema and design choices
└── src/                               # Task 2: API implementation
    └── main/
        ├── java/com/wildflowers/
        │   ├── WildflowerApplication.java
        │   ├── controller/
        │   ├── dto/
        │   ├── model/
        │   ├── repository/
        │   └── service/
        └── resources/
            └── application.properties
```

## Running the Application

**Prerequisites:**

- Java 17+
- Maven 3.6+

**To run:**

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

**Test endpoints:**

```bash
# Get all wildflowers
curl "http://localhost:8080/wildflowers"

# Filter by color
curl "http://localhost:8080/wildflowers?color=blue"

# Filter by zone
curl "http://localhost:8080/wildflowers?zone=subalpine"

# Filter by scientific name
curl "http://localhost:8080/wildflowers?scientific_name=Lupinus"

# Get single wildflower
curl "http://localhost:8080/wildflowers/1"
```

## API Endpoints

### `GET /wildflowers`

Returns all wildflowers, with optional filtering via query parameters:

- `color` - Filter by color (e.g., blue, yellow, white)
- `zone` - Filter by elevational zone (e.g., subalpine, montane, lowland)
- `scientific_name` - Filter by scientific name (partial match)

### `GET /wildflowers/:id`

Returns details for a single wildflower by ID.

## Implementation Details

The code follows a clean layered architecture:

- **Controller Layer**: REST endpoint handlers
- **Service Layer**: Business logic and data transformation
- **Repository Layer**: Data access with in-memory storage
- **Model Layer**: Domain entities
- **DTO Layer**: API response objects

See `src/main/java/com/wildflowers/` for the complete implementation.

## Tasks Completed

1. ✅ **Schema Design** - See `tasks/1/wildflowers_schema.sql`
2. ✅ **API Implementation** - See `src/main/java/com/wildflowers/`
3. ✅ **Example Payloads** - See `tasks/3/example_responses.json`
4. ✅ **Design Explanation** - See `tasks/4/design_explanation.md`

## Notes

- The majority of boilerplate code was generated with assistance from Claude AI
- Data storage uses in-memory HashMaps (mock persistence)
- Sample data includes authentic Mt. Rainier wildflower species
- Date formatting follows "Month Day" pattern (e.g., "July 1")

## Author

Bobby
October 2025
