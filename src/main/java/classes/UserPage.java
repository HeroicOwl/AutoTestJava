package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class UserPage {
    //private WebDriver driver;
    private UserForm userForm;

    public UserPage() {
        //this.driver = driver;
        this.userForm = new UserForm();
    }
    //возвращать return this, если остаемся на той же странице или возвращать экземпляр класс новой страницы.
    // возвращается this тк остаемся еще на этой же страницы

    //редактирование юзера
    public UserPage fillUser(User user) {
        userForm.fillUserForm(user);
        return this;
    }

    //возвращать return this, если остаемся на той же странице или возвращать экземпляр класс новой страницы.
    // после апдейта идет новая стр поэтому тут экземпляр новой стр
    public UsersPage updateUser() {
        //driver.findElement(By.name("update")).click();
        $(By.name("update")).click();
        //return new UsersPage(driver);
        return new UsersPage();
    }
}
