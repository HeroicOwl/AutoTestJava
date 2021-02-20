package classes;

import java.util.Objects;

// класс описывающий юзера
public class User {

    private String fName;
    private String lName;
    private String address;

    // конструктор
    public User(String fName, String lName, String address) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
    }

    //сеттеры для полей объекта

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // геттеры для полей объекта

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAddress() {
        return address;
    }

    //переопределение equals и hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fName, user.fName) && Objects.equals(lName, user.lName) && Objects.equals(address, user.address);
    }
    //HashCode - это число и для одного и того же объекта это число всегда одинаковое.
    //Если хеш-коды разные, то и объекты разные.
    //Если хеш-коды равны, то объекты не всегда равны.
    //Если объекты одинаковые, то и хеш-коды одинаковые.
    //Если не переопределить hashCode(), то будет использоваться стандартный метод java и одинаковые объекты будут иметь
    // разные коды. Некоторые коллекции в Java перед сравнением через equals() выполняют сравнение по hashCode().
    @Override
    public int hashCode() {
        return Objects.hash(fName, lName, address);
    }
}
