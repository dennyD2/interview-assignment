package org.dhanush.driverhandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeManager extends DriverManager {
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public void startBrowser() {
        if(driver==null) {
            driver = new ChromeDriver(getChromeOptions());
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        return options;
    }
}
