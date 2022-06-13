package org.dhanush.page.objects;

import org.dhanush.domain.User;
import org.dhanush.driverhandler.DriverManager;
import org.dhanush.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class ActivationPage extends Page {

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-offset ng-binding'])[2]")
    private WebElement activateButton;
    @FindBy(xpath = "(//input[@id='activationDate'])[2]")
    private WebElement activationDate;
    @FindBy(xpath = "//button[@id='save']")
    private WebElement submit;
    public ActivationPage(DriverManager manager) {
        super(manager);
    }

    @Override
    public ActivationPage initialize() {
        PageFactory.initElements(manager.getDriver(), this);
        return this;
    }

    public void active(User user) throws AWTException {
        wait.waitTillVisibilityOf(activateButton);
        actions.clickAfterElementIsClickable(activateButton);
        wait.waitTillVisibilityOf(activationDate);
        activationDate.sendKeys(user.getActivationDate());
        actions.pressEnterKey();



    }

}