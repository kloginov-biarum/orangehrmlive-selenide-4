import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement usernameField =  $(byCssSelector("[name='username']"));

    private SelenideElement passwordField =  $(byAttribute("placeholder","Password"));

    private SelenideElement loginButton = $x("//button[@type='submit']");

    private SelenideElement errorMessage = $x("//p[contains(@class, 'oxd-alert-content-text')]");
    public void enterUsername(String usernameValue){
        usernameField.shouldBe(visible);
        usernameField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue){
        passwordField.setValue(passwordValue);
    }

    public void pushLoginButton(){
        loginButton.click();
    }

    public void invalidCredText(String expectedText){
        errorMessage.shouldBe(visible);
        errorMessage.shouldHave(text(expectedText));
    }

}
