package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageBeneficiariesPage {
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
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/rl_manage_beneficiaries")
    private WebElement manageBenefeciariesButton;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Manage Beneficiaries']")
    private WebElement manageBeneficiariesTitle;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_account")
    private WebElement accountButoon;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_search")
    private WebElement searchAccount;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/add_new")
    private WebElement addNewBeneficiary;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Add Account Number']")
    private WebElement optionAccounNumber;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_account_no")
    private WebElement accountNumber;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'GTBank Plc")
    private WebElement optionBank;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_add_new_beneficiary")
    private WebElement addBeneficiaryButton;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'OHIA JAMES CHUKWUEMEKA']")
    private WebElement chooseBeneficiary;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_delete_beneficiary")
    private WebElement deleteBeneficiary;
    @AndroidFindBy(id= "android:id/button1")
    private WebElement confirmDelete;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_airtime")
    private WebElement selfTopButton;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_search")
    private WebElement searchNumber;
    @AndroidFindBy(id= "//android.widget.TextView[@text = 'Add Phone Number']")
    private WebElement addPhoneNumber;
    @AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    private WebElement airtelButton;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_phone_number")
    private WebElement number;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_name")
    private WebElement name;
    @AndroidFindBy(id= "//android.widget.TextView[@text = 'James']")
    private WebElement numberBeneficiary;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backButton;




    public ManageBeneficiariesPage(AndroidDriver <AndroidElement>driver) {
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

    public WebElement clickManageBeneficiaries(){
        manageBenefeciariesButton.click();
        return manageBenefeciariesButton;
    }

    public WebElement getManageBeneficiariesTitle(){
        return manageBeneficiariesTitle;
    }

    public WebElement enterSearchAccount(String input){
        searchAccount.sendKeys(input);
        searchAccount.sendKeys(Keys.ENTER);
        return searchAccount;
    }

    public WebElement clickNewAddBeneficiaryButton(){
        addNewBeneficiary.click();
        return addNewBeneficiary;
    }

    public WebElement clickAddAccountNumber(){
        accountNumber.click();
        return accountNumber;
    }

    public WebElement enterAccountNumber(String input){
        accountNumber.clear();
        accountNumber.sendKeys(input);
        return accountNumber;
    }

    public WebElement clickOptionBank(){
        optionBank.click();
        return optionBank;
    }

    public WebElement clickAddBeneficiaryButton(){
        addBeneficiaryButton.click();
        return addBeneficiaryButton;
    }

    public WebElement clickChooseBeneficiary(){
        chooseBeneficiary.click();
        return chooseBeneficiary;
    }

    public WebElement clickSelfTopButton(){
        selfTopButton.click();
        return selfTopButton;
    }

    public WebElement clickConfirmDelete(){
        confirmDelete.click();
        return confirmDelete;
    }

    public WebElement enterSearchNumber(String input){
        searchNumber.sendKeys(input);
        searchNumber.sendKeys(Keys.ENTER);
        return searchNumber;
    }
    //clickAddNewBeneficiary function performs

    public WebElement clickAddPhoneNumber(){
        addPhoneNumber.click();
        return addPhoneNumber;
    }

    public WebElement clickAirtelButton(){
        airtelButton.click();
        return airtelButton;
    }

    public WebElement enterNumber(String input){
        number.clear();
        number.sendKeys(input);
        return number;
    }

    public WebElement enterName(String input){
        name.clear();
        name.sendKeys(input);
        return name;
    }

    //click Add Beneficiary Button

    public WebElement clickNumberBeneficiary(){
        numberBeneficiary.click();
        return numberBeneficiary;
    }

    //click Delete Number Beneficiary
    //Click Confirm Delete Number Beneficiary


    public WebElement clickBackButton(){
        backButton.click();
        return backButton;
    }

    //Back button twice




}
