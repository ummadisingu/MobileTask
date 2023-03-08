Feature: API Validation

  @Test3
  Scenario: API Get call validation
    Given user enter baseURI and header details
    When user perform get call
    Then user verify response code
    Then user verify response data
