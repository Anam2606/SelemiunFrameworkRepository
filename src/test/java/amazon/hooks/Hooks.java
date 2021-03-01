package amazon.hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {

    //    private static ThreadLocal<WebDriver> abc = new ThreadLocal<WebDriver>();
    private static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver, 10);
//        abc.set(new ChromeDriver());
        System.out.println("this is before");
    }

    @After (order = 0)
    public void quit() {
        System.out.println("this is after");
        driver.quit();
//        abc.get().quit();
    }

//    @After (order = 1)
//    public void takeScreenshot(Scenario scenario){
//        if (scenario.isFailed()){
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            byte[] scr = ts.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(scr, "image/png","screenshot");
//        }
//    }

    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario){
        TakesScreenshot ts = (TakesScreenshot)driver;
        byte[] scr = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(scr,"image/png","screenshot");
    }

    public static WebDriver getDriver() {
//        return abc.get();
        return driver;
    }

    public static WebDriverWait expicitWait(){
        return wait;
    }
    }

