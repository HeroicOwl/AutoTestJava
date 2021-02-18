import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
    }

    // после выполнения всех тестовых методов
    @AfterClass
    public void cleanup() {
        // закрываем браузер
        //driver.quit();
    }
}
