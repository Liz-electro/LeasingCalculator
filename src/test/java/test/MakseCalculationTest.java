package test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CookiesPopup;
import pages.LeaseCalculatorPage;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


public class MakseCalculationTest {

    WebDriver driver;
    LeaseCalculatorPage calcPage;
    CookiesPopup popup;
    By calculatorFrame = By.xpath("//*[@id=\"block-seb8-content\"]/article/div/div/div[2]/div[10]/div/div/div/div/iframe");

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miros\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();

        calcPage = new LeaseCalculatorPage(driver);
        popup = new CookiesPopup(driver);


    }


    @Given("As a SEB user I open Lease Calculator page and close the Cookies popup")
    public void userNavigatesToTheCalculatorPage() {
        driver.get(calcPage.getURL());
        driver.manage().window().maximize();
        //log.info("Lease calculator: " + calcPage.getURL() + " page is opening");
        popup.closePopup();
        driver.switchTo().frame(driver.findElement(calculatorFrame));
        //log.info("Cookies popup is closing");
    }

    @When("input {string} value and {string} value")
    public void userFillImputFields(String carPriceValue, String depositValue) {
        calcPage.setCarPrice(carPriceValue);
        calcPage.setDeposit(depositValue);

    }

    @And("click on Lisa Vordlusesse button")
    public void clickOnComparisonButton() {
        calcPage.addToComparison();
    }

    @And("select {string} lease type")
    public void selectLeaseType(String leasingType) {
        calcPage.changeLeasingType(leasingType);
    }


    @Then("correct rate {string} is displayed")
    public void rateCalculationCheck(String expectedRate) {
        assertThat(calcPage.getMonthlyPayment()).isEqualTo(expectedRate);
    }

    @Then("leasing type {string} in comparison table is displayed")
    public void comparisonTableCheck(String leasingType){
        assertThat(calcPage.getLeasingType()).isEqualTo(leasingType);
    }

    @After
    public void tearDown() {
        //log.info("Closing application");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
