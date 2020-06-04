package com.appium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Description:
 * date: 2020 2020/6/3 18:22
 *
 * @author shaowenhao
 * @since JDK 1.8
 */
public class WaitTest extends BaseTest {
    @Test
    public void fun(){

        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
        // to do some click operation on search button
        WebElement ali = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='BABA']")));

       ali.getAttribute("enabled");

    }
}
