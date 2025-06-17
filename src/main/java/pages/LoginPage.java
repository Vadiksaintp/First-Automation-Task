package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // 1. Element locators on the login page
    private By usernameField = By.id("username");     // login field
    private By passwordField = By.id("password");     // password field
    private By loginButton = By.xpath("//*[@id='loginForm']/button");       // login button

    // 2. Constructor that accepts WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 3. Method for entering login
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // 4. Method for entering password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // 5. Method for clicking the "Login" button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

