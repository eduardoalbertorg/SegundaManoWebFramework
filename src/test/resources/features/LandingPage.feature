Feature: Home page feature

    # As a QA I want to test the home page functionalities:
    # - Login
    # - Register account

    Scenario: User is on home page
    Given the user opens his browser
    When the user navigates to home page url
    Then the page title should be "Segundamano.mx - Compra y venta, anuncios clasificados de segundamano gratis"

    Scenario: User creates a new account
    Given the user is at the home page
    When the user clicks on "Ingresa"
    And the user clicks on "Crea una nueva cuenta" link
    And the user enters the email
    And the user enters the password
    And the user enters the confirm password
    And the user clicks on "Crea una cuenta" button
    Then the user should see a confirmation message containing "Verifica tu cuenta"

    Scenario: User logs in
    Given the user is at the home page
    When the user clicks on "Ingresa"
    And the user enters the email
    And the user enters the password
    And the user clicks on "Entra" button
    Then the user should see the username of the account