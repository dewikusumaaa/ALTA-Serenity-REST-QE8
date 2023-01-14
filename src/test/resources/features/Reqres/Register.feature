Feature: Reqres register
  @Tugas
  Scenario: Register valid user
    Given Post register valid user with valid json
    When Send post register valid user request
    Then Should return status code 200
    And Response body page should be id 4 and token "QpwL5tke4Pnpja7X4"
    And Validate register user with json schema

  @Tugas
  Scenario: Register invalid user
    Given Post register invalid user with valid json
    When Send post register invalid user request
    Then Status code should be 400 ERROR
    And Response body page should be contain "Missing password"
    And Validate register invalid user with json schema