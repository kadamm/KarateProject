Feature: Users


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

      # match each array
    * match each response.data == sc
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
        # compare json file
    * match users[0] == read('classpath:Responses/users.json')

       #partial match response
    * match users[0] contains { "email": "michael.lawson@reqres.in", "first_name": "Michael", "last_name": "Lawson" }

       #read schema json file and compare it
    * def userSch = read('classpath:schemaFiles/users.json')
    * match users[0] == userSch

       #Call java method from feature file
    * def x = square(4)
    * print x

    # ignore value in
    * match users[0] ==
  """
  {
  "id": 7,
  "email": "michael.lawson@reqres.in",
  "first_name": "Michael",
  "last_name": "Lawson",
  "avatar": '#ignore'
  }
  """


    Scenario Outline: Successful - gate users of all pages
      Given url baseUrl
      And path 'api', 'users'
      And param page = <page>
      And header x-api-key = 'reqres-free-v1'
      And method GET
      Then status 200
      * print response

      Examples:
        | page |
        | 1    |
        | 2    |
        | 3    |


  Scenario: Successful - retry method gate users of all pages
    Given url baseUrl
    And path 'api', 'users'
    And param page = 1
    And header x-api-key = 'reqres-free-v1'
    * retry until response.status == 400
    * configure retry = { interval: 2000, count: 2 }
    * method GET
    * print 'Current status:', response.status
    Then status 200
    * print response