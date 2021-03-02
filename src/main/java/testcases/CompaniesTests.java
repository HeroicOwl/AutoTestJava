package testcases;

import classes.Company;
import classes.CompaniesPage;

import classes.CompanyPage;
import classes.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.SortedMap;

import static org.testng.Assert.assertEquals;


public class CompaniesTests {
    private Company company, updateCompany;



    @BeforeMethod
    public void testFixtures() {
        CompaniesPage companiesPage = new CompaniesPage();
        companiesPage.openCompanies();
        company = new Company("5ООО ТЕСТОВЫЙ ТЕСТ", "ТЕСТ", "1234568", "Москва, ул. Тестовая 54",
                "Рязань, тестовая 78", "666-66-66", "98765431", "54927517", "123",
                "1234567890", "123456789");
        updateCompany = new Company("ОТРЕДАКТИРОВАННАЯ КОМПАНИЯ", "ред комп", "86521565", "Москва, ул. Редакторская 54",
                "Рязань, редакторская 78", "999-99-99", "123456789", "555", "555",
                "198765432", "123456789");

    }

    @Test(description = "Тест создания компании", priority = 1)
    public void createCompany() {
        System.out.println("\nСтарт тест добавления компании");
        CompaniesPage companiesPage = new CompaniesPage();
        List<Company> companiesBefore = companiesPage.getCompanyList();
        System.out.println("список ДО : " + companiesBefore);

        companiesPage.fillCompany(company);
        companiesPage.addCompany();
        companiesBefore.add(company);
        System.out.println("Добавили компанию: " + companiesBefore);

        List<Company> companies = companiesPage.getCompanyList();
        System.out.println("вывод companies " + companies);

        assertEquals(companiesBefore, companies);

    }
    @Test(description = "Тест редактирования компании", priority = 2)
    public void updateCompanyTest() {
        System.out.println("\nСтарт тест апдейт компании");
        CompaniesPage companiesPage = new CompaniesPage();
        CompanyPage companyPage = companiesPage.openCompanies().clickUpdateCompany();
        companyPage.fillCompany(updateCompany);
        companyPage.updateCompany();
        List<Company> companies = companiesPage.getCompanyList();
        System.out.println("отредактированный юзер " + companies.get(0));
        System.out.println("юзеро которого ожидаем " + updateCompany);
        assertEquals(updateCompany, companies.get(0));
    }

    @Test(description = "Тест удаления компании", priority = 3)
    public void deleteCompanyTest(){
        System.out.println("\nСтарт тест удаления компании");
        CompaniesPage companiesPage = new CompaniesPage();
        List<Company>  companiesBefore = companiesPage.getCompanyList();
        System.out.println("список до удаления companiesBefore " + companiesBefore);
        companiesPage.deleteCompany();
        companiesBefore.remove(0);
        System.out.println("список после удаления компании companiesBefore " + companiesBefore);
        List<Company> companies = companiesPage.getCompanyList();
        System.out.println("Список после удаления компании " + companies);
        assertEquals(companiesBefore, companies);

    }


}
