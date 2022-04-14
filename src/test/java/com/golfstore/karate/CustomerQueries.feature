
  Feature: Customer Level Queries Test

    Scenario: Get All Customers
      Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Customers'
      And header Accept = 'application/json'
      When method GET
      Then status 200
      
      Scenario: Save User Test
        Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Customers'
        And request { "customerId": 22, "firstName": "Joe", "lastName": "Monage", "contactNumber": "0876152435", "emailAddress": "JM@cgl.com", "password": "1234567891234567"}
        And header Accept = 'application/json'
        When method POST
        Then status 201
        
        Scenario: Get Customer By Id
          Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Customers/1'
          And header Accept = 'application/json'
          When method GET
          Then status 200

          Scenario: Get Customer By Email Address
            Given url 'http://localhost:8080/GolfStoreWorking-0.0.1-SNAPSHOT/rest/Customers/search/JJ@cgl.com'
            And header Accept = 'application/json'
            When method GET
            Then status 200