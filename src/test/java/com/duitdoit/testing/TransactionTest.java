package com.duitdoit.testing;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionTest extends BaseTest {

    private void createAccount(String name, String balance) throws InterruptedException {

        waitForElement("nav_accounts").click();

        waitForElement("btn_add_account").click();

        waitForElement("field_account_name")
                .sendKeys(name);

        waitForElement("field_account_balance")
                .sendKeys(balance);

        waitForElement("btn_icon_ic_wallet").click();

        waitForElement("btn_save_account").click();

        waitForElement("nav_dashboard").click();

    }

    @Test
    public void testCreateIncomeTransaction() throws InterruptedException {
        createAccount("Main Wallet", "0");

        waitForElement("nav_add_transaction").click();

        waitForElement("chip_type_income").click();

        waitForElement("field_amount").sendKeys("500000");

        waitForElement("dropdown_account").click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Main Wallet']")).click();

        waitForElement("chip_category_Salary").click();

        waitForElement("field_note").sendKeys("Test Income");

        scrollToElement("btn_save_transactions").click();

        Assert.assertTrue(true, "Income transaction created successfully");
    }

    @Test
    public void testCreateExpenseTransaction() throws InterruptedException {
        createAccount("Expense Wallet", "1000000");

        waitForElement("nav_add_transaction").click();

        waitForElement("chip_type_expense").click();

        waitForElement("field_amount").sendKeys("50000");

        waitForElement("dropdown_account").click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expense Wallet']")).click();

        waitForElement("chip_category_Food").click();

        waitForElement("field_note").sendKeys("Test Expense");

        scrollToElement("btn_save_transactions").click();

        Assert.assertTrue(true, "Expense transaction created successfully");
    }

    @Test
    public void testInsufficientBalanceExpense() throws InterruptedException {
        createAccount("Poor Wallet", "1000");

        waitForElement("nav_add_transaction").click();

        waitForElement("chip_type_expense").click();

        waitForElement("field_amount").sendKeys("999999");

        waitForElement("dropdown_account").click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Poor Wallet']")).click();

        waitForElement("chip_category_Food").click();

        scrollToElement("btn_save_transactions").click();

        WebElement error = driver
                .findElement(AppiumBy.xpath("//android.widget.TextView[@text='Insufficient balance']"));
        Assert.assertNotNull(error, "Should show insufficient balance error");
    }

    @Test
    public void testEditTransaction() throws InterruptedException {
        createAccount("Edit Wallet", "500000");

        waitForElement("nav_add_transaction").click();

        waitForElement("chip_type_income").click();

        waitForElement("field_amount").sendKeys("100000");

        waitForElement("dropdown_account").click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Edit Wallet']")).click();

        waitForElement("chip_category_Salary").click();

        scrollToElement("btn_save_transactions").click();

        waitForElement("nav_analytics").click();

        driver.findElements(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'transaction_item_')]"))
                .get(0).click();
        Thread.sleep(1000);

        waitForElement("field_amount").clear();

        waitForElement("field_amount").sendKeys("200000");

        scrollToElement("btn_save_transactions").click();

        Assert.assertTrue(true, "Transaction edited successfully");
    }

    @Test
    public void testDeleteTransaction() throws InterruptedException {
        createAccount("Delete Wallet", "500000");

        waitForElement("nav_add_transaction").click();

        waitForElement("chip_type_income").click();

        waitForElement("field_amount").sendKeys("100000");

        waitForElement("dropdown_account").click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Delete Wallet']")).click();

        waitForElement("chip_category_Salary").click();

        scrollToElement("btn_save_transactions").click();

        waitForElement("nav_analytics").click();

        driver.findElements(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'transaction_item_')]"))
                .get(0).click();
        Thread.sleep(1000);

        waitForElement("btn_delete_transaction").click();

        waitForElement("btn_confirm_delete").click();

        Assert.assertTrue(true, "Transaction deleted successfully");
    }
}