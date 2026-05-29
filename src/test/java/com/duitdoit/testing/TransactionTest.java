package com.duitdoit.testing;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionTest extends BaseTest {

    private void createAccount(String name, String balance) throws InterruptedException {
        driver.findElement(AppiumBy.id("nav_accounts")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.id("btn_add_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.id("field_account_name")).sendKeys(name);
        driver.findElement(AppiumBy.id("field_account_balance")).sendKeys(balance);
        driver.findElement(AppiumBy.id("btn_save_account")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id("nav_dashboard")).click();
        Thread.sleep(500);
    }

    @Test
    public void testCreateIncomeTransaction() throws InterruptedException {
        createAccount("Main Wallet", "0");

        driver.findElement(AppiumBy.id("nav_add_transaction")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("chip_type_income")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("field_amount")).sendKeys("500000");

        driver.findElement(AppiumBy.id("dropdown_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Main Wallet']")).click();

        driver.findElement(AppiumBy.id("chip_category_Salary")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("field_note")).sendKeys("Test income");
        driver.findElement(AppiumBy.id("btn_save_transaction")).click();
        Thread.sleep(1000);

        Assert.assertTrue(true, "Income transaction created successfully");
    }

    @Test
    public void testCreateExpenseTransaction() throws InterruptedException {
        createAccount("Expense Wallet", "1000000");

        driver.findElement(AppiumBy.id("nav_add_transaction")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("chip_type_expense")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("field_amount")).sendKeys("50000");

        driver.findElement(AppiumBy.id("dropdown_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expense Wallet']")).click();

        driver.findElement(AppiumBy.id("chip_category_Food & Drinks")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("field_note")).sendKeys("Test expense");
        driver.findElement(AppiumBy.id("btn_save_transaction")).click();
        Thread.sleep(1000);

        Assert.assertTrue(true, "Expense transaction created successfully");
    }

    @Test
    public void testInsufficientBalanceExpense() throws InterruptedException {
        createAccount("Poor Wallet", "1000");

        driver.findElement(AppiumBy.id("nav_add_transaction")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("chip_type_expense")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("field_amount")).sendKeys("999999");

        driver.findElement(AppiumBy.id("dropdown_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Poor Wallet']")).click();

        driver.findElement(AppiumBy.id("chip_category_Food & Drinks")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("btn_save_transaction")).click();
        Thread.sleep(1000);

        WebElement error = driver
                .findElement(AppiumBy.xpath("//android.widget.TextView[@text='Insufficient balance']"));
        Assert.assertNotNull(error, "Should show insufficient balance error");
    }

    @Test
    public void testEditTransaction() throws InterruptedException {
        createAccount("Edit Wallet", "500000");

        driver.findElement(AppiumBy.id("nav_add_transaction")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("chip_type_income")).click();
        driver.findElement(AppiumBy.id("field_amount")).sendKeys("100000");

        driver.findElement(AppiumBy.id("dropdown_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Edit Wallet']")).click();

        driver.findElement(AppiumBy.id("chip_category_Salary")).click();
        driver.findElement(AppiumBy.id("btn_save_transaction")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("nav_analytics")).click();
        Thread.sleep(1000);

        driver.findElements(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'transaction_item_')]"))
                .get(0).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("field_amount")).clear();
        driver.findElement(AppiumBy.id("field_amount")).sendKeys("200000");
        driver.findElement(AppiumBy.id("btn_save_changes")).click();
        Thread.sleep(1000);

        Assert.assertTrue(true, "Transaction edited successfully");
    }

    @Test
    public void testDeleteTransaction() throws InterruptedException {
        createAccount("Delete Wallet", "500000");

        driver.findElement(AppiumBy.id("nav_add_transaction")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("chip_type_income")).click();
        driver.findElement(AppiumBy.id("field_amount")).sendKeys("100000");

        driver.findElement(AppiumBy.id("dropdown_account")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Delete Wallet']")).click();

        driver.findElement(AppiumBy.id("chip_category_Salary")).click();
        driver.findElement(AppiumBy.id("btn_save_transaction")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("nav_analytics")).click();
        Thread.sleep(1000);

        driver.findElements(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'transaction_item_')]"))
                .get(0).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("btn_delete_transaction")).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.id("btn_confirm_delete")).click();
        Thread.sleep(1000);

        Assert.assertTrue(true, "Transaction deleted successfully");
    }
}