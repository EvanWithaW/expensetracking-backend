# **Back-End** Application for ExpenseTracking Project

---

## Background:

This is the back-end application for the ExpenseTracking project. It is a Spring Boot application that provides the API
endpoints for the front-end application located [here](https://github.com/EvanWithaW/expensetracking-frontend).

---

## Running the App:

*This app was built using Spring Boot, and requires a MongoDB database to operate.*

*This app was developed using Java version 17 and requires a compatible machine*

***Instructions:***

1. Clone this repo.
2. Navigate to the application.properties file located in the *src/main/resources* directory.
3. Edit your application.properties file to include your MongoDB URI and database name, use the template below to create
   these changes.

~~~ 
spring.application.name={YOUR MONGODB APP NAME}
spring.data.mongodb.uri={YOUR MONGODB URI}
spring.data.mongodb.database={YOUR MONGODB DATABASE NAME}
spring.data.mongodb.ssl.enabled=true

security.jwt.secret-key={YOUR_SECRET_KEY}
security.jwt.expiration-time={YOUR CHOICE OF JWT EXPIRATION TIME}
~~~

4. Run the application.

--- 

## Features

- **Security:**
    - This application uses [Spring Security](https://spring.io/projects/spring-security) to secure all API endpoints
      excluding core registration and login endpoints.
    - This application utilizes JWT tokens to manage user sessions, and also return information about the user in other
      endpoints.
    - This application uses a custom JWT filter to intercept requests and validate JWT tokens, comparing them with the
      database in addition to ensuring the validity of their expiration time.
    - This application utilizes a MongoDB database to store user information and expenses.
- **Endpoints**
    - Protected Endpoints required a bearer token to be provided in the authorization header of the request.
    - Public Endpoints are open to all users, and do not require a token to be provided.
    - **Protected Endpoints**:
        - /addExpense:
            - POST request that allows users to add a new expense to their account.
            - Requires JWT token to be included in the header of the request.
            - Body of the request should include the following:
                - **description**: Description of the expense
                - **amount**: Amount of the expense in USD
                - **frequency**: Frequency of the expense (is it recurring?): annually, monthly, weekly, bi-weekly,
                  daily
        - /getExpenses:
            - GET request that allows users to retrieve all of their expenses.
            - Requires JWT token to be included in the header of the request, which is utilized to find the user's
              expenses.
            - Returns an array of all expenses associated with the user.
            - Body of the request is empty.
        - /auth/signup:
            - POST request that allows users to register a new account.
            - Ensures that the user is not already registered.
            - The password is hashed on the backend to prevent any storing plain text passwords on db.
            - Body of the request should include the following:
                - **email**: Email of the user
                - **password**: Password of the user
                - **firstName**: First name of the user
                - **lastName**: Last name of the user
    - **Public Endpoints**:
        - /auth/signin:
            - POST request that allows users to login to their account.
            - **Returns a JWT token** that is stored in the user's session storage (will be moved in local after testing
              is finished, this is handled in the frontend).
            - Compares the password with the hashed password stored in the database.
            - Body of the request should include the following:
                - **email**: Email of the user
                - **password**: Password of the user
        - /user/info:
            - GET request that allows users to retrieve their information.
            - Requires JWT token to be included in the header of the request, which is utilized to find the user's
              information.
            - The current information returned includes:
                - First and Last Name of User

##Planned Features

- Expenses:
  - Users will be able to edit/delete existing expenses
  - Users will be able to view important metrics such as how much they are spending and top spending amounts
    