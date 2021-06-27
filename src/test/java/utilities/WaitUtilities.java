package utilities;


import core.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtilities extends BaseSetup {

    static WebDriverWait wait;

    public static void initWait(WebDriver driver, int timeoutInSeconds) {
        try{
            wait = new WebDriverWait(driver, timeoutInSeconds);
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitImplicitly(WebDriver driver) {
        try{
            driver.manage().timeouts().implicitlyWait(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
        }catch(Exception e){
            System.out.println("printing excption : "+e);
            throw e;

        }
    }

    public static void waitForVisibilityOf(WebElement element, String message) {
        try {
            wait.withMessage(message);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitForElementToBeClickable(WebElement element, String message) {
        try{
            wait.withMessage(message);
            wait.until(ExpectedConditions.elementToBeClickable(element));//visibilityOf(element));
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitForNonVisibilityOf(WebElement element, String message) {
        try{
            wait.withMessage(message);
            wait.until(ExpectedConditions.invisibilityOf(element));
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitForTextToBePresentInElement(WebElement element, String text, String message) {
        try{
            wait.withMessage(message);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        }catch(Exception e){
            throw e;
        }
    }

    public static void waitImplicitly(WebDriver driver, int seconds) {
        try{
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        }catch(Exception e){
            throw e;
        }
    }


}
