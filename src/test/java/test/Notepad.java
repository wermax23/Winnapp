package test;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Notepad {

    public static WindowsDriver driver = null;

    @BeforeClass
    public void setUp(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app","C:\\Windows\\System32\\notepad.exe");
        cap.setCapability("platformName","Windows");
        cap.setCapability("deviceName","WindowsPC");

        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
//    @AfterMethod
//    public void cleanUp(){
//        driver.quit();
//        setUp();
//    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void checkHelp(){
         driver.findElementByName("Help").click();
        driver.findElementByName("About Notepad").click();
        driver.findElementByName("OK").click();
        Date date = new Date();
        String d = date.toString();
        driver.findElementByName("Text Editor").sendKeys(d);
       driver.findElementByName("Close").click();
        driver.findElementByName("Don't Save").click();

    }
}
