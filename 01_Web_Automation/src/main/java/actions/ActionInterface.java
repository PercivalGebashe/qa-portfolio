package actions;

import actions.impl.ActionImp;
import org.openqa.selenium.WebElement;

public interface ActionInterface {

    ActionInterface moveToElement(WebElement element);
    ActionInterface click();
    ActionInterface clickElement(WebElement element);
    ActionImp sendKeys(WebElement element, String chars);
}
