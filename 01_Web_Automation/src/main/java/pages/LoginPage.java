package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BaseClass{

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    private final By loginForm = By.cssSelector("form");

    private final By requiredField = By.xpath("//span[text()='Required']");

    private final By errorMessage = By.xpath("//p[text()='Invalid credentials']");

    public LoginPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void enterUsername(String username){
        getWait().until(ExpectedConditions.visibilityOf(usernameField));
        this.usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        getWait().until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void submit(){
        getWait().until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.submit();
    }

    public boolean isValidationMessageDisplayed(){
        return !super.getDriver().findElements(requiredField).isEmpty();
    }

    public List<WebElement> getRequiredField(){
        return super.getDriver().findElements(requiredField);
    }

    public boolean isErrorMessageDisplayed(){
        return super.getDriver().findElement(errorMessage).isDisplayed();
    }

    public String getErrorMessage(){
        return super.getDriver().findElement(errorMessage).getText();
    }
}