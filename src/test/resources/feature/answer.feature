Feature: Answer End Point
  Background:
    * url 'http://localhost:8020'
    * header Accept = 'application/json'

  Scenario: Testing valid GET endpoint
    Given path 'answer/all'
    When method GET
    Then status 200
    * def first = response[0]
    And match first contains {choiceId: 1}

  Scenario: Add new Answer OK response
    def
    Given  path 'answer'
    And request { choiceId: 7 ,emailPerson: 'karate-khalid@gmail.com' }
    When method POST
    Then status 201
    And def person = response
