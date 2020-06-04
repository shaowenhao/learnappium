package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public  static AppiumDriver driver;

    @BeforeAll
    public static void setUp(){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            //udid 一定要写对 deviceName 随意给可以
            caps.setCapability("udid","127.0.0.1:7555");
            caps.setCapability("deviceName","xxxx");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");
            //弹窗没有啦~~
            caps.setCapability("noReset","true");

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
