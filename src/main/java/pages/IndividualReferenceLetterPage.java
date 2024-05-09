package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class IndividualReferenceLetterPage {
    AndroidDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 3);

    //The Mobile Element Variables
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/tv_login")
    private WebElement loginPage;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement menuButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Service Requests']")
    private WebElement serviceRequestsButton;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/tv_goal")
    private WebElement requestsTitle;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/ll_various_letters")
    private WebElement variousLettersButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Reference Letter']")
    private WebElement referenceLetterButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Individual Reference Letter']")
    private WebElement individualReferenceLetterChoice;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/btn_submit")
    private WebElement submitButton;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/reciepient_ed")
    private WebElement recipientField;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/reciepient_address_ed")
    private WebElement recipientAddressField;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/for_who_ed")
    private WebElement forWhoField;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/iv_checkmark")
    private WebElement accountToBeReferenced;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/et_branch_name")
    private WebElement branchNameField;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[2]/android.widget.RelativeLayout[1]/android.widget.ImageView")
    private WebElement accountToBeCharged;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/additional_notes_ed")
    private WebElement additionalNotesField;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/next_button")
    private WebElement nextButton;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/txt_pin_entry")
    private WebElement pinEntry;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/tv_title")
    private WebElement errorTitle;
    @AndroidFindBy(id = "com.appzonegroup.fcmb.dev:id/btn_continue")
    private WebElement errorContinue;
    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backButton;


    public IndividualReferenceLetterPage(AndroidDriver<AndroidElement> driver) {
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

    public WebElement clickServiceRequests() {
        serviceRequestsButton.click();
        return serviceRequestsButton;
    }

    public WebElement getRequestsTitle() {
        return requestsTitle;
    }

    public WebElement clickVariousLettersButton() {
        variousLettersButton.click();
        return variousLettersButton;
    }

    public WebElement clickReferenceLetterButton() {
        referenceLetterButton.click();
        return referenceLetterButton;
    }


    public WebElement selectIndividualReferenceLetterChoice() {
        individualReferenceLetterChoice.click();
        return individualReferenceLetterChoice;
    }

    public WebElement clickSubmitButton() {
        submitButton.click();
        return submitButton;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement enterRecipientField(String input) {
        recipientField.sendKeys(input);
        return recipientField;
    }

    public WebElement enterRecipientAddressField(String input) {
        recipientAddressField.sendKeys(input);
        return recipientAddressField;
    }

    public WebElement enterForWhoField(String input) {
        forWhoField.sendKeys(input);
        return forWhoField;
    }

    public WebElement clickAccountToBeReferenced() {
        accountToBeReferenced.click();
        return accountToBeReferenced;
    }

    public WebElement enterBranchNameField(String input) {
        branchNameField.sendKeys(input);
        return branchNameField;
    }

    public WebElement clickAccountToBeCharged() {
        accountToBeCharged.click();
        return accountToBeCharged;
    }

    public WebElement enterAdditionalNotesField(String input) {
        additionalNotesField.sendKeys(input);
        return additionalNotesField;
    }

    public WebElement clickNextButton() {
        nextButton.click();
        return nextButton;
    }

    public WebElement enterPinEntry(String input) {
        pinEntry.sendKeys(input);
        return pinEntry;
    }

    public WebElement getErrorTitle() {
        return errorTitle;
    }

    public WebElement clickErrorContinue() {
        errorContinue.click();
        return errorContinue;
    }


    public WebElement clickBackButton(){
        backButton.click();
        return backButton;
    }
}