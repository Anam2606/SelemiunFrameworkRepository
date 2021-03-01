package amazon.stepDefinitions;

import amazon.hooks.Hooks;
import amazon.pages.CheckboxDemoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckboxDemoSteps {

    CheckboxDemoPage cdp = new CheckboxDemoPage(new Hooks().getDriver());

    @And("user selects checkbox demo")
    public void userSelectsCheckboxDemo() {
        cdp.userSelectsCheckboxDemo();
    }

    @And("user selects checkbox")
    public void userSelectsCheckbox() {
        cdp.userSelectsCheckbox();
    }

    @Then("a message should be displayed {string}")
    public void aMessageShouldBeDisplayed(String msg) {
        cdp.aMessageShouldBeDisplayed(msg);
    }

    @When("user clicks on check all button")
    public void userUserClicksOnCheckAllButton() {
        cdp.userUserClicksOnCheckAllButton();
    }

    @Then("all checkboxes should be checked")
    public void allCheckboxesShouldBeChecked(DataTable checkbox) {
        cdp.allCheckboxesShouldBeChecked(checkbox);
    }

    @Then("all checkboxes should be unchecked")
    public void allCheckboxesShouldBeUnchecked(DataTable checkbox) {
        cdp.allCheckboxesShouldBeUnchecked(checkbox);
    }

    @When("user clicks on uncheck all button")
    public void userClicksOnUncheckAllButton() {
        cdp.userClicksOnUncheckAllButton();
    }

    @And("uncheck all button should be displayed")
    public void uncheckAllButtonShouldBeDisplayed() {
        cdp.uncheckAllButtonShouldBeDisplayed();
    }
}
