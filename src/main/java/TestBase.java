import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

// класс подключения с методами запуска и остановки драйвера
public class TestBase {

    WebDriver driver;

    //Самый первый
    @BeforeClass
    public void setup() {
        // путь к файлу драйвера
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //новый объект для запуска браузера
        driver = new ChromeDriver();
        driver  .manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver  .manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // после выполнения всех тестовых методов
    @AfterClass
    public void cleanup() {
        // закрываем браузер
        //driver.quit();
    }
}
