Feature: Customers
  Background:
    Given user launch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then User can view Dashboard

  @sanity
  Scenario: Add a new customer
    When User clicks on customers menu
    And click on customers menu item
    And click on Add new button
    Then User can view add new customer page
    When user enters customer info
    And click on save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close chrome browser

  @Reg
  Scenario: Search customer by email ID
    When User clicks on customers menu
    And click on customers menu item
    And enter email as search item
    And click search button
    Then User should found email in the search table
    And close chrome browser

  @Reg
  Scenario: Search customer by name
    When User clicks on customers menu
    And click on customers menu item
    And enter customer first name
    And enter customer last name
    And click search button
    Then User should found name in the search table
    And close chrome browser

