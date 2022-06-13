package org.dhanush.page;

import org.dhanush.driverhandler.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class Page {
    protected DriverManager manager;
    public Actions actions;
    protected WaitManager wait;
    public abstract Page initialize();

    public Page(DriverManager manager) { //VERIFY
        this.manager = manager;
        this.actions=new Actions(manager, this);
        this.wait=new WaitManager(manager);
    }

    protected WebElement getWebElement(By by){
        return manager.getDriver().findElement(by);
    }

    public void moveTo(WebElement element){
        org.openqa.selenium.interactions.Actions mouse = new org.openqa.selenium.interactions.Actions(manager.getDriver());
        mouse.moveToElement(element).perform();
    }

}
