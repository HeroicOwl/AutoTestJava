public class Company {

    private String fullName;
    private String shortName;
    private String ogrn;
    private String address;
    private String legalAddress;
    private String phone;
    private String checkingAccount;
    private String correspondentAccount;
    private String bik;
    private String inn;
    private String kpp;

    public Company(String fullName, String shortName, String ogrn, String address, String legalAddress,
                   String phone, String checkingAccount, String correspondentAccount, String bik, String inn, String kpp) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.ogrn = ogrn;
        this.address = address;
        this.legalAddress = legalAddress;
        this.phone = phone;
        this.checkingAccount = checkingAccount;
        this.correspondentAccount = correspondentAccount;
        this.bik = bik;
        this.inn = inn;
        this.kpp = kpp;
    }

    //сеттеры
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCheckingAccount(String checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }


    // геттеры

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getOgrn() {
        return ogrn;
    }

    public String getAddress() {
        return address;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getCheckingAccount() {
        return checkingAccount;
    }

    public String getCorrespondentAccount() {
        return correspondentAccount;
    }

    public String getBik() {
        return bik;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }
}
