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
    private  ItripHotelTempStoreService hotelTempStoreService;
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        hotelTempStoreService = (ItripHotelTempStoreService) context.getBean("itripHotelTempStoreServiceImpl");
    }
    @Test
    public void test() throws Exception {
        for (int i = 0; i < 50; i++) {
            //new 开辟子线程 start：调用run，运行子线程
            new ThreadDemo("T" + i, hotelTempStoreService).start();
        }
    }
}