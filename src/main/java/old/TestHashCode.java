package old;

import classes.User;

import java.util.HashSet;
import java.util.Set;

public class TestHashCode {
    public static void main(String[] args) {

        //если у юзера переопределим метод equals(), но не hashCode() Объекты равны, но хеш-коды у них разные.
        //true false 798154996 681842940

        //если Переопределим метод hashCode()
        //true true -802557286 -802557286
        User user1 = new User("Ivanov", "Ivan", "Address");
        User user2 = new User("Ivanov", "Ivan", "Address");
        Set<User> list1 = new HashSet<>();
        list1.add(user1);
        Set<User> list2 = new HashSet<>();
        list2.add(user2);
        System.out.println(user1.equals(user2));
        System.out.println(list1.equals(list2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
