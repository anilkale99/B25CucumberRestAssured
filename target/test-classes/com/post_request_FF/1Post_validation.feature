@regression
Feature: ZPost request testing 2

Scenario: 1Post request validation
Given Create User with data 
Then validate user created.
Then validate user ID have non null value

Scenario: 2Post request validation
Given Create User with data1 
Then validate user created.
Then validate user ID have non null value

Scenario: 3Post request validation
Given Create User "Anil" with data from file 
Given Create User "Prashant" with data from file 
Then validate user created.
Then validate user ID have non null value

Scenario: 4Post request validation for Headers
Given Create User "Ruksana" with data from file 
Then validate all headers




















