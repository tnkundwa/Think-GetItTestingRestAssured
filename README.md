# Think-GetIt Testing - REST Assured

This is a REST API automation project I built using Java and REST Assured to practice testing the Think-GetIt application APIs.

The project contains tests for different parts of the application, including:

* Authentication
* Users
* Products
* Categories
* Cart
* Orders
* Reviews
* Search
* Wishlist
* Admin

## Technologies

* Java
* REST Assured
* TestNG
* Maven
* Jackson
* Lombok
* Allure
* JavaFaker
* JSON Schema Validator

## Project Structure

The main test code is organized into:

```text
src/test/java/com/think_get_it
├── api
├── pojo
├── tests
└── utils
```

I separated the API-related code, data models, tests, and reusable utilities to keep the project easier to work with.

## Running the Tests

Clone the repository and run:

```bash
mvn clean test
```

## About

This project was mainly built to get practical experience with REST API automation, request/response validation, reusable test components, and organizing API tests with TestNG.

## Author

Toussaint Nkundwa

GitHub: https://github.com/tnkundwa
