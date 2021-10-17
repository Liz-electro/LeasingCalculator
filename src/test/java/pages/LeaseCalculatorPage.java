package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LeaseCalculatorPage {

    WebDriver driver;
    private String LeaseCalculatorURL = "https://www.seb.ee/en/private/loans/leasing-convenient-way-buying-your-vehicle#calculator";

    public LeaseCalculatorPage(WebDriver driver) {
        this.driver=driver;
    }

    By leasingTypeKAS = By.xpath("//*[@id=\"calc08-type01\"]");
    By leasingTypeKAP = By.xpath("//*[@id=\"calc08-type02\"]");
    By leasingTypeJM = By.xpath("//*[@id=\"calc08-type03\"]");
    By addButton = By.xpath("//*[@id=\"calc08\"]/div[2]/div/div/div[2]/ul/li[2]/span/span/input");
    By carPrice = By.xpath("//*[@id=\"calc08-sum\"]");
    By carDeposit = By.xpath("//*[@id=\"calc08-deposit\"]");
    By monthlyPayment = By.xpath("//*[@id=\"monthly-result\"]/span");
    By leasingTypeInComparisonTable = By.xpath("//*[@id=\"calc08\"]/div[3]/table/tbody/tr/td[2]/abbr");




    public void changeLeasingType(String leasingTypeName) {
        switch (leasingTypeName) {
            case "KAS":
                driver.findElement(leasingTypeKAS).click();
                break;
            case "KAP":
                driver.findElement(leasingTypeKAP).click();
                break;
            case "JM":
                driver.findElement(leasingTypeJM).click();
                break;
        }
    }

    public String  getURL(){
        return this.LeaseCalculatorURL;
    }


    public void addToComparison(){
        driver.findElement(addButton).click();
    }

    public void setCarPrice(String price){
        driver.findElement(carPrice).sendKeys(price);

    }

    public void setDeposit(String deposit){
        driver.findElement(carDeposit).sendKeys(deposit);
    }

    public String getMonthlyPayment(){
        return driver.findElement(monthlyPayment).getText();
    }

    public String getLeasingType(){
        return driver.findElement(leasingTypeInComparisonTable).getText();
    }
}
