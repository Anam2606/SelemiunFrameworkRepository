package amazon.stepDefinitions;

import amazon.hooks.Hooks;
import amazon.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeSteps {
    HomePage hp = new HomePage(Hooks.getDriver());


    @Given("user is on home page {string}")
    public void userIsOnHomePage(String url) {
        hp.userIsOnHomePage(url);
    }

    @When("user selects input form")
    public void userSelectsInputForm() {
        hp.userSelectsInputForm();
    }

    @And("user selects simple form demo")
    public void userSelectsSimpleFormDemo() {
        hp.userSelectsSimpleFormDemo();
    }



}
