package classes;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CompanyForm {

    public void fillCompanyForm(Company company) {
        $(By.name("fullName")).setValue(company.getFullName());
        $(By.name("shortName")).setValue(company.getShortName());
        $(By.name("ogrn")).setValue(company.getOgrn());
        $(By.name("address")).setValue(company.getAddress());
        $(By.name("legalAddress")).setValue(company.getLegalAddress());
        $(By.name("phone")).setValue(company.getPhone());
        $(By.name("checkingAccount")).setValue(company.getCheckingAccount());
        $(By.name("correspondentAccount")).setValue(company.getCorrespondentAccount());
        $(By.name("bik")).setValue(company.getBik());
        $(By.name("inn")).setValue(company.getInn());
        $(By.name("kpp")).setValue(company.getKpp());
    }
}
