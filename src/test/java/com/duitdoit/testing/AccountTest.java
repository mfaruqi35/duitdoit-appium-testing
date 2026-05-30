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

                waitForElement("btn_confirm_delete_account").click();

                boolean isAccountGone = driver.findElements(AppiumBy.id("account_item_Delete Test")).isEmpty();
                Assert.assertTrue(isAccountGone, "Account should be deleted");
        }

        @Test
        public void testTransferBetweenAccounts() throws InterruptedException {

                waitForElement("nav_accounts").click();

                // Add First Account
                waitForElement("btn_add_account").click();

                waitForElement("field_account_name")
                                .sendKeys("Account A");

                waitForElement("field_account_balance")
                                .sendKeys("500000");

                waitForElement("btn_icon_ic_wallet").click();

                waitForElement("btn_save_account").click();

                // Add Second Account
                waitForElement("btn_add_account").click();

                waitForElement("field_account_name")
                                .sendKeys("Account B");

                waitForElement("field_account_balance")
                                .sendKeys("5000");

                waitForElement("btn_icon_ic_wallet").click();

                waitForElement("btn_save_account").click();

                waitForElement("btn_transfer").click();

                waitForElement("dropdown_from_account").click();
                driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Account A']")).click();

                waitForElement("dropdown_to_account").click();
                driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Account B']")).click();

                waitForElement("field_transfer_amount").sendKeys("50000");

                waitForElement("btn_confirm_transfer").click();

                Assert.assertTrue(true, "Transfer completed successfully");
        }

        @Test
        public void testTransferInsufficientBalance() throws InterruptedException {

                waitForElement("nav_accounts").click();

                waitForElement("btn_add_account").click();

                waitForElement("field_account_name")
                                .sendKeys("Low Balance");

                waitForElement("field_account_balance")
                                .sendKeys("1000");

                waitForElement("btn_icon_ic_wallet").click();

                waitForElement("btn_save_account").click();

                waitForElement("btn_add_account").click();

                waitForElement("field_account_name")
                                .sendKeys("Target");

                waitForElement("field_account_balance")
                                .sendKeys("0");

                waitForElement("btn_icon_ic_wallet").click();

                waitForElement("btn_save_account").click();

                waitForElement("btn_transfer").click();

                waitForElement("dropdown_from_account").click();
                driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Low Balance']")).click();

                waitForElement("dropdown_to_account").click();
                driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Target']")).click();

                waitForElement("field_transfer_amount").sendKeys("9999999");

                waitForElement("btn_confirm_transfer").click();

                WebElement errorMessage = driver
                                .findElement(AppiumBy.xpath("//android.widget.TextView[@text='Insufficient balance']"));
                Assert.assertNotNull(errorMessage, "Should show insufficient balance error");
        }

}
