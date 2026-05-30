package com.duitdoit.testing;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    public WebElement waitForElement(String resourceId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@resource-id='" + resourceId + "']")));
    }

    public WebElement waitForAccessibilityId(String id) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId(id)));
    }

    public WebElement scrollToElement(String resourceId) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""
                        + resourceId + "\"))"));
    }

    public void scrollToTop() {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(5)"));
        } catch (Exception e) {
        }
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAvd("Pixel_8");
        options.setApp("/home/arsene/Documents/semester-6/kpl/UAS/app-debug.apk");
        options.setAppActivity(".MainActivity");
        // options.setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
