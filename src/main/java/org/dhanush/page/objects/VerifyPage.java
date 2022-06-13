package org.dhanush.page.objects;

import org.dhanush.domain.User;
import org.dhanush.driverhandler.DriverManager;
import org.dhanush.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class VerifyPage extends Page{

    @FindBy(xpath = "//a[@id='client-dropdown']")
    private WebElement clientDropDown;

    @FindBy(xpath = "(//a[@class='ng-binding'])[1]")
    private WebElement clientsInDropDown;
    @FindBy(xpath = "(//input[@type='text'])[7]")
    private WebElement searchBox;

    public VerifyPage(DriverManager manager) {
        super(manager);
    }
    @Override
    public VerifyPage initialize() {
        PageFactory.initElements(manager.getDriver(), this);
        return this;
    }
    public void verify(User user) throws AWTException {
        wait.waitTillVisibilityOf(clientDropDown);
        moveTo(clientDropDown);
        moveTo(clientsInDropDown);
        actions.clickElement(clientsInDropDown);
        searchBox.sendKeys(user.getMobileNum());
        actions.pressEnterKey();

    }

}
