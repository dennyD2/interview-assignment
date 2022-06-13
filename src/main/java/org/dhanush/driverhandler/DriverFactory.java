package org.dhanush.driverhandler;

public class DriverFactory {

    private void DriverFactory(){

    }

    public static DriverManager getDriverManager(){
        //Upcasting and downcasting
        DriverManager manager = null;
        Browser browser = Browser.getBrowser();
        switch (browser){
            case CHROME:
                manager = new ChromeManager();
                break;
            case FIREFOX:
                manager = new FirefoxManager();
                break;
        }
        return manager;
    }


}
