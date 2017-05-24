package cn.itrip.test;
import cn.itrip.common.DateUtil;
import cn.itrip.service.itripHotelTempStore.ItripHotelTempStoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class ThreadDemo extends Thread {

    private String threadNo;

    private  ItripHotelTempStoreService hotelTempStoreService;

    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        hotelTempStoreService = (ItripHotelTempStoreService) context.getBean("itripHotelTempStoreServiceImpl");
    }

    public ThreadDemo(String _threadNo) {
        threadNo = _threadNo;
    }


    @Override
    public void run() {//线程开始执行
        super.run();
        Map<String, Object> param = new HashMap<String, Object>();
        try {
            param.put("startTime", DateUtil.parse("2018-01-01", "yyyy-MM-dd"));
            param.put("endTime", DateUtil.parse("2018-01-10", "yyyy-MM-dd"));
            param.put("roomId", 1);
            param.put("hotelId", 1);
            param.put("count", 10);
            hotelTempStoreService.validateRoomStore(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("run ================ threadNo:" + threadNo);
    }


    public String getThreadNo() {
        return threadNo;
    }

    public void setThreadNo(String threadNo) {
        this.threadNo = threadNo;
    }

}
