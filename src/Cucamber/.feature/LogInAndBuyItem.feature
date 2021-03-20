Feature: Task 2

  Scenario Outline: Preregistered user Logs in and goes through proses of ordering an item
    Given Registered user is on MyStore login website
    When User is logged in with <email> and <password> and gets to MyStore main profile
    And Goes to MyStores main page and searches <product>
    And Chooses <product> they want to buy
    And Checks if product is on a discount
    And Chooses right SIZE <size>
    And Chooses <quantity> they want to order
    And Adds product to cart and goes to the cart
    And Fallows to checkout
    And Selects <Address option> and continues to shipping method
    And User chooses <shipping method> and continues to payment method
    And User chooses payment <method>
    And User accepts terms of service and submits order with obligation to pay
    Then User gets Order confirmation and Makes screenshot
    #And User goes to History and Detail of orders through profile page
    #Then Program checks if shown value of the order is correct
    #Then Program checks if shown status of the order is correct

    Examples:
      | email         | password | product                     |product                     | size | quantity | Address option | shipping method | method |to location      |
      |a.lucy@lucky.pl| elo123   | Hummingbird printed sweater |Hummingbird printed sweater | M    | 5        | Main Building  | Pick up         | Check  |icloud.Desktop|





