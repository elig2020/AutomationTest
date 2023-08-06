package Functions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class functions {

    public static String getTableCellText(WebElement table, int searchColumn, String companyName, int returnColumnText){
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        
        // Loop through each row and validate the cells
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            // Find all columns in the row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            WebElement searchCell = cells.get(searchColumn - 1);

            if (searchCell.getText().equalsIgnoreCase(companyName)) {  
                WebElement returnCell = cells.get(returnColumnText - 1);  
                // Return the name of the country  
                return returnCell.getText();
            }
        } 
        // Return null if the companyName is not found in the search column
        return null;
    }

    public static boolean verifyTableCellText(WebElement table, int searchColumn, String companyName, int returnColumnText, String countryName) {
        String actualText = getTableCellText(table, searchColumn, companyName, returnColumnText);
    
        if (actualText != null && actualText.equals(countryName)) {
            System.out.println("Verification Successful: Its great, the country '" + countryName + "' was found.");
            return true;
        } else {
            System.out.println("Verification Failed: Expected to find country to be '" + countryName + "' but it wasn't found.");
            return false;
        }
    }

    public static String getTableCellTextByXpath(WebElement xPath, int searchColumn, String companyName, int returnColumnText) throws Exception {
        List<WebElement> rows = xPath.findElements(By.tagName("tr"));
        
        // Loop through each row and validate the cells
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            // Find all columns in the row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            WebElement searchCell = cells.get(searchColumn - 1);

            if (searchCell.getText().equalsIgnoreCase(companyName)) {  
                WebElement returnCell = cells.get(returnColumnText - 1);    
                return returnCell.getText();
            }
        } 
        // Return null if the companyName is not found in the search column
        return null;
    }
}
