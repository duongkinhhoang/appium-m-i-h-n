package pac2;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.testng.Assert.assertEquals;



public class DemoTests extends SetupStep {
    @Test(testName = "Calculator")
    public void testOne() {
        MobileElement two = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        two.click();
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        plus.click();
        MobileElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        three.click();
        MobileElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));
        equals.click();
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        assertEquals(result.getText(), "5" );
        System.out.println("Result testOne: " + result.getText());
        verticalScroll(2);

    }

    @Test(testName = "Test-TouchAction-Tap-LongPress")
    public void testTouchActionTapLongPress() {
        MobileElement apiDemoslabels = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[2]");
        apiDemoslabels.click();
        tap(setViewLabel());
        MobileElement dateWidgetsLabel = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[7]");
        dateWidgetsLabel.click();
        MobileElement inlineLabel = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[2]");
        inlineLabel.click();
    }


}
