package utilities;


import core.BaseSetup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.StaleElementReferenceException;


public class CommonUtilities extends BaseSetup {
  private AppPermissionsUtilities appPermissionsUtilities;

    public CommonUtilities(AndroidDriver<AndroidElement> driver) {
       appPermissionsUtilities= new AppPermissionsUtilities(driver);

    }
    //Method to click
    public static void clickElement(AndroidElement element) {
        element.click();
    }

    //Method to setValue in input
    public static void setValue(AndroidDriver<?> driver, AndroidElement element, String inputValue) {
        element.setValue(inputValue);
        driver.hideKeyboard();
    }
    //Code for setting permission on device
    public void setAppPermissions() {
        if (appPermissionsUtilities.getAllowButton().isDisplayed()) {
            try {
                while (appPermissionsUtilities.getAllowButton().isDisplayed()) {
                    appPermissionsUtilities.allowPermission();
                }
            } catch (StaleElementReferenceException exception){
                System.out.println("In Catch Block");
                logger.info(exception);
            } catch (Exception exception) {
                logger.info(exception);
            }
        }
    }
}





