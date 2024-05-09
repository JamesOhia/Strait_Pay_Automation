package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HideAccountBalancePage {
    AndroidDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 3);

    //The Mobile Element Variables
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/tv_login")
    private WebElement loginPage;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement menuButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Profile Management']")
    private WebElement profileManagementButton;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement settingsTitle;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/s_hide_account_balance")
    private WebElement hideAccountButton;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/tv_hide_account_balance_caption")
    private WebElement accountBalanceHidden;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backButton;


    public HideAccountBalancePage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
        //For your Page Object Model
    }

    public WebElement getLoginPage() {
        return loginPage;
    }

    public WebElement clickMenu() {
        menuButton.click();
        return menuButton;
    }

    public WebElement clickProfileManagement() {
        profileManagementButton.click();
        return profileManagementButton;
    }

    public WebElement getSettingsTitle() {
        return settingsTitle;
    }

    public WebElement clickHideAccountButton() {
        hideAccountButton.click();
        return hideAccountButton;
    }

    public WebElement getAccountBalanceHidden() {
        return accountBalanceHidden;
    }

    public WebElement clickBackButton(){
        backButton.click();
        return backButton;
    }
}