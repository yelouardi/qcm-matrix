Feature: Choice End Point
  Background:
    * url 'http://localhost:8020'
    * header Accept = 'application/json'

  Scenario: Testing valid GET endpoint
    Given path 'choice/all'
    When method GET
    Then status 200
    * def first = response[0]
    And match first contains {choiceText:"choice 1"}

  Scenario: Add new Choice OK response
    def
    Given  path 'choice'
    And request { choiceText: 'choice 5' ,percentage: 100 ,questionId: 10  }
    When method POST
    Then status 201
    And def person = response
