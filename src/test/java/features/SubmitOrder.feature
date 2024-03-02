@regression @smoke
Feature: Purchase the order from sauce demo ecommerce website

	Background: launch application
	Given I launch the saucedemo application
	
  @submitorder
  Scenario Outline: Add an item to the cart and Submit the Order
    Given user logged into application using '<username>' and '<password>'
    When user add '<product>' to cart
    And navigate to checkout page and enter '<firstname>', '<lastname>' and '<zipcode>' information
    Then verify the order confirmation '<message>'

    Examples: 
      | username      | password     | product             | firstname | lastname | zipcode | message                   |
      | standard_user | secret_sauce | Sauce Labs Backpack | Dhanesh   | kumar    |   12601 | Thank you for your order! |