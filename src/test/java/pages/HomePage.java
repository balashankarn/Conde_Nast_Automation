package pages;

import core.BaseSetup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Balashankar and Srivalli
 */
public class HomePage extends BaseSetup {

    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public AndroidElement getHome_NavigationButton() {
        return home_NavigationButton;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/navigation_home")
    private AndroidElement home_NavigationButton;


    public AndroidElement getFree_Trial_Button() {
        return free_Trial_Button;
    }

    @AndroidFindBy(id ="com.magzter.condenasttravellerindia:id/home_fragment_latest_issue_try_now")
    private AndroidElement free_Trial_Button;

    public AndroidElement getSubscribe_Button() {
        return subscribe_Button;
    }

    @AndroidFindBy(id="com.magzter.condenasttravellerindia:id/home_fragment_latest_issue_subscribe_btn")
    private AndroidElement subscribe_Button;

    public AndroidElement getRecentIssues_ViewAll_Button() {
        return recentIssues_ViewAll_Button;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/home_fragment_issues_load_more")
    private AndroidElement recentIssues_ViewAll_Button;

    public AndroidElement getShare_Button() {
        return share_Button;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/home_fragment_share")
    private AndroidElement share_Button;

    public AndroidElement getUpdate_Card_Button() {
        return update_Card_Button;
    }

    @AndroidFindBy(id = "com.android.vending:id/0_resource_name_obfuscated")
    private AndroidElement update_Card_Button;


    public AndroidElement getSearch_Box() {
        return search_Box;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/home_fragment_search_bar")
    private AndroidElement search_Box;

    public AndroidElement getSearch_TextField() {
        return search_TextField;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/search_src_text")
    private AndroidElement search_TextField;

    public AndroidElement getOffer_Subscribe_Button() {
        return Offer_Subscribe_Button;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/subscribe_offer_buy_button")
    private AndroidElement Offer_Subscribe_Button;



}
