Feature: Scenarios that would be performing API request to selected end points

  @demo
  @Story=positive

    Scenario: Obtaining the weather for a given US location via Zip Code

    Given I request the weather for <location>
    Then I get the weather


#    Scenario: Obtaining a 5 forecast for a given USA city
#
#      Given I request 5 day forecast for <city>
#      Then I get the 5 day forecast