import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Тест на добавление компании
public class Task1 {

    private static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/companies");
        fillCompany(new Company("ООО ТЕСТОВЫЙ ТЕСТ", "ТЕСТ", "1234568", "Москва, ул. Тестовая 54",
                "Рязань, тестовая 78", "666-66-66", "98765431", "54927517", "123",
                "1234567890", "123456789"));

        addCompany();
        driver.quit();

    }

    private static void fillCompany(Company company) {
        driver.findElement(By.name("fullName")).sendKeys(company.getFullName());
        driver.findElement(By.name("shortName")).sendKeys(company.getShortName());
        driver.findElement(By.name("ogrn")).sendKeys(company.getOgrn());
        driver.findElement(By.name("address")).sendKeys(company.getAddress());
        driver.findElement(By.name("legalAddress")).sendKeys(company.getLegalAddress());
        driver.findElement(By.name("phone")).sendKeys(company.getPhone());
        driver.findElement(By.name("checkingAccount")).sendKeys(company.getCheckingAccount());
        driver.findElement(By.name("correspondentAccount")).sendKeys(company.getCorrespondentAccount());
        driver.findElement(By.name("bik")).sendKeys(company.getBik());
        driver.findElement(By.name("inn")).sendKeys(company.getInn());
        driver.findElement(By.name("kpp")).sendKeys(company.getKpp());


    }

    private static void addCompany() {
        driver.findElement(By.name("add")).click();
    }
}
