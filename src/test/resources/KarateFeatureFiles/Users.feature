Feature: Users

  @smoke_1
  Scenario: Success - get users
    #Given url 'https://reqres.in/api/users?page=2'
    Given url baseUrl
    And path 'api', 'users'
    And param page = 2
    And header x-api-key = 'reqres-free-v1'
    And method GET
    Then status 200
    And print response
    * def users = response.data
    * def schema =
  """
  {
    id: '#number',
    email: '#string',
    first_name: '#string',
    last_name: '#string',
    avatar: '#string'
  }
  """
    * def validateEach =
  """
  function(users, schema) {

    for (var i = 0; i < users.length; i++) {
      karate.match(users[i], schema);
    }
  }
  """
    * eval validateEach(users, schema)

    # Single arrays data schema match
    * def sc =   { id: '#number', email: '#string', first_name: '#string', last_name: '#string', avatar: '#string' }
    * match response.data[1] == sc

      # Single data value match
    * match users[0].id == 7

     # Single arrays data values match
    * match users[0] ==
  """
  {
  "id": 7,
  "email": "michael.lawson@reqres.in",
  "first_name": "Michael",
  "last_name": "Lawson",
  "avatar": "https://reqres.in/img/faces/7-image.jpg"
  }
  """
    #read schema json file and compare it
    * def userSch = read('classpath:schemaFiles/users.json')
    * match users[0] == userSch


    * def x = square(4)
    * print x
