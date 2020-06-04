package test_app;

/**
 * Description: 按视频先跟老师敲一遍 雪球app 选股票
 * date: 2020 2020/6/4 13:32
 *
 * @author shaowenhao
 * @since JDK 1.8
 */
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class TestDemo {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        // 不清理之前的数据
        desiredCapabilities.setCapability("noReset","true");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        // 1. 先加个简单的隐式等待
        // todo:等待与优化
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el2.sendKeys("Alibaba");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        el3.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
