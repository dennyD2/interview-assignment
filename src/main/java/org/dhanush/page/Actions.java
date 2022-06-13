package org.dhanush.page;

import org.dhanush.driverhandler.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;


import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Actions {
    private DriverManager manager;

    private WaitManager wait;

    private Page onPage;

    protected Robot robo;
    public Select select;
    public JavascriptExecutor javaScript;

    public Actions(DriverManager manager, Page onPage) {
        this.manager=manager;
        this.wait=new WaitManager(manager);
        this.onPage=onPage;
    }

    public void clickElement(WebElement element){
        element.click();
    }


    public void goTo(String URL){
        manager.getDriver().manage().window().maximize();
        manager.getDriver().get(URL);
    }

    public void clickAfterElementIsClickable(String path){
        By by = By.xpath(path);
        wait.getWait().until(elementToBeClickable(by));
        onPage.getWebElement(by).click();
    }

    public void clickAfterElementIsClickable(WebElement element){
        wait.getWait().until(elementToBeClickable(element));
        element.click();
    }

    public void pressEnterKey() throws AWTException {
        robo = new Robot();
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);
    }
    public void pressDownKey(int pressCount) throws AWTException {
        for (int i = 1; i <= pressCount ; i++) {
            robo = new Robot();
            robo.keyPress(KeyEvent.VK_DOWN);
            robo.keyRelease(KeyEvent.VK_DOWN);
        }
    }
    public void pressTabKey(int pressCount) throws AWTException {
        for (int i = 1; i <= pressCount; i++) {
            robo = new Robot();
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
        }
    }
    public void pressPageDown(int pressCount) throws AWTException {
        for (int i = 1; i <= pressCount; i++) {
            robo = new Robot();
            robo.keyPress(KeyEvent.VK_PAGE_DOWN);
            robo.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }
    }
    public void selectOption(WebElement element){
        select = new Select(element);
    }
    public void clickJavaScript(WebElement element){
        javaScript=(JavascriptExecutor) manager;
        javaScript.executeScript("arguments[0].click();", element);

    }
}
