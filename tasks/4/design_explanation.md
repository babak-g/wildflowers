# Design Explanation

As mentioned in the README, I used Claude AI for the general boilerplate code and some personal, deep-dive design questions. This design explanation file is entirely written by me (you'll probably notice the more you read, so please excuse my typos lol)

## Task 1: Schema Design

Firstly, I started with how I wanted to structure the schema. The immediate questions that came to mind were:

**(1) Could a Wildflower have more than one color and are they mutable?**
i.e. Could a Wildflower be White, Brown, Blue, Red, Green? I've seen some beautiful flowers with lots of colors.

**(2) Could a Wildflower have more than one elevational zone?** i.e. Could some wildflowers exist in multiple zones?

For the sake of the assignment, I assumed 1:1 mappings for colors and zones. I'm likely wrong, and am happy to discuss what I'd do differently in that case.

I first made a main entity table called `wildflowers` and I created the primary key: wildflower_id. Reason: we need an immutable identifier to uniquely identify records (wildflowers). Then I added, common_name and scientific_name, under the assumption that both must be unique, non-empty fields. Next, I thought for awhile on how I wanted to include colors and zones. I ended up creating two lookup tables: `colors` and `elevational_zones`. Rather than storing color and zone as free-text strings in the wildflowers table(which I think would be quite redundant to have our records write out text like 'White' or 'Alpine' everywhere), I normalized these into separate lookup tables. This approach provides several benefits:

- **Data consistency**: Prevents typos that totally would happen (i.e., "Blue" vs "bLuE")
- **Query efficiency**: Integer foreign keys are faster to index
- **Flexibility**: Easy to add new colors/zones or rename existing ones without touching wildflower records...avoids annoying backfills

For bloom dates, I used `DATE` type following Jason's clarification that blooms are a single start/end date pair ("March 15" to "June 30"). As much as I disliked a meaningless year attached to this data type, I think it's readable, space and query efficient, and worth avoiding having to incorporate calendar logic in our database (how many days in each month). One alternative was 4 new integer fields:

`bloom_start_month TINYINT NOT NULL CHECK(bloom_start_month BETWEEN 1 AND 12),
bloom_start_day TINYINT NOT NULL CHECK(bloom_start_day BETWEEN 1 AND 31),
bloom_end_month TINYINT NOT NULL,
bloom_end_day TINYINT NOT NULL`

Another alternative was adding two integer fields start_doy and end_day, where the number would map to month and day (i.e. Jan 1 -> 1, Jan 2 -> 2... Dec 31 -> 365).

## Task 2: API Design

This implementation could be improved a lot, with respect to error-handling, pagination, javadocs + comments, unit tests, etc, but overall this skeleton is how I would organize and start this project. I split the code into four folders and the access pattern is below:

**Controller → Service → Repository → Model**

- **Controller layer**: Handles HTTP routing, request/response mapping.
- **Service layer**: Contains business logic (i.e. join wildflower data with color/zone names)
- **Repository layer**: Abstracts data access. Uses in-memory HashMaps for this assignment.
- **DTO layer**: API response objects
