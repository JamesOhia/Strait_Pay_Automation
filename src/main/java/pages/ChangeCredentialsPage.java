package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ChangeCredentialsPage {
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
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_change_credentials")
    private WebElement changeCredentialsButton;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Change Credentials']")
    private WebElement changeCredentialsTitle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_old_password")
    private WebElement oldPassword;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_new_password")
    private WebElement newPassword;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_confirm_new_password")
    private WebElement confirmNewPassword;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_next")
    private WebElement updateButton;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_transaction_pin")
    private WebElement navigateTransactionPin;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_login_pin")
    private WebElement navigateLoginPin;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_password")
    private WebElement loginPassword;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_new_login_pin")
    private WebElement newLoginPin;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_confirm_new_login_pin")
    private WebElement confirmNewLoginPin;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backButton;




    public ChangeCredentialsPage(AndroidDriver <AndroidElement>driver) {
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

    public WebElement clickChangeCredentials(){
        changeCredentialsButton.click();
        return changeCredentialsButton;
    }

    public WebElement getChangeCredentialsTitle(){
        return changeCredentialsTitle;
    }

    public WebElement getUpdateButton(){
        return updateButton;
    }

    public WebElement clickUpdateButton(){
        updateButton.click();
        return updateButton;
    }

    public WebElement enterOldPassword(String input){
        oldPassword.clear();
        oldPassword.sendKeys(input);
        return oldPassword;
    }

    public WebElement enterNewPassword(String input){
        newPassword.clear();
        newPassword.sendKeys(input);
        return newPassword;
    }

    public WebElement enterConfirmPassword(String input){
        confirmNewPassword.clear();
        confirmNewPassword.sendKeys(input);
        return confirmNewPassword;
    }

    public WebElement clickNavigateTransactionPin(){
        navigateTransactionPin.click();
        return navigateTransactionPin;
    }

    public WebElement clickNavigateLoginPin(){
        navigateLoginPin.click();
        return navigateLoginPin;
    }

    public WebElement enterLoginPassword(String input){
        loginPassword.clear();
        loginPassword.sendKeys(input);
        return loginPassword;
    }

    public WebElement enterNewLoginPin(String input){
        newLoginPin.clear();
        newLoginPin.sendKeys(input);
        return newLoginPin;
    }

    public WebElement enterConfirmNewLoginPin(String input){
        confirmNewLoginPin.clear();
        confirmNewLoginPin.sendKeys(input);
        return confirmNewLoginPin;
    }


    public WebElement clickBackButton(){
        backButton.click();
        return backButton;
    }




}
