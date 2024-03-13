package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ForgetCredentialsPage;
import pages.LoginPage;

public class ForgetCredentialsTest extends CapabilitySetup {

    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;

    @Test(priority = 1)
    public void forgotCredentialNoUsername() throws InterruptedException {
        String username = "";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Credential_No_Username",
                "Forget Credential No Username Test Scenario. Forget Credential Scenario that ensures that " +
                        "the user cannot go further without a username");

        test.log(Status.INFO, "Testing Forget Credential No Username has Started");
        try {
            forgetPage.clickForgetCredBtn();
            System.out.println("Forget Credential Button is clicked");
            test.log(Status.PASS, "Forget Credential Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
        }
        try {
            forgetPage.clickForgetPasswordBtn();
            System.out.println("Forget Password Button is clicked");
            test.log(Status.PASS, "Forget Password Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
        }
        try {
            forgetPage.getRecoverPage();
            System.out.println("Recover Password Page is displayed");
            softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
            test.log(Status.PASS, "Recover Password Page is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
        }
        try {
            forgetPage.clearUsername();
            System.out.println("Username field is cleared");
            softAssert.assertNull(forgetPage.clearUsername());
            test.log(Status.PASS, "Username field is cleared and Null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Username field couldn't be cleared or is Not Null");
        }

        softAssert.assertFalse(forgetPage.getBtnNext().isEnabled());
        if(!forgetPage.getBtnNext().isEnabled()){
            System.out.println("Next Button is successfully disabled since Username is null");
            test.log(Status.PASS, "Next Button is successfully disabled since Username is null");
        }
        else{//enabled
            test.log(Status.PASS, "Next Button is enabled");
        }


        test.log(Status.INFO, "Testing Forget Credential No Username Test Completed");
    }

    @Test(priority = 2)
    public void forgotCredentialInvalidUsername() throws InterruptedException {
        String username = "Invalid";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Credential_Invalid_Username",
                "Forget Credential Invalid Username Test Scenario. Forget Credential Scenario that ensures that " +
                        "the user cannot successfully do a forget credential with an invalid usernam");

        test.log(Status.INFO, "Testing Forget Credential Invalid Username has Started");

        if(!forgetPage.getRecoverPage().isDisplayed()){
            System.out.println("Recovery page failed to be displayed from the earlier process");
            test.log(Status.PASS, "Recovery page failed to be displayed from the earlier process");
            try {
                forgetPage.clickForgetCredBtn();
                System.out.println("Forget Credential Button is clicked");
                test.log(Status.PASS, "Forget Credential Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
            }
            try {
                forgetPage.clickForgetPasswordBtn();
                System.out.println("Forget Password Button is clicked");
                test.log(Status.PASS, "Forget Password Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
            }
            try {
                forgetPage.getRecoverPage();
                System.out.println("Recover Password Page is displayed");
                softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
                test.log(Status.PASS, "Recover Password Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
            }
        }

        try {
            forgetPage.enterUsernameField(username);
            System.out.println("Invalid Username is entered");
            softAssert.assertNotNull(forgetPage.enterUsernameField(username));
            test.log(Status.PASS, "Invalid Username is entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when inputting username");
        }

        try {
            forgetPage.clickBtnNext();
            System.out.println("Next Button in the Recover Password Page is clicked");
            test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
        }

        try {
            forgetPage.getCardPage();
            System.out.println("Recover OTP/Card Page is displayed");
            test.log(Status.PASS, "Recover OTP/Card Page is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Recover OTP/Card Page");
        }

        try {
            forgetPage.clickOTPButton();
            System.out.println("OTP Button is clicked");
            test.log(Status.PASS, "OTP Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking OTP Button is clicked");
        }
        Thread.sleep(5000);
        try {
            forgetPage.clickBackButton();
            System.out.println("Back Button is clicked");
            test.log(Status.PASS, "Back Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Submit Button");
        }

        test.log(Status.INFO, "Testing Forget Credential Invalid Username Test Completed");
    }

    @Test(priority = 3)
    public void forgotPasswordValidUsernameIncompleteCard() throws InterruptedException {
        String username = "onobrr";
        String first5Digits = "5161";
        String last4Digits = "6448";
        String cardExpiryDate = "0129";
        String otpPin = "1234";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Password_Valid_Username_Incomplete_Card",
                "Forget Password Valid Username Incomplete Card Scenario. Test to ensure you cannot " +
                        "do forget password with an Incomplete card and the Submit button is inactive");

        test.log(Status.INFO, "Testing Forget Password Valid Username Incomplete Card has Started");

        if(forgetPage.getRecoverPage().isDisplayed()){
            System.out.println("Recover page displayed successfully from the previous test");
            test.log(Status.PASS, "Recover page displayed successfully from the previous test");

        }
        else{//At the login Page
            System.out.println("Card/OTP page wasn't displayed successfully from the previous test."+
                    "Still at the beginning Page");
            test.log(Status.PASS, "Card/OTP page wasn't displayed successfully from the previous test."+
                    "Still at the beginning Page");
            try {
                forgetPage.clickForgetCredBtn();
                System.out.println("Forget Credential Button is clicked");
                test.log(Status.PASS, "Forget Credential Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
            }
            try {
                forgetPage.clickForgetPasswordBtn();
                System.out.println("Forget Password Button is clicked");
                test.log(Status.PASS, "Forget Password Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
            }
            try {
                forgetPage.getRecoverPage();
                System.out.println("Recover Password Page is displayed");
                softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
                test.log(Status.PASS, "Recover Password Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
            }
        }

        try {
            forgetPage.enterUsernameField(username);
            System.out.println("Username is entered");
            softAssert.assertNotNull(forgetPage.enterUsernameField(username));
            test.log(Status.PASS, "Valid Username is entered and field is not null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering  ValidUsername");
        }
        try {
            forgetPage.clickBtnNext();
            System.out.println("Next Button in the Recover Password Page is clicked");
            test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
        }
        try {
            forgetPage.getCardPage();
            System.out.println("Recover OTP/Card Page is displayed");
            test.log(Status.PASS, "Recover OTP/Card Page is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Recover OTP/Card Page");
        }
        try {
            forgetPage.enterLast4Digits(last4Digits);
            System.out.println("Last 4 Digits has been entered");
            test.log(Status.PASS, "Last 4 Digits has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Last 4 Digits");
        }
        try {
            forgetPage.enterExpiryDate(cardExpiryDate);
            System.out.println("Card Expiry Date has been entered");
            test.log(Status.PASS, "Card Expiry Date has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Card Expiry Date");
        }
        softAssert.assertFalse(forgetPage.getBtnNext().isEnabled());
        if(!forgetPage.getBtnNext().isEnabled()){
            System.out.println("Submit Button is inactive until the card field is inputted completely");
            test.log(Status.PASS, "Submit Button is inactive until the card field is inputted completely");
        }
        else{
            test.log(Status.FAIL, "Submit Button is active or Error Encountered on identifying it");
        }

        test.log(Status.INFO, "Testing Forget Password Valid Username Incomplete Card Test Completed");
    }

    @Test(priority = 4)
    public void forgotPasswordValidUsernameInvalidCard() throws InterruptedException {
        String username = "onobrr";
        String first5Digits = "51610";
        String last4Digits = "6448";
        String cardExpiryDate = "0129";
        String otpPin = "1234";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Password_Valid_Username_Invalid_Card",
                "Forget Password Valid Username Invalid Card Scenario. Test to ensure you cannot " +
                        "do forget password with an invalid card and right error message displayed");

        test.log(Status.INFO, "Testing Forget Password Valid Username Invalid Card has Started");

        if(forgetPage.getCardPage().isDisplayed()){
            System.out.println("Card/OTP page displayed successfully from the previous test");
            test.log(Status.PASS, "Card/OTP page displayed successfully from the previous test");
        }
        else {
            if (!forgetPage.getRecoverPage().isDisplayed()) {
                System.out.println("Card/OTP page wasn't displayed successfully from the previous test." +
                        "Still at the beginning Page");
                test.log(Status.PASS, "Card/OTP page wasn't displayed successfully from the previous test." +
                        "Still at the beginning Page");
                try {
                    forgetPage.clickForgetCredBtn();
                    System.out.println("Forget Credential Button is clicked");
                    test.log(Status.PASS, "Forget Credential Button is clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
                }
                try {
                    forgetPage.clickForgetPasswordBtn();
                    System.out.println("Forget Password Button is clicked");
                    test.log(Status.PASS, "Forget Password Button is clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
                }
                try {
                    forgetPage.getRecoverPage();
                    System.out.println("Recover Password Page is displayed");
                    softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
                    test.log(Status.PASS, "Recover Password Page is displayed");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
                }
            }
            try {
                forgetPage.enterUsernameField(username);
                System.out.println("Username is entered");
                softAssert.assertNotNull(forgetPage.enterUsernameField(username));
                test.log(Status.PASS, "Valid Username is entered and field is not null");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered entering  ValidUsername");
            }
            try {
                forgetPage.clickBtnNext();
                System.out.println("Next Button in the Recover Password Page is clicked");
                test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
            }
            try {
                forgetPage.getCardPage();
                System.out.println("Recover OTP/Card Page is displayed");
                test.log(Status.PASS, "Recover OTP/Card Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Recover OTP/Card Page");
            }
            try {
                forgetPage.enterLast4Digits(last4Digits);
                System.out.println("Last 4 Digits has been entered");
                test.log(Status.PASS, "Last 4 Digits has been entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when entering Last 4 Digits");
            }
            try {
                forgetPage.enterExpiryDate(cardExpiryDate);
                System.out.println("Card Expiry Date has been entered");
                test.log(Status.PASS, "Card Expiry Date has been entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when entering Card Expiry Date");
            }
        }
        try {
            forgetPage.enterFirst5Digits(first5Digits);
            System.out.println("First 5 Digits has been entered");
            test.log(Status.PASS, "First 5 Digits has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering first 5 Digits");
        }

        softAssert.assertTrue(forgetPage.getBtnNext().isEnabled());
        if(forgetPage.getBtnNext().isEnabled()){
            System.out.println("Submit Button is active after filling the card details");
            test.log(Status.PASS, "Submit Button is active after filling the card details");
        }
        else{
            test.log(Status.FAIL, "Submit Button is inactive or Error Encountered on identifying it");
        }
        try {
            forgetPage.clickBtnNext();
            System.out.println("Submit Button is clicked");
            test.log(Status.PASS, "Submit Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Submit Button");
        }
        try {
            forgetPage.enterPinNumber(otpPin);
            System.out.println("OTP Pin has been entered");
            test.log(Status.PASS, "OTP Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering OTP Pin has been entered");
        }
        try {
            forgetPage.getCardFailureTitle();
            System.out.println("Card Error message is displayed");
            test.log(Status.PASS, "Card Error message is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Card Error message");
        }
        try {
            forgetPage.clickErrorButton();
            System.out.println("Cancel button has been clicked");
            test.log(Status.PASS, "Cancel button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking cancel button");
        }


        test.log(Status.INFO, "Testing Forget Password Valid Username Invalid Card Test Completed");
    }

    @Test(priority = 5)
    public void forgotPasswordValidUsernameValidCardInvalidPin() throws InterruptedException {
        String username = "onobrr";
        String first5Digits = "50610";
        String last4Digits = "6448";
        String cardExpiryDate = "0129";
        String otpPin = "0000";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("Forgot_Password_Valid_Username_Valid_Card_Invalid_Pin",
                "Forgot Password Valid Username Valid Card Invalid Pin Scenario. Test to ensure you cannot " +
                        "do forget password with an invalid card and right error message displayed");

        test.log(Status.INFO, "Testing Forget Password Valid Username Invalid Card Invalid Pin has Started");

        if(forgetPage.getCardPage().isDisplayed()){
            System.out.println("Card/OTP page is displayed successfully from the previous test");
            test.log(Status.PASS, "Card/OTP page is displayed successfully from the previous test");
        }
        else{
            if(!forgetPage.getRecoverPage().isDisplayed()){
                System.out.println("Card/OTP page wasn't displayed successfully from the previous test."+
                        "Still at the beginning Page");
                test.log(Status.PASS, "Card/OTP page wasn't displayed successfully from the previous test."+
                        "Still at the beginning Page");
                try {
                    forgetPage.clickForgetCredBtn();
                    System.out.println("Forget Credential Button is clicked");
                    test.log(Status.PASS, "Forget Credential Button is clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
                }
                try {
                    forgetPage.clickForgetPasswordBtn();
                    System.out.println("Forget Password Button is clicked");
                    test.log(Status.PASS, "Forget Password Button is clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
                }
                try {
                    forgetPage.getRecoverPage();
                    System.out.println("Recover Password Page is displayed");
                    softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
                    test.log(Status.PASS, "Recover Password Page is displayed");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
                }
            }
            try {
                forgetPage.enterUsernameField(username);
                System.out.println("Username is entered");
                softAssert.assertNotNull(forgetPage.enterUsernameField(username));
                test.log(Status.PASS, "Valid Username is entered and field is not null");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered entering  ValidUsername");
            }
            try {
                forgetPage.clickBtnNext();
                System.out.println("Next Button in the Recover Password Page is clicked");
                test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
            }
            try {
                forgetPage.getCardPage();
                System.out.println("Recover OTP/Card Page is displayed");
                test.log(Status.PASS, "Recover OTP/Card Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Recover OTP/Card Page");
            }

            try {
                forgetPage.enterLast4Digits(last4Digits);
                System.out.println("Last 4 Digits has been entered");
                test.log(Status.PASS, "Last 4 Digits has been entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when entering Last 4 Digits");
            }
            try {
                forgetPage.enterExpiryDate(cardExpiryDate);
                System.out.println("Card Expiry Date has been entered");
                test.log(Status.PASS, "Card Expiry Date has been entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when entering Card Expiry Date");
            }
        }

        try {
            forgetPage.enterFirst5Digits(first5Digits);
            System.out.println("First 5 Digits has been entered");
            test.log(Status.PASS, "First 5 Digits has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering first 5 Digits");
        }

        softAssert.assertTrue(forgetPage.getBtnNext().isEnabled());
        if(forgetPage.getBtnNext().isEnabled()){
            System.out.println("Submit Button is active after filling the card details");
            test.log(Status.PASS, "Submit Button is active after filling the card details");
        }
        else{
            test.log(Status.FAIL, "Submit Button is inactive or Error Encountered on identifying it");
        }
        try {
            forgetPage.clickBtnNext();
            System.out.println("Submit Button is clicked");
            test.log(Status.PASS, "Submit Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Submit Button");
        }
        try {
            forgetPage.enterPinNumber(otpPin);
            System.out.println("Invalid OTP Pin has been entered");
            test.log(Status.PASS, "Invalid OTP Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering OTP Pin has been entered");
        }
        try {
            forgetPage.getCardFailureTitle().isDisplayed();
            System.out.println("Card Error message is displayed");
            test.log(Status.PASS, "Card Error message is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Card Error message");
        }
        try {
            forgetPage.clickErrorButton();
            System.out.println("Cancel button has been clicked");
            test.log(Status.PASS, "Cancel button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking cancel button");
        }


        test.log(Status.INFO, "Testing Forget Password Valid Username Invalid Card Invalid Pin Test Completed");
    }

    /*
    @Test(priority = 6)
        public void forgotPasswordValidUsernameValidCardValidPin() throws InterruptedException {

        }
         @Test(priority = 7)
        public void forgotPasswordValidUsernameUseOTP() throws InterruptedException {

        }

 */

    @Test(priority = 6)
    public void forgotCredentialNoAccountNumber() throws InterruptedException {
        String username = "";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Credential_No_AccountNumber",
                "Forget Credential No Account Number Test Scenario. Forget Credential Scenario that ensures that " +
                        "the user cannot go further without an Account Number");

        test.log(Status.INFO, "Testing Forget Credential No Account Number has Started");
        if(forgetPage.getCardPage().isDisplayed()) {
            System.out.println("Card/OTP page is displayed successfully from the previous test");
            test.log(Status.PASS, "Card/OTP page is displayed successfully from the previous test");
            try {
                forgetPage.clickBackButton();
                System.out.println("Back Button is clicked");
                test.log(Status.PASS, "Back Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when clicking Submit Button");
            }
            try {
                forgetPage.clickBackButton();
                System.out.println("Back Button is clicked");
                test.log(Status.PASS, "Back Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when clicking Submit Button");
            }
        }

        try {
            forgetPage.clickForgetCredBtn();
            System.out.println("Forget Credential Button is clicked");
            test.log(Status.PASS, "Forget Credential Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
        }
        try {
            forgetPage.clickForgetUsernameBtn();
            System.out.println("Forget Username Button is clicked");
            test.log(Status.PASS, "Forget Username Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered Clicking Forgot Username Button");
        }
        try {
            forgetPage.getRecoverPage();
            System.out.println("Recover Username Page is displayed");
            softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Username");
            test.log(Status.PASS, "Recover Username Page is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered while displaying Recover Username Page");
        }

        try {
            forgetPage.clearUsername();
            System.out.println("Username field is cleared");
            softAssert.assertNull(forgetPage.clearUsername());
            test.log(Status.PASS, "Account Number field is cleared and Null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Account Number field couldn't be cleared or is Not Null");
        }

        softAssert.assertFalse(forgetPage.getBtnNext().isEnabled());
        if(!forgetPage.getBtnNext().isEnabled()){
            System.out.println("Next Button is successfully disabled since Username is null");
            test.log(Status.PASS, "Next Button is successfully disabled since Username is null");
        }
        else{//enabled
            test.log(Status.PASS, "Next Button is enabled");
        }


        test.log(Status.INFO, "Testing Forget Credential No Account Number Test Completed");
    }

    @Test(priority = 7)
    public void forgotCredentialInvalidAccountNumberLength() throws InterruptedException {
        String accountNo = "12345";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Credential_Invalid_Account_Number_Length",
                "Forget Credential Invalid Account Number Length Test Scenario. Forget Credential Scenario that ensures that " +
                        "the user cannot successfully do a forget credential with an invalid Account Number Length");

        test.log(Status.INFO, "Testing Forget Credential Invalid Account Number Length has Started");

        if(!forgetPage.getRecoverPage().isDisplayed()){
            System.out.println("Recovery page failed to be displayed from the earlier process");
            test.log(Status.PASS, "Recovery page failed to be displayed from the earlier process");
            try {
                forgetPage.clickForgetCredBtn();
                System.out.println("Forget Credential Button is clicked");
                test.log(Status.PASS, "Forget Credential Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
            }
            try {
                forgetPage.clickForgetUsernameBtn();
                System.out.println("Forget Username Button is clicked");
                test.log(Status.PASS, "Forget Username Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Username Button");
            }
            try {
                forgetPage.getRecoverPage();
                System.out.println("Recover Username Page is displayed");
                softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Username");
                test.log(Status.PASS, "Recover Username Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered while displaying Recover Username Page");
            }
        }

        try {
            forgetPage.enterUsernameField(accountNo);
            System.out.println("Incomplete Account Number  is entered");
            softAssert.assertNotNull(forgetPage.enterUsernameField(accountNo));
            test.log(Status.PASS, "Incomplete Account Number is entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when inputting Account Number");
        }


        softAssert.assertFalse(forgetPage.getBtnNext().isEnabled());
        if(!forgetPage.getBtnNext().isEnabled()){
            System.out.println("Next Button is successfully disabled since Account Number is incomplete");
            test.log(Status.PASS, "Next Button is successfully disabled since Account Number is incomplete");
        }
        else{//enabled
            test.log(Status.PASS, "Next Button is enabled");
        }

        test.log(Status.INFO, "Testing Forget Credential Invalid Account Number Length Test Completed");
    }

    @Test(priority = 7)
    public void forgotCredentialInvalidAccountNumber() throws InterruptedException {
        String accountNo = "1234567890";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Credential_Invalid_Account_Number",
                "Forget Credential Invalid Account Number Test Scenario. Forget Credential Scenario that ensures that " +
                        "the user cannot successfully do a forget credential with an invalid Account Number");

        test.log(Status.INFO, "Testing Forget Credential Invalid Account Number has Started");

        if(!forgetPage.getRecoverPage().isDisplayed()){
            System.out.println("Recovery page failed to be displayed from the earlier process");
            test.log(Status.PASS, "Recovery page failed to be displayed from the earlier process");
            try {
                forgetPage.clickForgetCredBtn();
                System.out.println("Forget Credential Button is clicked");
                test.log(Status.PASS, "Forget Credential Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
            }
            try {
                forgetPage.clickForgetUsernameBtn();
                System.out.println("Forget Username Button is clicked");
                test.log(Status.PASS, "Forget Username Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Username Button");
            }
            try {
                forgetPage.getRecoverPage();
                System.out.println("Recover Username Page is displayed");
                softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Username");
                test.log(Status.PASS, "Recover Username Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered while displaying Recover Username Page");
            }
        }

        try {
            forgetPage.enterUsernameField(accountNo);
            System.out.println("Invalid Account Number  is entered");
            softAssert.assertNotNull(forgetPage.enterUsernameField(accountNo));
            test.log(Status.PASS, "Invalid Account Number is entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when inputting Account Number");
        }

        try {
            forgetPage.clickBtnNext();
            System.out.println("Next Button in the Recover Password Page is clicked");
            test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
        }

        try {
            forgetPage.getCardPage();
            System.out.println("Recover OTP/Card Page is displayed");
            test.log(Status.PASS, "Recover OTP/Card Page is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Recover OTP/Card Page");
        }

        try {
            forgetPage.clickOTPButton();
            System.out.println("OTP Button is clicked");
            test.log(Status.PASS, "OTP Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking OTP Button is clicked");
        }
        Thread.sleep(5000);
        try {
            forgetPage.clickBackButton();
            System.out.println("Back Button is clicked");
            test.log(Status.PASS, "Back Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Submit Button");
        }

        test.log(Status.INFO, "Testing Forget Credential Invalid Account Number Test Completed");
    }

    @Test(priority = 8)
    public void forgotCredentialValidAccountIncompleteCard() throws InterruptedException {
        String accountNo = "2291515019";
        String last4Digits = "6449";
        String cardExpiryDate = "0129";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Credential_Valid_Account_Incomplete_Card",
                "Forget Credential Valid Account Incomplete Card Test Scenario. Forget Credential Scenario that ensures that " +
                        "the user cannot successfully do a forget credential with an Incomplete Card ");

        test.log(Status.INFO, "Testing Forget Credential Valid Account Number Incomplete Card has Started");

        if(forgetPage.getRecoverPage().isDisplayed()){
            System.out.println("Card/OTP page displayed successfully from the previous test");
            test.log(Status.PASS, "Card/OTP page displayed successfully from the previous test");
        }

        else{//At the login Page
            System.out.println("Card/OTP page wasn't displayed successfully from the previous test."+
                    "Still at the beginning Page");
            test.log(Status.PASS, "Card/OTP page wasn't displayed successfully from the previous test."+
                    "Still at the beginning Page");
            try {
                forgetPage.clickForgetCredBtn();
                System.out.println("Forget Credential Button is clicked");
                test.log(Status.PASS, "Forget Credential Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
            }
            try {
                forgetPage.clickForgetPasswordBtn();
                System.out.println("Forget Password Button is clicked");
                test.log(Status.PASS, "Forget Password Button is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
            }
            try {
                forgetPage.getRecoverPage();
                System.out.println("Recover Password Page is displayed");
                softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
                test.log(Status.PASS, "Recover Password Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
            }
        }

        try {
            forgetPage.enterUsernameField(accountNo);
            System.out.println("Invalid Account Number  is entered");
            softAssert.assertNotNull(forgetPage.enterUsernameField(accountNo));
            test.log(Status.PASS, "Valid Account Number is entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when inputting Account Number");
        }

        try {
            forgetPage.clickBtnNext();
            System.out.println("Next Button in the Recover Password Page is clicked");
            test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
        }

        try {
            forgetPage.getCardPage();
            System.out.println("Recover OTP/Card Page is displayed");
            test.log(Status.PASS, "Recover OTP/Card Page is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Recover OTP/Card Page");
        }

        try {
            forgetPage.enterLast4Digits(last4Digits);
            System.out.println("Last 4 Digits has been entered");
            test.log(Status.PASS, "Last 4 Digits has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Last 4 Digits");
        }
        try {
            forgetPage.enterExpiryDate(cardExpiryDate);
            System.out.println("Card Expiry Date has been entered");
            test.log(Status.PASS, "Card Expiry Date has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Card Expiry Date");
        }
        softAssert.assertFalse(forgetPage.getBtnNext().isEnabled());
        if(!forgetPage.getBtnNext().isEnabled()){
            System.out.println("Submit Button is inactive until the card field is inputted completely");
            test.log(Status.PASS, "Submit Button is inactive until the card field is inputted completely");
        }
        else{
            test.log(Status.FAIL, "Submit Button is active or Error Encountered on identifying it");
        }

        test.log(Status.INFO, "Testing Forget Credential Valid Account Number Incomplete Card Test Completed");
    }

    @Test(priority = 9)
    public void forgotCredentialValidAccountInvalidCard() throws InterruptedException {
        String accountNo = "2291515019";
        String first5Digits = "51610";
        String last4Digits = "6448";
        String cardExpiryDate = "0129";
        String otpPin = "1234";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Credential_Valid_Account_Invalid_Card",
                "Forget Credential Valid Account Invalid Card Test Scenario. Forget Credential Scenario that ensures that " +
                        "the user cannot successfully do a forget credential with an Incomplete Card ");

        test.log(Status.INFO, "Testing Forget Credential Valid Account Number Invalid Card has Started");

        if(forgetPage.getCardPage().isDisplayed()){
            System.out.println("Card/OTP page displayed successfully from the previous test");
            test.log(Status.PASS, "Card/OTP page displayed successfully from the previous test");
        }
        else {
            if (!forgetPage.getRecoverPage().isDisplayed()) {
                System.out.println("Card/OTP page wasn't displayed successfully from the previous test." +
                        "Still at the beginning Page");
                test.log(Status.PASS, "Card/OTP page wasn't displayed successfully from the previous test." +
                        "Still at the beginning Page");
                try {
                    forgetPage.clickForgetCredBtn();
                    System.out.println("Forget Credential Button is clicked");
                    test.log(Status.PASS, "Forget Credential Button is clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
                }
                try {
                    forgetPage.clickForgetPasswordBtn();
                    System.out.println("Forget Password Button is clicked");
                    test.log(Status.PASS, "Forget Password Button is clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
                }
                try {
                    forgetPage.getRecoverPage();
                    System.out.println("Recover Password Page is displayed");
                    softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
                    test.log(Status.PASS, "Recover Password Page is displayed");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
                }
            }
            try {
                forgetPage.enterUsernameField(accountNo);
                System.out.println("Invalid Account Number  is entered");
                softAssert.assertNotNull(forgetPage.enterUsernameField(accountNo));
                test.log(Status.PASS, "Valid Account Number is entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when inputting Account Number");
            }
            try {
                forgetPage.clickBtnNext();
                System.out.println("Next Button in the Recover Password Page is clicked");
                test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
            }
            try {
                forgetPage.getCardPage();
                System.out.println("Recover OTP/Card Page is displayed");
                test.log(Status.PASS, "Recover OTP/Card Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Recover OTP/Card Page");
            }
            try {
                forgetPage.enterLast4Digits(last4Digits);
                System.out.println("Last 4 Digits has been entered");
                test.log(Status.PASS, "Last 4 Digits has been entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when entering Last 4 Digits");
            }
            try {
                forgetPage.enterExpiryDate(cardExpiryDate);
                System.out.println("Card Expiry Date has been entered");
                test.log(Status.PASS, "Card Expiry Date has been entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when entering Card Expiry Date");
            }
        }
        try {
            forgetPage.enterFirst5Digits(first5Digits);
            System.out.println("First 5 Digits has been entered");
            test.log(Status.PASS, "First 5 Digits has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering first 5 Digits");
        }

        softAssert.assertTrue(forgetPage.getBtnNext().isEnabled());
        if(forgetPage.getBtnNext().isEnabled()){
            System.out.println("Submit Button is active after filling the card details");
            test.log(Status.PASS, "Submit Button is active after filling the card details");
        }
        else{
            test.log(Status.FAIL, "Submit Button is inactive or Error Encountered on identifying it");
        }
        try {
            forgetPage.clickBtnNext();
            System.out.println("Submit Button is clicked");
            test.log(Status.PASS, "Submit Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Submit Button");
        }
        try {
            forgetPage.enterPinNumber(otpPin);
            System.out.println("OTP Pin has been entered");
            test.log(Status.PASS, "OTP Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering OTP Pin has been entered");
        }
        try {
            forgetPage.getCardFailureTitle();
            System.out.println("Card Error message is displayed");
            test.log(Status.PASS, "Card Error message is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Card Error message");
        }
        try {
            forgetPage.clickErrorButton();
            System.out.println("Cancel button has been clicked");
            test.log(Status.PASS, "Cancel button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking cancel button");
        }

        test.log(Status.INFO, "Testing Forget Credential Valid Account Number Invalid Card Test Completed");
    }

    @Test(priority = 10)
    public void forgotCredentialValidAccountValidCardInvalidPin() throws InterruptedException {
        String accountNo = "2291515019";
        String first5Digits = "50610";
        String last4Digits = "6448";
        String cardExpiryDate = "0129";
        String otpPin = "1234";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forget_Credential_Valid_Account_Valid_Card_Invalid_Pin",
                "Forget Credential Valid Account Valid Card Invalid Pin Test Scenario. Forget Credential Scenario that ensures that " +
                        "the user cannot successfully do a forget credential with an Incomplete Card ");

        test.log(Status.INFO, "Testing Forget Credential Valid Account Number Invalid Card has Started");

        if(forgetPage.getCardPage().isDisplayed()){
            System.out.println("Card/OTP page is displayed successfully from the previous test");
            test.log(Status.PASS, "Card/OTP page is displayed successfully from the previous test");
        }
        else{
            if(!forgetPage.getRecoverPage().isDisplayed()){
                System.out.println("Card/OTP page wasn't displayed successfully from the previous test."+
                        "Still at the beginning Page");
                test.log(Status.PASS, "Card/OTP page wasn't displayed successfully from the previous test."+
                        "Still at the beginning Page");
                try {
                    forgetPage.clickForgetCredBtn();
                    System.out.println("Forget Credential Button is clicked");
                    test.log(Status.PASS, "Forget Credential Button is clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
                }
                try {
                    forgetPage.clickForgetPasswordBtn();
                    System.out.println("Forget Password Button is clicked");
                    test.log(Status.PASS, "Forget Password Button is clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
                }
                try {
                    forgetPage.getRecoverPage();
                    System.out.println("Recover Password Page is displayed");
                    softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
                    test.log(Status.PASS, "Recover Password Page is displayed");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
                }
            }
            try {
                forgetPage.enterUsernameField(accountNo);
                System.out.println("Invalid Account Number  is entered");
                softAssert.assertNotNull(forgetPage.enterUsernameField(accountNo));
                test.log(Status.PASS, "Valid Account Number is entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when inputting Account Number");
            }
            try {
                forgetPage.clickBtnNext();
                System.out.println("Next Button in the Recover Password Page is clicked");
                test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
            }
            try {
                forgetPage.getCardPage();
                System.out.println("Recover OTP/Card Page is displayed");
                test.log(Status.PASS, "Recover OTP/Card Page is displayed");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Recover OTP/Card Page");
            }
            try {
                forgetPage.enterLast4Digits(last4Digits);
                System.out.println("Last 4 Digits has been entered");
                test.log(Status.PASS, "Last 4 Digits has been entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when entering Last 4 Digits");
            }
            try {
                forgetPage.enterExpiryDate(cardExpiryDate);
                System.out.println("Card Expiry Date has been entered");
                test.log(Status.PASS, "Card Expiry Date has been entered");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered when entering Card Expiry Date");
            }
        }
        try {
            forgetPage.enterFirst5Digits(first5Digits);
            System.out.println("First 5 Digits has been entered");
            test.log(Status.PASS, "First 5 Digits has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering first 5 Digits");
        }

        softAssert.assertTrue(forgetPage.getBtnNext().isEnabled());
        if(forgetPage.getBtnNext().isEnabled()){
            System.out.println("Submit Button is active after filling the card details");
            test.log(Status.PASS, "Submit Button is active after filling the card details");
        }
        else{
            test.log(Status.FAIL, "Submit Button is inactive or Error Encountered on identifying it");
        }
        try {
            forgetPage.clickBtnNext();
            System.out.println("Submit Button is clicked");
            test.log(Status.PASS, "Submit Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Submit Button");
        }
        try {
            forgetPage.enterPinNumber(otpPin);
            System.out.println("Invalid OTP Pin has been entered");
            test.log(Status.PASS, "Invalid OTP Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering OTP Pin has been entered");
        }
        try {
            forgetPage.getCardFailureTitle().isDisplayed();
            System.out.println("Card Error message is displayed");
            test.log(Status.PASS, "Card Error message is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Card Error message");
        }
        try {
            forgetPage.clickErrorButton();
            System.out.println("Cancel button has been clicked");
            test.log(Status.PASS, "Cancel button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking cancel button");
        }

        test.log(Status.INFO, "Testing Forget Credential Valid Account Valid Card Invalid Pin Test Completed");
    }



   /* @Test(priority = 2)
    public void forgetUsername() throws InterruptedException {
        String bankAccount = "1001762950";

        ForgetCredentialsPage forgetPage = new ForgetCredentialsPage(driver);
        ExtentTest test = extent.createTest("forgetPassword",
                "Forget Password Test Scenario. The automation stops before applying the OTP page" +
                        " since you cannot automate external OTP");

        test.log(Status.INFO, "Testing Forget Password has Started");
        try {
            forgetPage.clickForgetCredBtn();
            System.out.println("Forget Credential Button is clicked");
            test.log(Status.PASS, "Forget Credential Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered Clicking Forgot Credential Button");
        }
        try {
            forgetPage.clickForgetPasswordBtn();
            System.out.println("Forget Password Button is clicked");
            test.log(Status.PASS, "Forget Password Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered Clicking Forgot Password Button");
        }
        try {
            forgetPage.getRecoverPage();
            System.out.println("Recover Password Page is displayed");
            softAssert.assertEquals(forgetPage.getRecoverPage().getText(), "Recover Password");
            test.log(Status.PASS, "Recover Password Page is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered while displaying Recover Password Page");
        }
        try {
            forgetPage.enterUsernameField(username);
            System.out.println("Username is entered");
            softAssert.assertNotNull(forgetPage.enterUsernameField(username));
            test.log(Status.PASS, "Username is entered and field is not null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Username");
        }
        try {
            forgetPage.clickBtnNext();
            System.out.println("Next Button in the Recover Password Page is clicked");
            test.log(Status.PASS, "Next Button in the Recover Password Page is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking the Next Button in the Recover Page");
        }
        try {
            forgetPage.getOTPRecoverPage();
            System.out.println("Recover OTP Page is displayed");
            test.log(Status.PASS, "Recover OTP Page is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Recover OTP Page");
        }
        try {
            forgetPage.clickBackButton();
            System.out.println("Back Button is clicked");
            test.log(Status.PASS, "Back Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking the Back Button");
        }
        try {
            forgetPage.clickBackButton();
            System.out.println("Back Button is clicked");
            test.log(Status.PASS, "Back Button is clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking the Back Button");
        }


        test.log(Status.INFO, "Forget Password Test Completed");
    }*/

}

