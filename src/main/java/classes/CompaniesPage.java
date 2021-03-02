package classes;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import java.util.ArrayList;
import java.util.List;


import static com.codeborne.selenide.Selenide.*;

public class CompaniesPage {
    private CompanyForm companyForm;
    public CompaniesPage() {
        this.companyForm = new CompanyForm();
    }


    public CompaniesPage openCompanies() {
        open("http://localhost:8080/companies");
        return this;
    }

    public CompaniesPage fillCompany(Company company) {
        companyForm.fillCompanyForm(company);
        return this;
    }

    public void addCompany() {
        $(By.name("add")).click();
    }

    public CompanyPage clickUpdateCompany() {
        $(By.xpath(".//a[text()='Редактировать']")).click();
        return new CompanyPage();
    }

    public CompaniesPage deleteCompany() {
        $(By.xpath(".//a[@class='btn btn-danger']")).click();
        return this;
    }

    public List<Company> getCompanyList() {

        List<SelenideElement> elements = $$(By.xpath(".//tr[@name='item']"));
        List<Company> companies = new ArrayList<>();
        for (SelenideElement element : elements) {
            String fullName = element.$(By.xpath(".//td[@name='fullName']")).getText();
            String shortName = element.$(By.xpath(".//td[@name='shortName']")).getText();
            String ogrn = element.$(By.xpath(".//td[@name='ogrn']")).getText();
            String address = element.$(By.xpath(".//td[@name='address']")).getText();
            String legalAddress = element.$(By.xpath(".//td[@name='legalAddress']")).getText();
            String phone = element.$(By.xpath(".//td[@name='phone']")).getText();
            String checkingAccount = element.$(By.xpath(".//td[@name='checkingAccount']")).getText();
            String correspondentAccount = element.$(By.xpath(".//td[@name='correspondentAccount']")).getText();
            String bik = element.$(By.xpath(".//td[@name='bik']")).getText();
            String inn = element.$(By.xpath(".//td[@name='inn']")).getText();
            String kpp = element.$(By.xpath(".//td[@name='kpp']")).getText();
            Company company = new Company(fullName, shortName, ogrn, address, legalAddress,
                    phone, checkingAccount, correspondentAccount, bik, inn, kpp);
            companies.add(company);

        }
        return companies;
    }


}
