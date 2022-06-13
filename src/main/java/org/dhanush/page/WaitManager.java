package org.dhanush.page;

import org.dhanush.driverhandler.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WaitManager {
    private DriverManager manager;
    private WebDriverWait wait;
    public static int universalWaitTimeInSeconds = 5;

    public WebDriverWait getWait() {
        return wait;
    }

    public WaitManager(DriverManager manager) {
        this.manager=manager;
        wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(universalWaitTimeInSeconds));
    }
    public void waitTillVisibilityOf(WebElement element){
        wait.until(visibilityOf(element));
    }

    protected void waitTillVisibilityOf(String path){
        wait.until(visibilityOfElementLocated(By.xpath(path)));
    }
    public void For(int milliSec) throws InterruptedException {
        Thread.sleep(milliSec);
    }
}
