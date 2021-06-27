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
public class SettingPage extends BaseSetup {

    public SettingPage(AndroidDriver<AndroidElement>driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/layout_account")
    private AndroidElement account_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/layout_redeem")
    private AndroidElement redeem_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/layout_help")
    private AndroidElement help_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/layout_about_new")
    private AndroidElement about_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/layout_rate_us")
    private AndroidElement rate_Us_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/txt_register")
    private AndroidElement setting_Register_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/txt_login")
    private AndroidElement setting_Login_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/txt_redeem_login")
    private AndroidElement redeem_Login_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/txt_terms")
    private AndroidElement about_Terms_Condition_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/txt_privacy")
    private AndroidElement about__Privacy_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/txt_versionn")
    private AndroidElement about_Version_Button;

    public AndroidElement getBack_Button() {
        return back_Button;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/settings_sub_page_back")
    private AndroidElement back_Button;

    public AndroidElement getAccount_Button() {
        return account_Button;
    }

    public AndroidElement getRedeem_Button() {
        return redeem_Button;
    }

    public AndroidElement getHelp_Button() {
        return help_Button;
    }

    public AndroidElement getAbout_Button() {
        return about_Button;
    }

    public AndroidElement getRate_Us_Button() {
        return rate_Us_Button;
    }

    public AndroidElement getSetting_Register_Button() {
        return setting_Register_Button;
    }

    public AndroidElement getSetting_Login_Button() {
        return setting_Login_Button;
    }

    public AndroidElement getRedeem_Login_Button() {
        return redeem_Login_Button;
    }

    public AndroidElement getAbout_Terms_Condition_Button() {
        return about_Terms_Condition_Button;
    }

    public AndroidElement getAbout__Privacy_Button() {
        return about__Privacy_Button;
    }

    public AndroidElement getAbout_Version_Button() {
        return about_Version_Button;
    }
}
