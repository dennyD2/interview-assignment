package org.dhanush.page.objects;

import org.dhanush.domain.User;
import org.dhanush.driverhandler.DriverManager;
import org.dhanush.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;


public class LoginPage extends Page {

    //Locators
    @FindBy(xpath = "(//input[@id='oid'])[1]")
    private WebElement orgID;

    @FindBy(xpath = "(//input[@id='uid'])[1]")
    private WebElement userID;

    @FindBy(xpath = "//input[@id='pwd']")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Sign In' and  @id='login-button']")
    private WebElement signInButton;


    public LoginPage(DriverManager manager) {
        super(manager);
    }

    @Override
    public LoginPage initialize() {
        PageFactory.initElements(manager.getDriver(), this);
        return this;
    }

    public void loginWith(User user) throws AWTException, InterruptedException {
        wait.waitTillVisibilityOf(orgID);
        actions.clickElement(orgID);
        orgID.sendKeys(user.getOrganization());
        userID.sendKeys(user.getUserName());
        password.sendKeys(user.getPassword());
        wait.For(3000);
//        actions.pressEnterKey();
        actions.clickElement(signInButton);

    }
}
