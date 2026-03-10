package com.emi.calculator.pages;

import com.aventstack.extentreports.Status;
import com.emi.calculator.report.ReportTestManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page{
    public BasePage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getElement(By selector) {
        WebElement element = null;
        try {
            addInfo("Appium Driver going to find a WebElement with " + selector + " Selector");
            element = driver.findElement(selector);
            addInfo("Appium Driver found a Web Element with " + selector + " Selector");
        } catch (Exception e) {
            addFailInfo("Appium Driver is not found a Web Element with " + selector + " Selector");
            System.out.println("Element not found: " + selector);
        }
        return element;
    }

    @Override
    public List<WebElement> getElements(By selector) {
        List<WebElement> elements = null;
        try {
            addInfo("Appium Driver going to find a WebElements with " + selector + " Selector");
            elements = driver.findElements(selector);
            addInfo("Appium Driver found a Web Elements with " + selector + " Selector");
        } catch (Exception e) {
            addInfo("Appium Driver is not found a Web Elements with " + selector + " Selector");
            System.out.println("Elements not found: " + selector);
        }
        return elements;
    }

    @Override
    public String getTextFromElement(By selector) {
        return getElement(selector).getText();
    }

    @Override
    public void tapElement(By selector) {
        getElement(selector).click();
        addInfo("Tapped on element with " + selector + " Selector");

    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public void waitForElementToBeVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOf(getElement(selector)));
        addInfo("Waited for element with " + selector + " Selector to be visible");
    }

    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }

    public void addFailInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.FAIL, message);
        }
    }
}
