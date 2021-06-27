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
public class IssuePage extends BaseSetup {

    public IssuePage(AndroidDriver<AndroidElement>driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public AndroidElement getTraveller_May() {
        return traveller_May;
    }

    public AndroidElement getPreview_Button() {
        return preview_Button;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'May - June - July 2021 ')]")
    private AndroidElement traveller_May;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/issue_list_item_preview")
    private AndroidElement preview_Button;

    public AndroidElement getPrice_Button() {
        return price_Button;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/issue_list_item_buy")
    private AndroidElement price_Button;



}
