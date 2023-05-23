import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginTest {

    @Test
    public void successLogin() {
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.pushLoginButton();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.correctHeaderText();
    }

    @Test
    public void invalidPassword(){
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin");
        loginPage.pushLoginButton();
        loginPage.invalidCredText("Invalid credentials");
    }

    @Test
    public void emptyInputFields(){
        //Leave password and username empty
        //check error messages "Required"
    }

}
