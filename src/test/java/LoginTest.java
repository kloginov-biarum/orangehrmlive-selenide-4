import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginTest extends BaseTest{

    @Test
    public void successLogin() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.pushLoginButton();
        dashboardPage.correctHeaderText();

    }

    @Test
    public void invalidPassword(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin");
        loginPage.pushLoginButton();
        loginPage.invalidCredText("Invalid credentials");
    }


    public void emptyInputFields(){
        //Leave password and username empty
        //check error messages "Required"
    }

    @Test
    public void forgotPassword(){
        loginPage.followTheForgotPasswordLink();
        resetPasswordPage.checkResetPasswordTittle();
        resetPasswordPage.urlIsCorrect();
    }


    @Test
    public void elementsAreVisible(){
        //logo is displayed
        loginPage.logoIsDisplayed();
        //credentionals section is displayed
        loginPage.credSectionIsDisplayed();
        loginPage.logoImageIsCorrect();
    }

}
