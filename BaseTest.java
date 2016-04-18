import junit.framework.TestCase;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Daria on 18.04.2016.
 */
public class BaseTest extends TestCase {
    protected static WebDriver driver;
    public void setUp(String startPage) throws Exception{
        driver = new FirefoxDriver();
        driver.get(startPage);
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("Тест окончен!");
        driver.quit();
    }
}
