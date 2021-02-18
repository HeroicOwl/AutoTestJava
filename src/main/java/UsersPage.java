import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

//методы в отдельном классе
public class UsersPage {

    private WebDriver driver;
    private UserForm userForm;

    //Создадим поле driver конструктор класса, в который будем передавать ссылку на driver.
    public UsersPage(WebDriver driver) {
        this.driver = driver;
        //Добавим инициализацию компонента страниц
        this.userForm = new UserForm(driver);
    }

    // метод открытия страницы
    public UsersPage open() {
        // метод гет для перехода на страницу
        driver.get("http://localhost:8080/users");
        return this;
    }
    public UsersPage fillUser(User user) {
        userForm.fillUserForm(user);
        return this;

    }


    // метод добавлние юзера(клик по кнопке Добавить)
    public UsersPage addUser() {
        // Нажать кнопку
        // findElement() возвращает WebElement, у которого вызывается метод click()
        driver.findElement(By.name("add")).click();
        return this;
    }


    //метод окрытия формы редактирования юзера
    public UserPage clickUpdateUser() {
        driver.findElement(By.xpath(".//a[text()='Редактировать']")).click();
        return new UserPage(driver);
    }

    // получение списка юзеров
    public List<User> getUserList() {
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
