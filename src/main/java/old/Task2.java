package old;

import classes.Company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

// Тест на добавление компании
public class Task2 {

    private static WebDriver driver;
    private Company company;
    private String foundCompany;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void testFixtures() {
        driver.get("http://localhost:8080/companies");
        company = new Company("ООО ТЕСТОВЫЙ ТЕСТ", "ТЕСТ", "1234568", "Москва, ул. Тестовая 54",
                "Рязань, тестовая 78", "666-66-66", "98765431", "54927517", "123",
                "1234567890", "123456789");

    }

    // проверка что компания добавлена
    @Test
    public void createCompany() {
        List<Company> companiesBefore = getCompanyList();
        System.out.println("список ДО : " + companiesBefore);

        fillCompany(company);
        addCompany();
        companiesBefore.add(company);
        System.out.println("Добавили компанию: " + companiesBefore);

        List<Company> companies = getCompanyList();
        System.out.println("вывод companies " + companies);

        assertEquals(companiesBefore, companies);

    }

    //проверка поиска
    @Test
    public void foundCompany() {
        //получаем имя компании которую добавили ранее
        foundCompany = company.getFullName();
        // поиск названия равному foundCompany из всего списка
        List<String> foundCompanyBefore = getFoundCompanyList();
        System.out.println("из всего списка foundCompany " + foundCompanyBefore);

        // тест поиска
        driver.findElement(By.name("filter")).sendKeys(foundCompany);
        driver.findElement(By.xpath(".//form/button")).click();

        List<String> foundCompany = getFoundCompanyList();

        System.out.println("из поиска foundCompany " + foundCompany);

        assertEquals(foundCompanyBefore, foundCompany);


    }

    @AfterClass
    public void cleanup() {
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

    private List<Company> getCompanyList() {

        List<WebElement> elements = driver.findElements(By.xpath(".//tr[@name='item']"));
        List<Company> companies = new ArrayList<>();
        for (WebElement element : elements) {
            String fullName = element.findElement(By.xpath(".//td[@name='fullName']")).getText();
            String shortName = element.findElement(By.xpath(".//td[@name='shortName']")).getText();
            String ogrn = element.findElement(By.xpath(".//td[@name='ogrn']")).getText();
            String address = element.findElement(By.xpath(".//td[@name='address']")).getText();
            String legalAddress = element.findElement(By.xpath(".//td[@name='legalAddress']")).getText();
            String phone = element.findElement(By.xpath(".//td[@name='phone']")).getText();
            String checkingAccount = element.findElement(By.xpath(".//td[@name='checkingAccount']")).getText();
            String correspondentAccount = element.findElement(By.xpath(".//td[@name='correspondentAccount']")).getText();
            String bik = element.findElement(By.xpath(".//td[@name='bik']")).getText();
            String inn = element.findElement(By.xpath(".//td[@name='inn']")).getText();
            String kpp = element.findElement(By.xpath(".//td[@name='kpp']")).getText();
            Company company = new Company(fullName, shortName, ogrn, address, legalAddress,
                    phone, checkingAccount, correspondentAccount, bik, inn, kpp);
            companies.add(company);

        }
        return companies;
    }

    //метод на получение fullName компаний
    private List<String> getFoundCompanyList() {
        List<WebElement> elements = driver.findElements(By.xpath(".//tr[@name='item']"));
        List<String> fullNames = new ArrayList<>();
        for (WebElement element : elements) {

            String fullName = element.findElement(By.xpath(".//td[@name='fullName']")).getText();
            if (foundCompany.equals(fullName)) {
                fullNames.add(fullName);
            }

        }
        return fullNames;

    }
}
