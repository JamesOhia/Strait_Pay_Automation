package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ForgetCredentialsPage {
    AndroidDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 3);

    //The Mobile Element Variables
    @AndroidFindBy(id="com.appzonegroup.fcmb.dev:id/tv_forgot_password")
    private WebElement forgotCredBtn;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/item_one_tv")
    private WebElement forgetPasswordBtn;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_main_title")
    private WebElement recoverPage;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_action")
    private WebElement userNameField;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_next")
    private WebElement btnNext;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement cardPage;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backButton;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/item_two_tv")
    private WebElement forgetUsernameBtn;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_first_6_digits")
    private WebElement first5Digit;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_last_4_digits")
    private WebElement last4Digits;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_expiry_date")
    private WebElement expiryDate;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_pin")
    private WebElement enterPin;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement cardFailureTitle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_continue")
    private WebElement errorButton;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_click_otp")
    private WebElement otpButton;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement otpFailureTitle;






   public ForgetCredentialsPage(AndroidDriver <AndroidElement>driver) {
       PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
       //For your Page Object Model
   }

    public WebElement clickForgetCredBtn(){
           forgotCredBtn.click();
           return forgotCredBtn;
    }

    public WebElement clickForgetPasswordBtn(){
        forgetPasswordBtn.click();
        return forgetPasswordBtn;
    }

    public WebElement getRecoverPage(){
           return recoverPage;
    }

    public WebElement enterUsernameField(String Username){
        userNameField.clear();
        userNameField.sendKeys(Username);
        return userNameField;
    }

    public WebElement clearUsername(){
        userNameField.clear();
        return userNameField;

    }

    public WebElement clickBtnNext(){
        btnNext.click();
        return btnNext;
    }

    public WebElement getBtnNext(){
        return btnNext;
    }

    public WebElement getCardPage(){
            return cardPage;
    }

    public WebElement clickBackButton(){
        backButton.click();
        return backButton;
    }

    public WebElement enterFirst5Digits(String first5CardNumber){
        first5Digit.clear();
        first5Digit.sendKeys(first5CardNumber);
        return first5Digit;
    }

    public WebElement enterLast4Digits(String last4CardNumber){
        last4Digits.clear();
        last4Digits.sendKeys(last4CardNumber);
        return last4Digits;
    }

    public WebElement enterExpiryDate(String expiryDateNumber){
        expiryDate.clear();
        expiryDate.sendKeys(expiryDateNumber);
        return expiryDate;
    }

    //btnNext

    public WebElement enterPinNumber(String pinNumber){
        enterPin.sendKeys(pinNumber);
        return enterPin;
    }

    public WebElement getCardFailureTitle(){
        return cardFailureTitle;
    }

    public WebElement clickErrorButton(){
        errorButton.click();
        return errorButton;
    }

    public WebElement clickOTPButton(){
        otpButton.click();
        return otpButton;
    }

    public WebElement getOtpFailureTitle(){
        return otpFailureTitle;
    }
    //ClickErrorButton

    public WebElement clickForgetUsernameBtn(){
            forgetUsernameBtn.clear();
            return forgetUsernameBtn;

    }

   /* public WebElement getUsern(){
            password.clear();
            return password;
    }
    */





}
