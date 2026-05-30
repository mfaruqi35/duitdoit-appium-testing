package com.duitdoit.testing;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegularPaymentTest extends BaseTest {

    private void navigateToRegularPayment() throws InterruptedException {
        waitForElement("nav_extras").click();

        waitForAccessibilityId("btn_see_all_regular_payment").click();
    }

    @Test
    public void testCreateRegularPayment() throws InterruptedException {
        navigateToRegularPayment();

        waitForElement("btn_add_regular_payment").click();

        waitForElement("field_regular_payment_name").sendKeys("Netflix");

        waitForElement("field_regular_payment_amount").sendKeys("54000");

        waitForElement("chip_billing_cycle_monthly").click();

        waitForElement("btn_save_regular_payment").click();

        WebElement item = waitForElement("regular_payment_item_Netflix");
        Assert.assertNotNull(item, "Regular payment should be created");
    }

    @Test
    public void testDeleteRegularPayment() throws InterruptedException {
        // navigateToRegularPayment();

        waitForElement("btn_add_regular_payment").click();

        waitForElement("field_regular_payment_name").sendKeys("Spotify");

        waitForElement("field_regular_payment_amount").sendKeys("29000");

        waitForElement("chip_billing_cycle_monthly").click();

        waitForElement("btn_save_regular_payment").click();

        waitForElement("btn_delete_regular_payment_Spotify").click();

        boolean isGone = driver.findElements(AppiumBy.xpath("//*[@resource-id='regular_payment_item_Delete Test']"))
                .isEmpty();
        Assert.assertTrue(isGone, "Regular payment should be deleted");
    }
}