Feature: Login into okcredit Application

@MobileTest
Scenario: positive test login  

Given Launch the okcredit app
And Select the english language
And click on english language to land on okcredit login page
When User enters "9900857755" and "123456" and click on ok 
Then Verify that user is successfuly logged in and land on home screen




