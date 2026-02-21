package com.emi.calculator.pages;

import com.emi.calculator.util.EmiCalculatorUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public abstract class Page {
    AndroidDriver driver;
    WebDriverWait wait;

    public Page(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(EmiCalculatorUtil.WAIT_TIME));
    }

    public abstract WebElement getElement(By selector);

    public abstract List<WebElement> getElements(By selector);

    public abstract String getTextFromElement(By selector);

    public abstract void clickElement(By selector);

    public abstract String getPageTitle();

    public abstract void waitForElementToBeVisible(By selector);

    public <T extends BasePage> T navigateToPage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(AndroidDriver.class).newInstance(driver);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
