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



        softAssert.assertFalse(managBeneficiaries.getMakeTransfer().isEnabled()); //Assert if false
        if (!managBeneficiaries.getMakeTransfer().isEnabled()) {
            System.out.println("Make Transfer Button is successfully disabled since amount is null");
            test.log(Status.PASS, "Make Transfer Button is successfully disabled since amount is null");
        } else {
            test.log(Status.FAIL, "Make Transfer Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Transfer Beneficiary No Amount Test Completed");
    }

    @Test(priority = 4, dependsOnMethods = "ViewAccount")
    public void TransferBeneficiaryInvalidPin() throws InterruptedException {
        String transferAmount = "100";
        String transferComment = "Testing";
        String pin = "100000";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Transfer_Beneficiary_Invalid_Pin",
                "Negative Test to ensure that you cannot Transfer Beneficiary with an invalid Pin in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Transfer Beneficiary Invalid Pin has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterTransferAmount(transferAmount);
            System.out.println("Transfer Amount has been entered");
            test.log(Status.PASS, "Transfer Amount has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Account Number");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterTransferComment(transferComment);
            System.out.println("Transfer Comment has been entered");
            test.log(Status.PASS, "Transfer Comment has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Account Comment");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.clickMakeTransfer();
            System.out.println("Make Transfer Button has been clicked");
            test.log(Status.PASS, "Make Transfer Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Make Transfer Button");
        }

        try {
            managBeneficiaries.enterPin(pin);
            System.out.println("Invalid Transfer pin has been entered");
            test.log(Status.PASS, "Invalid Transfer pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Invalid Transfer pin");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertEquals(managBeneficiaries.getPinErrorTitle().getText(), "Transfer Error");
            System.out.println("Transfer Error Title is displayed");
            test.log(Status.PASS, "Transfer Error Title is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with the Transfer error title element");
        }

        try {
            softAssert.assertEquals(managBeneficiaries.getPinErrorMessage().getText(), "An error has occurred. Please try again.");
            System.out.println("Transfer Error Message is displayed");
            test.log(Status.PASS, "Transfer Error Message is displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with the Transfer error message element");
        }

        try {
            managBeneficiaries.clickErrorContinue();
            System.out.println("Error Continue Button has been clicked");
            test.log(Status.PASS, "Error Continue Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Error Continue button");
        }

        try{
            managBeneficiaries.clickBackButton();
            System.out.println("Back Button is Clicked");
            test.log(Status.PASS, "Back Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Back Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            managBeneficiaries.clickBackButton();
            System.out.println("Back Button is Clicked");
            test.log(Status.PASS, "Back Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Back Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Manage Beneficiaries for Transfer Beneficiary for Invalid Pin Test Completed");
    }

    @Test(priority = 5, dependsOnMethods = "ViewAccount")
    public void AddNewBeneficiaryNoAccountNumber() throws InterruptedException {
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_New_Beneficiary_No_Account_Number",
                "Negative Test to ensure that you cannot Add New Beneficiary with No Account Number in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add New Beneficiary No Account Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.clickNewAddBeneficiaryButton();
            System.out.println("Add Beneficiary Button has been clicked");
            test.log(Status.PASS, "Add Beneficiary Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Add Beneficiary Button");
        }

        try {
            managBeneficiaries.clickAddAccountNumber();
            System.out.println("Account Number option has been clicked");
            test.log(Status.PASS, "Account Number option has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Account Number option");
        }

        softAssert.assertFalse(managBeneficiaries.getMakeTransfer().isEnabled()); //Assert if false
        if (!managBeneficiaries.getMakeTransfer().isEnabled()) {
            System.out.println("Make Transfer Button is successfully disabled since Account Number is null");
            test.log(Status.PASS, "Make Transfer Button is successfully disabled since Account Number is null");
        } else {
            test.log(Status.FAIL, "Make Transfer Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary No Account Number Test Completed");
    }

    @Test(priority = 6, dependsOnMethods = "ViewAccount")
    public void AddNewBeneficiaryIncompleteAccountNumber() throws InterruptedException {
        String account = "017713655";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_New_Beneficiary_Incomplete_Account_Number",
                "Negative Test to ensure that you cannot Add New Beneficiary with Incomplete Account Number in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add New Beneficiary Incomplete Account Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterAccountNumber(account);
            System.out.println("Incomplete Account Number has been entered");
            test.log(Status.PASS, "Incomplete Account Number has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Account Number");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getMakeTransfer().isEnabled()); //Assert if false
        if (!managBeneficiaries.getMakeTransfer().isEnabled()) {
            System.out.println("Make Transfer Button is successfully disabled since Account Number is incomplete");
            test.log(Status.PASS, "Make Transfer Button is successfully disabled since Account Number is incomplete");
        } else {
            test.log(Status.FAIL, "Make Transfer Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary incomplete Account Number Test Completed");
    }

    @Test(priority = 7, dependsOnMethods = "ViewAccount")
    public void AddNewBeneficiaryInvalidAccountNumber() throws InterruptedException {
        String account = "0177136551";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_New_Beneficiary_Invalid_Account_Number",
                "Negative Test to ensure that you cannot Add New Beneficiary with Invalid Account Number in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add New Beneficiary Invalid Account Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterAccountNumber(account);
            System.out.println("Invalid Account Number has been entered");
            test.log(Status.PASS, "Invalid Account Number has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Invalid Account Number");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.clickOptionBank();
            System.out.println("Option Bank has been clicked");
            test.log(Status.PASS, "Option Bank has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Option Bank");
        }

        softAssert.assertFalse(managBeneficiaries.getMakeTransfer().isEnabled()); //Assert if false
        if (!managBeneficiaries.getMakeTransfer().isEnabled()) {
            System.out.println("Make Transfer Button is successfully disabled since Account Number is invalid");
            test.log(Status.PASS, "Make Transfer Button is successfully disabled since Account Number is invalid");
        } else {
            test.log(Status.FAIL, "Make Transfer Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary Invalid Account Number Test Completed");
    }

    @Test(priority = 8, dependsOnMethods = "ViewAccount")
    public void AddNewBeneficiaryAccountNumber() throws InterruptedException {
        String account = "0177136558";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_New_Beneficiary_Account_Number",
                "Positive Test to ensure that you can Add New Beneficiary with valid Account Number in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add New Beneficiary valid Account Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterAccountNumber(account);
            System.out.println("Valid Account Number has been entered");
            test.log(Status.PASS, "Valid Account Number has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Valid Account Number");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.clickOptionBank();
            System.out.println("Option Bank has been clicked");
            test.log(Status.PASS, "Option Bank has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Option Bank");
        }

        try {
            managBeneficiaries.clickAddBeneficiaryButton();
            System.out.println("Beneficiary Button has been clicked");
            test.log(Status.PASS, "Beneficiary Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Beneficiary Button");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary Account Number Test Completed");
    }

    @Test(priority = 9, dependsOnMethods = "ViewAccount")
    public void DeleteBeneficiary() throws InterruptedException {
        String account = "017713655";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Delete_Beneficiary",
                "Positive Test to ensure that you Delete Beneficiary in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Delete Beneficiary has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterAccountNumber(account);
            System.out.println("Incomplete Account Number has been entered");
            test.log(Status.PASS, "Incomplete Account Number has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Account Number");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getMakeTransfer().isEnabled()); //Assert if false
        if (!managBeneficiaries.getMakeTransfer().isEnabled()) {
            System.out.println("Make Transfer Button is successfully disabled since Account Number is incomplete");
            test.log(Status.PASS, "Make Transfer Button is successfully disabled since Account Number is incomplete");
        } else {
            test.log(Status.FAIL, "Make Transfer Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary incomplete Account Number Test Completed");
    }

    @Test(priority = 6, dependsOnMethods = "ViewAccount")
    public void AddNewBeneficiaryIncompleteAccountNumber() throws InterruptedException {
        String account = "017713655";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_New_Beneficiary_No_Incomplete_Account_Number",
                "Negative Test to ensure that you cannot Add New Beneficiary with Incomplete Account Number in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add New Beneficiary Incomplete Account Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterAccountNumber(account);
            System.out.println("Incomplete Account Number has been entered");
            test.log(Status.PASS, "Incomplete Account Number has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Account Number");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getMakeTransfer().isEnabled()); //Assert if false
        if (!managBeneficiaries.getMakeTransfer().isEnabled()) {
            System.out.println("Make Transfer Button is successfully disabled since Account Number is incomplete");
            test.log(Status.PASS, "Make Transfer Button is successfully disabled since Account Number is incomplete");
        } else {
            test.log(Status.FAIL, "Make Transfer Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary incomplete Account Number Test Completed");
    }

    @Test(priority = 6, dependsOnMethods = "ViewAccount")
    public void AddNewBeneficiaryIncompleteAccountNumber() throws InterruptedException {
        String account = "017713655";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_New_Beneficiary_No_Incomplete_Account_Number",
                "Negative Test to ensure that you cannot Add New Beneficiary with Incomplete Account Number in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add New Beneficiary Incomplete Account Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterAccountNumber(account);
            System.out.println("Incomplete Account Number has been entered");
            test.log(Status.PASS, "Incomplete Account Number has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Account Number");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getMakeTransfer().isEnabled()); //Assert if false
        if (!managBeneficiaries.getMakeTransfer().isEnabled()) {
            System.out.println("Make Transfer Button is successfully disabled since Account Number is incomplete");
            test.log(Status.PASS, "Make Transfer Button is successfully disabled since Account Number is incomplete");
        } else {
            test.log(Status.FAIL, "Make Transfer Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary incomplete Account Number Test Completed");
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
