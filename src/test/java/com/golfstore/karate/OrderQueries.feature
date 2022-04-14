Feature: Order Queries Tests

  Scenario: Find all Orders
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Orders'
    And header Accept = 'application/json'
    When method GET
    Then status 200


  Scenario: Create Order
    Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Orders'
    And request {"orderNumber": 22, "productId": "7", "totalPrice": 299.00, "status": "In Progress"}
    And header Accept = 'application/json'
    When method POST
    Then status 201

    Scenario: Find Order By Id
      Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Orders/search/2'
      And header Accept = 'application/json'
      When method GET
      Then status 200

      Scenario: Update Order
        Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Orders/update/2/In Progress'
        And request
        And header Accept = 'application/json'
        When method PUT
        Then status 200