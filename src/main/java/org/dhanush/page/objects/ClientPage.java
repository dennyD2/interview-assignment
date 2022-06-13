package org.dhanush.page.objects;

import org.dhanush.driverhandler.DriverManager;
import org.dhanush.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ClientPage extends Page {

//    @FindBy()
    @FindBy(xpath = "//a[@id='client-dropdown']")
    private WebElement clientDropDown;

    @FindBy(xpath = "(//a[@class='ng-binding'])[1]")
    private WebElement clientsInDropDown;

    @FindBy(xpath = "//a[@id='client_createbutton']")
    private WebElement createClientButton;

    public ClientPage(DriverManager manager) {
        super(manager);
    }

    @Override
    public ClientPage initialize() {
        PageFactory.initElements(manager.getDriver(), this);
        return this;
    }

    public void createClient(){
        wait.waitTillVisibilityOf(clientDropDown);
        moveTo(clientDropDown);
        moveTo(clientsInDropDown);
        actions.clickElement(clientsInDropDown);
        actions.clickAfterElementIsClickable(createClientButton);

    }


}
