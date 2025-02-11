Feature: Api Testing with cucumber rest assured on https://reqres.in/

  Scenario: Valid GET request for a user list
    Given I set the GET request for endpoint "api/users?page=2"
    When I send the GET request
    Then I should receive status code 200
    And the response body should contain "michael.lawson@reqres.in"

  Scenario: Valid POST request new user
    Given I set the POST request for endpoint "api/users"
    And the resquest body  is:
    """
    {
      "name": "morpheus",
      "job": "leader"
    }
    """
    When I send the POST request
    Then I should receive status code 201
    And the response body should contain "morpheus"

  Scenario: Valid POST request missing password
    Given I set the POST request for endpoint "api/login"
    And the resquest body  is:
    """
    {
      "email": "peter@klaven"
    }
    """
    When I send the POST request
    Then I should receive status code 400
    And the response body should contain "Missing password"

