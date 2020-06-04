
package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class firstdemo {

    private  static AppiumDriver driver;

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

    @Test
    public void xueqiu_test(){
        //定位首页搜索框 resource-id
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        //定位搜索页搜索框
        driver.findElement(MobileBy.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        driver.findElement(MobileBy.xpath("//*[@text='BABA']")).click();
        System.out.println(driver.findElement(MobileBy.id("current_price")).getText());

        //比较好的定位方式是 XPath
        //   用 //*[@text='09988']先定位到一个元素 再考虑找父亲 兄弟 节点
        //*[@text='09988']../../..//*[@resource-id="XXX"] 找到了期望的current_price值

    }


    @Test //uiautomator2 更高效
    public void uiautomatorSelectTest(){
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        //String id_text = "resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")";
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")").click();
       //父子关系节点
        // inspector上 uiautomator2 验证 resourceId("com.xueqiu.android:id/scroll_view").childSelector(text("热门"))
    }


}
