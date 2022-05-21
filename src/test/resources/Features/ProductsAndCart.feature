@Sanity
Feature: Adding Products to cart and verify product details

Background: Access Launch Page
   Given I am in the login page of the application
    
 @scenario1
Scenario Outline: Log in - Add Product to Cart - Checkout
	When User login in application with userName "<userName>" and password "<password>"
	And Click on Login btn
	Then Verify that user is succesfully logged in "<pageHeading>"
	And Add the product "<product>" to the cart
	And Get description and price of product "<product>" from Products page
	Then Click on Cart icon and validate the product details of product "<product>" from Cart page
	And Click on Checkout btn
	Then Enter user First name "<fName>" last name "<lName>" and Postal code "<zipCode>" 
	And Click on Continue btn
	Then Click on Finish btn

	Examples:
		|userName			|password	  |Url|pageHeading|product                |fName  |lName|zipCode   |
		|standard_user      |secret_sauce |Url|Products   |Sauce Labs Bolt T-Shirt|Soumya |Rathi|201001    |
	

		