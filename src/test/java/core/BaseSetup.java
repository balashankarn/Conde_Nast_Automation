package core;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.condenast.jsonmodel.LoginDataModel;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ReportLibrary;
import utilities.ScreenshotUtility;
import utilities.WaitUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@Listeners({ScreenshotUtility.class})
public class BaseSetup {

    public final static Logger logger = LogManager.getLogger(BaseSetup.class);
    public static AndroidDriver<AndroidElement> driver;
    protected static Properties properties;

  public LoginDataModel loginDataModel;

    public ReportLibrary reportLibrary;

    public static ExtentTest extentTest;

    private AppiumServiceBuilder builder;
    private AppiumDriverLocalService service;

    String appiumServiceUrl;

    public ObjectMapper mapper;
    public JsonNode doc;

    public static final int TIMEOUT_IN_SECONDS = 45;

    private static final String PROPERTIES_FILEPATH = "./config.properties";
    private static final String LOGIN_DATA_JSON_PATH = "logindata.json";
    private static final String APPIUM_JS_PATH = "appiumjspath";
    private static final String NODE_PATH = "Node";

 //   private static final String Conde_APP_APK_PATH = "condenastAPK";
    private static final String APP_PACKAGE = "androidAppPackage";
    private static final String APP_ACTIVITY = "androidAppActivity";

    @BeforeSuite(alwaysRun = true)
    public void setup() throws IOException {

        reportLibrary = new ReportLibrary();

        this.defineProperties();
        this.startServer();
        this.defineJson(properties.getProperty(LOGIN_DATA_JSON_PATH));
        this.defineDevice();
        this.startReport();
        WaitUtilities.initWait(driver, TIMEOUT_IN_SECONDS);
    }

    protected void defineProperties() {
        properties = new Properties();
        try {
            File file = new File(PROPERTIES_FILEPATH);
            FileInputStream fileInput = new FileInputStream(file);
            properties.load(fileInput);
            logger.info("Properties Defined============");

        } catch (IOException e) {
            System.out.println("Error at getting properties from project.properties at Base class");
            e.printStackTrace();
        }
    }

    protected void defineJson(String jsonFileName) {
        mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            doc = mapper.readTree(new File(jsonFileName));
        } catch (Exception exception) {
            System.out.println("Exception : " + exception);

        }
        System.out.println("Json data" + doc);
    }

    private void startServer() {
        //Build the Appium service
        try {
            builder = new AppiumServiceBuilder();
            builder.usingDriverExecutable(new File(properties.getProperty(NODE_PATH)))
                    .withAppiumJS(new File(properties.getProperty(APPIUM_JS_PATH)))
                    .usingAnyFreePort();
            //Start the server with the builder
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
            appiumServiceUrl = service.getUrl().toString();
            logger.error("appium Server======== : " + service.getUrl().toString());

        } catch (Exception e) {
            logger.error("Exception in Appium server start ===== "+e);
        }
    }

    private void defineDevice() throws MalformedURLException {

        System.out.println("Inside capabilities");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("skipUnlock",true);
        capabilities.setCapability("clearSystemFiles",true);
        //  capabilities.setCapability("autoGrantPermissions",true);
      // capabilities.setCapability("app", properties.getProperty(Conde_APP_APK_PATH));
        capabilities.setCapability("appPackage", properties.getProperty(APP_PACKAGE));
        capabilities.setCapability("appActivity",properties.getProperty(APP_ACTIVITY));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS",true);
        //capabilities.setCapability("autoGrantPermissions",true);

            driver = new AndroidDriver<>(new URL(appiumServiceUrl), capabilities);
        }

        private void startReport() {
            try {

                System.out.println("Inside Report=============");
                reportLibrary.reportSetup();
            }catch (Exception e){
            logger.error("Report Start Exception" + e);
        }
    }



    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetup() {

    }

    @AfterMethod(alwaysRun = true)
    public void closeMethod(ITestResult result) {

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.log(Status.FAIL, "Test Case Failed is " + result.getName());
                extentTest.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());

            } else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.log(Status.SKIP, "Test Case Skipped is " + result.getName());
            }

        }
        catch (Exception e) {
            System.out.println("Report Exception : "+e);
            logger.error(" Exception" + e);
        }
    }

    //  @AfterClass(alwaysRun = true)
    public void resetApp(){
        //driver.resetApp();
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        reportLibrary.endReport();
        service.stop();
    }
}
