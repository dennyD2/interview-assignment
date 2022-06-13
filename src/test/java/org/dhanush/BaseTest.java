package org.dhanush;

import org.dhanush.driverhandler.DriverFactory;
import org.dhanush.driverhandler.DriverManager;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected DriverManager manager;

    @BeforeSuite
    public void setBrowser(){
        manager = DriverFactory.getDriverManager();
        manager.setUpDriver();
    }

}
