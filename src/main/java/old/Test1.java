package old;

import classes.User;
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

// тест на добавления нового юзера
public class Test1 {

    private static WebDriver driver;
    private User user, user1, user2;

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
        //создание юзеров
        user = new User("Иван", "Петров", "Москва");
        user1 = new User("Ivanov", "Ivan", "Address");
        user2 = new User("Ivanov", "Ivan", "Address");

    }

    // после выполнения всех тестовых методов
    @AfterClass
    public void cleanup() {
        // закрываем браузер
        //driver.quit();
    }


    @Test
    public void createUserTest() {
        //список юзеров до добавления
        List<User> usersBefore = getUserList();
        System.out.println("список ДО : " + usersBefore);

        // вызываем метод заполнения формы
        fillUser(user);
        // вызываем метода добавления юзера
        addUser();
        //Добавляем созданного пользователя в старый список
        usersBefore.add(user);
        System.out.println("Добавили первого нового юзера: " + usersBefore);

        /*fillUser(user1);
        addUser();
        usersBefore.add(user1);
        System.out.println("Добавили второго нового юзера: " + usersBefore);
        fillUser(user2);
        System.out.println("Добавили третьего нового юзера: " + usersBefore);
        addUser();
        usersBefore.add(user2);*/

        //новый список после добавления
        List<User> users = getUserList();
        System.out.println("вывод users " + users);


        //сравнение двух списков
        assertEquals(usersBefore, users);



    }

    @Test
    public void update() {
        
        driver.findElement(By.xpath(".//a[text()='Редактировать']")).click();
        fillUser(new User("1", "2", "3"));


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

    // получение списка юзеров
    private List<User> getUserList() {
        //В списке elements хранятся все строки таблицы. Хранятся как объекты типа WebElement.
        List<WebElement> elements = driver.findElements(By.xpath(".//tr[@name='item']"));
        List<User> users = new ArrayList<>();
        for (WebElement element : elements) {
            String name = element.findElement(By.xpath(".//td[@name='fName']")).getText();
            String lName = element.findElement(By.xpath(".//td[@name='lName']")).getText();
            String address = element.findElement(By.xpath(".//td[@name='address']")).getText();
            User user = new User(name, lName, address);
            users.add(user);

        }
        return users;
    }
}
