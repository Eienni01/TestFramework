Feature: Login Test

	Scenario: Valid Login
	Given I am on the login page
	When I enter username "student" and password "Password123"
	And I click on the login button
	Then I should see the welcome message