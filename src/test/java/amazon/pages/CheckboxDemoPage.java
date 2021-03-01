package amazon.pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckboxDemoPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckboxDemoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    //*[@id="easycont"]/div/div[2]/div[2]/div[2]/div[1]
    //*[@id="easycont"]/div/div[2]/div[2]/div[2]/div[3]
    @FindBy(xpath = "(//*[contains(text(),'Checkbox Demo')])[2]")
    WebElement checkboxDemo;

    @FindBy(xpath = "//*[contains(@id,'isAgeSelected')]")
    WebElement singleCheckbox;

    @FindBy(xpath = "//*[contains(@id,'txtAge')]")
    WebElement txtAgeMessage;

    @FindBy(xpath = "//*[contains(@id,'check1')]")
    WebElement checkAllButton;

    @FindBy(xpath = "//*[contains(@id,'check1')]")
    WebElement uncheckAllButton;


    public void userSelectsCheckboxDemo() {
        checkboxDemo.click();

    }

    public void uncheckAllButtonShouldBeDisplayed() {
        uncheckAllButton.isDisplayed();
    }

    public void userClicksOnUncheckAllButton() {
    }

    public void allCheckboxesShouldBeChecked(DataTable checkboxdata) {
//        List<Map<String, String>> ss = checkbox.asMaps();
//        for (Map<String, String> x : ss) {
//            System.out.println("data table print : " + x.get("checkbox1"));
//        }

        //       List<List<String>> ss = checkbox.asLists();
        //       for (int i = 0; i < ss.size(); i++) {
//            List<String> l1 = ss.get(i);
        //           String v1 = l1.get(i);
        //          System.out.println("Row " + i + " : " + ss.get(i).get(0));
        List<String> ss = checkboxdata.asList();
        for (int i = 0; i < ss.size(); i++) {
            int a = i + 1;
            WebElement checkbox = driver.findElement(By.xpath("(//*[contains(@class,'cb1-element')])[" + a + "]"));
            // Assert.assertEquals("checkbox is not checked : ", true, checkbox.isSelected());
            Assert.assertTrue("checkbox is not checked : ", checkbox.isSelected());
            //  if (! checkbox.isSelected()){
            //      Assert.fail("checkbox is not checked");
        }
    }




    public void userUserClicksOnCheckAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkAllButton));
        checkAllButton.click();
    }

    public void aMessageShouldBeDisplayed(String msg) {
        String txt = txtAgeMessage.getText();
        boolean adc = txt.equalsIgnoreCase(msg);
        if (adc == true)

            System.out.println("Message is present");
        else
            System.out.println("Message is not present");

    }

    public void userSelectsCheckbox() {
        singleCheckbox.click();
    }

    public void allCheckboxesShouldBeUnchecked(DataTable checkboxdata) {
        List<String> ss = checkboxdata.asList();
        for (int i = 0; i < ss.size(); i++) {
            int a = i + 1;
            WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[" + a + "]"));
            Assert.assertFalse("checkbox is checked : ", checkbox.isSelected());
        }
    }
}
