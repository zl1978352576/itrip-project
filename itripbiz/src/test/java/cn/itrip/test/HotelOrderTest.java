package cn.itrip.test;
import org.junit.Test;
public class HotelOrderTest {

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 500; i++) {
            //new 开辟子线程 start：调用run，运行子线程
            new ThreadDemo("T" + i).start();
            if (i % 2==0) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
