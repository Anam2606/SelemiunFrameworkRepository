package amazon.stepDefinitions;

import amazon.hooks.Hooks;
import amazon.pages.SimpleFormDemoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SimpleFormDemoSteps {
    SimpleFormDemoPage sfd = new SimpleFormDemoPage(Hooks.getDriver(), Hooks.expicitWait());


    public SimpleFormDemoSteps() throws InterruptedException {
    }

    @And("user enters message {string}")
    public void userEntersMessage(String msg) {

        sfd.userEntersMessage(msg);
    }

    @And("user clicks on show message button")
    public void userClicksOnShowMessageButton() {

        sfd.userClicksOnShowMessageButton();
    }

    @Then("entered message should display {string}")
    public void enteredMessageShouldDisplay(String msg) {
        sfd.enteredMessageShouldDisplay(msg);
    }
}
