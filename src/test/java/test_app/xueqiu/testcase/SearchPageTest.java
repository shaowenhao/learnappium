package test_app.xueqiu.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.SearchPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description: 该方法从 SearchPage 定义的方法 得来 IDEA generate test得到 指定生成测试类的路径
 * date: 2020 2020/6/4 15:20
 *
 * @author shaowenhao
 * @since JDK 1.8
 */
class SearchPageTest {

    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll(){
        mainPage = new MainPage();
        searchPage = mainPage.toSearch();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba, 阿里巴巴",
            "jd, 京东"
    })
    void search(String keyword, String name) {
           //首先mainPage先启动 一个初始化的过程
        List<String> result = searchPage.search(keyword).getSearchList();
        assertEquals(result.get(0),name);
    }

@Test
     // 老师提到 需要回到初始界面 比如点取消就回到mainpage 后续添加
    void getPrice() {
          assertTrue(searchPage.search("alibaba").getPrice() > 200);
    }
}