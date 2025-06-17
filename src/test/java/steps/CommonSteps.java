package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

 public class CommonSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I open the Integration CTRL login page")
    public void i_open_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://portal.betradar.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid username and password")
    public void i_enter_credentials() {
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_see_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Handle cookie pop-up if present
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tru_accept_btn")));
            acceptCookies.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#tru_accept_btn")));
            System.out.println("Cookie pop-up handled successfully.");
        } catch (Exception e) {
            System.out.println("No cookie pop-up detected or already handled.");
        }

        // Wait for page to fully load
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));

        // Attempt to locate and verify dashboard header
        try {
            WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"portal-root\"]")));
            System.out.println("Dashboard Header Found: " + (dashboardHeader != null));
            System.out.println("Dashboard Header Visible: " + dashboardHeader.isDisplayed());

            // Validate the dashboard header visibility
            // Assertions.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not visible");


        } catch (Exception e) {
            System.out.println("Dashboard header not found or not visible.");
            Assertions.fail("Dashboard element could not be located.");
        }

        // Close the driver
        driver.quit();
    }
}




