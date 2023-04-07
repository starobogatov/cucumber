Feature: Google Search

  Scenario: Search for IMDb
    Given I am on the Google homepage
    And I accept cookies
    When I search for "IMDb"
    Then I should see search results
    And I click on the first search result
    Then I should be on the IMDb homepage