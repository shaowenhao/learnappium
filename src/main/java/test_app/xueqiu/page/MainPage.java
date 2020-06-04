package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Description: APP PO第一节 雪球app 的main主页
 * date: 2020 2020/6/4 14:44
 *
 * @author shaowenhao
 * @since JDK 1.8
 */
public class MainPage {

    //PO不应该对外暴露driver
     private AndroidDriver driver;
    public MainPage() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        // 不清理之前的数据
        desiredCapabilities.setCapability("noReset","true");
        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        // 1. 先加个简单的隐式等待
        // todo:等待与优化
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
    }

    // 提供什么功能？

    public SearchPage toSearch(){
          // 老师先写好语句再添加的类
         // 怎么进入Search页面呢
        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el1.click();
        return new SearchPage(driver);
    }

    public void toStock(){

    }
}
