Feature: Testing Update user Reqres API
  @Latihan
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "Dewi Kusuma" and job "QA Engineer"

