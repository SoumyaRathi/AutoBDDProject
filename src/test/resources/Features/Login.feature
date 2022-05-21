Feature: Login into Application

Background: Access Launch Page
	Given I am in the login page of the application
	
@scenario
Scenario Outline: Log in to the Application
When User login in application with userName "<userName>" and password "<password>"
And Click on Login btn
Then Verify that user is succesfully logged in "<pageHeading>"

Examples:
|userName			|password	    |pageHeading|Url|
|standard_user      |secret_sauce   |Products   |Url  |

@wrongLogin
Scenario Outline: Log in with wrong Credentials and validate Error Message 
	When User login in application with userName "<userName>" and password "<password>"
	And Click on Login btn
	Then Validate Error msg displayed when credentials are Invalid
	
	Examples: 
		|userName     |password     |Url|
		|wrong_user   |wrong_pswrd  |Url|