package testcases;

import classes.User;
import classes.UserPage;
import classes.UsersPage;

import com.codeborne.selenide.ElementsCollection;
import general.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;

//тест11111111111
// класс с тестом на добавление юзера
public class UserTests extends TestBase {
    private User user, updateUser;

    //Код из аннотации @BeforeMethod выполняется перед выполнением методов, отмеченных аннотаций @Test.
    @BeforeMethod
    public void testFixtures() {
        UsersPage usersPage = new UsersPage();
        usersPage.openUsers();
        //создание юзеров
        user = new User("Иван", "Петров", "Москва");
        updateUser = new User("7Отредактированный1", "7Юзер1", "7ТЕСТ1");


    }

    @Test(description = "Тест создания юзера", priority = 1)
    public void createUserTest() {
        System.out.println("Старт тест добавления юзера");
        //В тесте создадим экземпляр класса UserPage
        //и через него будем обращаться к методам класса.
        UsersPage usersPage = new UsersPage();

        //список юзеров до добавления
        // открываем страницу и заполняем список
        //List<User> usersBefore = usersPage.openUsers().getUserList();
        //System.out.println("список usersBefore ДО добавления юзера : " + usersBefore);

        // заполняем форму и добавляем юзера
        usersPage.fillUser(user).addUser();

        //Добавляем созданного пользователя в старый список
        //usersBefore.add(user);
        //System.out.println("Добавили нового юзера usersBefore : " + usersBefore);


        //новый список после добавления
        //List<User> users = usersPage.getUserList();
        //System.out.println("вывод users (добавленные)" + users);

        //сравнение двух списков
        //assertEquals(usersBefore, users);
    }


    @Test(description = "Тест редактирования юзера", priority = 2)
    public void updateUserTest() {

        UsersPage usersPage = new UsersPage();
        UserPage userPage = usersPage.openUsers().clickUpdateUser();
        //редактируем юзера(перезаполняем поля)
        userPage.fillUser(updateUser);
        // клик обновить
        userPage.updateUser();
        ElementsCollection elements = $$(By.xpath(".//tr[@name='item']"));
        System.out.println(elements);
        //получаем список юзеров
        //List<User> users = usersPage.getUserList();
        //сравниваем юзера которого вставили с 1 элементом вставленным юзером
        //assertEquals(updateUser, users.get(0));


    }

    @Test(description = "Тест удаления юзера", priority = 3)
        public void deleteUserTest() {
        System.out.println("Старт тест удаления юзера");
        UsersPage usersPage = new UsersPage();
        //получаем список до удаления юзера
        //List<User> userBefore = usersPage.getUserList();

        //System.out.println("список до удаления userBefore " + userBefore);
        // удаляем юзера
        usersPage.deleteUser();
        //удаляем юзера из списка
        //userBefore.remove(0);
        //System.out.println("список после удаления юзера userBefore " + userBefore);
        //получаем список юзеров после удаления юзера
        //List<User> users = usersPage.getUserList();

        //System.out.println("Список после удаления юзера " + users);
        //сравнение
        //assertEquals(userBefore, users);

    }


}
