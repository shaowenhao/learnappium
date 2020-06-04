package test_app.xueqiu.page;

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
    public SearchPage search(String keyword){

        return this;
    }

    // IDEA技巧 选方法名右键 gererate -- test
    public Double getPrice(){
        // 先这么写
        return 1.1;
    }

    public List<String> getSearchList(){
        // 这个方法可能会返回一个搜索的结果集
        return Arrays.asList("1","2");
    }
}
