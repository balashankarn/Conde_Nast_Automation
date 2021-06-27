package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TabBarNavigationPage;
import utilities.CommonUtilities;
import utilities.ScrollUtilities;
import utilities.WaitUtilities;

/**
 * Created by Balashankar
 */
public class SanityTest extends BaseSetup {
    private CommonUtilities commonUtilities;
    private ScrollUtilities scrollUtilities;
    private WaitUtilities waitUtilities;
    private HomePage homePage;
    private TabBarNavigationPage tabBarNavigationPage;

    @BeforeTest(alwaysRun = true)
    public void init() {
        commonUtilities = new CommonUtilities(driver);
        scrollUtilities = new ScrollUtilities(driver);
        waitUtilities= new WaitUtilities();
        homePage = new HomePage(driver);
        tabBarNavigationPage =new TabBarNavigationPage(driver);
    }

    @BeforeClass(alwaysRun = true)
    public void initialSetup() throws JsonProcessingException, InterruptedException {

        commonUtilities.setAppPermissions();
    }
 //Verify Whether user is able to perform up and down
    @Test(priority = 1)
  public void performScroll(){
     WaitUtilities.waitForElementToBeClickable(homePage.getFree_Trial_Button(),"Free trial button not clickable");
     scrollUtilities.scrollBottomToTop();
     scrollUtilities.scrollTopToBottom();
    }
 //Verify The UI element is homepage
    @Test(priority = 2)
    public void verifyHomeUI(){
        Assert.assertTrue(homePage.getFree_Trial_Button().isDisplayed());//7days free trial is displayed
        Assert.assertTrue(homePage.getSubscribe_Button().isDisplayed());//Subscribe is displayed
        Assert.assertTrue(homePage.getRecentIssues_ViewAll_Button().isDisplayed());//recent view all buttons
        Assert.assertTrue(homePage.getShare_Button().isDisplayed());//
        Assert.assertTrue(homePage.getSearch_Box().isDisplayed());

    }
@Test(priority = 3)
public void click_On_Subcribe(){
        CommonUtilities.clickElement(homePage.getSubscribe_Button());
        WaitUtilities.waitForElementToBeClickable(homePage.getOffer_Subscribe_Button(),"not clickable");
        driver.navigate().back();
}
@Test(priority = 4)
public void click_On_Search(){
        CommonUtilities.clickElement(homePage.getSearch_Box());
        WaitUtilities.waitForElementToBeClickable(homePage.getSearch_TextField(),"Not clickable");
        CommonUtilities.setValue(driver,homePage.getSearch_TextField(),"hello");
        driver.navigate().back();
}

@Test(priority = 5)
    public void navigate_To_Issues(){
        CommonUtilities.clickElement(tabBarNavigationPage.getIssues_Button());
}



}