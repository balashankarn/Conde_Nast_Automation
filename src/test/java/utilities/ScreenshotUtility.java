package utilities;

/**
 * Created by Balashankar and Srivalli
 */
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentTest;
import core.BaseSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ReportLibrary;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility extends BaseSetup implements ITestListener {

    private ExtentTest extentTest;

    // This method will execute before starting of Test suite.
    public void onStart(ITestContext tr) {

    }

    // This method will execute, Once the Test suite is finished.
    public void onFinish(ITestContext result) {

    }


    // This method will execute only when the test is pass.
    public void onTestSuccess(ITestResult result) {
        extentTest = ReportLibrary.extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        captureScreenShot(result, "pass");
    }

    // This method will execute only on the event of fail test.
    public void onTestFailure(ITestResult result) {

        extentTest = ReportLibrary.extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        captureScreenShot(result, "fail");
    }

    // This method will execute before the main test start (@Test)
    public void onTestStart(ITestResult tr) {

    }

    // This method will execute only if any of the main test(@Test) get skipped
    public void onTestSkipped(ITestResult result) {
        extentTest = ReportLibrary.extentReports.createTest(result.getName());
        extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    // Function to capture screenshot.
    private static void captureScreenShot(ITestResult result, String status) {
        // AndroidDriver driver=ScreenshotOnPassFail.getDriver();
        String destDir = "";
        String passfailMethod = result.getMethod().getRealClass(). getSimpleName() + "." + result.getMethod().getMethodName();

        // To capture screenshot.
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        File scrFile=scrShot.getScreenshotAs(OutputType.FILE);

        //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

        // If status = fail then set folder name "screenshots/Failures"
        if (status.equalsIgnoreCase("fail")) {
            destDir = properties.getProperty("failurescreenshotpath");
        }
        // If status = pass then set folder name "screenshots/Success"
        else if (status.equalsIgnoreCase("pass")) {
            destDir = properties.getProperty("successscreenshotpath");
        }
        else if (status.equalsIgnoreCase("Test Start")) {
            destDir = properties.getProperty("teststartscreenshotpath");
        }

        // To create folder to store screenshots
        new File(destDir).mkdirs();
        // Set file name with combination of test class name + date time.
        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";

        try {
            // Store file at destination folder location
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

