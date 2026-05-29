package com.duitdoit.testing;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {

    private void navigateToWishlist() throws InterruptedException {
        driver.findElement(AppiumBy.id("nav_extras")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='See all']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testCreateWishlist() throws InterruptedException {
        navigateToWishlist();

        driver.findElement(AppiumBy.id("btn_add_wishlist")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("field_wishlist_name")).sendKeys("Test Item");
        driver.findElement(AppiumBy.id("field_wishlist_price")).sendKeys("500000");

        driver.findElement(AppiumBy.id("chip_priority_high")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("btn_save_wishlist")).click();
        Thread.sleep(1000);

        WebElement item = driver.findElement(AppiumBy.id("wishlist_item_Test Item"));
        Assert.assertNotNull(item, "Wishlist item should be created");
    }

    @Test
    public void testDeleteWishlist() throws InterruptedException {
        navigateToWishlist();

        driver.findElement(AppiumBy.id("btn_add_wishlist")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("field_wishlist_name")).sendKeys("Delete Item");
        driver.findElement(AppiumBy.id("field_wishlist_price")).sendKeys("100000");
        driver.findElement(AppiumBy.id("chip_priority_low")).click();
        driver.findElement(AppiumBy.id("btn_save_wishlist")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_delete_wishlist_Delete Item")).click();
        Thread.sleep(1000);

        boolean isGone = driver.findElements(AppiumBy.id("wishlist_item_Delete Item")).isEmpty();
        Assert.assertTrue(isGone, "Wishlist item should be deleted");
    }
}