package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // 1. Локаторы элементов на странице логина
    private By usernameField = By.id("username");     // поле логина
    private By passwordField = By.id("password");     // поле пароля
    private By loginButton = By.xpath("//*[@id='loginForm']/button");       // кнопка входа

    // 2. Конструктор, принимающий WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 3. Метод для ввода логина
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // 4. Метод для ввода пароля
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // 5. Метод для нажатия на кнопку "Login"
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

