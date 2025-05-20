Feature: browserstack automation demo

    @UI
  Scenario: try to login to github and check for expected error message
    * def driver = { type: 'chrome' }  # requires Chrome installed
    * driver 'https://github.com/login'
    * input('#login_field', 'XXXX')
    * input('#password', 'world')
    * submit().click("input[name=commit]")
    * match html('.flash-error') contains 'Incorrect username or password.'