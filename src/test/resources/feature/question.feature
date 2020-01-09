Feature: Question End Point
  Background:
    * url 'http://localhost:8090'
    * header Accept = 'application/json'

  Scenario: Testing valid GET endpoint
    Given path 'question/all'
    When method GET
    Then status 200
    * def first = response[0]
    And match first contains {questionText:"question 1"}


  Scenario: Add new Question OK response
    Given  path 'question'
    And request { questionText: 'question 4' }
    When method POST
    Then status 201
    And def question = response

  Scenario: Add new Question KO response
    Given  path 'question'
    And request { questionText: 'question 4' }
    When method POST
    Then status 302
