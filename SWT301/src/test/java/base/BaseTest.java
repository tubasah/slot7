package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseTest {
    public static WebDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        // Perform test actions here
        System.out.println(driver.getTitle());
   }


    @Test
    public void testSomething() {
        // Your test logic here
        // For example, you can assert that the title is as expected
        // assertEquals("Expected Title", driver.getTitle());
    }

    // Add more test methods as needed

    // This method will run after each test method
    // Add cleanup logic here
    // @AfterEach
    // public void tearDown() {
    //     driver.quit();
    // }
}
