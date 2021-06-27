package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * Created by Balashankar and Srivalli
 */
public class ScrollUtilities {


    private AndroidDriver<AndroidElement> driver;
    private org.openqa.selenium.Dimension size;

    public ScrollUtilities(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
//Get the resolution of the device
    private Dimension getSize() {
        size =driver.manage().window().getSize();
        return size;
    }

    // Swipe from left to right
    public void swipeHorizontallyLeftToRight() {

        size = this.getSize();
        System.out.println("Size : ============" + size);

        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        int startx = (int) (size.width * 0.01);
//        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * 0.80);
//        //Find vertical point where you wants to swipe. It is in middle of screen height.
        // int starty = size.height / 2;
//        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

        (new TouchAction(driver))
                .press(PointOption.point(startx, endx))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(10000)))
                .moveTo(PointOption.point(endx, startx))
                .release()
                .perform();
    }
    // Swipe from right to left
    public void swpieHorizontallyRighttoLeft() {

        size = this.getSize();
        System.out.println(size);

        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        int startx = (int) (size.width * 0.01);
//        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * 0.80);
//        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = size.height / 2;
        (new TouchAction(driver))
                .press(PointOption.point(starty, endx))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startx, starty))
                .release()
                .perform();
    }

    // Scroll from bottom to top
    public void scrollBottomToTop() {

        size = this.getSize();
        System.out.println("Size : ================" + size);
        int starty = (int) (size.height * 0.80);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.20);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;

        (new TouchAction(driver))
                .press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startx, endy))
                .release().perform();
    }

    // scroll from top to bottom
    public void scrollTopToBottom() {

        size = this.getSize();
        System.out.println("Size : ================" + size);
        int starty = (int) (size.height * 0.20);
//Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.80);
//Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;

        (new TouchAction(driver))
                .press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startx, endy))
                .release()
                .perform();

    }


}

