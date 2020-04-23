package com.iooiee.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * Time: 18:36
 */
public class CookieUtil {
    // 默认缓存时间,单位/秒, 2H,勾选记住我为两个周
    private static final int COOKIE_DEFAULT_AGE = 60*60*2;
    private static final int COOKIE_REMEMBER_AGE = 60*60*24*14;
    // 保存路径,根路径
    private static final String COOKIE_PATH = "/";
    /**
     * 保存
     *
     * @param response
     * @param key
     * @param value
     * @param ifRemember
     */
    public static void setCookie(HttpServletResponse response, String key, String value, boolean ifRemember) {
        int age = ifRemember?COOKIE_REMEMBER_AGE:COOKIE_DEFAULT_AGE;
        saveCookie(response, key, value, null, COOKIE_PATH, age, true);
    }

    /**
     * 保存
     *
     * @param response
     * @param key
     * @param value
     * @param maxAge
     */
    private static void saveCookie(HttpServletResponse response, String key, String value, String domain, String path, int maxAge, boolean isHttpOnly) {
        Cookie cookie = new Cookie(key, value);
        if (domain != null) {
            cookie.setDomain(domain);
        }
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(isHttpOnly);
        response.addCookie(cookie);
    }

    /**
     * 查询value
     *
     * @param request
     * @param key
     * @return
     */
    public static String getValue(HttpServletRequest request, String key) {
        Cookie cookie = matchCookieByName(request, key);
        if (cookie != null) {
            return cookie.getValue();
        }
        return null;
    }

    /**
     * 循环查找是否有相同的Cookie-Name
     *
     * @param request
     * @param key
     */
    private static Cookie matchCookieByName(HttpServletRequest request, String key) {
        Cookie[] arr_cookie = request.getCookies();
        if (arr_cookie != null && arr_cookie.length > 0) {
            for (Cookie cookie : arr_cookie) {
                if (cookie.getName().equals(key)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * 删除Cookie
     *
     * @param request
     * @param response
     * @param key
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie cookie = matchCookieByName(request, key);
        if (cookie != null) {
            saveCookie(response, key, "", null, COOKIE_PATH, 0, true);
        }
    }
}
