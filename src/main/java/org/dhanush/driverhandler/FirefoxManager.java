package org.dhanush.driverhandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxManager extends DriverManager{

    @Override
    public void setUpDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    public void startBrowser() {
        if(driver==null) {
            driver = new FirefoxDriver(new FirefoxOptions());
        }
    }
}
