Feature: Main Page
  
  Scenario: Search Action
    When I open the main page url
    And I input Hi into location field
    Then I choose Adams Hill as location
    Then I choose £150, 000 as max price
    Then I choose At Least 3 Bedrooms as number of bedroom
	And I click on the Search button