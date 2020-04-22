package com.iooiee.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * @Author: Yanggc
 * Time: 16:46
 */


@Slf4j
public class ExceptionUtil {
    /**
     * 打印异常信息
     */
    public static String getMessage(Exception e) {
        String swStr = null;
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            swStr = sw.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
        }
        return swStr;
    }
}
