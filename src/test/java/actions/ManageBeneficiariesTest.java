package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ManageBeneficiariesPage;
import pages.LoginPage;

public class ManageBeneficiariesTest extends CapabilitySetup {

    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;

    @Test(priority = 1)
    public void ViewAccount() throws InterruptedException {


        LoginPage loginPage = new LoginPage(driver);
        ExtentTest test = extent.createTest("Manage_Beneficiaries_View_Account",
                "Positive Test to ensure that you can view accounts in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for View Account has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        if (managBeneficiaries.getLoginPage().isDisplayed()) {
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
                managBeneficiaries.clickMenu();
                System.out.println("Menu Button is Clicked");
                test.log(Status.PASS, "Menu Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Menu Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                managBeneficiaries.clickProfileManagement();
                System.out.println("Profile Management Button is Clicked");
                test.log(Status.PASS, "Profile Management Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Profile Management Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                if (managBeneficiaries.getSettingsTitle().isDisplayed()) {
                    System.out.println("User is currently in the Settings page");
                    test.log(Status.PASS, "User is currently in the Settings page");
                } else {
                    test.log(Status.FAIL, "Error Settings Page isn't display");
                }
                softAssert.assertEquals(managBeneficiaries.getSettingsTitle().getText(), "Settings"); //Assert the right Text
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Settings");
            }
        }

        try {
            managBeneficiaries.clickManageBeneficiaries();
            System.out.println("Manage Beneficiaries Button is Clicked");
            test.log(Status.PASS, "Manage Beneficiaries Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Manage Beneficiaries Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            if (managBeneficiaries.getManageBeneficiariesTitle().isDisplayed()) {
                System.out.println("User is currently in the Manage Beneficiaries page");
                test.log(Status.PASS, "User is currently in the Manage Beneficiaries page");
            } else {
                test.log(Status.FAIL, "Error Reset Manage Beneficiaries Page isn't display");
            }
            softAssert.assertEquals(managBeneficiaries.getSettingsTitle().getText(), "Manage Beneficiaries"); //Assert the right Text
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Manage Beneficiaries");
        }

        try {
            if (managBeneficiaries.getAccountNumberList().isDisplayed()) {
                System.out.println("Beneficiary Accounts can be viewed in the Manage Beneficiaries Page");
                test.log(Status.PASS, "Beneficiary Accounts can be viewed in the Manage Beneficiaries Page");
            } else {
                test.log(Status.FAIL, "Error Beneficiary Accounts aren't displayed");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with the beneficiary account element");
        }
    
        test.log(Status.INFO, "Manage Beneficiaries View Accounts Test Completed");
    }

    @Test(priority = 2, dependsOnMethods = "ViewAccount")
    public void SearchAccountName() throws InterruptedException {
        String name = "ESENWA";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Search_Account_Name",
                "Positive Test to ensure that you can search Account Name in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Search Account Name has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterSearchAccount(name);
            System.out.println("Account Name has been entered");
            test.log(Status.PASS, "Account Name has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Account Name");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Manage Beneficiaries Search Account Name Test Completed");
    }

    @Test(priority = 3, dependsOnMethods = "ViewAccount")
    public void TransferBeneficiaryNoAmount() throws InterruptedException {
        String transferAmount = "100";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Transfer_Beneficiary_No_Amount",
                "Negative Test to ensure that you cannot Transfer Beneficiary without Amount in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Transfer Beneficiary No Amount has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.clickAccountNumber();
            System.out.println("Account Number has been clicked");
            test.log(Status.PASS, "Account Number has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking Account Number");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.clickTransferBeneficiary();
            System.out.println("Transfer Beneficiary has been clicked");
            test.log(Status.PASS, "Transfer Beneficiary has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking Transfer Beneficiary");
            throw new RuntimeException(e.getMessage());
        }

            if (managBeneficiaries.getPinErrorTitle().isDisplayed()) {
                try {
                    softAssert.assertEquals(managBeneficiaries.getPinErrorTitle().getText(), "Bank Charge Failed");
                    System.out.println("Bank Charges Error Title is displayed");
                    test.log(Status.PASS, "Bank Charges Error Title is displayed");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered with the beneficiary error title element");
                }
                try {
                    softAssert.assertEquals(managBeneficiaries.getPinErrorMessage().getText(), "An error has occurred. Please try again.");
                    System.out.println("Bank Charges Error Message is displayed");
                    test.log(Status.PASS, "Bank Charges Error Message is displayed");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered with the beneficiary error message element");
                }
                try {
                    managBeneficiaries.clickErrorContinue();
                    System.out.println("Error Continue Button has been clicked");
                    test.log(Status.PASS, "Error Continue Button has been clicked");
                } catch (Exception e) {
                    test.log(Status.FAIL, "Error Encountered with clicking Error Continue button");
                }
            }

        try {
            managBeneficiaries.clickChooseAccount();
            System.out.println("Account has been clicked");
            test.log(Status.PASS, "Account has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking Account");
            throw new RuntimeException(e.getMessage());
        }



        softAssert.assertFalse(managBeneficiaries.clickMakeTransfer().isEnabled()); //Assert if false
        if (!managBeneficiaries.clickMakeTransfer().isEnabled()) {
            System.out.println("Make Transfer Button is successfully disabled since amount is null");
            test.log(Status.PASS, "Make Transfer Button is successfully disabled since amount is null");
        } else {
            test.log(Status.FAIL, "Make Transfer Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Transfer Beneficiary No Amount Test Completed");
    }

    @Test(priority = 4, dependsOnMethods = "ViewAccount")
    public void IncompleteOldPassword() throws InterruptedException {
        String incompletePassword = "Code";
        String completePassword = "Code@123";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Incomplete_Old_Password",
                "Negative Test to ensure that you cannot Manage Beneficiaries with an incomplete old Password ");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Incomplete Old Password has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterConfirmPassword(completePassword);
            System.out.println("Confirm Password has been entered");
            test.log(Status.PASS, "Confirm Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewPassword(completePassword);
            System.out.println("New Password has been entered");
            test.log(Status.PASS, "New Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterOldPassword(incompletePassword);
            System.out.println("Incomplete Old Password has been entered");
            test.log(Status.PASS, "Incomplete Old Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Incomplete Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Old Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Old Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries Incomplete Old Password Test Completed");
    }

    @Test(priority = 5, dependsOnMethods = "ViewAccount")
    public void IncompleteNewPassword() throws InterruptedException {
        String incompletePassword = "Code";
        String completePassword = "Code@123";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Incomplete_New_Password",
                "Negative Test to ensure that you cannot Manage Beneficiaries with an incomplete new Password ");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Incomplete New Password has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterConfirmPassword(completePassword);
            System.out.println("Confirm Password has been entered");
            test.log(Status.PASS, "Confirm Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterOldPassword(completePassword);
            System.out.println("Old Password has been entered");
            test.log(Status.PASS, "Old Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewPassword(incompletePassword);
            System.out.println("Incomplete New Password has been entered");
            test.log(Status.PASS, "Incomplete New Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Incomplete Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since New Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since New Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries Incomplete New Password Test Completed");
    }

    @Test(priority = 6, dependsOnMethods = "ViewAccount")
    public void IncompleteConfirmPassword() throws InterruptedException {
        String incompletePassword = "Code";
        String completePassword = "Code@123";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Incomplete_Confirm_Password",
                "Negative Test to ensure that you cannot Manage Beneficiaries with an incomplete confirm Password ");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Incomplete Confirm Password has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterOldPassword(completePassword);
            System.out.println("Old Password has been entered");
            test.log(Status.PASS, "Old Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewPassword(completePassword);
            System.out.println("New Password has been entered");
            test.log(Status.PASS, "New Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterConfirmPassword(incompletePassword);
            System.out.println("Incomplete Confirm Password has been entered");
            test.log(Status.PASS, "Incomplete Confirm Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Confirm Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries Incomplete Confirm Password Test Completed");
    }

    @Test(priority = 7, dependsOnMethods = "ViewAccount")
    public void NonMatchingPassword() throws InterruptedException {
        String password1 = "Code@123";
        String password2 = "Code@124";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Non_Matching_Password",
                "Negative Test to ensure that you cannot Manage Beneficiaries with non matching password ");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Non Matching Password has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterOldPassword(password1);
            System.out.println("Old Password has been entered");
            test.log(Status.PASS, "Old Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Old Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewPassword(password1);
            System.out.println("New Password has been entered");
            test.log(Status.PASS, "New Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterConfirmPassword(password2);
            System.out.println("Different Confirm Password has been entered");
            test.log(Status.PASS, "Different Confirm Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Different Confirm Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm Password is Different from New Password");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm Password is Different from New Password");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries Non Matching Password Test Completed");
    }

    @Test(priority = 8, dependsOnMethods = "ViewAccount")
    public void NavigateToTransactionPin() throws InterruptedException {
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Navigate_To_Transaction_Pin",
                "Positive Test to ensure that you can navigate to transaction Pin ");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Navigate To Transaction Pin has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.clickNavigateTransactionPin();
            System.out.println("Transaction Pin Button is Clicked");
            test.log(Status.PASS, "Transaction Pin Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Transaction Pin Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Manage Beneficiaries Navigate to Transaction Pin Test Completed");

    }

    @Test(priority = 9, dependsOnMethods = "ViewAccount")
    public void NavigateToLoginPin() throws InterruptedException {
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Navigate_To_Login_Pin",
                "Positive Test to ensure that you can navigate to login Pin ");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Navigate To Login Pin has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.clickNavigateLoginPin();
            System.out.println("Login Pin Button is Clicked");
            test.log(Status.PASS, "Login Pin Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Login Pin Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Manage Beneficiaries Navigate To Login Pin Test Completed");

    }

    @Test(priority = 10, dependsOnMethods = "ViewAccount")
    public void NoLoginPassword() throws InterruptedException {
        ExtentTest test = extent.createTest("Manage_Beneficiaries_No_Login_Password",
                "Negative Test to ensure that you cannot Manage Beneficiaries with No Login Password");
        test.log(Status.INFO, "Testing Manage Beneficiaries for No Login Password has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Login Password is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Login Password is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries No Login Password Test Completed");

    }

    @Test(priority = 11, dependsOnMethods = "ViewAccount")
    public void NoNewLoginPin() throws InterruptedException {
        String password = "Code@123";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_No_New_Login_Pin",
                "Negative Test to ensure that you cannot Manage Beneficiaries with No New Login Pin");
        test.log(Status.INFO, "Testing Manage Beneficiaries for No New Login Pin has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since New Login Pin is null");
            test.log(Status.PASS, "Update Button is successfully disabled since New Login Pin is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries No New Login Pin Test Completed");
    }

    @Test(priority = 12, dependsOnMethods = "ViewAccount")
    public void NoConfirmNewLoginPin() throws InterruptedException {
        String password = "Code@123";
        String pin = "123456";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_No_Confirm_New_Login_Pin",
                "Negative Test to ensure that you cannot Manage Beneficiaries with No Confirm New Login Pin");
        test.log(Status.INFO, "Testing Manage Beneficiaries for No Confirm New Login Pin has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewLoginPin(pin);
            System.out.println("New Login Pin has been entered");
            test.log(Status.PASS, "New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm New Login Pin is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm New Login Pin is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries No Confirm New Login Pin Test Completed");
    }

    @Test(priority = 13, dependsOnMethods = "ViewAccount")
    public void IncompleteLoginPassword() throws InterruptedException {
        String password = "Code";
        String pin = "123456";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Incomplete_Login_Password",
                "Negative Test to ensure that you cannot Manage Beneficiaries with Incomplete Login Password");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Incomplete Login Password has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterLoginPassword(password);
            System.out.println("Incomplete Login Password has been entered");
            test.log(Status.PASS, "Incomplete Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewLoginPin(pin);
            System.out.println("New Login Pin has been entered");
            test.log(Status.PASS, "New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterConfirmNewLoginPin(pin);
            System.out.println("Confirm New Login Pin has been entered");
            test.log(Status.PASS, "Confirm New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Login Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Login Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries Incomplete Login Password Test Completed");
    }

    @Test(priority = 14, dependsOnMethods = "ViewAccount")
    public void IncompleteNewLoginPin() throws InterruptedException {
        String password = "Code@123";
        String pin = "123456";
        String incompletePin = "1234";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Incomplete_New_Login_Pin",
                "Negative Test to ensure that you cannot Manage Beneficiaries with Incomplete New Login Pin");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Incomplete New Login Pin has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewLoginPin(incompletePin);
            System.out.println("Incomplete New Login Pin has been entered");
            test.log(Status.PASS, "Incomplete New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterConfirmNewLoginPin(pin);
            System.out.println("Confirm New Login Pin has been entered");
            test.log(Status.PASS, "Confirm New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since New Login Pin is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since New Login Pin is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries Incomplete New Login Pin Test Completed");
    }

    @Test(priority = 15, dependsOnMethods = "ViewAccount")
    public void IncompleteConfirmNewLoginPin() throws InterruptedException {
        String password = "Code@123";
        String pin = "123456";
        String incompletePin = "1234";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Incomplete_Confirm_New_Login_Pin",
                "Negative Test to ensure that you cannot Manage Beneficiaries with Incomplete Confirm New Login Pin");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Incomplete Confirm New Login Pin has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewLoginPin(pin);
            System.out.println("New Login Pin has been entered");
            test.log(Status.PASS, "New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterConfirmNewLoginPin(incompletePin);
            System.out.println("Incomplete Confirm New Login Pin has been entered");
            test.log(Status.PASS, "Incomplete Confirm New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Confirm New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getUpdateButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm New Login Pin is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm New Login Pin is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries Incomplete Confirm New Login Pin Test Completed");
    }

    @Test(priority = 16, dependsOnMethods = "ViewAccount")
    public void NonMatchingPin() throws InterruptedException {
        String password = "Code@123";
        String pin1 = "123456";
        String pin2 = "123457";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Non_Matching_Pin",
                "Negative Test to ensure that you cannot Manage Beneficiaries with Non Matching Pin");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Non Matching Pin has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterLoginPassword(password);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterNewLoginPin(pin1);
            System.out.println("New Login Pin has been entered");
            test.log(Status.PASS, "New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterConfirmNewLoginPin(pin2);
            System.out.println("Different Confirm New Login Pin has been entered");
            test.log(Status.PASS, "Different Confirm New Login Pin  has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Different Confirm New Login Pin ");
            throw new RuntimeException(e.getMessage());
        }

        try{
            managBeneficiaries.clickUpdateButton();
            System.out.println("Update Button is Clicked and page remains intact due to Pin mismatch");
            test.log(Status.PASS, "Update Button is Clicked and page remains intact due to Pin mismatch");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Update Button");
            throw new RuntimeException(e.getMessage());
        }

        Thread.sleep(2000);

        try{
            managBeneficiaries.clickBackButton();
            System.out.println("Back Button is Clicked");
            test.log(Status.PASS, "Back Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Back Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Manage Beneficiaries Incomplete Confirm New Login Pin Test Completed");
    }
}
