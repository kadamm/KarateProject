Feature: Login tests

  @smoke
  Scenario: Success Case – Valid Email & Password
    Given url 'https://reqres.in/api/login'
    And header x-api-key = 'reqres-free-v1'
    And def jsonBody =
    """
          {
            "email": "eve.holt@reqres.in",
            "password": "cityslicka"
          }
    """
    And request jsonBody
    When method POST
    Then status 200
    And match response == { token: #string }
    And def token_len = response.token.length
    And assert token_len > 10

  @smoke
  Scenario: Failure Case – Missing API key in header
    Given url 'https://reqres.in/api/login'
    And def jsonBody = { "email": "eve.holt@reqres.in", "password": "cityslicka" }
    And request jsonBody
    When method POST
    Then status 401
    And print response
    And match response == { error: #string, how_to_get_one: #string }
    And match response.error == "Missing API key."

  @smoke
  Scenario: Failure Case – Missing password
    Given url 'https://reqres.in/api/login'
    And header x-api-key = 'reqres-free-v1'
    And request { "email": "eve.holt@reqres.in" }
    When method POST
    And print response
    Then status 400
    And match response.error == "Missing password"