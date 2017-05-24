/*
package cn.itrip.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class HotelOrderTest {


    @Test
    public void test() throws Exception {
        for (int i = 0; i < 500; i++) {
            //new 开辟子线程 start：调用run，运行子线程
            new ThreadDemo("T" + i).start();
            if (i % 2==0) {


    static {

    }
    private  ItripHotelTempStoreService hotelTempStoreService;
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        hotelTempStoreService = (ItripHotelTempStoreService) context.getBean("itripHotelTempStoreServiceImpl");
    }
    @Test
    public void test() throws Exception {
        for (int i = 0; i < 400; i++) {
            //new 开辟子线程 start：调用run，运行子线程
            new ThreadDemo("T" + i, hotelTempStoreService).start();
            if (i == 1) {

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}*/
