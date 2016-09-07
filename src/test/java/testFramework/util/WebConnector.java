package testFramework.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.picocontainer.classname.ClassName;


public class WebConnector {

    public static WebDriver driver;
    public static Properties properties;
    public static String baseURL;
    public static String browser;
    public static Logger logger;
    public static int width;
    public static int height;

    public void initialize() throws MalformedURLException {
        initializeLogger();
        initializeProperties();
        setProperties();
        setBrowser();
        manageBrowser();
    }

    public void initializeLogger(){
        logger = Logger.getLogger(ClassName.class.getName());
    }

    public void initializeProperties() {
        properties = new Properties();
        try {
            properties.load(WebConnector.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProperties() {
        String width;
        String height;
        baseURL = properties.getProperty("baseURL");
        browser = properties.getProperty("browser");
        width = properties.getProperty("width");
        height = properties.getProperty("height");
        WebConnector.width = Integer.parseInt(String.valueOf(width));
        WebConnector.height = Integer.parseInt(String.valueOf(Integer.parseInt(height)));
        System.out.println("Height is "+WebConnector.height);
        System.out.println("Width is "+WebConnector.width);
    }

    public void setBrowser() {
        switch (browser) {

            case "chrome":
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/chromedriver"));
                    driver = new ChromeDriver();
                    /*Point targetPosition = new Point(0, 0);
                    driver.manage().window().setPosition(targetPosition);
                    Dimension targetSize = new Dimension(1920, 1080); //your screen resolution here
                    driver.manage().window().setSize(targetSize);*/
                }
                break;

            case "firefox":
                if (driver == null) {
                    driver = new FirefoxDriver();
                }
                break;

            case "safari":
                if (driver == null) {
                    driver = new SafariDriver();
                }
                break;
        }

    }

    public void manageBrowser() {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return window.innerWidth"));
        System.out.println(js.executeScript("return window.innerHeight"));
        driver.manage().window().setSize(new Dimension(width, height));
        System.out.println("Height is "+height);
        System.out.println("Width is "+width);
    }

    public void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTextInElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.titleIs(pageTitle));
    }

    public void waitForElementToBeNotDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public boolean isNotDisplayed(WebElement element) {
        boolean result;
        try {
            result = !element.isDisplayed();
        } catch (NoSuchElementException e) {
            result = true;
        }
        return result;
    }

    public Boolean elementIsDisplayedOrNot(WebElement element) {
        Boolean displayed = true;
        try {
            if (element.isDisplayed())
                displayed = true;
        } catch (Throwable t) {
            displayed = false;
        }
        return displayed;
    }

    public void waitForElementToBePresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForButtonToEnable(WebElement button) {

        while (button.getAttribute("disabled") != null) {

        }

        System.out.println("The value of the disabled attribute is " + button.getAttribute("disabled"));
    }

    public void waitForElementToDisappear(WebElement element) {
        try {
            while (true) {
                element.isDisplayed();
            }
        } catch (Exception e) {
            System.out.println("Element has disappeared now");
        }
    }
}