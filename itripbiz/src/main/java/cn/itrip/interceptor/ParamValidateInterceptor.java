package cn.itrip.interceptor;

import cn.itrip.beans.dtos.Dto;
import cn.itrip.beans.dtos.ItripException;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.PropertiesUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zezhong.shang on 17-5-9.
 */
public class ParamValidateInterceptor extends HandlerInterceptorAdapter {

    static Logger logger = Logger.getLogger(ParamValidateInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String reqUrl = request.getServletPath();
        //验证当前接口是否需要进行非空判断
        String nullValue = PropertiesUtils.get("validateNull.properties", reqUrl);
        String regValue = PropertiesUtils.get("validateReg.properties", reqUrl);
        logger.info(">>>>>>>>拦截到>>>>>>>>>请求:" + reqUrl + "验证的value为:" + nullValue);
        if (EmptyUtils.isEmpty(nullValue)) {
            return true;
        }
        //如果需要进行非空判断
        String validateNullParam[] = nullValue.split(";")[0].split("##");
        String validateNullMessage[] = nullValue.split(";")[1].split("##");
        if (EmptyUtils.isNotEmpty(validateNullParam)) {
            for (int i = 0; i < validateNullParam.length; i++) {
                String temp = request.getParameter(validateNullParam[i]);
                if (EmptyUtils.isEmpty(temp)) {
                    reurnError("0001", validateNullMessage[i], response);
                    return false;
                }
            }
        }
        //验证正则表达式
        String validateParam[] = regValue.split(";")[0].split("##");
        String validateRegAndMessage[] = regValue.split(";")[1].split("##");
        if (EmptyUtils.isNotEmpty(validateParam)) {
            for (int i = 0; i < validateParam.length; i++) {
                String temp = request.getParameter(validateParam[i]);
                Pattern pattern = Pattern.compile(validateRegAndMessage[i].split(":")[0]);
                Matcher matcher = pattern.matcher(temp);
                if (!matcher.matches()) {
                    reurnError("0002", validateRegAndMessage[i].split(":")[1], response);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (EmptyUtils.isNotEmpty(ex)) {
            try {
                if (ex instanceof ItripException) {
                    ItripException se = (ItripException) ex;
                    String status = se.getExceptionCode();
                    String message = se.getMessage();
                    reurnError(status,message,response);
                } else {
                    reurnError("0003","系统异常",response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                reurnError("0003", "系统异常", response);
            }
        }
    }

    private void reurnError(String errorCode, String message, HttpServletResponse response) {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Dto dto = DtoUtil.returnFail(message, errorCode);
        PrintWriter writer = null;
        try {
            if (null != response) {
                writer = response.getWriter();
                writer.print(JSONObject.toJSONString(dto));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
