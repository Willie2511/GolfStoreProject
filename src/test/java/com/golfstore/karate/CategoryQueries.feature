Feature: Category Query Tests

  Scenario: Find all Categories
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/categories'
    And header Accept = 'application/json'
    When method GET
    Then status 200

    Scenario: Find Category By Id
      Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/categories/2'
      And header Accept = 'application/json'
      When method GET
      Then status 200