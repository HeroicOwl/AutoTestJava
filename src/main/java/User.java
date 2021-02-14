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
}
