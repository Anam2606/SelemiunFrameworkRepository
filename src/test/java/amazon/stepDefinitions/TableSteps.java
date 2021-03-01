package amazon.stepDefinitions;

import amazon.hooks.Hooks;
import amazon.pages.TablePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TableSteps {

    TablePage tp = new TablePage(Hooks.getDriver());

    @When("user selects table")
    public void userSelectsTable(){
        tp.userSelectsTable();
    }

    @And("user selects table sort and search")
    public void userSelectsTableSortAndSearch() {
        tp.userSelectsTableSortAndSearch();
    }


    @And("fetch data for user {string}")
    public void fetchDataForUserUser(String user) {
        tp.fetchDataForUserUser(user);
    }


    @Then("printUserDetails {string}")
    public void printuserdetails(String name) {
        tp.printUserDetails(name);

    }

    @And("ageGreaterThen {int}")
    public void agegreaterthen(int age) {
        tp.ageGreaterThen(age);
    }

    @And("pagination {string}")
    public void pagination(String name) {
        tp.pagination(name);
    }


}
