package org.dhanush.driverhandler;

import java.util.Optional;

public enum Browser {
    CHROME, FIREFOX;

    public static Browser getBrowser(){
        String browser=null;
        if(System.getProperty("browser")==null){
            browser="chrome";
        }else{
            browser=System.getProperty("browser");
        }
        if(browser.equalsIgnoreCase("chrome")){
            return CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            return FIREFOX;
        } else {
            throw new RuntimeException(String.format("%s browser is not available", browser));
        }
    }
}

