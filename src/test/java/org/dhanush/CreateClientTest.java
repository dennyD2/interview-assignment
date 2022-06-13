package org.dhanush;

import org.dhanush.domain.User;
import org.dhanush.page.objects.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.AWTException;

public class CreateClientTest extends BaseTest {
    private LoginPage loginPage;
    private ClientPage clientPage;
    private CreateClientPage createClientPage;
    private ActivationPage activationPage;
    private VerifyPage verifyPage;

    @BeforeMethod
    public void startBrowser(){
        manager.startBrowser();
        loginPage = new LoginPage(manager).initialize();
        clientPage = new ClientPage(manager).initialize();
        createClientPage = new CreateClientPage(manager).initialize();
        activationPage = new ActivationPage(manager).initialize();
        verifyPage = new VerifyPage(manager).initialize();
    }

    @Test
    public void createClientTest() throws AWTException, InterruptedException {
        loginPage.actions.goTo(AppConfig.getAppUrl());
        loginPage.loginWith(new User());
        clientPage.createClient();
        createClientPage.fillDetails(new User());
        createClientPage.fillAddress(new User());
        activationPage.active(new User());
        verifyPage.verify(new User());
    }


//    @AfterMethod
//    public void tearDown(){
//        manager.stopBrowser();
//    }
}
