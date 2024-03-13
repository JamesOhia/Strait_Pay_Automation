package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ForgetYourPinPage {
    AndroidDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 3);

    //The Mobile Element Variables
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_login")
    private WebElement loginPage;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement menuButton;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Profile Management']")
    private WebElement profileManagementButton;
    @AndroidFindBy(id="com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement settingsTitle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_reset_pin")
    private WebElement forgetYourPinButton;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Reset Transaction PIN']")
    private WebElement resetTransactionPinTitle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_password")
    private WebElement loginPassword;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_new_transaction_pin")
    private WebElement transactionPin;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_confirm_new_transaction_pin")
    private WebElement confirmTransactionPin;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_update")
    private WebElement updateButton;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backButton;




    public ForgetYourPinPage(AndroidDriver <AndroidElement>driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
        //For your Page Object Model
    }
    public WebElement getLoginPage(){
        return loginPage;
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

    public WebElement clickForgetYourPin(){
        forgetYourPinButton.click();
        return forgetYourPinButton;
    }

    public WebElement getResetTransactionPinTitle(){
        return resetTransactionPinTitle;
    }

    public WebElement getUpdateButton(){
        return updateButton;
    }

    public WebElement clickUpdateButton(){
        updateButton.click();
        return updateButton;
    }

    public WebElement enterLoginPassword(String input){
        loginPassword.clear();
        loginPassword.sendKeys(input);
        return loginPassword;
    }

    public WebElement enterTransactionPin(String input){
        transactionPin.clear();
        transactionPin.sendKeys(input);
        return transactionPin;
    }

    public WebElement enterConfirmTransactionPin(String input){
        transactionPin.clear();
        confirmTransactionPin.sendKeys(input);
        return confirmTransactionPin;
    }

    public WebElement clickBackButton(){
        backButton.click();
        return backButton;
    }




}
