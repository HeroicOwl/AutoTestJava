package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

//Формы редактирования и добавления пользователя имеют одинаковые поля, поэтому
// можно вынести общий компонент этих страниц в отдельный класс UserForm.
// И вынести туда метод заполнения формы.
public class UserForm {
    //private WebDriver driver;

    //Создадим поле driver конструктор класса, в который будем передавать ссылку на driver.
    /*public UserForm(WebDriver driver) {
        this.driver = driver;
    }*/
    // метод для заполнения формы
    public void fillUserForm(User user) {
        //поиск элемента методом findElement
        //driver.findElement(By.name("fName"));
        // Заполнить поле
        // Метод findElement() возвращает WebElement, у которого вызывается метод sendKeys()
        //System.out.println(user.toString());
        //driver.findElement(By.name("fName")).click();
        //driver.findElement(By.name("fName")).clear();

        // КОСТЫЛЬ иначе поля не заполняются вообще
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        /*driver.findElement(By.name("fName")).clear();
        driver.findElement(By.name("fName")).sendKeys(user.getfName());
        driver.findElement(By.name("lName")).clear();
        driver.findElement(By.name("lName")).sendKeys(user.getlName());
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(user.getAddress());*/

        // sendKeys добавить в конец
        // setValue заменит значение
        $(By.name("fName")).setValue(user.getfName());
        $(By.name("lName")).setValue(user.getlName());
        $(By.name("address")).setValue(user.getAddress());

    }
}
