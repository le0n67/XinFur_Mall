package com.leon.xinfur.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * Date：2024/7/5  18:24
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class DataUtils {

    //将方法，封装到静态方法，方便使用
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    //将字符串转成整数,否则返回默认值
    public static int parseInt(String val, int defaultVal) {

        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            System.out.println(val + " 格式不正确...");
        }
        return defaultVal;
    }
}
