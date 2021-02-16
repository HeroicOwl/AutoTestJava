import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

// тест на добавления нового юзера
public class Test1 {

    private static WebDriver driver;
    private User user;

    //Самый первый
    @BeforeClass
    private void setUp() {
        // путь к файлу драйвера
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //новый объект для запуска браузера
        driver = new ChromeDriver();

    }

    //Код из аннотации @BeforeMethod выполняется перед выполнением методов, отмеченных аннотаций @Test.
    @BeforeMethod
    private void testFixtures() {
        // метод гет для перехода на страницу
        driver.get("http://localhost:8080/users");
        //создание юзера
        user = new User("Иван", "Петров", "Москва");

    }

    // после выполнения всех тестовых методов
    @AfterClass
    public void cleanup() {
        // закрываем браузер
        driver.quit();
    }


    @Test
    public void createUserTest() {
        // вызываем метод заполнения формы
        fillUser(user);
        // вызываем метода добавления юзера
        addUser();
    }


    // метод для заполнения формы
    private static void fillUser(User user) {
        //поиск элемента методом findElement
        //driver.findElement(By.name("fName"));
        // Заполнить поле
        // Метод findElement() возвращает WebElement, у которого вызывается метод sendKeys()
        driver.findElement(By.name("fName")).sendKeys(user.getfName());
        driver.findElement(By.name("lName")).sendKeys(user.getlName());
        driver.findElement(By.name("address")).sendKeys(user.getAddress());

    }

    // метод добавлние юзера(клик по кнопке Добавить)
    private static void addUser() {
        // Нажать кнопку
        // findElement() возвращает WebElement, у которого вызывается метод click()
        driver.findElement(By.name("add")).click();
    }
}
