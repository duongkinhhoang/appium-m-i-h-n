package pac2;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.*;

public class SetupStep {

    public static AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//          caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//            caps.setCapability("appPackage", "com.android.calculator2");
//            caps.setCapability("appActivity", "com.android.calculator2.Calculator");
            caps.setCapability("appPackage", "com.touchboarder.android.api.demos");
            caps.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");

            caps.setCapability(MobileCapabilityType.NO_RESET, true);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AppiumDriver<MobileElement>(url, caps);
            driver = new AndroidDriver<MobileElement>(url, caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Cause is: " + exp.getMessage());
            exp.printStackTrace();
        }
    }

    public void verticalScroll(int retries) {
        Dimension screen_dimensions = driver.manage().window().getSize();
        int location_x = (int) (screen_dimensions.width * 0.5);
        int location_start_y = (int) (screen_dimensions.height * 0.6);
        int location_end_y = (int) (screen_dimensions.height * 0.3);
        TouchAction<?> touchAction = new TouchAction<>(driver);
        PointOption start = new PointOption().withCoordinates(location_x, location_start_y);
        PointOption end = new PointOption().withCoordinates(location_x, location_end_y);
        for (int i = 0; i < retries; i++)
            touchAction
                    .press(end)
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(start)
                    .release()
                    .perform();
    }

    public MobileElement setViewLabel (){
        By  viewLabel = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[13]");
        return driver.findElement(viewLabel);
    }

    public void tap(MobileElement setViewLabel){
         new AndroidTouchAction(driver)
                 .tap(tapOptions().withElement(element(setViewLabel())))
                 .perform();
    }




    @AfterSuite
    public void tearDown() {
        driver.closeApp();
    }
}


