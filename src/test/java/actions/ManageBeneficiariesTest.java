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
        String name = "Esenwa";
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

   /* @Test(priority = 3, dependsOnMethods = "ViewAccount")
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

    @Test(priority = 4, dependsOnMethods = "TransferBeneficiaryNoAmount")
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
    }*/

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

        softAssert.assertFalse(managBeneficiaries.getAddBeneficiaryButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getAddBeneficiaryButton().isEnabled()) {
            System.out.println("Add Beneficiary Button is successfully disabled since Account Number is null");
            test.log(Status.PASS, "Add Beneficiary Button is successfully disabled since Account Number is null");
        } else {
            test.log(Status.FAIL, "Add Beneficiary Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary No Account Number Test Completed");
    }

    @Test(priority = 6, dependsOnMethods = "AddNewBeneficiaryNoAccountNumber")
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

        softAssert.assertFalse(managBeneficiaries.getAddBeneficiaryButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getAddBeneficiaryButton().isEnabled()) {
            System.out.println("Add Beneficiary Button is successfully disabled since Account Number is incomplete");
            test.log(Status.PASS, "Add Beneficiary Button is successfully disabled since Account Number is incomplete");
        } else {
            test.log(Status.FAIL, "Add Beneficiary Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary incomplete Account Number Test Completed");
    }

    @Test(priority = 7, dependsOnMethods = "AddNewBeneficiaryNoAccountNumber")
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
            managBeneficiaries.clickInvalidBank();
            System.out.println("Providus Bank has been clicked");
            test.log(Status.PASS, "Providus Bank has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Providus Bank");
        }

        softAssert.assertFalse(managBeneficiaries.getAddBeneficiaryButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getAddBeneficiaryButton().isEnabled()) {
            System.out.println("Add Beneficiary Button is successfully disabled since Account Number is invalid");
            test.log(Status.PASS, "Add Beneficiary Button is successfully disabled since Account Number is invalid");
        } else {
            test.log(Status.FAIL, "Add Beneficiary Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary Invalid Account Number Test Completed");
    }

    @Test(priority = 8, dependsOnMethods = "AddNewBeneficiaryNoAccountNumber")
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

    @Test(priority = 9, dependsOnMethods = "AddNewBeneficiaryAccountNumber")
    public void DeleteBeneficiary() throws InterruptedException {
        String account = "017713655";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Delete_Beneficiary",
                "Positive Test to ensure that you Delete Beneficiary in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Delete Beneficiary has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.clickChooseBeneficiary();
            System.out.println("A Beneficiary has been selected");
            test.log(Status.PASS, "A Beneficiary has been selected");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with selecting a Beneficiary");
        }

        try {
            managBeneficiaries.clickDeleteBeneficiary();
            System.out.println("Delete Beneficiary Button has been selected");
            test.log(Status.PASS, "Delete Beneficiary Button has been selected");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Delete Beneficiary Button");
        }

        try {
            managBeneficiaries.clickConfirmDelete();
            System.out.println("Confirm Delete Beneficiary Button has been selected");
            test.log(Status.PASS, "Confirm Delete Beneficiary Button has been selected");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Confirm Delete Beneficiary Button");
        }
        test.log(Status.INFO, "Manage Beneficiaries for Delete Beneficiary Test Completed");
    }

    @Test(priority = 10, dependsOnMethods = "ViewAccount")
    public void SearchBeneficiaryNumber() throws InterruptedException {
        String name = "Test";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Search_Beneficiary_Number",
                "Postive Test to ensure that you can Search Beneficiary Number in the Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Search Beneficiary Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.clickSelfTopButton();
            System.out.println("Self Top Button has been clicked");
            test.log(Status.PASS, "Self Top Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Self Top Button");
        }

        try {
            managBeneficiaries.enterSearchNumber(name);
            System.out.println("Name has been entered in the search number field");
            test.log(Status.PASS, "Name has been entered in the search number field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Name");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Manage Beneficiaries for Search Beneficiary Number Test Completed");
    }

    @Test(priority = 11, dependsOnMethods = "ViewAccount")
    public void AddPhoneNumberNoNumber() throws InterruptedException {
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_Phone_Number_No_Number",
                "Negative Test to ensure that you cannot Add New Phone Number without Number inputted in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add Phone Number No Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.clickSelfTopButton();
            System.out.println("Self Top Button has been clicked");
            test.log(Status.PASS, "Self Top Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Self Top Button");
        }

        try {
            managBeneficiaries.clickNewAddBeneficiaryButton();
            System.out.println("Add Beneficiary Button has been clicked");
            test.log(Status.PASS, "Add Beneficiary Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Add Beneficiary Button");
        }

        try {
            managBeneficiaries.clickAddPhoneNumber();
            System.out.println("Add Phone Number Option has been clicked");
            test.log(Status.PASS, "Add Phone Number Option has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Add Phone Number Option");
        }

        try {
            managBeneficiaries.clickAirtelButton();
            System.out.println("Airtel Button has been clicked");
            test.log(Status.PASS, "Airtel Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Airtel Button");
        }

        softAssert.assertFalse(managBeneficiaries.getAddBeneficiaryButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getAddBeneficiaryButton().isEnabled()) {
            System.out.println("Add Beneficiary Button is successfully disabled since Phone Number is null");
            test.log(Status.PASS, "Add Beneficiary Button is successfully disabled since Phone Number is null");
        } else {
            test.log(Status.FAIL, "Add Beneficiary Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary No Number Test Completed");
    }

    @Test(priority = 12, dependsOnMethods = "AddPhoneNumberNoNumber")
    public void AddPhoneNumberIncompleteNumber() throws InterruptedException {
        String number = "08088730";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_Phone_Number_No_Number",
                "Negative Test to ensure that you cannot Add New Phone Number without Number inputted in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add Phone Number No Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterNumber(number);
            System.out.println("Incomplete number has been entered in the search number field");
            test.log(Status.PASS, "Incomplete number has been entered in the search number field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete number");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(managBeneficiaries.getAddBeneficiaryButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getAddBeneficiaryButton().isEnabled()) {
            System.out.println("Add Beneficiary Button is successfully disabled since Phone Number is incomplete");
            test.log(Status.PASS, "Add Beneficiary Button is successfully disabled since Phone Number is incomplete");
        } else {
            test.log(Status.FAIL, "Add Beneficiary Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary incomplete Number Test Completed");
    }

    @Test(priority = 13, dependsOnMethods = "AddPhoneNumberNoNumber")
    public void AddPhoneNumberNoName() throws InterruptedException {
        String number = "08088730310";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_Phone_Number_No_Name",
                "Negative Test to ensure that you cannot Add New Phone Number without Name inputted in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add Phone Number No Name has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterNumber(number);
            System.out.println("Phone number has been entered in the search number field");
            test.log(Status.PASS, "Phone number has been entered in the search number field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Phone number");
            throw new RuntimeException(e.getMessage());
        }


        softAssert.assertFalse(managBeneficiaries.getAddBeneficiaryButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getAddBeneficiaryButton().isEnabled()) {
            System.out.println("Add Beneficiary Button is successfully disabled since Beneficiary Name is null");
            test.log(Status.PASS, "Add Beneficiary Button is successfully disabled since Beneficiary Name is null");
        } else {
            test.log(Status.FAIL, "Add Beneficiary Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary No Name Test Completed");
    }

    @Test(priority = 14, dependsOnMethods = "AddPhoneNumberNoNumber")
    public void AddPhoneNumberIncompleteName() throws InterruptedException {
        String number = "08088730310";
        String name = "Ja";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_Phone_Number_Incomplete_Name",
                "Negative Test to ensure that you cannot Add New Phone Number with Incomplete Name inputted in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add Phone Number Incomplete Name has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterNumber(number);
            System.out.println("Phone number has been entered in the search number field");
            test.log(Status.PASS, "Phone number has been entered in the search number field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Phone number");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterName(name);
            System.out.println("Incomplete Beneficiary Name has been entered in the search number field");
            test.log(Status.PASS, "Incomplete Beneficiary Name has been entered in the search number field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Beneficiary Name");
            throw new RuntimeException(e.getMessage());
        }


        softAssert.assertFalse(managBeneficiaries.getAddBeneficiaryButton().isEnabled()); //Assert if false
        if (!managBeneficiaries.getAddBeneficiaryButton().isEnabled()) {
            System.out.println("Add Beneficiary Button is successfully disabled since Beneficiary Name is incomplete");
            test.log(Status.PASS, "Add Beneficiary Button is successfully disabled since Beneficiary Name is incomplete");
        } else {
            test.log(Status.FAIL, "Add Beneficiary Button is Enabled");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Beneficiary Incomplete Name Test Completed");
    }

    @Test(priority = 15, dependsOnMethods = "AddPhoneNumberNoNumber")
    public void AddPhoneNumber() throws InterruptedException {
        String number = "08088730310";
        String name = "James";
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Add_Phone_Number",
                "Positive Test to ensure that you can Add New Phone Number in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Add Phone Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.enterNumber(number);
            System.out.println("Phone number has been entered in the search number field");
            test.log(Status.PASS, "Phone number has been entered in the search number field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Phone number");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.enterName(name);
            System.out.println("Beneficiary Name has been entered in the search number field");
            test.log(Status.PASS, "Beneficiary Name has been entered in the search number field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Beneficiary Name");
            throw new RuntimeException(e.getMessage());
        }

        try {
            managBeneficiaries.clickAddBeneficiaryButton();
            System.out.println("Beneficiary Button has been clicked");
            test.log(Status.PASS, "Beneficiary Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Beneficiary Button");
        }

        test.log(Status.INFO, "Manage Beneficiaries for Add New Phone Number Test Completed");
    }

    @Test(priority = 15, dependsOnMethods = "AddPhoneNumber")
    public void DeletePhoneNumber() throws InterruptedException {
        ExtentTest test = extent.createTest("Manage_Beneficiaries_Delete_Phone_Number",
                "Positive Test to ensure that you can Delete Phone Number in Manage Beneficiaries");
        test.log(Status.INFO, "Testing Manage Beneficiaries for Delete Phone Number has Started");
        ManageBeneficiariesPage managBeneficiaries = new ManageBeneficiariesPage(driver);

        try {
            managBeneficiaries.clickSelfTopButton();
            System.out.println("Self Top Button has been clicked");
            test.log(Status.PASS, "Self Top Button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Self Top Button");
        }

        try {
            managBeneficiaries.clickNumberBeneficiary();
            System.out.println("Number Beneficiary has been clicked");
            test.log(Status.PASS, "Number Beneficiary has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Number Beneficiary");
        }

        try {
            managBeneficiaries.clickDeleteBeneficiary();
            System.out.println("Delete Beneficiary has been clicked");
            test.log(Status.PASS, "Delete Beneficiary has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Delete Beneficiary");
        }

        try {
            managBeneficiaries.clickConfirmDelete();
            System.out.println("Confirm Delete Beneficiary has been clicked");
            test.log(Status.PASS, "Confirm Delete Beneficiary has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered with clicking Confirm Delete Beneficiary");
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

        if(!managBeneficiaries.getSettingsTitle().isDisplayed()){
            try{
                managBeneficiaries.clickBackButton();
                System.out.println("Back Button is Clicked");
                test.log(Status.PASS, "Back Button is Clicked");
            }
            catch(Exception e){
                test.log(Status.FAIL, "Error Encountered clicking on Back Button");
                throw new RuntimeException(e.getMessage());
            }
        }

        test.log(Status.INFO, "Manage Beneficiaries for Delete Phone Number Test Completed");
    }
}
