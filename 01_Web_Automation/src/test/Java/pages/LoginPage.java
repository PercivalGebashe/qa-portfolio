package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class LoginPage extends BasePage{

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "form")
    private WebElement loginForm;

    @FindBy(xpath = "//span[text()='Required']")
    private List<WebElement> requiredField;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    private WebElement errorMessage;

    public LoginPage(DriverManager driverManager){
        super(driverManager);
    }

    public void login(String userName, String password){
        isLoginFormVisible();
        type(usernameField, userName);
        type(passwordField, password);
        click(submitButton);
    }

    public void isLoginFormVisible(){
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(loginForm))).isDisplayed();
    }
}