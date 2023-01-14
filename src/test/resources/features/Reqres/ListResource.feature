Feature: Get list resources
  @Tugas
  Scenario: GET list Resource with valid page
    Given get list resource with valid page 2
    When Send request get list resources
    Then Should return status code 200
    Then Response body should contain id 7, name "sand dollar", year 2006, color "#DECDBE", and pantone_value "13-1106"
    And Get list resource assert json validation

  @Tugas
  Scenario: GET list Resource with valid page
    Given get list resource with valid page 2
    When Send request get list resources
    Then Should return status code 200
    Then Response body should contain name "sand dollar", color "#DECDBE", and pantone_value "13-1106"
    And Get list resource assert json validation

