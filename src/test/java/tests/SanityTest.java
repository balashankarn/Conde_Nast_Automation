package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
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
    private IssuePage issuePage;
    private MyCollectionPage myCollectionPage;
    private SettingPage settingPage;

    @BeforeTest(alwaysRun = true)
    public void init() {
        commonUtilities = new CommonUtilities(driver);
        scrollUtilities = new ScrollUtilities(driver);
        waitUtilities= new WaitUtilities();
        homePage = new HomePage(driver);
        tabBarNavigationPage =new TabBarNavigationPage(driver);
        issuePage=new IssuePage(driver);
        myCollectionPage=new MyCollectionPage(driver);
        settingPage= new SettingPage(driver);

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
//Verify Whether user is able click on subscribe
@Test(priority = 3)
public void click_On_Subcribe(){
        CommonUtilities.clickElement(homePage.getSubscribe_Button());
        WaitUtilities.waitForElementToBeClickable(homePage.getOffer_Subscribe_Button(),"not clickable");
        driver.navigate().back();
}
//Verify Whether user is able to click on search
@Test(priority = 4)
public void click_On_Search(){
        CommonUtilities.clickElement(homePage.getSearch_Box());
        WaitUtilities.waitForElementToBeClickable(homePage.getSearch_TextField(),"Not clickable");
        CommonUtilities.setValue(driver,homePage.getSearch_TextField(),"hoooooololol");
        WaitUtilities.waitForVisibilityOf(homePage.getNo_Result_Found(),"Element not present");
        driver.navigate().back();
}
//Verify whether user is able to navigate to issue Tab
@Test(priority = 5)
    public void navigate_To_Issues(){
        CommonUtilities.clickElement(tabBarNavigationPage.getIssues_Button());
}

//Verify UI of Issue TAB
@Test(priority = 6,groups = {"Sanity"})
    public void perform_Scroll(){
        scrollUtilities.scrollBottomToTop();
        scrollUtilities.scrollTopToBottom();
}
//Verify UI of Issue Detail screen
    @Test(priority = 7,groups = {"Sanity"})
    public void verify_Issue_Screen_UI(){
        Assert.assertTrue(issuePage.getTraveller_May().isDisplayed());
        Assert.assertTrue(issuePage.getPreview_Button().isDisplayed());
        Assert.assertTrue(issuePage.getPrice_Button().isDisplayed());
    }
//Verify user is able to navigate to articles
    @Test(priority = 8)
    public void navigate_To_Articles(){
        CommonUtilities.clickElement(tabBarNavigationPage.getArticles_Button());
    }
 //Verify whether user is able to scroll up and down
    @Test(priority = 9)
    public void scroll_Up_Down(){
        scrollUtilities.scrollBottomToTop();
        scrollUtilities.scrollTopToBottom();
    }
//verify user is able to navigate to my collection screen
    @Test(priority = 10)
    public void navigate_T0_Mycollection(){
        CommonUtilities.clickElement(tabBarNavigationPage.getMy_Collection_Button());
    }
 //Verify user is able to navigate to Setting page
    @Test(priority = 11)
    public void navigate_To_Setting(){
      CommonUtilities.clickElement(tabBarNavigationPage.getSettings_Button());
    }
 //Verify Setting UI
    @Test(priority = 12)
    public void verify_Setting_UI(){
        Assert.assertTrue(settingPage.getAccount_Button().isDisplayed());
        Assert.assertTrue(settingPage.getRedeem_Button().isDisplayed());
        Assert.assertTrue(settingPage.getHelp_Button().isDisplayed());
        Assert.assertTrue(settingPage.getAbout_Button().isDisplayed());
        Assert.assertTrue(settingPage.getRate_Us_Button().isDisplayed());
    }
 //Verify the user is able to navigate to account screen and Verify UI
  @Test(priority = 13)
  public void click_On_Account(){
        CommonUtilities.clickElement(settingPage.getAccount_Button());
        Assert.assertTrue(settingPage.getSetting_Register_Button().isDisplayed());
      Assert.assertTrue(settingPage.getSetting_Register_Button().isDisplayed());
      CommonUtilities.clickElement(settingPage.getBack_Button());
  }
  //verify redeem screen navigation and verify UI
  @Test(priority =14)
    public void navigate_To_Redeem(){
        CommonUtilities.clickElement(settingPage.getRedeem_Button());
        Assert.assertTrue(settingPage.getRedeem_Login_Button().isDisplayed());
        CommonUtilities.clickElement(settingPage.getBack_Button());
  }
//Verify UI and Navigation
@Test(priority = 15)
    public void navigate_To_About(){
        CommonUtilities.clickElement(settingPage.getAbout_Button());
        Assert.assertTrue(settingPage.getAbout__Privacy_Button().isDisplayed());
        Assert.assertTrue(settingPage.getAbout_Terms_Condition_Button().isDisplayed());
        Assert.assertTrue(settingPage.getAbout_Version_Button().isDisplayed());
        CommonUtilities.clickElement(settingPage.getBack_Button());
}
}