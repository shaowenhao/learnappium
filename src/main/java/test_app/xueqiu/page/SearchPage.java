package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 有了基本的Po模型
 * date: 2020 2020/6/4 14:58
 *
 * @author shaowenhao
 * @since JDK 1.8
 */
public class SearchPage {

    private AndroidDriver driver;
    //因为很多地方都用到 By.id("name")
    private By nameLocator=By.id("name");

    // 先写了MainPage里的方法 再来这边加的构造方法 需要driver
    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public SearchPage search(String keyword){
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el2.sendKeys(keyword);
        return this;
    }

    // IDEA技巧 选方法名右键 gererate -- test
    public Double getPrice(){
        // 先这么写
       // return 1.1;
        MobileElement el3 = (MobileElement) driver.findElement(nameLocator);
        el3.click();
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }

    public List<String> getSearchList(){
        // 这个方法可能会返回一个搜索的结果集
        //return Arrays.asList("1","2");
        List<String> nameList = new ArrayList<>();
        for (Object element : driver.findElements(nameLocator)) {
            nameList.add(((WebElement)element).getText());
        }
        return nameList;
    }
}
