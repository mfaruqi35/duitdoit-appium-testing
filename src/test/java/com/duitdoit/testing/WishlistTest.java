package com.duitdoit.testing;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {

    private void navigateToWishlist() throws InterruptedException {
        waitForElement("nav_extras").click();
        waitForAccessibilityId("btn_see_all_wishlist").click();
    }

    @Test
    public void testCreateWishlist() throws InterruptedException {
        navigateToWishlist();

        waitForElement("btn_add_wishlist").click();

        waitForElement("field_wishlist_name")
                .sendKeys("Test Item");

        waitForElement("field_wishlist_price")
                .sendKeys("500000");

        waitForElement("chip_priority_high").click();

        waitForElement("btn_save_wishlist").click();

        WebElement item = waitForElement("wishlist_item_Test Item");
        Assert.assertNotNull(item, "Wishlist item should be created");
    }

    @Test
    public void testDeleteWishlist() throws InterruptedException {
        // navigateToWishlist();

        waitForElement("btn_add_wishlist").click();

        waitForElement("field_wishlist_name")
                .sendKeys("Delete Test");

        waitForElement("field_wishlist_price")
                .sendKeys("100000");

        waitForElement("chip_priority_low").click();

        waitForElement("btn_save_wishlist").click();

        waitForElement("btn_delete_wishlist_Delete Test").click();

        boolean isGone = driver.findElements(AppiumBy.xpath("//*[@resource-id='wishlist_item_Delete Test']")).isEmpty();
        Assert.assertTrue(isGone, "Wishlist item should be deleted");
    }
}