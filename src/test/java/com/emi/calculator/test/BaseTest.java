package com.emi.calculator.test;

import com.emi.calculator.pages.BasePage;
import com.emi.calculator.pages.Page;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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
            driver.startRecordingScreen();
            pg = new BasePage(driver);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDownMobileApp() {
        System.out.println("Tearing down mobile app testing environment...");
        // Code to clean up mobile app testing environment goes here
        recordingVideo();
        driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void takeScreenshot() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void recordingVideo() {
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = System.getProperty("user.dir") + "/build/videos/";
        File theDir = new File(destinationPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        System.out.println("filePath : " + filePath);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
