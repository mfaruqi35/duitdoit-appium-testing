package com.duitdoit.testing;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegularPaymentTest extends BaseTest {

    private void navigateToRegularPayment() throws InterruptedException {
        driver.findElement(AppiumBy.id("nav_extras")).click();
        Thread.sleep(1000);
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='See all']")).get(0).click();
        Thread.sleep(1000);
    }

    @Test
    public void testCreateRegularPayment() throws InterruptedException {
        navigateToRegularPayment();

        driver.findElement(AppiumBy.id("btn_add_regular_payment")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("field_regular_payment_name")).sendKeys("Netflix");
        driver.findElement(AppiumBy.id("field_regular_payment_amount")).sendKeys("54000");

        driver.findElement(AppiumBy.id("chip_billing_cycle_monthly")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("btn_save_regular_payment")).click();
        Thread.sleep(1000);

        WebElement item = driver.findElement(AppiumBy.id("regular_payment_item_Netflix"));
        Assert.assertNotNull(item, "Regular payment should be created");
    }

    @Test
    public void testDeleteRegularPayment() throws InterruptedException {
        navigateToRegularPayment();

        driver.findElement(AppiumBy.id("btn_add_regular_payment")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("field_regular_payment_name")).sendKeys("Spotify");
        driver.findElement(AppiumBy.id("field_regular_payment_amount")).sendKeys("29000");
        driver.findElement(AppiumBy.id("chip_billing_cycle_monthly")).click();
        driver.findElement(AppiumBy.id("btn_save_regular_payment")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_delete_regular_payment_Spotify")).click();
        Thread.sleep(1000);

        boolean isGone = driver.findElements(AppiumBy.id("regular_payment_item_Spotify")).isEmpty();
        Assert.assertTrue(isGone, "Regular payment should be deleted");
    }
}