Feature: validattion for bookstore data using dataTable

Scenario: 1Validate data in json response with data table
Given Hit the bookstore api 
Then validate as status code 
Then validate data from response
	|	Git Pocket Guide				|	books[0].title		|

Scenario: 2Validate data in json response with data table
Given Hit the bookstore api 
Then validate as status code 
Then validate data from response
	|	A Working Introduction	|	books[0].subTitle	|

Scenario: 3Validate data in json response with data table
Given Hit the bookstore api 
Then validate as status code 
Then validate data from response
	|	Richard E. Silverman		|	books[0].author		|
	
	