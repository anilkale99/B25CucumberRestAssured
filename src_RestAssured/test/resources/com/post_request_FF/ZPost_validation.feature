@regression
Feature: Post request testing


Scenario: Post request validation for no null value
Given Create User with data 
Then validate user created.
Then validate user ID have non null value

@smoke @Test @FunctionalityA
Scenario: Post request validation for valid user ID
Given Create User with data1 
Then validate user created.
Then validate user ID have non null value

@smoke
Scenario: Post request validation for data file
Given Create User "Anil" with data from file 
Given Create User "Prashant" with data from file 
Then validate user created.
Then validate user ID have non null value

Scenario: Post request validation for Headers
Given Create User "Ruksana" with data from file 
Then validate all headers




















