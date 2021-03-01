package amazon.stepDefinitions;

import amazon.hooks.Hooks;
import amazon.pages.RadioButtonsDemoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;


public class RadioButtonsDemoSteps {

    RadioButtonsDemoPage rbdp = new RadioButtonsDemoPage(Hooks.getDriver());

    @When("user selects radio button demo")
    public void userSelectsRadioButtonDemo() {
        rbdp.userSelectsRadioButtonDemo();
    }

    @And("user selects sex")
    public void userSelectsSex(String sex) {
        rbdp.userSelectsSex(sex);
    }


    @And("user clicks on get value button")
    public void userClicksOnGetValueButton() {
        rbdp.userClicksOnGetValueButton();
    }


    @And("user selects sex and age group & clicks on get value")
    public void userSelectsSexAndAgeGroupClicksOnGetValue(DataTable data) {
        List<List<String>> l = data.asLists();
        System.out.println(l.size());
        for (int i=1; i< l.size(); i++) {
            List<String> l2 = l.get(i);
            rbdp.userSelectsSex(l2.get(0));
            rbdp.userSelectsAgeGroup(l2.get(1));
            rbdp.userClicksOnGetValueButton();
            rbdp.correctValuesShouldReflect(l2.get(2), l2.get(3));
        }
    }
}
