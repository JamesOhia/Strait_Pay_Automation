package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ForgetYourPinPage;
import pages.LoginPage;

public class ForgetYourPinTest extends CapabilitySetup {

    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;

    @Test(priority = 1)
    public void NoLoginPassword() throws InterruptedException {


        LoginPage loginPage = new LoginPage(driver);
        ExtentTest test = extent.createTest("Forget_Your_Pin_No_Login_Password",
                "Negative Test to ensure that you cannot reset your pin without your Login Password ");
        test.log(Status.INFO, "Testing Forget Your Pin for No Login Password has Started");
        ForgetYourPinPage forgetPin = new ForgetYourPinPage(driver);

        if (forgetPin.getLoginPage().isDisplayed()) {
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
                forgetPin.clickMenu();
                System.out.println("Menu Button is Clicked");
                test.log(Status.PASS, "Menu Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Menu Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                forgetPin.clickProfileManagement();
                System.out.println("Profile Management Button is Clicked");
                test.log(Status.PASS, "Profile Management Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Profile Management Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                if (forgetPin.getSettingsTitle().isDisplayed()) {
                    System.out.println("User is currently in the Settings page");
                    test.log(Status.PASS, "User is currently in the Settings page");
                } else {
                    test.log(Status.FAIL, "Error Settings Page isn't display");
                }
                softAssert.assertEquals(forgetPin.getSettingsTitle().getText(), "Settings"); //Assert the right Text
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Settings");
            }
        }

        try {
            forgetPin.clickForgetYourPin();
            System.out.println("Forget Your Pin Button is Clicked");
            test.log(Status.PASS, "Forget Your Pin Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Forget Your Pin Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            if (forgetPin.getResetTransactionPinTitle().isDisplayed()) {
                System.out.println("User is currently in the Reset Transaction PIN page");
                test.log(Status.PASS, "User is currently in the Reset Transaction PIN page");
            } else {
                test.log(Status.FAIL, "Error Reset Transaction PIN Page isn't display");
            }
            softAssert.assertEquals(forgetPin.getSettingsTitle().getText(), "Reset Transaction PIN"); //Assert the right Text
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Reset Transaction PIN");
        }

        softAssert.assertFalse(forgetPin.getUpdateButton().isEnabled()); //Assert if false
        if (!forgetPin.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Login Password is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Login Password is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Forget Your Pin No Login Password Test Completed");
    }

    @Test(priority = 2, dependsOnMethods = "NoLoginPassword")
    public void NoPin() throws InterruptedException {
        String loginPassword = "Code@123";
        ExtentTest test = extent.createTest("Forget_Your_Pin_No_Pin",
                "Negative Test to ensure that you cannot reset your pin without your Pin ");
        test.log(Status.INFO, "Testing Forget Your Pin for No Pin has Started");
        ForgetYourPinPage forgetPin = new ForgetYourPinPage(driver);

        try {
            forgetPin.enterLoginPassword(loginPassword);
            System.out.println("Login Password has been entered");
            test.log(Status.PASS, "Login Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Login Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(forgetPin.getUpdateButton().isEnabled()); //Assert if false
        if (!forgetPin.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Login Transaction Pin is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Transaction Pin is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Forget Your Pin No Pin Test Completed");
    }

    @Test(priority = 3, dependsOnMethods = "NoLoginPassword")
    public void NoConfirmPin() throws InterruptedException {
        String pin = "1234";
        ExtentTest test = extent.createTest("Forget_Your_Pin_No_Confirm_Pin",
                "Negative Test to ensure that you cannot reset your pin without your Confirmation Pin ");
        test.log(Status.INFO, "Testing Forget Your Pin for No Confirm Pin has Started");
        ForgetYourPinPage forgetPin = new ForgetYourPinPage(driver);

        try {
            forgetPin.enterTransactionPin(pin);
            System.out.println("Transaction Pin has been entered");
            test.log(Status.PASS, "Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(forgetPin.getUpdateButton().isEnabled()); //Assert if false
        if (!forgetPin.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Confirm Transaction Pin is null");
            test.log(Status.PASS, "Update Button is successfully disabled since Confirm Transaction Pin is null");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Forget Your Pin No Confirm Pin Test Completed");
    }

    @Test(priority = 4, dependsOnMethods = "NoLoginPassword")
    public void IncompletePassword() throws InterruptedException {
        String confirmPin = "1234";
        String pin = "1234";
        String incompletePassword = "Test";
        ExtentTest test = extent.createTest("Forget_Your_Pin_Incomplete_Password",
                "Negative Test to ensure that you cannot reset your pin with an incomplete Password ");
        test.log(Status.INFO, "Testing Forget Your Pin for Incomplete Password has Started");
        ForgetYourPinPage forgetPin = new ForgetYourPinPage(driver);

        try {
            forgetPin.enterConfirmTransactionPin(confirmPin);
            System.out.println("Confirm Transaction Pin has been entered");
            test.log(Status.PASS, "Confirm Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        try {
            forgetPin.enterTransactionPin(pin);
            System.out.println("Transaction Pin has been entered");
            test.log(Status.PASS, "Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        try {
            forgetPin.enterLoginPassword(incompletePassword);
            System.out.println("Incomplete Password has been entered");
            test.log(Status.PASS, "Incomplete Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(forgetPin.getUpdateButton().isEnabled()); //Assert if false
        if (!forgetPin.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Password is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Password is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Forget Your Pin Incomplete Password Test Completed");
    }

    @Test(priority = 5, dependsOnMethods = "NoLoginPassword")
    public void IncompletePin() throws InterruptedException {
        String pin = "123";
        String confirmPin = "1234";
        String password = "Code@123";
        ExtentTest test = extent.createTest("Forget_Your_Pin_Incomplete_Pin",
                "Negative Test to ensure that you cannot reset your pin with an incomplete Pin ");
        test.log(Status.INFO, "Testing Forget Your Pin for Incomplete Pin has Started");
        ForgetYourPinPage forgetPin = new ForgetYourPinPage(driver);

        try {
            forgetPin.enterTransactionPin(pin);
            System.out.println("Incomplete Transaction Pin has been entered");
            test.log(Status.PASS, "Incomplete Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        try {
            forgetPin.enterConfirmTransactionPin(confirmPin);
            System.out.println("Confirm Transaction Pin has been entered");
            test.log(Status.PASS, "Confirm Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Confirm Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        try {
            forgetPin.enterLoginPassword(password);
            System.out.println("Password has been entered");
            test.log(Status.PASS, "Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Password");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(forgetPin.getUpdateButton().isEnabled()); //Assert if false
        if (!forgetPin.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Pin is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Pin is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Forget Your Pin Incomplete Pin Test Completed");
    }

    @Test(priority = 6, dependsOnMethods = "NoLoginPassword")
    public void IncompleteConfirmPin() throws InterruptedException {
        String pin = "1234";
        String confirmPin = "123";
        String password = "Code@123";
        ExtentTest test = extent.createTest("Forget_Your_Pin_Incomplete_Confirm_Pin",
                "Negative Test to ensure that you cannot reset your pin with an incomplete Confirm Pin ");
        test.log(Status.INFO, "Testing Forget Your Pin for Incomplete Confirm Pin has Started");
        ForgetYourPinPage forgetPin = new ForgetYourPinPage(driver);

        try {
            forgetPin.enterTransactionPin(pin);
            System.out.println("Transaction Pin has been entered");
            test.log(Status.PASS, "Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        try {
            forgetPin.enterLoginPassword(password);
            System.out.println("Password has been entered");
            test.log(Status.PASS, "Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            forgetPin.enterConfirmTransactionPin(confirmPin);
            System.out.println("Incomplete Confirm Transaction Pin has been entered");
            test.log(Status.PASS, "Incomplete Confirm Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Incomplete Confirm Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(forgetPin.getUpdateButton().isEnabled()); //Assert if false
        if (!forgetPin.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Pin is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Pin is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        test.log(Status.INFO, "Forget Your Pin Incomplete Confirm Pin Test Completed");
    }

    @Test(priority = 7, dependsOnMethods = "NoLoginPassword")
    public void PinNotMatching() throws InterruptedException {
        String pin = "1234";
        String confirmPin = "1235";
        String password = "Code@123";
        ExtentTest test = extent.createTest("Forget_Your_Pin_Pin_Not_Matching",
                "Negative Test to ensure that you cannot reset your pin with non matching Pin ");
        test.log(Status.INFO, "Testing Forget Your Pin for Non Matching Pin has Started");
        ForgetYourPinPage forgetPin = new ForgetYourPinPage(driver);

        try {
            forgetPin.enterTransactionPin(pin);
            System.out.println("Transaction Pin has been entered");
            test.log(Status.PASS, "Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        try {
            forgetPin.enterLoginPassword(password);
            System.out.println("Password has been entered");
            test.log(Status.PASS, "Password has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Password");
            throw new RuntimeException(e.getMessage());
        }

        try {
            forgetPin.enterConfirmTransactionPin(confirmPin);
            System.out.println("Non-Matching Confirm Transaction Pin has been entered");
            test.log(Status.PASS, "Non-Matching Confirm Transaction Pin has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered entering Non-Matching Confirm Transaction Pin");
            throw new RuntimeException(e.getMessage());
        }

        softAssert.assertFalse(forgetPin.getUpdateButton().isEnabled()); //Assert if false
        if (!forgetPin.getUpdateButton().isEnabled()) {
            System.out.println("Update Button is successfully disabled since Pin is incomplete");
            test.log(Status.PASS, "Update Button is successfully disabled since Pin is incomplete");
        } else {
            test.log(Status.FAIL, "Login Button is Enabled");
        }

        try{
            forgetPin.clickBackButton();
            System.out.println("Back Button is Clicked");
            test.log(Status.PASS, "Back Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Back Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Forget Your Pin Non-Matching Pin Test Completed");
    }

}
