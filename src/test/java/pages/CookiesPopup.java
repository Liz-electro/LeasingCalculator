package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CookiesPopup {

    WebDriver driver;

    public CookiesPopup(WebDriver driver) {
        this.driver = driver;
    }

    By popupWindow = By.xpath("//a[contains(text(),'I agree')]");

    public void closePopup() {
        driver.findElement(popupWindow).click();
    }
}
