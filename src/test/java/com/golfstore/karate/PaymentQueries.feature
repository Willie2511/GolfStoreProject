Feature: Payment Query Tests

  Scenario: Find all Payment Details
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/PaymentDetails'
    And header Accept = 'application/json'
    When method GET
    Then status 200

  Scenario: Find Payment By Card Details
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/PaymentDetails/search/123456781920'
    And header Accept = 'application/json'
    When method GET
    Then status 200


