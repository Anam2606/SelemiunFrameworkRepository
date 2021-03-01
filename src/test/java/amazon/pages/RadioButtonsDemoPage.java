package amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonsDemoPage {
    WebDriver driver;
    WebDriverWait wait;

    public RadioButtonsDemoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[contains(@value,'Male')])[2]")
    WebElement maleRadioButton;

    @FindBy(xpath = "(//*[contains(@value,'Female')])[2]")
    WebElement femaleRadioButton;

    @FindBy(xpath = "(//a[contains(text(),'Radio Buttons Demo')])[2]")
    WebElement RadioButtonDemo;

    @FindBy(xpath = "//*[contains(@onclick,'getValues();')]")
    WebElement getValueButton;

    @FindBy(xpath = "//*[@class='groupradiobutton']")
    WebElement sexReflectedValue;

    @FindBy(xpath = "(//a[contains(text(),'Radio Buttons Demo')])[2]")
    WebElement ageGroupReflectedValue;

    @FindBy(xpath = "//*[contains(@value,'0 - 5')]")
    WebElement ageGroup0to5;

    @FindBy(xpath = "//*[contains(@value,'5 - 15')]")
    WebElement ageGroup5to15;

    @FindBy(xpath = "//*[contains(@value,'15 - 50')]")
    WebElement ageGroup15to50;

    public void correctValuesShouldReflect(String sex_msg, String age_group_msg) {
        //System.out.println("result Value is:" + sexReflectedValue.getText());
        String [] result = sexReflectedValue.getText().split("\n");

        Assert.assertEquals(sex_msg,result[0].trim());
        Assert.assertEquals(age_group_msg,result[1].trim());
    }

    public void userClicksOnGetValueButton() {
        getValueButton.click();
    }

    public void userSelectsAgeGroup(String age_group) {
        if (age_group.equals("0 to 5")) {
            ageGroup0to5.click();
        }
        if (age_group.equals("5 to 15")) {
            ageGroup5to15.click();
        }
        if (age_group.equals("15 to 50")) {
            ageGroup15to50.click();
        }

    }

    public void userSelectsSex(String sex) {
        if (sex.equals("Male")) {
            boolean a = !maleRadioButton.isSelected();
            if (a) {
                maleRadioButton.click();
            }
        } else {
            if (sex.equals("Female")) {
                boolean a = !femaleRadioButton.isSelected();
                if (a)
                    femaleRadioButton.click();
            }
        }
    }


    public void userSelectsRadioButtonDemo() {
        System.out.println("in method");
        wait.until(ExpectedConditions.elementToBeClickable(RadioButtonDemo));
        RadioButtonDemo.click();
        System.out.println("clicked");
    }
}

