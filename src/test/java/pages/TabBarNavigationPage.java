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
public class TabBarNavigationPage extends BaseSetup {

    public AndroidElement getIssues_Button() {
        return issues_Button;
    }

    public AndroidElement getArticles_Button() {
        return articles_Button;
    }

    public AndroidElement getMy_Collection_Button() {
        return my_Collection_Button;
    }

    public AndroidElement getSettings_Button() {
        return settings_Button;
    }

    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/navigation_issues")
    private AndroidElement issues_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/navigation_articles")
    private AndroidElement articles_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/navigation_my_collection")
    private AndroidElement my_Collection_Button;
    @AndroidFindBy(id = "com.magzter.condenasttravellerindia:id/navigation_settings")
    private AndroidElement settings_Button;

   public TabBarNavigationPage(AndroidDriver<AndroidElement> driver) {
       this.driver = driver;
       PageFactory.initElements(new AppiumFieldDecorator(driver), this);
   }


}
