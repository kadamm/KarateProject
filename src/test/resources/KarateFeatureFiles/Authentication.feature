Feature: Authentication feature

  @smoke
  Scenario: Basic Authentication - Use JavaScript to set the Authorization header
    * def username = 'user'
    * def password = 'passwd'
    * def credentials = username + ':' + password
    * def encoded = java.util.Base64.getEncoder().encodeToString(credentials.getBytes())
    * header Authorization = 'Basic ' + encoded

    Given url 'https://httpbin.org/basic-auth/user/passwd'
    When method GET
    Then status 200
    And match response.authenticated == true

  Scenario: Basic Authentication - passing credentials from url
    Given url 'https://user:passwd@httpbin.org/basic-auth/user/passwd'
    When method GET
    Then status 200
    And match response.authenticated == true

  @smoke_1
  Scenario: Bearer Token (OAuth2-style)
    * configure proxy = 'http://localhost:8080'
    Given url 'https://reqres.in/api/login'
    And header x-api-key = 'reqres-free-v1'
    And request { "email": "eve.holt@reqres.in", "password": "cityslicka" }
    When method POST
    Then status 200
    #* print 'Response Headers:', responseHeaders
    * print responseHeaders