Feature: OpenCart E-Commerce End-to-End Automation
  This feature validates smoke, regression, integration,
  negative, and end-to-end scenarios for OpenCart application

  # ---------------- SMOKE TEST ----------------
  @Smoke
  Scenario: Verify OpenCart home page launch
    Given user launches the application
    Then home page should be displayed successfully


  # ---------------- REGRESSION TEST ----------------
  @Regression
  Scenario: Search product and add to cart
    Given user launches the application
    When user searches for product "MacBook"
    And user selects the product and adds to cart
    Then product should be added to cart successfully


  # ---------------- INTEGRATION TEST ----------------
  @Integration
  Scenario: Validate cart and remove product
    Given user launches the application
    When user searches for product "MacBook"
    And user selects the product and adds to cart
    And user navigates to cart page
    And user removes the product from cart
    Then cart should be empty


  # ---------------- END TO END TEST ----------------
  @E2E
  Scenario: Complete end-to-end purchase flow
    Given user launches the application
    When user searches for product "MacBook"
    And user selects the product and adds to cart
    And user navigates to cart page
    And user proceeds to checkout
    Then checkout page should be displayed


  # ---------------- NEGATIVE TEST ----------------
  @Negative
  Scenario: Login with invalid credentials
    Given user launches the application
    When user navigates to login page
    And user logs in with username "fake@mail.com" and password "wrong123"
    Then warning message should be displayed
