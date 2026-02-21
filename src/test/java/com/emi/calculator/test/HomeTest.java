package com.emi.calculator.test;

import com.emi.calculator.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    @Test
    public void shouldDisplayAppNameText() {
        HomePage page = pg.navigateToPage(HomePage.class);
        Assert.assertTrue(page.hasAppNameText());
    }

    @Test
    public void shouldDisplayCalculateEmiButton() {
        HomePage page = pg.navigateToPage(HomePage.class);
        Assert.assertTrue(page.hasCalculateEmiButton());
    }

    @Test
    public void shouldDisplayCompareLoanButton() {
        HomePage page = pg.navigateToPage(HomePage.class);
        Assert.assertTrue(page.hasCompareLoanButton());
    }
}
