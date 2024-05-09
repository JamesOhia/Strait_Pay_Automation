package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.IndividualReferenceLetterPage;
import pages.LoginPage;
import utility.ScrollManager;

public class IndividualReferenceLetterTest extends CapabilitySetup {

    ScrollManager scroll = new ScrollManager(driver);
    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;
    private String findText = "Next";

    @Test(priority = 1)
    public void NoReceipt() throws InterruptedException {
        
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
        String ref = "Testing";
        String findText = "Recipient";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_Receipt_Address",
                "Negative Test to ensure that you cannot create Reference Letter without entering Receipient Address ");
        test.log(Status.INFO, "Testing Display Account Balance has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll up to Receipt Field");
            test.log(Status.PASS, "Scrolled up to Receipt Field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Receipt Field");
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

    @Test(priority = 3, dependsOnMethods = "NoReceipt")
    public void NoForWho() throws InterruptedException {
        String ref = "Testing";
        String findText = "Recipient Address";
        ExtentTest test = extent.createTest("Individual_Reference_Letter_No_For_Who",
                "Negative Test to ensure that you cannot For Reference Letter without entering For Who ");
        test.log(Status.INFO, "Testing No For Who has Started");
        IndividualReferenceLetterPage individualReferenceLetterPage = new IndividualReferenceLetterPage(driver);

        try {
            scroll.scrollToText(findText);
            System.out.println("Scroll up to Recipient Address Field");
            test.log(Status.PASS, "Scrolled up to Recipient Address Field");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error Encountered scrolling to Recipient Address Field");
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
}