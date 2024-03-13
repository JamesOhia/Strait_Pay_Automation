package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginMethodPage {
    AndroidDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 3);

    //The Mobile Element Variables
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement menuButton;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Profile Management']")
    private WebElement profileManagementButton;
    @AndroidFindBy(id="com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement settingsTitle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_login_methods")
    private WebElement loginMethodButton;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement loginMethodTitle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/s_enable_password")
    private WebElement passwordToggle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/s_enable_pin")
    private WebElement pinToggle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/s_enable_fingerprint")
    private WebElement fingerPrintToggle;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backButton;






   public LoginMethodPage(AndroidDriver <AndroidElement>driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
       //For your Page Object Model
    }
    public WebElement clickMenu(){
        menuButton.click();
        return menuButton;
    }

    public WebElement clickProfileManagement(){
        profileManagementButton.click();
        return profileManagementButton;
    }

    public WebElement getSettingsTitle(){
           return settingsTitle;
    }

    public WebElement clickLoginMethod(){
        loginMethodButton.click();
        return loginMethodButton;
    }

    public WebElement getLoginMethodTitle(){
            return loginMethodTitle;
    }

    public WebElement clickPasswordToggle(){
            passwordToggle.click();
            return passwordToggle;
    }

    public WebElement clickPinToggle(){
        pinToggle.click();
        return pinToggle;
    }

    public WebElement clickFingerPrintToggle(){
        fingerPrintToggle.click();
        return fingerPrintToggle;
    }

    public WebElement clickBackButton(){
        backButton.click();
        return backButton;
    }
}
