package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HideAccountBalancePage;
import pages.LoginPage;
import utility.ScrollManager;

public class HideAccountBalanceTest extends CapabilitySetup {

    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;

    @Test(priority = 1)
    public void HideAccountBalance() throws InterruptedException {
        String findText = "Hide Account Balance";

        LoginPage loginPage = new LoginPage(driver);
        ExtentTest test = extent.createTest("Hide_Account_Balance",
                "Positive Test to ensure that you can Hide Account Balance");
        test.log(Status.INFO, "Testing Hide Account Balance has Started");
        HideAccountBalancePage hideAccountBalancePage = new HideAccountBalancePage(driver);

        if (hideAccountBalancePage.getLoginPage().isDisplayed()) {
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
                hideAccountBalancePage.clickMenu();
                System.out.println("Menu Button is Clicked");
                test.log(Status.PASS, "Menu Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Menu Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                hideAccountBalancePage.clickProfileManagement();
                System.out.println("Profile Management Button is Clicked");
                test.log(Status.PASS, "Profile Management Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Profile Management Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                if (hideAccountBalancePage.getSettingsTitle().isDisplayed()) {
                    System.out.println("User is currently in the Settings page");
                    test.log(Status.PASS, "User is currently in the Settings page");
                } else {
                    test.log(Status.FAIL, "Error Settings Page isn't display");
                }
                softAssert.assertEquals(hideAccountBalancePage.getSettingsTitle().getText(), "Settings"); //Assert the right Text
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Settings");
            }
        }

        ScrollManager scroll = new ScrollManager(driver);
        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll down to Hide Account Balance Button");
            test.log(Status.PASS, "Scrolled down to Hide Account Balance Button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Hide Account Balance Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            hideAccountBalancePage.clickHideAccountButton();
            System.out.println("Hide Account Balance button has been clicked");
            test.log(Status.PASS, "Hide Account Balance button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Hide Account Balance Button");
            throw new RuntimeException(e.getMessage());
        }
        try {
            softAssert.assertTrue(hideAccountBalancePage.getAccountBalanceHidden().isDisplayed());
            System.out.println("Account Balance is Hidden");
            test.log(Status.PASS, "Account Balance is Hidden");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when checking if Account Balance is hidden");
            throw new RuntimeException(e.getMessage());
        }
        test.log(Status.INFO, "Hide Account Balance Test Completed");
    }

    @Test(priority = 2, dependsOnMethods = "HideAccountBalance")
    public void DisplayAccountBalance() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ExtentTest test = extent.createTest("Display_Account_Balance",
                "Positive Test to ensure that you can Display Account Balance");
        test.log(Status.INFO, "Testing Display Account Balance has Started");
        HideAccountBalancePage hideAccountBalancePage = new HideAccountBalancePage(driver);

        try {
            hideAccountBalancePage.clickHideAccountButton();
            System.out.println("Display Account Balance button has been clicked");
            test.log(Status.PASS, "Display Account Balance button has been clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Display Account Balance Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            hideAccountBalancePage.clickBackButton();
            System.out.println("Back Button is Clicked");
            test.log(Status.PASS, "Back Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Back Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Display Account Balance Test Completed");
    }

}