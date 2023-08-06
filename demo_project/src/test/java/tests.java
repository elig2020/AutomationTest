import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import Functions.functions;
import Initialize.DriverManager;
import POM.pages;
import Initialize.*;

public class tests {
    // Company names are in the first column in the table
    int searchColumn = 1; 
    // Country names are in the third column in the table
    int returnColumnText = 3; 
    // Reading properties from a file, Split them using "," to use them as array and get all names in that array
    String[] companyName = propReader.getProperty("companyNames").split(","); 
    String[] countryName = propReader.getProperty("countryNames").split(",");
    // Reading Company and Country properties from a propReader file
    String oneCompanyName = propReader.getProperty("oneCompanyName");
    String oneCountryName = propReader.getProperty("oneCountryName");

    @BeforeSuite
    public void Initialization () throws InterruptedException{
        DriverManager.driverInit();
        DriverManager.openBrowser();
        extentReport.initReport();
    }
    
    @AfterSuite
    public void tearDown (){
        DriverManager.closeDriver();
        extentReport.closeReport();
    }

    @Test
    public void receive_company_name_and_return_country_name_for_all_companies () throws IOException, InterruptedException{
        WebElement table = pages.table(DriverManager.driverInit());
        for (int i = 0; i <  companyName.length; i++) {
            functions.verifyTableCellText(table, searchColumn, companyName[i], returnColumnText, countryName[i]);
        }

        ExtentTest test_2 = extentReport.initReport().createTest("test_2");
        test_2.pass("companyName");
    }

    @Test
    public void receive_company_name_and_return_country_name_using_xpath () throws Exception{
        WebElement xPath = pages.xPath(DriverManager.driverInit());
        String actualText = functions.getTableCellTextByXpath(xPath, searchColumn, oneCompanyName, returnColumnText);    
        
        if (actualText != null && actualText.equals(oneCountryName)) {
            System.out.println("Verification Successful: Its great, the country '" + oneCountryName + "' was found.");
        } else {
            System.out.println("Verification Failed: Expected country to be '" + oneCountryName + "' but not found.");
        }

        ExtentTest test_2 = extentReport.initReport().createTest("test_2");
        test_2.pass(actualText);
    }
}
