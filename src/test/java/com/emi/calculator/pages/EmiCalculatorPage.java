package com.emi.calculator.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmiCalculatorPage extends BasePage {
    public EmiCalculatorPage(AndroidDriver driver) {
        super(driver);
    }

    public EmiCalculatorPage fillLoanAmount(String amount) {
        getElement(By.id("etLoanAmount")).sendKeys(amount);
        return this;
    }

    public EmiCalculatorPage fillInterestRate(String rate) {
        getElement(By.id("etInterest")).sendKeys(rate);
        return this;
    }

    public EmiCalculatorPage fillLoanYears(String years) {
        getElement(By.id("etYears")).sendKeys(years);
        return this;
    }

    public EmiCalculatorPage fillLoanMonths(String months) {
        getElement(By.id("etMonths")).sendKeys(months);
        return this;
    }

    public EmiCalculatorPage tapOnPeriod() {
        tapElement(By.id("rbPeriod"));
        return this;
    }

    public EmiCalculatorPage fillProcessingFee(String fee) {
        getElement(By.id("etFee")).sendKeys(fee);
        return this;
    }


    public EmiCalculatorPage tapOnCalculateButton() {
        tapElement(By.id("btnCalculate"));
        return this;
    }

    public EmiCalculatorPage tapOnResetButton() {
        tapElement(By.id("btnReset"));
        return this;
    }

    public EmiDetailPage tapOnViewDetailsButton() {
        tapElement(By.id("btnDetail"));
        return navigateToPage(EmiDetailPage.class);
    }
}
