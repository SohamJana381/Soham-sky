Feature: Test

  Scenario: User navigates to shop page
    Given I am on the home page
    When I navigate to 'Deals'
    Then the user should be on the https://www.sky.com/deals

  Scenario: User sees titles on the shop page
    Given I am on the home page
    When I try to sign in with invalid credentials
    Then I should see a text saying that 'Sorry, we did not recognise either your username or password'

  Scenario: User sees a list of deals on the deals page
    Given I am on the 'https://www.sky.com/deals' page
    Then I see a list of deals with a price to it

    Scenario: User sees the editorial section in specific searches
      Given I am on the home page
      When I search 'sky' in the search bar
      Then I should see an editorial section