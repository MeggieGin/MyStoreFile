Feature: LogIn
  //Background: User is already on the website


  Scenario: LogIn without right data
    Given user is on MyStore login website
    When User tries to log in without giving any data
    Then User gets notification about luck of proper data


  Scenario Outline: LogIn with wrong data
    Given user is on MyStore login website
    When User loges in wrong log in data <email> and <password>
      # First wrong email and password
      # Second wrong password and correct email
      # Third wrong email and correct password
    Then User gets notification about filling wrong data
    Examples:
      | email           | password |
      |a.lucy@unlucky.pl|helo123   |
      |a.lucy@lucky.pl  |helo123   |
      |a.lucy@unlucky.pl|elo123    |


  Scenario Outline: Correct LogIn
    Given user is on MyStore login website
    When  User loges in with correct <email> and correct <password>
    Then  User gets to user profile page
    Examples:
      | email         | password |
      |a.lucy@lucky.pl|elo123    |