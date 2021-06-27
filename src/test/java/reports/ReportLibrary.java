package reports;

import core.BaseSetup;

/**
 * Created by Balashankar
 */
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReportLibrary extends BaseSetup {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extentReports;

    public void reportSetup() {

        extentReports = new ExtentReports();
        String reportPath = properties.getProperty("reportspath") + "/test-output/" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "ExtentReport.html";

        sparkReporter = new ExtentSparkReporter(new File(reportPath));

        sparkReporter.config().setDocumentTitle("Mobile Automation");
        sparkReporter.config().setReportName("Automation Execution Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extentReports.attachReporter(sparkReporter);


        extentReports.setSystemInfo("condenast","Extent Report");
        extentReports.setSystemInfo("Platform",System.getProperty("os.name"));
        extentReports.setSystemInfo("Environment","Prod");

        // directory where output is to be printed
   /* ExtentSparkReporter spark = new ExtentSparkReporter(properties.getProperty("reportspath") + "/test-output/"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) +"ExtentReport.html");
    ExtentReports extent = new ExtentReports();
    extent.*/

    }

    public void endReport() {
        extentReports.flush();
    }

}