package actions;

import com.google.common.io.Files;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CapabilitySetup extends ExtentReportClass{
     public static AndroidDriver driver;
     private static AppiumDriverLocalService service;

    @BeforeClass
    public void SetUp() throws MalformedURLException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("fullReset", "false");
        //force apk not to re-install
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("appPackage", "com.appzonegroup.fcmb.dev");
        capabilities.setCapability("appActivity", "com.appzonegroup.fcmb.features.login.activity.SplashActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        //Skip the installation of io.appium.settings app and the UIAutomator 2 server
        //capabilities.setCapability("skipDeviceInitialization", "tr

        //Skip the installation of io.appium.settings app and the UIAutomator 2 server
//        capabilities.setCapability("skipDeviceInitialization", "true");
//        capabilities.setCapability("skipServerInstallation", "true");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * finishing.
     */
  /* @AfterClass
    public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }*/

   /* @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".jpeg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}
