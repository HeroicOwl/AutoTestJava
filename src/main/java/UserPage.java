import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    private WebDriver driver;
    private UserForm userForm;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.userForm = new UserForm(driver);
    }

    //редактирование юзера
    public UserPage fillUser(User user) {
        userForm.fillUserForm(user);
        return this;
    }

    public UsersPage updateUser() {
        driver.findElement(By.name("update")).click();
        return new UsersPage(driver);
    }
}
