package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.IndividualReferenceLetterPage;
import pages.LoginPage;
import utility.ScrollManager;

public class IndividualReferenceLetterTest extends CapabilitySetup {

    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;


    @Test(priority = 1)
    public void NoReceipt() throws InterruptedException {
        String findText = "Next";
        ScrollManager scroll = new ScrollManager(driver);
        LoginPage loginPage = new LoginPage(driver);
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_Receipt",
                "Negative Test to ensure that you can not create Individual Reference Letter without Receipt");
        test.log(Status.INFO, "Testing No Receipt has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        if (individualReferenceLetterPage.getLoginPage().isDisplayed()) {
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
                individualReferenceLetterPage.clickMenu();
                System.out.println("Menu Button is Clicked");
                test.log(Status.PASS, "Menu Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Menu Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                individualReferenceLetterPage.clickServiceRequests();
                System.out.println("Service Request Button is Clicked");
                test.log(Status.PASS, "Service Request Button is Clicked");
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered clicking on Service Request Button");
                throw new RuntimeException(e.getMessage());
            }

            try {
                if (individualReferenceLetterPage.getRequestsTitle().isDisplayed()) {
                    System.out.println("User is currently in the Request page");
                    test.log(Status.PASS, "User is currently in the Request page");
                } else {
                    test.log(Status.FAIL, "Error Request Page isn't display");
                }
                softAssert.assertEquals(individualReferenceLetterPage.getRequestsTitle().getText(), "Requests"); //Assert the right Text
            } catch (Exception e) {
                test.log(Status.FAIL, "Error Encountered displaying Request Page");
            }
        }

        try {
            individualReferenceLetterPage.clickVariousLettersButton();
            System.out.println("Various Letter Button is Clicked");
            test.log(Status.PASS, "Various Letter Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Various Letter Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.clickReferenceLetterButton();
            System.out.println("Reference Letter Button is Clicked");
            test.log(Status.PASS, "Reference Letter Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Reference Letter Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.selectIndividualReferenceLetterChoice();
            System.out.println("Individual Reference Letter is chosen");
            test.log(Status.PASS, "Individual Reference Letter is chosen");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered selecting Individual Reference Letter");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.clickSubmitButton();
            System.out.println("Submit Button is Clicked");
            test.log(Status.PASS, "Submit Button is Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Submit Button");
            throw new RuntimeException(e.getMessage());
        }

        Thread.sleep(2000);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll down to Next Button");
            test.log(Status.PASS, "Scrolled down to Next Button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertFalse(individualReferenceLetterPage.getNextButton().isEnabled());
            System.out.println("Next Button is disabled because Reference is null");
            test.log(Status.PASS, "Next Button is disabled because Reference is null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Next Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "No Receipt Test is Completed");
    }

    @Test(priority = 2, dependsOnMethods = "NoReceipt")
    public void NoReceiptAddress() throws InterruptedException {
        ScrollManager scroll = new ScrollManager(driver);
        String ref = "Testing";
        String findText = "Recipient";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_Receipt_Address",
                "Negative Test to ensure that you cannot create Reference Letter without entering Receipient Address ");
        test.log(Status.INFO, "Testing Display Account Balance has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll up to Recipient");
            test.log(Status.PASS, "Scrolled up to Recipient");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.enterRecipientField(ref);
            System.out.println("Recipient has been entered");
            test.log(Status.PASS, "Recipient has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Recipient");
            throw new RuntimeException(e.getMessage());
        }

        findText = "Next";
        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll down to Next Button");
            test.log(Status.PASS, "Scrolled down to Next Button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertFalse(individualReferenceLetterPage.getNextButton().isEnabled());
            System.out.println("Next Button is disabled because Recipient Address is null");
            test.log(Status.PASS, "Next Button is disabled because Recipient Address is null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Next Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "No Recipient Address Test Completed");
    }

    @Test(priority = 3)
    public void NoForWho() throws InterruptedException {
        ScrollManager scroll = new ScrollManager(driver);
        String ref = "Testing";
        String findText = "Recipient Address";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_For_Who",
                "Negative Test to ensure that you cannot create Individual Reference Letter without entering For Who ");
        test.log(Status.INFO, "Testing No For Who has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll up to address field");
            test.log(Status.PASS, "Scroll up to address field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.enterRecipientAddressField(ref);
            System.out.println("Recipient Address has been entered");
            test.log(Status.PASS, "Recipient Address has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Recipient Address");
            throw new RuntimeException(e.getMessage());
        }

        findText = "Next";
        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll down to Next Button");
            test.log(Status.PASS, "Scrolled down to Next Button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertFalse(individualReferenceLetterPage.getNextButton().isEnabled());
            System.out.println("Next Button is disabled because For Who is null");
            test.log(Status.PASS, "Next Button is disabled because For Who is null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Next Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "No For Who Test Completed");
    }

    @Test(priority = 4)
    public void NoAccountReferenced() throws InterruptedException {
        ScrollManager scroll = new ScrollManager(driver);
        String ref = "Testing";
        String findText = "For Who";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_Account_Referenced",
                "Negative Test to ensure that you cannot create Individual Reference Letter without choosing Account To Be Referenced ");
        test.log(Status.INFO, "Testing No Account Referenced has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll up to For Who");
            test.log(Status.PASS, "Scroll up to For Who");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.enterForWhoField(ref);
            System.out.println("For Who has been entered");
            test.log(Status.PASS, "For Who has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering For Who");
            throw new RuntimeException(e.getMessage());
        }

        findText = "Next";
        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll down to Next Button");
            test.log(Status.PASS, "Scrolled down to Next Button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertFalse(individualReferenceLetterPage.getNextButton().isEnabled());
            System.out.println("Next Button is disabled because Account To Be Referenced is not selected");
            test.log(Status.PASS, "Next Button is disabled because Account To Be Referenced is not selected");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Next Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "No Account Referenced Test Completed");
    }

    @Test(priority = 5)
    public void NoPickupBranch() throws InterruptedException {
        ScrollManager scroll = new ScrollManager(driver);
        //String ref = "FESTAC BRANCH";
        String findText = "Account to be Referenced";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_Pickup_Branch",
                "Negative Test to ensure that you cannot create Individual Reference Letter without entering Pickup Branch");
        test.log(Status.INFO, "Testing No Account Referenced has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll up to Account to be Referenced");
            test.log(Status.PASS, "Scrolled up to Account to be Referenced");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.clickAccountToBeReferenced();
            System.out.println("Account To Be Referenced has been Selected");
            test.log(Status.PASS, "Account To Be Referenced has been Selected");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when selecting Account To Be Referenced");
            throw new RuntimeException(e.getMessage());
        }

        findText = "Next";
        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll down to Next Button");
            test.log(Status.PASS, "Scrolled down to Next Button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertFalse(individualReferenceLetterPage.getNextButton().isEnabled());
            System.out.println("Next Button is disabled because Preferred Pickup Branch is null");
            test.log(Status.PASS, "Next Button is disabled because Preferred Pickup Branch is null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Next Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "No Pickup Branch Test Completed");
    }

    @Test(priority = 6)
    public void NoAccountToCharge() throws InterruptedException {
        ScrollManager scroll = new ScrollManager(driver);
        String ref = "FESTAC BRANCH";
        String findText = "Preferred Pickup Branch";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_Account_To_Charge",
                "Negative Test to ensure that you cannot create Individual Reference Letter without selecting Account To Charge");
        test.log(Status.INFO, "No Account To Charge Test has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll up to Preferred Pickup Branch");
            test.log(Status.PASS, "Scrolled up to Preferred Pickup Branch");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.enterBranchNameField(ref);
            System.out.println("Preferred Branch Name has been entered");
            test.log(Status.PASS, "Preferred Branch Name has been entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Preferred Branch Name");
            throw new RuntimeException(e.getMessage());
        }

        findText = "Next";
        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll down to Next Button");
            test.log(Status.PASS, "Scrolled down to Next Button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertFalse(individualReferenceLetterPage.getNextButton().isEnabled());
            System.out.println("Next Button is disabled because Account To Charge isn't selected");
            test.log(Status.PASS, "Next Button is disabled because Account To Charge isn't selected");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Next Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "No Account To Charge Test Completed");
    }

    @Test(priority = 7)
    public void NoAdditionalNotes() throws InterruptedException {
        ScrollManager scroll = new ScrollManager(driver);
        String findText = "Account To Charge";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_Additional_Notes",
                "Negative Test to ensure that you cannot create Individual Reference Letter without Additional Notes");
        test.log(Status.INFO, "No Additional Notes Test has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll up to Account To Charge");
            test.log(Status.PASS, "Scrolled up to Account To Charge");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.clickAccountToBeCharged();
            System.out.println("Account To Be Charged has been Selected");
            test.log(Status.PASS, "Account To Be Charged has been Selected");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Account To Be Charged");
            throw new RuntimeException(e.getMessage());
        }

        findText = "Next";
        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll down to Next Button");
            test.log(Status.PASS, "Scrolled down to Next Button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertFalse(individualReferenceLetterPage.getNextButton().isEnabled());
            System.out.println("Next Button is disabled because Additional Notes is null");
            test.log(Status.PASS, "Next Button is disabled because Additional Notes is null");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered clicking on Next Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "No Additional Notes Test Completed");
    }

    @Test(priority = 7, dependsOnMethods = "NoAdditionalNotes")
    public void InvalidPin() throws InterruptedException {
        String ref = "Testing Additional Notes";
        String pin = "123456";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_Invalid_Pin",
                "Negative Test to ensure that you cannot create Individual Reference Letter with an Invalid Pin");
        test.log(Status.INFO, "Invalid Pin Test has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            individualReferenceLetterPage.enterAdditionalNotesField(ref);
            System.out.println("Additional Notes has been Entered");
            test.log(Status.PASS, "Additional Notes has been Entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Additional Notes");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.clickNextButton();
            System.out.println("Next Button has been Clicked");
            test.log(Status.PASS, "Next Button has been Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Next Button");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.enterPinEntry(pin);
            System.out.println("Invalid Pin has been Entered");
            test.log(Status.PASS, "Invalid Pin has been Entered");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when entering Invalid Pin");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertFalse(individualReferenceLetterPage.getErrorTitle().isDisplayed());
            System.out.println("Error Title is Displayed because the Pin is invalid");
            test.log(Status.PASS, "Error Title is Displayed because the Pin is invalid");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered displaying Error Title");
            throw new RuntimeException(e.getMessage());
        }

        try {
            softAssert.assertEquals(individualReferenceLetterPage.getErrorTitle().getText(), "Request Submission Failed");
            System.out.println("Error Title Text is accurate");
            test.log(Status.PASS, "Error Title Text is accurate");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Title Text isn't accurate or an Error Occurred");
            throw new RuntimeException(e.getMessage());
        }

        try {
            individualReferenceLetterPage.clickErrorContinue();
            System.out.println("Error Cancel Button has been Clicked");
            test.log(Status.PASS, "Error Cancel Button has been Clicked");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered when clicking Error Cancel Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            individualReferenceLetterPage.clickBackButton();
            System.out.println("Back Button is Clicked");
            test.log(Status.PASS, "Back Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Back Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Invalid Pin Test Completed");
    }
}