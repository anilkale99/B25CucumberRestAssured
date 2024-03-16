Feature: validattion for bookstore data using dataTable

Scenario: Validate data in json response with data table
Given Hit the bookstore api 
Then validate as status code 
Then validate data from response
	|	Git Pocket Guide				|	books[0].title		|
	|	A Working Introduction	|	books[0].subTitle	|
	|	Richard E. Silverman		|	books[0].author		|
	
