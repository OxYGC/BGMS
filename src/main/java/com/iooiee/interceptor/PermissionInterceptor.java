package com.iooiee.interceptor;

import com.iooiee.annotation.PermissionLimit;
import com.iooiee.model.BackUser;
import com.iooiee.service.LoginService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * Time: 18:07
 */
@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return super.preHandle(request, response, handler);
        }

        // if need login
        boolean needLogin = true;
        boolean needAdminuser = false;
        HandlerMethod method = (HandlerMethod)handler;
        PermissionLimit permission = method.getMethodAnnotation(PermissionLimit.class);
        if (permission!=null) {
            needLogin = permission.limit();
            needAdminuser = permission.adminuser();
        }


        if (needLogin) {
            BackUser loginUser = loginService.ifLogin(request, response);
            if (loginUser == null) {
                response.sendRedirect(request.getContextPath() + "/toLogin");
                return false;
            }
            if (needAdminuser && loginUser.getRole()!=1) {
                throw new RuntimeException("权限不足");
            }
            request.setAttribute(LoginService.LOGIN_IDENTITY_KEY, loginUser);
        }
        return super.preHandle(request, response, handler);
    }
}
