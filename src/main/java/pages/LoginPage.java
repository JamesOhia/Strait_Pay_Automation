package pages;

import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;


import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    AndroidDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 3);

    //The Mobile Element Variables
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_personal")
    private WebElement individualLogin;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_business")
    private WebElement businessLogin;
    @AndroidFindBy(id="com.appzonegroup.fcmb.dev:id/et_username")
    private WebElement userName;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_password")
    private WebElement password;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_login")
    private WebElement loginBtn;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement loginErrorTitle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_message")
    private WebElement loginErrorMessage;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_continue")
    private WebElement cancelErrorMessage;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/tv_login")
    private WebElement loginPage;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/dashboard")
    private WebElement dashboardPage;





   public LoginPage(AndroidDriver <AndroidElement>driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
       //For your Page Object Model
    }
    public WebElement clickIndividualLogin(){
        individualLogin.click();
        return individualLogin;
    }

    public WebElement clickBusinessLogin(){
        businessLogin.click();
        return businessLogin;
    }

    public WebElement enterUserName(String Username){
           userName.clear();
           userName.sendKeys(Username);
           return userName;
    }

    public WebElement enterPassword(String Password){

            password.clear();
            password.sendKeys(Password);
            return password;
    }

    public WebElement clickLoginBtn(){
           loginBtn.click();
           return loginBtn;
    }

    public WebElement getLoginErrorTitle(){
           return loginErrorTitle;
    }

    public WebElement getLoginErrorMessage(){
            return loginErrorMessage;
    }

    public WebElement clickCancelError(){
            cancelErrorMessage.click();
            return cancelErrorMessage;
    }

    public WebElement getLoginPage(){
            return loginPage;
    }

    public WebElement clearUserName(){
            userName.clear();
            return userName;

    }

    public WebElement clearPassword(){
            password.clear();
            return password;
    }

    public WebElement getLoginBtn(){
            return loginBtn;
    }

    public WebElement getDashboardPage(){
        return dashboardPage;
    }





}
