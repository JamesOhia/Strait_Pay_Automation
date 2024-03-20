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
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'ESENWA UCHE KELVIN']")
    private WebElement accountNumberList;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_account")
    private WebElement accountButoon;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/et_search")
    private WebElement searchAccount;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/btn_action")
    private WebElement transferBeneficiaryButton;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Balance: ₦200,000.00']")
    private WebElement chooseAccount;
    @AndroidFindBy(xpath= "com.appzonegroup.fcmb.dev:id/et_amount")
    private WebElement transferAmount;
    @AndroidFindBy(xpath= "com.appzonegroup.fcmb.dev:id/et_description")
    private WebElement transferComment;
    @AndroidFindBy(xpath= "com.appzonegroup.fcmb.dev:id/btn_make_transfer")
    private WebElement makeTransfer;
    @AndroidFindBy(xpath= "com.appzonegroup.fcmb.dev:id/txt_pin_entry")
    private WebElement pin;
    @AndroidFindBy(xpath= "com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement pinErrorTitle;
    @AndroidFindBy(xpath= "com.appzonegroup.fcmb.dev:id/tv_message")
    private WebElement pinErrorMessage;
    @AndroidFindBy(xpath= "com.appzonegroup.fcmb.dev:id/btn_continue")
    private WebElement errorContinueButton;
    @AndroidFindBy(id= "com.appzonegroup.fcmb.dev:id/add_new")
    private WebElement addNewBeneficiary;
    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Add Account Number']")
    private WebElement optionAccountNumber;
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

    public WebElement getAccountNumberList(){
        return accountNumberList;
    }

    public WebElement enterSearchAccount(String input){
        searchAccount.sendKeys(input);
        searchAccount.sendKeys(Keys.ENTER);
        return searchAccount;
    }

    public WebElement clickAccountNumber(){
        accountNumberList.click();
        return accountNumberList;
    }

    public WebElement clickTransferBeneficiary(){
        transferBeneficiaryButton.click();
        return transferBeneficiaryButton;
    }

    public WebElement clickChooseAccount(){
        chooseAccount.click();
        return chooseAccount;
    }

    public WebElement enterTransferAmount(String input){
        transferAmount.sendKeys(input);
        return transferAmount;
    }

    public WebElement enterTransferComment(String input){
        transferComment.sendKeys(input);
        return transferComment;
    }

    public WebElement getMakeTransfer(){
        return makeTransfer;
    }

    public WebElement clickMakeTransfer(){
        makeTransfer.click();
        return makeTransfer;
    }


    public WebElement enterPin(String input){
        pin.sendKeys(input);
        return pin;
    }

    public WebElement getPinErrorTitle(){
        return pinErrorTitle;
    }

    public WebElement getPinErrorMessage(){
        return pinErrorMessage;
    }

    public WebElement clickErrorContinue(){
        errorContinueButton.click();
        return errorContinueButton;
    }

    //Click Back Button twice
    public WebElement clickNewAddBeneficiaryButton(){
        addNewBeneficiary.click();
        return addNewBeneficiary;
    }

    public WebElement clickAddAccountNumber(){
        optionAccountNumber.click();
        return optionAccountNumber;
    }

    public WebElement getAddBeneficiaryButton(){
        return addBeneficiaryButton;
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

    public WebElement clickDeleteBeneficiary(){
        deleteBeneficiary.click();
        return deleteBeneficiary;
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
