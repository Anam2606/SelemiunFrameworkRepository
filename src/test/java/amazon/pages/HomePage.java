package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
//    WebDriverWait wait = new WebDriverWait(driver,10);


    // elements
    @FindBy(xpath = "(//*[contains(text(), 'Input Forms')])[2]")
    WebElement inputForm;

    @FindBy(xpath = "//*[contains(text(), 'Simple Form Demo')]")
    WebElement simpleFormDemo;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver, this);
    }

    /**
     * This is for user to get test page
     */
    public void userIsOnHomePage(String url) {
        driver.get(url);
    }

    public void userSelectsInputForm() {
        wait.until(ExpectedConditions.elementToBeClickable(inputForm));
        inputForm.click();
        System.out.println("in input form");
    }

    public void userSelectsSimpleFormDemo() {
        simpleFormDemo.click();
    }


    }


