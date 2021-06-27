package pages;

import core.BaseSetup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Balashankar
 */
public class MyCollectionPage extends BaseSetup {
    public MyCollectionPage(AndroidDriver<AndroidElement> driver){
        this.driver= driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath ="//android.widget.Button[@content-desc='Bookmarks'])" )
    private AndroidElement on_MY_Device;
    @AndroidFindBy(className = "//androidx.appcompat.app.ActionBar$Tab(@index,'1')")
    private AndroidElement bookMarks;
    @AndroidFindBy(className = "//androidx.appcompat.app.ActionBar$Tab(@index,'2')")
    private AndroidElement clip;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/bookmark_login_button")
    private AndroidElement booMark_Login;

    public AndroidElement getOn_MY_Device() {
        return on_MY_Device;
    }

    public AndroidElement getBookMarks() {
        return bookMarks;
    }

    public AndroidElement getClip() {
        return clip;
    }

    public AndroidElement getBooMark_Login() {
        return booMark_Login;
    }
}
