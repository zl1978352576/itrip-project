package cn.itrip.common;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;


public class Constants {
    public static final String SESSION_USER = "userSession";
    public static final String SESSION_BASE_MODEL = "baseModel";
    public static ApplicationContext cxt;

    public static final String PAGE_SELECT_EXAMPLE_STATEMENT = "selectByExample";
    public static final String PAGE_SELECT_COUNT_EXAMPLE_STATEMENT = "countByExample";

    public static final Integer DEFAULT_PAGE_NO = 1;

    public static final Integer DEFAULT_PAGE_SIZE = 10;

    public static class Area_HOT_STATUS {
        public static int IS_HOT = 1;
        public static int NOT_HOT = 0;
    }
}
