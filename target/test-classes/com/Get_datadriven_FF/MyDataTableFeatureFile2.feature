Feature: 1validattion for bookstore data using datadriven

Scenario Outline: 1Validate data in json response with data table
Given Hit the bookstore api 
Then validate as status code 
Then validate data <ExpValue> from <jsonPath> response
Examples:
	| ExpValue								  | jsonPath				  	|
	|	'Git Pocket Guide'				|	'books[0].title'		|
	|	'A Working Introduction'	|	'books[0].subTitle'	|
	|	'Richard E. Silverman'		|	'books[0].author'		|
	|	'Richard E. Silverman'		|	'books[0].author'		|
	|	'Richard Kale'	        	|	'books[0].author'		|

	