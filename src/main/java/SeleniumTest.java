import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class SeleniumTest {
        public static void main(String[] args) {
            // Optional if chromedriver is in PATH
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\v.ilichev\\Desktop\\Automation\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.get("https://www.google.com");

            System.out.println("Page title is: " + driver.getTitle());

            driver.quit();
        }
    }

