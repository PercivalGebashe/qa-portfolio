package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.DriverFactory;

import java.util.List;
import java.util.Objects;

public class LoginPage{

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

    public LoginPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void enterUsername(String username){
        Objects.requireNonNull(DriverFactory.getWait().until(ExpectedConditions.visibilityOf(usernameField)))
                .sendKeys(username);
    }

    public void enterPassword(String password){
        Objects.requireNonNull(DriverFactory.getWait().until(ExpectedConditions.visibilityOf(passwordField)))
            .sendKeys(password);
    }

    public void submit(){
        Objects.requireNonNull(DriverFactory.getWait().until(ExpectedConditions.visibilityOf(submitButton)))
            .submit();
    }

    public boolean isValidationMessageDisplayed(){
        return !requiredField.isEmpty();
    }

    public List<WebElement> getRequiredField(){
        return requiredField;
    }

    public boolean isLoginFormVisible(){
        return Objects.requireNonNull(DriverFactory.getWait()
                .until(ExpectedConditions.visibilityOf(loginForm))).isDisplayed();
    }

    public boolean isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}