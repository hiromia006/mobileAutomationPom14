package com.emi.calculator.test;

import com.emi.calculator.pages.EmiCalculatorPage;
import com.emi.calculator.pages.HomePage;
import org.testng.annotations.Test;

public class EmiCalculatorTest extends BaseTest {
    @Test
    public void calculateEmiShouldSucceed() {
        HomePage homePage = pg.navigateToPage(HomePage.class);
        EmiCalculatorPage emiCalculatorPage = homePage
                .tapOnCalculateEmiButton()
                .fillLoanAmount("100000")
                .fillInterestRate("10")
                .fillLoanYears("5")
                .fillLoanMonths("6")
                .fillProcessingFee("2")
                .tapOnCalculateButton();

    }
}
