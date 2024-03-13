package actions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ExtentReportClass {
    protected ExtentSparkReporter spark;
    protected ExtentReports extent;


    @BeforeSuite
    public void reportSetup(){
        spark = new ExtentSparkReporter("./SparkReport/report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void reportTearDown(){
        extent.flush();
    }
}
