package amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleFormDemoPage {


    @FindBy(xpath = "//*[contains(@id,'user-message')]")
    WebElement messageBox;

    @FindBy(xpath = "//*[contains(@onclick,'showInput()')]")
    WebElement showButton;

    @FindBy(xpath = "//*[contains(@id,'display')]")
    WebElement verifyMessage;

    WebDriverWait wait;
    WebDriver driver;

    public SimpleFormDemoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    public void userEntersMessage(String msg) {
        wait.until(ExpectedConditions.visibilityOf(messageBox));
        messageBox.sendKeys(msg);

    }

    public void userClicksOnShowMessageButton() {
        showButton.click();

    }

    public void enteredMessageShouldDisplay(String msg) {
        Assert.assertEquals(msg,verifyMessage.getText());
    }

}