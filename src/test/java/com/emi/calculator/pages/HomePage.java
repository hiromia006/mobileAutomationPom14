package com.emi.calculator.pages;

import com.emi.calculator.util.EmiCalculatorUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean hasAppNameText() {
        EmiCalculatorUtil.setWaitTime();
        waitForElementToBeVisible(By.id("appName"));
        return getElements(By.id("appName")).size() > 0;
    }

    public EmiCalculatorPage tapOnCalculateEmiButton() {
        EmiCalculatorUtil.setWaitTime();
        tapElement(By.id("btnStart"));
        return navigateToPage(EmiCalculatorPage.class);
    }

    public CompareLoanPage tapOnCompareLoanButton() {
        EmiCalculatorUtil.setWaitTime();
        tapElement(By.id("btnCompare"));
        return navigateToPage(CompareLoanPage.class);
    }

    public boolean hasCalculateEmiButton() {
        return getElements(By.id("btnStart")).size() > 0;
    }

    public boolean hasCompareLoanButton() {
        return getElements(By.id("btnCompare")).size() > 0;
    }
}
