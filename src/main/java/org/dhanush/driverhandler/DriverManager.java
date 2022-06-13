package org.dhanush.driverhandler;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public abstract void setUpDriver();
    public abstract void startBrowser();

    public void stopBrowser() {
        driver.quit();
        driver = null;
    }

}

