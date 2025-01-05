Feature: Login Functionality


@LoginValidUser
  Scenario: Test Case to verify Login functionality with valid username and password
    Given Browser should be open with login page
    When User should enter Username and Password and click on login button
    Then Home Page should get open and title should be Altoro Mutual
