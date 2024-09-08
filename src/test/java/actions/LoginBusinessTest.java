package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginBusinessTest extends CapabilitySetup {

    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;

   /* @Test(priority = 1)
    public void loginInvalidEmail() throws InterruptedException{
        String username = "horlawalay1";
        String password = "Password@123";

        LoginPage loginPage = new LoginPage(driver);

        ExtentTest test = extent.createTest("Login_Invalid_Password",
                "Negative Test to ensure you cannot login without an invalid Password");
        test.log(Status.INFO, "Testing Login for Invalid Password has Started");

        try{
            loginPage.enterUserName(username);
            System.out.println("Valid Username entered");
            softAssert.assertNotNull(loginPage.enterUserName(username)); //Assert if not Empty
            test.log(Status.PASS, "Valid Username is Entered and field is Not Null");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered entering Valid Username or field is Not Null");
            throw new RuntimeException(e.getMessage());
        }

       try{
           loginPage.enterPassword(password);
           System.out.println("Invalid Password entered");
           softAssert.assertNotNull(loginPage.enterPassword(password)); //Assert if not Empty
           test.log(Status.PASS, "Invalid Password is Entered and field is Not Null");
       }
       catch(Exception e){
           test.log(Status.FAIL, "Error Encountered entering invalid Password or field is Not Null");
           throw new RuntimeException(e.getMessage());
       }

       try{
           loginPage.clickLoginBtn();
           System.out.println("Login Button is Clicked");
           test.log(Status.PASS, "Login Button is Clicked");
       }
       catch (Exception e){
           test.log(Status.FAIL, "Error Encountered Clicking Login Button");
           throw new RuntimeException(e.getMessage());
       }

        Thread.sleep(timer);

       try{
           if(loginPage.getLoginErrorTitle().isDisplayed()){
               System.out.println("Error Title is displayed");
               test.log(Status.PASS, "Error Title is successfully displayed");
           }
           else{
               test.log(Status.FAIL, "Error Title isn't display");
           }
           softAssert.assertEquals(loginPage.getLoginErrorTitle().getText(), "Login Failure"); //Assert the right Text
       }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered displaying Error Title");
        }

        try{
            if(loginPage.getLoginErrorMessage().isDisplayed()){
                System.out.println("Error Message is displayed");
                test.log(Status.PASS, "Error Message is successfully displayed");
            }
            else{
                test.log(Status.FAIL, "Error Message is not displayed");
            }
            softAssert.assertEquals(loginPage.getLoginErrorMessage().getText(), "Please enter the correct Username and/or Password to proceed.");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered displaying Error Message");
        }


        try{
            loginPage.clickCancelError();
            System.out.println("Cancel Error Button was Clicked");
            test.log(Status.PASS, "Cancel Error Button was Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered Clicking Cancel Error Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            if(loginPage.getLoginPage().isDisplayed()){
                System.out.println("Login Page is displayed");
                test.log(Status.PASS, "Login Page is displayed");
            }
            else{
                test.log(Status.FAIL, "Login Page is not displayed");
            }
            softAssert.assertEquals(loginPage.getLoginPage().getText(), "Login");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered displaying Login Page");
        }


        test.log(Status.INFO, "Login_Invalid_Password Test Completed");

    }

    @Test(priority = 2)
    public void loginValidCredentials() throws InterruptedException{
        String username = "onobrr";
        String password = "Code@123";

        LoginPage loginPage = new LoginPage(driver);
        ExtentTest test = extent.createTest("Login_Valid_Credentials",
                "Positive Test to ensure you can login with a invalid Password");
        test.log(Status.INFO, "Testing Login for Valid Credential has Started");

        try{
            loginPage.enterUserName(username);
            System.out.println("Valid Username entered");
            softAssert.assertNotNull(loginPage.enterUserName(username)); //Assert if not Empty
            test.log(Status.PASS, "Valid Username is Entered and field is Not Null");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered entering Valid Username or field is Not Null");
            throw new RuntimeException(e.getMessage());
        }

        try{
            loginPage.enterPassword(password);
            System.out.println("Valid Password entered");
            softAssert.assertNotNull(loginPage.enterPassword(password)); //Assert if not Empty
            test.log(Status.PASS, "Valid Password is Entered and field is Not Null");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered entering Valid Password or field is Not Null");
            throw new RuntimeException(e.getMessage());
        }

        try{
            loginPage.clickLoginBtn();
            System.out.println("Login Button is Clicked");
            test.log(Status.PASS, "Login Button is Clicked");
        }
        catch (Exception e){
            test.log(Status.FAIL, "Error Encountered Clicking Login Button");
            throw new RuntimeException(e.getMessage());
        }

        Thread.sleep(timer);

        try{
            if(loginPage.getDashboardPage().isDisplayed()){
                System.out.println("User has logged into his Dashboard successfully");
                test.log(Status.PASS, "User has logged into his Dashboard successfully");
            }
            else{
                test.log(Status.FAIL, "Error Dashboard isn't display");
            }
            softAssert.assertEquals(loginPage.getLoginErrorTitle().getText(), "Dashboard"); //Assert the right Text
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered displaying Dashboard");
        }

        test.log(Status.INFO, "Login_Valid_Credential Test Completed");

    }*/

}
