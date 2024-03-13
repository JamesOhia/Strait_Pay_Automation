package actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginMethodPage;
import pages.LoginPage;

public class LoginMethodTest extends CapabilitySetup {

    SoftAssert softAssert = new SoftAssert();
    private int timer = 2000;

    @Test(priority = 1)
    public void LoginMethodEnablePassword() throws InterruptedException{
        String username = "onobrr";
        String password = "Code@123";

        LoginPage loginPage = new LoginPage(driver);
        ExtentTest test = extent.createTest("Login_Method_Enable_Password",
                "Positive Test to ensure that you can enable or disable Password ");
        test.log(Status.INFO, "Testing Login Method for Enable or Disable Password has Started");

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
       LoginMethodPage loginMethod = new LoginMethodPage(driver);

        try{
            loginMethod.clickMenu();
            System.out.println("Menu Button is Clicked");
            test.log(Status.PASS, "Menu Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Menu Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            loginMethod.clickProfileManagement();
            System.out.println("Profile Management Button is Clicked");
            test.log(Status.PASS, "Profile Management Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Profile Management Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            if(loginMethod.getSettingsTitle().isDisplayed()){
                System.out.println("User is currently in the Settings page");
                test.log(Status.PASS, "User is currently in the Settings page");
            }
            else{
                test.log(Status.FAIL, "Error Settings Page isn't display");
            }
            softAssert.assertEquals(loginMethod.getSettingsTitle().getText(), "Settings"); //Assert the right Text
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered displaying Settings");
        }

        try{
            loginMethod.clickLoginMethod();
            System.out.println("Login Method Button is Clicked");
            test.log(Status.PASS, "Login Method Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Login Method Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            if(loginMethod.getLoginMethodTitle().isDisplayed()){
                System.out.println("User is currently in the Login Method page");
                test.log(Status.PASS, "User is currently in the Login Method page");
            }
            else{
                test.log(Status.FAIL, "Error Login Method Page isn't display");
            }
            softAssert.assertEquals(loginMethod.getSettingsTitle().getText(), "Login Methods"); //Assert the right Text
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered displaying Login Method");
        }

        try{
            loginMethod.clickPasswordToggle();
            System.out.println("Password Toggle Button is switched off");
            test.log(Status.PASS, "Password Toggle Button is switched off");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Password Toggle Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            loginMethod.clickPasswordToggle();
            System.out.println("Password Toggle Button is switched on");
            test.log(Status.PASS, "Password Toggle Button is switched on");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Password Toggle Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Login Method Enable/Disabled Password Test Completed");
    }

    @Test (priority=2, dependsOnMethods="LoginMethodEnablePassword")
    public void LoginMethodEnablePin() throws InterruptedException{
        ExtentTest test = extent.createTest("Login_Method_Enable_Pin",
                "Positive Test to ensure that you can enable or disable Pin ");
        test.log(Status.INFO, "Testing Login Method for Enable or Disable Pin has Started");

        LoginMethodPage loginMethod = new LoginMethodPage(driver);

        try{
            loginMethod.clickPinToggle();
            System.out.println("Pin Toggle Button is switched on");
            test.log(Status.PASS, "Pin Toggle Button is switched on");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Pin Toggle Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            loginMethod.clickPinToggle();
            System.out.println("Pin Toggle Button is switched off");
            test.log(Status.PASS, "Pin Toggle Button is switched off");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Pin Toggle Button");
            throw new RuntimeException(e.getMessage());
        }

        try{
            loginMethod.clickBackButton();
            System.out.println("Back Button is Clicked");
            test.log(Status.PASS, "Back Button is Clicked");
        }
        catch(Exception e){
            test.log(Status.FAIL, "Error Encountered clicking on Back Button");
            throw new RuntimeException(e.getMessage());
        }

        test.log(Status.INFO, "Login Method Enabled/Disabled Pin Test Completed");
    }

}
