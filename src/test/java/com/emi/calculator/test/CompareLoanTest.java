package com.emi.calculator.test;

import com.emi.calculator.pages.CompareLoanPage;
import com.emi.calculator.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareLoanTest extends BaseTest {
    @Test(priority = 0)
    public void compareLoanShouldSucceed() {
//        HomePage page=pg.navigateToPage(HomePage.class);
//        CompareLoanPage loanPage=page.tapOnCompareLoanButton();
//        loanPage=loanPage
//                .fillLaon1Amount(15000)
//                .fillLaon1Interest(9)
//                .fillLaon1Months(15)
//                .fillLaon2Amount(15000)
//                .fillLaon2Interest(10)
//                .fillLaon2Months(15)
//                .tapCalculateBtn();
//        Assert.assertTrue(loanPage.isCompareLoansScreenDisplayed());

        CompareLoanPage loanPage = pg.navigateToPage(HomePage.class)
                .tapOnCompareLoanButton()
                .fillLaon1Amount(15000)
                .fillLaon1Interest(9)
                .fillLaon1Months(15)
                .fillLaon2Amount(15000)
                .fillLaon2Interest(10)
                .fillLaon2Months(15)
                .tapCalculateBtn();
        Assert.assertTrue(loanPage.isCompareLoansScreenDisplayed());

    }
}
