package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TablePage {


    WebDriver driver;
    WebDriverWait wait;

    public TablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Table']")
    WebElement table;

    @FindBy(xpath = "(//a[text()='Table Sort & Search'])[2]")
    WebElement sorttable;

    @FindBy(xpath = "//table[@id='example']")
    WebElement tabledata;

    @FindBy(xpath = "//*[@id='example_next']")
    WebElement nextButton;

    public void userSelectsTable() {
        wait.until(ExpectedConditions.elementToBeClickable(table));
        table.click();
    }

    public void userSelectsTableSortAndSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(sorttable));
        sorttable.click();
    }

    public void fetchDataForUserUser(String user) {
        List<WebElement> row = tabledata.findElements(By.tagName("tr"));
        //System.out.println(row.size());
        for (int i = 1; i < row.size(); i++) {
            List<WebElement> col = row.get(i).findElements(By.tagName("td"));
            //  for (int j = 0; j < col.size(); j++) {
            if (col.get(0).getText().equals(user)) {
                System.out.println(col.get(0).getText());
                System.out.println(col.get(1).getText());
                System.out.println(col.get(2).getText());
                System.out.println(col.get(3).getText());
                System.out.println(col.get(4).getText());
                System.out.println(col.get(5).getText());
            }
            //      }
        }
    }

    public boolean tableTest(WebElement table, String name) {
        List<WebElement> row = table.findElements(By.tagName("tr"));
        for (int i = 0; i < row.size(); i++) {
            List<WebElement> col = row.get(i).findElements(By.tagName("td"));
            WebElement c = col.get(0);

            if (col.get(0).getText().equals(name)) {
                selectfromdropdown(col.get(1), "India");
                selectfromdropdown(col.get(2), "Maharashtra");
                selectCheckbox(col.get(3), true);
                selectRadioButton(col.get(4));
                return true;
            }
        }
        return false;

    }

    public void selectfromdropdown(WebElement col, String txt) {
        Select country = new Select(col);
        country.selectByVisibleText(txt);
    }

    public void selectCheckbox(WebElement col, boolean checked) {
        boolean isSelected = col.isSelected();
        if (checked) {
            if (!isSelected) {
                col.click();
            }
        } else {
            if (isSelected) {
                col.click();
            }
        }
    }

    public void selectRadioButton(WebElement col) {
        if (!col.isSelected()) {
            col.click();
        }
    }

    public boolean printUserDetails(String name) {
        wait.until(ExpectedConditions.visibilityOf(tabledata));
        List<WebElement> row = tabledata.findElements(By.tagName("tr"));
        for (int i = 1; i < row.size(); i++) {
            List<WebElement> col = row.get(i).findElements(By.tagName("td"));
            String data = col.get(0).getText();
            if (data.equals(name)) {
                for (int j = 0; j < col.size(); j++) {
                    // ArrayList<String> details = new ArrayList<String>();
                    //    details.add(col.get(j).getText());
                    System.out.println(col.get(j).getText());

                }
                System.out.println("------------------------------------------------------------------------");
                return true;
            }
        }
        return false;
    }


    public void ageGreaterThen(int age) {
        List<WebElement> row = tabledata.findElements(By.tagName("tr"));
        for (int i = 1; i < row.size(); i++) {
            List<WebElement> col = row.get(i).findElements(By.tagName("td"));
            String getAge = col.get(3).getText();
            int age1 = Integer.parseInt(getAge);
            if (age1 > age) {
                for (int j = 0; j < col.size(); j++) {
                    // ArrayList<String> details = new ArrayList<String>();
                    // details.add(col.get(j).getText());
                    System.out.println(col.get(j).getText());
                }
                System.out.println("------------------------------------------------------------------------");
            }

        }
    }

    public void pagination(String name) {
        for (int i = 0; i < 4; i++) {
            if (!printUserDetails(name)) {
                nextButton.click();
            } else {
                break;
            }
        }
    }
}
//Added Comments is edited