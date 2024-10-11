Feature: Sample test

  Background

  @smoke
  Scenario: Verify users get api response
    Given url baseUrl
    * path 'api', 'users'
    And param page = 2
    When method GET
    Then status 200
    And print response
    And match response.data[0].first_name == 'Michael'
    * match response.data == '#[6]'

    * match response.data[0].id == 7
    * match response.data[0].email == 'michael.lawson@reqres.in'
    * match response.data[0].first_name == 'Michael'
    * match response.data[0].last_name == 'Lawson'
    * match response.data[0].avatar == 'https://reqres.in/img/faces/7-image.jpg'
    * match each response.data == {id: #number, email: '#string', first_name: '#string', last_name: '#string', avatar: '#string' }