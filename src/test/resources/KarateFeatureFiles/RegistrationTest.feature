Feature: Registration

  @smoke
  Scenario: Success Case – Valid Email & Password
    Given url 'https://reqres.in/api/register'
    And header x-api-key = 'reqres-free-v1'
    And request {"email": "eve.holt@reqres.in", "password": "pistol" }
    When method POST
    Then status 200
    And print response
    And match response == { id: #number, token: #string }
    And match response.id == 4

  @smoke
  Scenario:  Failure Case – Missing Password
    Given url 'https://reqres.in/api/register'
    And header x-api-key = 'reqres-free-v1'
    And request {"email": "eve.holt@reqres.in" }
    When method POST
    Then status 400
    And print response
    And match response.error == 'Missing password'

  @smoke
  Scenario:  Failure Case – Missing Email
    Given url 'https://reqres.in/api/register'
    And header x-api-key = 'reqres-free-v1'
    And request {"password": "pistol" }
    When method POST
    Then status 400
    And print response
    And match response.error == 'Missing email or username'


  @smoke
  Scenario:  Failure Case – Empty Payload
    Given url 'https://reqres.in/api/register'
    And header x-api-key = 'reqres-free-v1'
    And request {}
    When method POST
    Then status 400
    And print response
    And match response.error == 'Missing email or username'