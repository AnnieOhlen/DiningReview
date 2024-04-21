# DiningReview
Spring portfolio project for CodeCademy course:  
*https://www.codecademy.com/learn/paths/create-rest-apis-with-spring-and-java*

## Description
This project is a simple REST API for a restaurant review site.  
Users can register, submit reviews, and search for restaurants.  
Admins can approve or reject reviews.  
  
The API is built using Spring Boot and Java.  
Spring Initialzr was used to create the project:  *https://start.spring.io/*  
A Maven project targeting Java with the following dependencies:
* Spring Web
* Spring Data JPA
* H2 Database
* Lombok

## Technologies
* Java
* Spring Boot
* H2 Database (in memory database)
* Swagger (API documentation)

## Prerequisites
To run this project you will need:
* Java 21
* Maven 3.8.1 (project was created using Maven Wrapper 3.8.1)

## Setup
You can run the project using the following command, if on Windows:
```
.\mvnw spring-boot:run
```
The API Swagger documentation will be available at *http://localhost:8080/swagger-ui.html*.

## Project Structure
The project is structured as follows:
* `src/main/java/com/codecademy/diningreview`: Contains the main application files.
  * `controller`: Contains the controllers for the API.
  * `dto`: Contains the data transfer objects for the application.
  * `exception`: Contains the exception classes for the application.
  * `mapping`: Contains the mapping classes for the application.
  * `model`: Contains the entities for the application.
  * `repository`: Contains the repositories for the entities.
  * `service`: Contains the services for the application.
* `src/test/java/com/codecademy/diningreview`: Contains the test files for the application.

## API Endpoints
The API has the following endpoints:

**Admin Controller**  
Handles operations related to admin users. Mapping: `/api/admin`
* `PUT /admin/review/{reviewId}`: Updates the status of a review.

**User Controller**  
Handles operations related to users. Mapping: `/api/users`
* `GET /users/{userName}`: Retrieves a user by username.
* `POST /users/register`: Registers a new user.
* `DELETE /users/{userName}`: Deletes a user by username.

**Review Controller**  
  Handles operations related to reviews. Mapping: `/api/reviews`
* `GET /reviews`: Retrieves all reviews.
* `POST /reviews/submit`: Submits a new review.
* `GET /reviews/pending`: Retrieves all pending reviews.
* `GET /reviews/{restaurantId}`: Retrieves reviews for a specific restaurant.

**Restaurant Controller**  
Handles operations related to restaurants. Mapping: `/api/restaurant`
* `GET /restaurants`: Retrieves all restaurants.
* `GET /restaurants/search`: Retrieves all restaurants that match zipcode and allergy.
* `POST /restaurants/submit`: Adds a new restaurant.

## Testing
### Testing API Endpoints
The endpoints can be tested using Swagger at *http://localhost:8080/swagger-ui.html*.'  
PowerShell commands, for Windows, to test the API endpoint is also provided.  
Currently, the endpoint for admin is failing in the script (works in Swagger).  
To run the tests, execute the following command:
```shell
.\test-script-endpoints.ps1
```

Running scripts in PowerShell may require changing the execution policy.  
It can be changed by running the following in Powershell as an administrator:
```shell
Set-ExecutionPolicy RemoteSigned
```

## Future Improvements
* Add more error handling and validation.
* Add tests as this was not part of the assignment on CodeCademy.
* The tests will be set up with application-test.properties and MockData-class.
* The tests will be using Unit 5 and Mockito.
* Expand upon the restaurant model/dto to include zip code.
* Improve the search functionality for zip code and allergy.
* Suggestions by CodeCademy: user model includes properties representing whether they’re interested in a particular allergy. Possibly enable a new search scenario that returns the set of restaurants that match the user’s particular interests.
