package cn.itrip.test;

import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.common.DateUtil;
import cn.itrip.service.itripHotelOrder.ItripHotelOrderService;
import cn.itrip.service.itripHotelTempStore.ItripHotelTempStoreService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class HotelOrderTest {


    static {

    }

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 40; i++) {
            //new 开辟子线程 start：调用run，运行子线程
            new ThreadDemo("T" + i).start();
            if (i == 1) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
