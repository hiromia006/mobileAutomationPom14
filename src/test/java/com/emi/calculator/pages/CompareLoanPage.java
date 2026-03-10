package com.emi.calculator.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompareLoanPage extends BasePage {
    public CompareLoanPage(AndroidDriver driver) {
        super(driver);
    }

    public CompareLoanPage fillLaon1Amount(int amount) {
        WebElement element = getElement(By.id("etLoanAmount1"));
        element.clear();
        element.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanPage fillLaon2Amount(int amount) {
        WebElement element = getElement(By.id("etLoanAmount2"));
        element.clear();
        element.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanPage fillLaon1Interest(float interest) {
        WebElement element = getElement(By.id("etInterest1"));
        element.clear();
        element.sendKeys(String.valueOf(interest));
        return this;
    }

    public CompareLoanPage fillLaon2Interest(float interest) {
        WebElement element = getElement(By.id("etInterest2"));
        element.clear();
        element.sendKeys(String.valueOf(interest));
        return this;
    }


    public CompareLoanPage fillLaon1Months(int months) {
        WebElement element = getElement(By.id("etPeriod1"));
        element.clear();
        element.sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoanPage fillLaon2Months(int months) {
        WebElement element = getElement(By.id("etPeriod2"));
        element.clear();
        element.sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoanPage tapCalculateBtn() {
        tapElement(By.id("btnCalculate"));
        return this;
    }

    public CompareLoanPage tapResetBtn() {
        tapElement(By.id("btnReset"));
        return this;
    }

    public boolean isCompareLoansScreenDisplayed() {
        return getElements(By.id("monthly_emi_result_1")).size() > 0;
    }

    public boolean hasCompareLoanResultReset() {
        return getElements(By.id("monthly_emi_result_1")).size() == 0;
    }
}
