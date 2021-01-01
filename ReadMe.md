### Spring Boot Security + JWT Hello World Example

In this tutorial we will be developing a Spring Boot Application that makes use of JWT authentication for securing an exposed REST API. In this example we will be making use of hard coded user values for User Authentication. In next tutorial we will be implementing


### Link
https://www.javainuse.com/spring/boot-jwt

* application.properties
 ``` 
  jwt.secret=javainuse
```

* JwtTokenUtil
  
 ```
 The JwtTokenUtil is responsible for performing JWT operations like creation and validation.
 It makes use of the io.jsonwebtoken.Jwts for achieving this.

```
* JWTUserDetailsService

JWTUserDetailsService implements the Spring Security UserDetailsService interface. It overrides the loadUserByUsername for fetching user details from the database using the username. The Spring Security Authentication Manager calls this method for getting the user details from the database when authenticating the user details provided by the user. Here we are getting the user details from a hardcoded User List. In the next tutorial we will be adding the DAO implementation for fetching User Details from the Database. Also the password for a user is stored in encrypted format using BCrypt. Previously we have seen Spring Boot Security - Password Encoding Using Bcrypt. Here using the Online Bcrypt Generator you can generate the Bcrypt for a password.

