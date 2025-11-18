package actions.impl;

import actions.ActionInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionImp implements ActionInterface {

    private final Actions actions;

    public ActionImp(WebDriver driver){
        actions = new Actions(driver);
    }

    @Override
    public ActionImp moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
        return this;
    }

    @Override
    public ActionImp click(){
        actions.click().perform();
        return this;
    }

    @Override
    public ActionImp clickElement(WebElement element) {
        actions.click(element).perform();
        return this;
    }

    @Override
    public ActionImp sendKeys(WebElement element, String chars){
        actions.sendKeys(element, chars);
        return this;
    }

}
