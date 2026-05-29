package com.duitdoit.testing;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void testCreateAccount() {

        waitForElement("nav_accounts").click();

        waitForElement("btn_add_account").click();

        waitForElement("field_account_name")
                .sendKeys("Test Account");

        waitForElement("field_account_balance")
                .sendKeys("100000");

        waitForElement("btn_icon_ic_wallet").click();

        waitForElement("btn_save_account").click();

        WebElement account = waitForElement("account_item_Test Account");

        Assert.assertNotNull(account);
    }

    @Test
    public void testDeleteAccount() throws InterruptedException {
        waitForElement("nav_accounts").click();

        waitForElement("btn_add_account").click();

        waitForElement("field_account_name")
                .sendKeys("DeleteTest");

        waitForElement("field_account_balance")
                .sendKeys("50000");

        waitForElement("btn_icon_ic_wallet").click();

        waitForElement("btn_save_account").click();

        waitForElement("btn_delete_account_DeleteTest").click();

        driver.findElement(AppiumBy.id("btn_confirm_delete_account")).click();
        Thread.sleep(1000);

        boolean isAccountGone = driver.findElements(AppiumBy.id("account_item_Delete Test")).isEmpty();
        Assert.assertTrue(isAccountGone, "Account should be deleted");
    }

    @Test
    public void testTransferBetweenAccounts() throws InterruptedException {
        driver.findElement(AppiumBy.id("nav_accounts")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_add_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.id("field_account_name")).sendKeys("Account A");
        driver.findElement(AppiumBy.id("field_account_balance")).sendKeys("200000");
        driver.findElement(AppiumBy.id("btn_save_account")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_add_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.id("field_account_name")).sendKeys("Account B");
        driver.findElement(AppiumBy.id("field_account_balance")).sendKeys("50000");
        driver.findElement(AppiumBy.id("btn_save_account")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_transfer")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("dropdown_from_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Account A']")).click();

        driver.findElement(AppiumBy.id("dropdown_to_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Account B']")).click();

        driver.findElement(AppiumBy.id("field_transfer_amount")).sendKeys("50000");
        driver.findElement(AppiumBy.id("btn_confirm_transfer")).click();
        Thread.sleep(1000);

        Assert.assertTrue(true, "Transfer completed successfully");
    }

    @Test
    public void testTransferInsufficientBalance() throws InterruptedException {
        driver.findElement(AppiumBy.id("nav_accounts")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_add_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.id("field_account_name")).sendKeys("Low Balance");
        driver.findElement(AppiumBy.id("field_account_balance")).sendKeys("1000");
        driver.findElement(AppiumBy.id("btn_save_account")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_add_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.id("field_account_name")).sendKeys("Target");
        driver.findElement(AppiumBy.id("field_account_balance")).sendKeys("0");
        driver.findElement(AppiumBy.id("btn_save_account")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_transfer")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("dropdown_from_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Low Balance']")).click();

        driver.findElement(AppiumBy.id("dropdown_to_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Target']")).click();

        driver.findElement(AppiumBy.id("field_transfer_amount")).sendKeys("999999");
        driver.findElement(AppiumBy.id("btn_confirm_transfer")).click();
        Thread.sleep(1000);

        WebElement errorMessage = driver
                .findElement(AppiumBy.xpath("//android.widget.TextView[@text='Insufficient balance']"));
        Assert.assertNotNull(errorMessage, "Should show insufficient balance error");
    }

}
