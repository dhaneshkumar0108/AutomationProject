@regression @smoke
Feature: Error validation in sauce demo ecommerce website

  @errorvalidation
  Scenario Outline: Invalid/lockedout login credentials
    Given I launch the saucedemo application
    When user logged into application using '<username>' and '<password>'
    Then verify the '<errormessage>'

    Examples: 
      | username        | password      | errormessage                                                              |
      | userdummy       | passworddummy | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce  | Sorry, this user has been locked out.                                     |
