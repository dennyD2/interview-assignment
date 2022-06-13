package org.dhanush.page.objects;

import org.dhanush.domain.User;
import org.dhanush.driverhandler.DriverManager;
import org.dhanush.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class CreateClientPage extends Page{
    public CreateClientPage(DriverManager manager) {
        super(manager);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='mobileNo']")
    private WebElement mobileNo;
    @FindBy(xpath = "//input[@name='dateofbirth']")
    private WebElement DOB;
    @FindBy(xpath = "(//a[@class='chosen-single'])[5]")
    private WebElement clientType;
    @FindBy(xpath = "//h3[@class='ng-binding']")
    private WebElement outClick;
    @FindBy(xpath = "(//li[@class='active-result'])[1]")
    private WebElement subscriber;
    @FindBy(xpath = "(//a[@class='chosen-single'])[4]")
    private WebElement gender;
    @FindBy(xpath = "(//li[@class='active-result'])[1]")
    private WebElement male;
    @FindBy(xpath = "(//a[@class='chosen-single'])[6]")
    private WebElement clientClassification;
    @FindBy(xpath = "(//li[@class='active-result'])[5]")
    private WebElement selectClass1;

//    ADDRESS LOCATORS
    @FindBy(xpath = "(//button[@class='fa fa-plus'])[2]")
    private WebElement addAddress;
    @FindBy(xpath = "(//a[@tabindex='-1'])[8]")
    private WebElement addressType;
    @FindBy(xpath = "(//li[@class='active-result'])[8]")
    private WebElement selectCurrent;
    @FindBy(xpath = "//input[@name='street0']")
    private WebElement enterStreet;
    @FindBy(xpath = "//input[@name='addressline1']")
    private WebElement addressLine1;
    @FindBy(xpath = "(//a[@class='chosen-single'])[9]")
    private WebElement country;
    @FindBy(xpath = "(//a[@class='chosen-single'])[10]")
    private WebElement state;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;
    @FindBy(xpath = "//button[@id='save']")
    private WebElement submit;

    @Override
    public CreateClientPage initialize() {
        PageFactory.initElements(manager.getDriver(), this);
        return this;
    }
    public void fillDetails(User user){
        wait.waitTillVisibilityOf(firstName);
        firstName.sendKeys(user.getNameFirst());
        lastName.sendKeys(user.getNameLast());
        mobileNo.sendKeys(user.getMobileNum());
        DOB.sendKeys(user.getDoB());
        actions.clickElement(outClick);

        actions.clickElement(clientType);
        actions.clickAfterElementIsClickable(subscriber);
        actions.clickElement(outClick);

        actions.clickAfterElementIsClickable(gender);
        actions.clickAfterElementIsClickable(male);
        actions.clickElement(outClick);

        actions.clickAfterElementIsClickable(clientClassification);
        actions.clickElement(selectClass1);
        actions.clickElement(outClick);
    }
    public void fillAddress(User user) throws AWTException, InterruptedException {

        actions.clickAfterElementIsClickable(addAddress);
        actions.pressPageDown(1);
        actions.pressTabKey(1);
        actions.pressDownKey(1);
        actions.clickAfterElementIsClickable(selectCurrent);

        enterStreet.sendKeys(user.getStreet());
        addressLine1.sendKeys(user.getAddressLine1());


        actions.clickAfterElementIsClickable(country);
        actions.pressDownKey(1);
        actions.pressEnterKey();

        actions.clickAfterElementIsClickable(state);
        actions.pressDownKey(15);
        actions.pressEnterKey();

        city.sendKeys(user.getDistrict());


        actions.clickAfterElementIsClickable(submit);

    }
}


