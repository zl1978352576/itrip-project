package cn.itrip.common;

/**
 * Created by zezhong.shang on 17-4-25.
 */
public class StringUtils {
    public static String objectToString(Object obj){
        if(EmptyUtils.isEmpty(obj)){
            return "";
        }else if(obj instanceof Number){
            return obj+"";
        }else{
            return obj.toString();
        }
    }
}
