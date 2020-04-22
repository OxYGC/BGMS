package com.iooiee.common.handler;

import com.iooiee.common.exception.CustomException;
import com.iooiee.common.utils.JacksonUtil;
import com.iooiee.common.vo.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * Time: 17:42
 */
@Component
public class WebExceptionHandler implements HandlerExceptionResolver {
    private static transient Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        if (!(ex instanceof CustomException)) {
            logger.error("WebExceptionResolver:{}", ex);
        }

        // if json
        boolean isJson = false;
        HandlerMethod method = (HandlerMethod)handler;
        ResponseBody responseBody = method.getMethodAnnotation(ResponseBody.class);
        if (responseBody != null) {
            isJson = true;
        }


        // response
        ModelAndView mv = new ModelAndView();
        if (isJson) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print(JacksonUtil.writeValueAsString(R.error().data("contents",ex.toString().replaceAll("\n", "<br/>"))));
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
            return mv;
        } else {

            mv.addObject("exceptionMsg", "异常");
            mv.setViewName("/common/common.exception");
            return mv;
        }
    }
}
