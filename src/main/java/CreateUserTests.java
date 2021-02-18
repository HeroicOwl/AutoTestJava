import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

// класс с тестом на добавление юзера
public class CreateUserTests extends TestBase {
    private User user, user1, user2, updateUser;

    //Код из аннотации @BeforeMethod выполняется перед выполнением методов, отмеченных аннотаций @Test.
    @BeforeMethod
    public void testFixtures() {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.open();
        //создание юзеров
        user = new User("Иван", "Петров", "Москва");
        //user1 = new User("Ivanov", "Ivan", "Address");
        //user2 = new User("Ivanov", "Ivan", "Address");
        updateUser = new User("Отредактированный", "Юзер", "ТЕСТ");

    }

    @Test
    public void createUserTest() {
        //В тесте создадим экземпляр класса UserPage
        //и через него будем обращаться к методам класса.
        UsersPage usersPage = new UsersPage(driver);

        //список юзеров до добавления
        // открываем страницу и заполняем список
        List<User> usersBefore = usersPage.open().getUserList();
        System.out.println("список ДО : " + usersBefore);

        // заполняем форму и добавляем юзера
        usersPage.fillUser(user).addUser();

        //Добавляем созданного пользователя в старый список
        usersBefore.add(user);
        System.out.println("Добавили первого нового юзера: " + usersBefore);

        /*usersPage.fillUser(user1).addUser();
        usersBefore.add(user1);
        System.out.println("Добавили второго нового юзера: " + usersBefore);
        usersPage.fillUser(user2);
        usersBefore.add(user2);
        System.out.println("Добавили третьего нового юзера: " + usersBefore);
        usersPage.addUser();*/

        //новый список после добавления
        List<User> users = usersPage.getUserList();
        System.out.println("вывод users " + users);

        //сравнение двух списков
        assertEquals(usersBefore, users);
    }

    @Test
    public void updateUserTest() {

        UsersPage usersPage = new UsersPage(driver);
        UserPage userPage = usersPage.open().clickUpdateUser();
        //действия на странице редактирования пользователя
        userPage.fillUser(new User("Отредактированный", "Пользователь", "тест"));
        //userPage.updateUser();


        }

    }
