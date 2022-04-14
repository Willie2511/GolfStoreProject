
Feature: Product Query Tests
  Scenario: Find all Product Details
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Products'
    And header Accept = 'application/json'
    When method GET
    Then status 200

  Scenario: Find all Product Details By Category
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Products/search/Drivers'
    And header Accept = 'application/json'
    When method GET
    Then status 200

  Scenario: Find all Product Details By Make
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Products/search/Titleist'
    And header Accept = 'application/json'
    When method GET
    Then status 200

  Scenario: Find all Product Details By Model
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Products/search/t100s'
    And header Accept = 'application/json'
    When method GET
    Then status 200


  Scenario: Find all Product Details By Id
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Products/search/id/2'
    And header Accept = 'application/json'
    When method GET
    Then status 200