Feature: Add New customer

@MobileTest
Scenario: postive test Add new customer

Given Add New customer button must be displayed
When user enters name and phonenumber and click on ok
Then verify customer added and displayed on home screen