
Feature: Simple UI Navigation across web site using BDD approach

  @demo
  @Story=positive
    Scenario: Navigate web site different pages

    Given I am at home page
    When I click over Services link
    Then Services page is displayed

