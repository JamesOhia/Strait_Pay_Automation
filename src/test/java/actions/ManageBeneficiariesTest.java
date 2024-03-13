package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ChangeCredentialsPage;
import pages.LoginPage;

public class ManageBeneficiariesTest extends CapabilitySetup {

    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;

    @Test(priority = 1)
    public void ViewAccount() throws InterruptedException {


        LoginPage loginPage = new LoginPage(driver);
        ExtentTest test = extent.createTest("Change_Credentials_No_Old_Password",
                "Negative Test to ensure that you cannot Change Credentials without your old Password ");
        test.log(Status.INFO, "Testing Change Credentials for No Old Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        if (changeCredentials.getLoginPage().isDisplayed()) {
            String username = "onobrr";
            String password = "Code@123";
            try {
                loginPage.enterUserName(username);
                System.out.println("Valid Username entered");
                softAssert.assertNotNull(loginPage.enterUserName(username)); //Assert if not Empty
                test.log(Status.PASS, "Valid Username is Entered and field is Not Null");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered entering Valid Username or field is Not Null");
                throw new RuntimeException(e.getMessage());
            }

            try {
                loginPage.enterPassword(password);
                System.out.println("Valid Password entered");
                softAssert.assertNotNull(loginPage.enterPassword(password)); //Assert if not Empty
                test.log(Status.PASS, "Valid Password is Entered and field is Not Null");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered entering Valid Password or field is Not Null");
                throw new RuntimeException(e.getMessage());
            }

            try {
                loginPage.clickLoginBtn();
                System.out.println("Login Button is Clicked");
                test.log(Status.PASS, "Login Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered Clicking Login Button");
                throw new RuntimeException(e.getMessage());
            }

            Thread.sleep(timer);

            try {
                if (loginPage.getDashboardPage().isDisplayed()) {
                    System.out.println("User has logged into his Dashboard successfully");
                    test.log(Status.PASS, "User has logged into his Dashboard successfully");
                } else {
                    test.log(Status.FAIL, "Error Dashboard isn't display");
                }
                softAssert.assertEquals(loginPage.getLoginErrorTitle().getText(), "Dashboard"); //Assert the right Text
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Dashboard");
            }


            try {
                changeCredentials.clickMenu();
                System.out.println("Menu Button is Clicked");
                test.log(Status.PASS, "Menu Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Menu Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                changeCredentials.clickProfileManagement();
                System.out.println("Profile Management Button is Clicked");
                test.log(Status.PASS, "Profile Management Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Profile Management Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                if (changeCredentials.getSettingsTitle().isDisplayed()) {
                    System.out.println("User is currently in the Settings page");
                    test.log(Status.PASS, "User is currently in the Settings page");
                } else {
                    test.log(Status.FAIL, "Error Settings Page isn't display");
                }
                softAssert.assertEquals(changeCredentials.getSettingsTitle().getText(), "Settings"); //Assert the right Text
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Settings");
            }
        }

        try {
            changeCredentials.clickChangeCredentials();
            System.out.println("Change Credentials Button is Clicked");
            test.log(Status.PASS, "Change Credentials Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Change Credentials Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            if (changeCredentials.getChangeCredentialsTitle().isDisplayed()) {
                System.out.println("User is currently in the Change Credentials page");
                test.log(Status.PASS, "User is currently in the Change Credentials page");
            } else {
                test.log(Status.FAIL, "Error Reset Change Credentials Page isn't display");
            }
            softAssert.assertEquals(changeCredentials.getSettingsTitle().getText(), "Change Credentials"); //Assert the right Text
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Change Credentials");
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Old Login Password is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Old Login Password is null");
        } else {
            test.log(Status.FAIL, "Old Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials No Old Password Test Completed");
    }

    @Test(priority = 2, dependsOnMethods = "NoOldPassword")
    public void NoNewPassword() throws InterruptedException {
        String loginPassword = "Code@123";
        ExtentTest test = extent.createTest("Change_Credentials_No_New_Password",
                "Negative Test to ensure that you cannot change credentials without new password ");
        test.log(Status.INFO, "Testing Change Credentials for No New Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterOldPassword(loginPassword);
            System.out.println("Old Login Password has been entered");
            test.log(Status.PASS, "Old Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Login Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since New Login Password is null");
            test.log(Status.PASS, "Update Button is successfully disabled since New Login Password is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials No New Password Test Completed");
    }

    @Test(priority = 3, dependsOnMethods = "NoOldPassword")
    public void NoConfirmPassword() throws InterruptedException {
        String loginPassword = "Code@123";
        ExtentTest test = extent.createTest("Change_Credentials_No_Confirm_Password",
                "Negative Test to ensure that you cannot change credentials without your Confirmation Password ");
        test.log(Status.INFO, "Testing Change Credentials for No Confirm Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterNewPassword(loginPassword);
            System.out.println("New Login Password has been entered");
            test.log(Status.PASS, "New Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm Password is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm Password is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials No Confirm Password Test Completed");
    }

    @Test(priority = 4, dependsOnMethods = "NoOldPassword")
    public void IncompleteOldPassword() throws InterruptedException {
        String incompletePassword = "Code";
        String completePassword = "Code@123";
        ExtentTest test = extent.createTest("Change_Credentials_Incomplete_Old_Password",
                "Negative Test to ensure that you cannot change credentials with an incomplete old Password ");
        test.log(Status.INFO, "Testing Change Credentials for Incomplete Old Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterConfirmPassword(completePassword);
            System.out.println("Confirm Password has been entered");
            test.log(Status.PASS, "Confirm Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewPassword(completePassword);
            System.out.println("New Password has been entered");
            test.log(Status.PASS, "New Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterOldPassword(incompletePassword);
            System.out.println("Incomplete Old Password has been entered");
            test.log(Status.PASS, "Incomplete Old Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Incomplete Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Old Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Old Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials Incomplete Old Password Test Completed");
    }

    @Test(priority = 5, dependsOnMethods = "NoOldPassword")
    public void IncompleteNewPassword() throws InterruptedException {
        String incompletePassword = "Code";
        String completePassword = "Code@123";
        ExtentTest test = extent.createTest("Change_Credentials_Incomplete_New_Password",
                "Negative Test to ensure that you cannot change credentials with an incomplete new Password ");
        test.log(Status.INFO, "Testing Change Credentials for Incomplete New Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterConfirmPassword(completePassword);
            System.out.println("Confirm Password has been entered");
            test.log(Status.PASS, "Confirm Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterOldPassword(completePassword);
            System.out.println("Old Password has been entered");
            test.log(Status.PASS, "Old Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewPassword(incompletePassword);
            System.out.println("Incomplete New Password has been entered");
            test.log(Status.PASS, "Incomplete New Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Incomplete Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since New Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since New Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials Incomplete New Password Test Completed");
    }

    @Test(priority = 6, dependsOnMethods = "NoOldPassword")
    public void IncompleteConfirmPassword() throws InterruptedException {
        String incompletePassword = "Code";
        String completePassword = "Code@123";
        ExtentTest test = extent.createTest("Change_Credentials_Incomplete_Confirm_Password",
                "Negative Test to ensure that you cannot change credentials with an incomplete confirm Password ");
        test.log(Status.INFO, "Testing Change Credentials for Incomplete Confirm Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterOldPassword(completePassword);
            System.out.println("Old Password has been entered");
            test.log(Status.PASS, "Old Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewPassword(completePassword);
            System.out.println("New Password has been entered");
            test.log(Status.PASS, "New Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterConfirmPassword(incompletePassword);
            System.out.println("Incomplete Confirm Password has been entered");
            test.log(Status.PASS, "Incomplete Confirm Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Confirm Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials Incomplete Confirm Password Test Completed");
    }

    @Test(priority = 7, dependsOnMethods = "NoOldPassword")
    public void NonMatchingPassword() throws InterruptedException {
        String password1 = "Code@123";
        String password2 = "Code@124";
        ExtentTest test = extent.createTest("Change_Credentials_Non_Matching_Password",
                "Negative Test to ensure that you cannot change credentials with non matching password ");
        test.log(Status.INFO, "Testing Change Credentials for Non Matching Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterOldPassword(password1);
            System.out.println("Old Password has been entered");
            test.log(Status.PASS, "Old Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewPassword(password1);
            System.out.println("New Password has been entered");
            test.log(Status.PASS, "New Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterConfirmPassword(password2);
            System.out.println("Different Confirm Password has been entered");
            test.log(Status.PASS, "Different Confirm Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Different Confirm Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm Password is Different from New Password");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm Password is Different from New Password");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials Non Matching Password Test Completed");
    }

    @Test(priority = 8, dependsOnMethods = "NoOldPassword")
    public void NavigateToTransactionPin() throws InterruptedException {
        ExtentTest test = extent.createTest("Change_Credentials_Navigate_To_Transaction_Pin",
                "Positive Test to ensure that you can navigate to transaction Pin ");
        test.log(Status.INFO, "Testing Change Credentials for Navigate To Transaction Pin has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.clickNavigateTransactionPin();
            System.out.println("Transaction Pin Button is Clicked");
            test.log(Status.PASS, "Transaction Pin Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Transaction Pin Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Change Credentials Navigate to Transaction Pin Test Completed");

    }

    @Test(priority = 9, dependsOnMethods = "NoOldPassword")
    public void NavigateToLoginPin() throws InterruptedException {
        ExtentTest test = extent.createTest("Change_Credentials_Navigate_To_Login_Pin",
                "Positive Test to ensure that you can navigate to login Pin ");
        test.log(Status.INFO, "Testing Change Credentials for Navigate To Login Pin has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.clickNavigateLoginPin();
            System.out.println("Login Pin Button is Clicked");
            test.log(Status.PASS, "Login Pin Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Login Pin Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Change Credentials Navigate To Login Pin Test Completed");

    }

    @Test(priority = 10, dependsOnMethods = "NoOldPassword")
    public void NoLoginPassword() throws InterruptedException {
        ExtentTest test = extent.createTest("Change_Credentials_No_Login_Password",
                "Negative Test to ensure that you cannot change credentials with No Login Password");
        test.log(Status.INFO, "Testing Change Credentials for No Login Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Login Password is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Login Password is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials No Login Password Test Completed");

    }

    @Test(priority = 11, dependsOnMethods = "NoOldPassword")
    public void NoNewLoginPin() throws InterruptedException {
        String password = "Code@123";
        ExtentTest test = extent.createTest("Change_Credentials_No_New_Login_Pin",
                "Negative Test to ensure that you cannot change credentials with No New Login Pin");
        test.log(Status.INFO, "Testing Change Credentials for No New Login Pin has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since New Login Pin is null");
            test.log(Status.PASS, "Update Button is successfully disabled since New Login Pin is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials No New Login Pin Test Completed");
    }

    @Test(priority = 12, dependsOnMethods = "NoOldPassword")
    public void NoConfirmNewLoginPin() throws InterruptedException {
        String password = "Code@123";
        String pin = "123456";
        ExtentTest test = extent.createTest("Change_Credentials_No_Confirm_New_Login_Pin",
                "Negative Test to ensure that you cannot change credentials with No Confirm New Login Pin");
        test.log(Status.INFO, "Testing Change Credentials for No Confirm New Login Pin has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewLoginPin(pin);
            System.out.println("New Login Pin has been entered");
            test.log(Status.PASS, "New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm New Login Pin is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm New Login Pin is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials No Confirm New Login Pin Test Completed");
    }

    @Test(priority = 13, dependsOnMethods = "NoOldPassword")
    public void IncompleteLoginPassword() throws InterruptedException {
        String password = "Code";
        String pin = "123456";
        ExtentTest test = extent.createTest("Change_Credentials_Incomplete_Login_Password",
                "Negative Test to ensure that you cannot change credentials with Incomplete Login Password");
        test.log(Status.INFO, "Testing Change Credentials for Incomplete Login Password has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterLoginPassword(password);
            System.out.println("Incomplete Login Password has been entered");
            test.log(Status.PASS, "Incomplete Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewLoginPin(pin);
            System.out.println("New Login Pin has been entered");
            test.log(Status.PASS, "New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterConfirmNewLoginPin(pin);
            System.out.println("Confirm New Login Pin has been entered");
            test.log(Status.PASS, "Confirm New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Login Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Login Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials Incomplete Login Password Test Completed");
    }

    @Test(priority = 14, dependsOnMethods = "NoOldPassword")
    public void IncompleteNewLoginPin() throws InterruptedException {
        String password = "Code@123";
        String pin = "123456";
        String incompletePin = "1234";
        ExtentTest test = extent.createTest("Change_Credentials_Incomplete_New_Login_Pin",
                "Negative Test to ensure that you cannot change credentials with Incomplete New Login Pin");
        test.log(Status.INFO, "Testing Change Credentials for Incomplete New Login Pin has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewLoginPin(incompletePin);
            System.out.println("Incomplete New Login Pin has been entered");
            test.log(Status.PASS, "Incomplete New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterConfirmNewLoginPin(pin);
            System.out.println("Confirm New Login Pin has been entered");
            test.log(Status.PASS, "Confirm New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since New Login Pin is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since New Login Pin is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials Incomplete New Login Pin Test Completed");
    }

    @Test(priority = 15, dependsOnMethods = "NoOldPassword")
    public void IncompleteConfirmNewLoginPin() throws InterruptedException {
        String password = "Code@123";
        String pin = "123456";
        String incompletePin = "1234";
        ExtentTest test = extent.createTest("Change_Credentials_Incomplete_Confirm_New_Login_Pin",
                "Negative Test to ensure that you cannot change credentials with Incomplete Confirm New Login Pin");
        test.log(Status.INFO, "Testing Change Credentials for Incomplete Confirm New Login Pin has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewLoginPin(pin);
            System.out.println("New Login Pin has been entered");
            test.log(Status.PASS, "New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterConfirmNewLoginPin(incompletePin);
            System.out.println("Incomplete Confirm New Login Pin has been entered");
            test.log(Status.PASS, "Incomplete Confirm New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Confirm New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(changeCredentials.getUpdateButton().isEnabled()); //Assert if false
        if (!changeCredentials.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm New Login Pin is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm New Login Pin is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Change Credentials Incomplete Confirm New Login Pin Test Completed");
    }

    @Test(priority = 16, dependsOnMethods = "NoOldPassword")
    public void NonMatchingPin() throws InterruptedException {
        String password = "Code@123";
        String pin1 = "123456";
        String pin2 = "123457";
        ExtentTest test = extent.createTest("Change_Credentials_Non_Matching_Pin",
                "Negative Test to ensure that you cannot change credentials with Non Matching Pin");
        test.log(Status.INFO, "Testing Change Credentials for Non Matching Pin has Started");
        ChangeCredentialsPage changeCredentials = new ChangeCredentialsPage(driver);

        try {
            changeCredentials.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterNewLoginPin(pin1);
            System.out.println("New Login Pin has been entered");
            test.log(Status.PASS, "New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try {
            changeCredentials.enterConfirmNewLoginPin(pin2);
            System.out.println("Different Confirm New Login Pin has been entered");
            test.log(Status.PASS, "Different Confirm New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Different Confirm New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try{
            changeCredentials.clickUpdateButton();
            System.out.println("Update Button is Clicked and page remains intact due to Pin mismatch");
            test.log(Status.PASS, "Update Button is Clicked and page remains intact due to Pin mismatch");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Update Button");
            throw new RuntimeException(e.getMessage());
        }

        Thread.sleep(2000);

        try{
            changeCredentials.clickBackButton();
            System.out.println("Back Button is Clicked");
            test.log(Status.PASS, "Back Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Back Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Change Credentials Incomplete Confirm New Login Pin Test Completed");
    }
}
