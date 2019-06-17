import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class SimpleTest {
    public static void main (String[] args) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName" , "android");
        dc.setCapability("appPackage" , "com.android.calculator2");
        dc.setCapability("appActivity" , ".Calculator");

        AndroidDriver<AndroidElement> ad = new AndroidDriver<> ( new URL("http://127.0.0.1:4723/wd/hub"),dc);



        MobileElement el8 = ad.findElementById("com.android.calculator2:id/digit_2");
        el8.click();
        MobileElement el9 = ad.findElementById("com.android.calculator2:id/digit_5");
        el9.click();
        MobileElement el10 = ad.findElementByAccessibilityId("plus");
        el10.click();
        MobileElement el11 =  ad.findElementById("com.android.calculator2:id/digit_2");
        el11.click();
        MobileElement el12 = ad.findElementById("com.android.calculator2:id/digit_5");
        el12.click();
        MobileElement el13 = ad.findElementByAccessibilityId("equals");
        el13.click();

        Assert.assertEquals(ad.findElementById("com.android.calculator2:id/result").getText(), "50");

    }
}
