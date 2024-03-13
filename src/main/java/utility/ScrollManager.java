package utility;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollManager {
    AndroidDriver driver;

    public ScrollManager(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void scrollToText(String text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))")).click();

    }

    public void scrollToProduct(String product) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + product + "\"))");
    }
}

//This is used to call the scroll method anywhere in the future when needed.
