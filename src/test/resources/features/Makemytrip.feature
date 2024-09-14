#Author: Priya S
@search_page
Feature: Make my trip Application
  I want to validate the search page present in makemytrip website

  Scenario Outline: Search Page Validation
    Given I want to navigate to makemytrip application
    When I search for the flights with "<FromCity>","<ToCity>","<Departuredate>","<ReturnDate>"
    Then I verify the search page with "<StartCity>","<EndCity>"

    Examples: 
    | FromCity  | ToCity | Departuredate  | ReturnDate | StartCity | EndCity |
    | HYD |    MAA | 25 | 12 | Hyderabad to | Chennai to |
