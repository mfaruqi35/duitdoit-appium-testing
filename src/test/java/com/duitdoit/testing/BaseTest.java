package com.duitdoit.testing;

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

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAvd("Pixel_9");
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
