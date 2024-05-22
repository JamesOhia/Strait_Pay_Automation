package utility;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ScrollManager {
    AndroidDriver driver;

    public ScrollManager(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void scrollToText(String text) {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        + text + "\").instance(0))").click();
    }

    public void scrollToProduct(String product) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + product + "\"))");
    }

    public void scrollBottom() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(300);"));
    }

    public void scrollTop() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(-1000);"));
    }
}

//This is used to call the scroll method anywhere in the future when needed.
