package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AppPermissionsUtilities {

    private AndroidDriver<AndroidElement> driver;

    @AndroidFindBy(id ="com.android.permissioncontroller:id/permission_allow_button")
   private AndroidElement allowButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private AndroidElement denyButton;


    public AppPermissionsUtilities(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public AndroidElement getAllowButton() {
        return allowButton;
    }

    public AndroidElement getDenyButton() {
        return denyButton;
    }

    public void allowPermission() {
        getAllowButton().click();
    }

    public void denyPermission(){
        getDenyButton().click();
    }

}
