Feature: Task 1

  Scenario Outline: User signs in and adds an address
    Given User is on MyStore login website
    When User loges in with <email> and <password> and gets to user profile page
    And Goes to website with addresses through the tile
    And Goes to website adding new address through button
    And Fills <Alias>, <City>, <Zip>, <Address>, <Phone>
    Then Program gets confirmation that form was filled the right way
    And Added Address is deleted
    Then Program gets confirmation of deleting the address

    Examples:
      | email         | password |Alias            | City  |Zip    |Address          |Phone     |
      |a.lucy@lucky.pl| elo123   | FirstBuilding   | Oxford| 04-809|Right Street 404 |369852883 |
      |a.lucy@lucky.pl| elo123   | MainBuilding    | Oxford| 01-009|Random Street 404|340448897 |
      |a.lucy@lucky.pl| elo123   | AnotherBuilding | Oxford| 01-099|Other Street 404 |615989119 |