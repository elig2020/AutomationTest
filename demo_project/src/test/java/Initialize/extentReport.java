package Initialize;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
    private static ExtentReports extent = new ExtentReports();

    public static ExtentReports initReport (){
        ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/extentReport/reports/report.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");

        return extent;
    } 

    public static void closeReport (){
        extent.flush();
    }
}
