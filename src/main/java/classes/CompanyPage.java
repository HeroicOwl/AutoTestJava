package classes;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CompanyPage {
    private CompanyForm companyForm;

    public CompanyPage() {
        this.companyForm = new CompanyForm();
    }

    public CompanyPage fillCompany(Company company) {
        companyForm.fillCompanyForm(company);
        return this;
    }

    public CompaniesPage updateCompany() {
        $(By.name("update")).click();
        return new CompaniesPage();
    }
}
