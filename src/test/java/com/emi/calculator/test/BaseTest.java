package com.emi.calculator.test;

import com.emi.calculator.pages.BasePage;
import com.emi.calculator.pages.Page;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AndroidDriver driver;
    public Page pg;

    @BeforeClass
    public void setUpMobileApp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:udid", "127.0.0.1:6555");
            caps.setCapability("appium:platformVersion", "13");
            caps.setCapability("appium:appPackage", "com.continuum.emi.calculator");
            caps.setCapability("appium:appActivity", "com.finance.emicalci.activity.Splash_screnn");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:automationName", "UiAutomator2");


            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
            pg = new BasePage(driver);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDownMobileApp() {
        System.out.println("Tearing down mobile app testing environment...");
        // Code to clean up mobile app testing environment goes here
        driver.quit();
    }
}
