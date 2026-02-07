package stepdefinitions;

import org.testng.AssertJUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CheckoutPage;

public class E2ESteps {

    HomePage home;
    ProductPage product;
    CartPage cart;
    LoginPage login;
    CheckoutPage checkout;

    // ---------------- SMOKE & COMMON ----------------
    @Given("user launches the application")
    public void user_launches_the_application() {
        home = new HomePage();
        AssertJUnit.assertTrue(home.isHomePageDisplayed());
    }

    @Then("home page should be displayed successfully")
    public void home_page_should_be_displayed_successfully() {
        AssertJUnit.assertTrue(home.isHomePageDisplayed());
    }

    // ---------------- REGRESSION & E2E ----------------
    @When("user searches for product {string}")
    public void user_searches_for_product(String productName) {
        home.searchProduct(productName);
        product = new ProductPage();
    }

    @When("user selects the product and adds to cart")
    public void user_selects_the_product_and_adds_to_cart() {
        product.selectProduct();
        product.addToCart();
    }

    @Then("product should be added to cart successfully")
    public void product_should_be_added_to_cart_successfully() {
        AssertJUnit.assertTrue(product.isProductAdded());
    }

    // ---------------- CART STEPS ----------------
    @When("user navigates to cart page")
    public void user_navigates_to_cart_page() {
        cart = new CartPage();
        cart.openCart();
    }

    @When("user removes the product from cart")
    public void user_removes_the_product_from_cart() {
        cart.removeItem();
    }

    @Then("cart should be empty")
    public void cart_should_be_empty() {
        AssertJUnit.assertTrue(cart.isCartEmpty());
    }

    // ---------------- CHECKOUT STEPS ----------------
    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cart.proceedToCheckout();
        checkout = new CheckoutPage();
    }

    @Then("checkout page should be displayed")
    public void checkout_page_should_be_displayed() {
        AssertJUnit.assertTrue(checkout.isCheckoutPageDisplayed());
    }

    // ---------------- LOGIN NEGATIVE ----------------
    @When("user navigates to login page")
    public void user_navigates_to_login_page() {
        login = new LoginPage();
        login.openLoginPage();
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        login.login(username, password);
    }

    @Then("warning message should be displayed")
    public void warning_message_should_be_displayed() {
        AssertJUnit.assertTrue(login.isWarningDisplayed());
    }
}