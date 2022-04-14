Feature: Staff Query Tests
  Scenario: Find all Staff
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Staff'
    And header Accept = 'application/json'
    When method GET
    Then status 200


  Scenario: Find Staff By Id
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Staff/2'
    And header Accept = 'application/json'
    When method GET
    Then status 200

  Scenario: Find Staff By Email Address
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Staff/search/JJ@cgl.com'
    And header Accept = 'application/json'
    When method GET
    Then status 200