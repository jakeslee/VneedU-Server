/*
 * Copyright 2016 Jakes Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package asia.gkc.vneedu.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * File Name: FilterUtil.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/7/16 8:07 PM
 */

public abstract class FilterUtil {
    private static final Log logger = LogFactory.getLog(FilterUtil.class);

    /**
     * 获取合法的方法名（Getter方法）
     * @param name - 变量名
     * @return 方法名
     */
    public static String getMethodName(String name) {
        return getMethodName(name, null, null);
    }

    /**
     * 获取合法的方法名
     * @param name - 变量名
     * @param prefix - 方法前缀
     * @return 方法名
     */
    public static String getMethodName(String name, String prefix) {
        return getMethodName(name, prefix, null);
    }

    /**
     * 获取合法的方法名
     * @param name - 变量的名称
     * @param prefix - 方法前缀,如get/set
     * @param delimiter - 变量分隔符
     * @return 方法名称
     */
    public static String getMethodName(String name, String prefix, String delimiter) {
        String[] parts = name.split(delimiter == null ? "_" : delimiter);
        StringBuilder sbOut = new StringBuilder(prefix == null ? "get" : prefix);

        if (parts.length >= 1) {
            for (String str : parts) {
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
                sbOut.append(sb);
            }
        }

        return new String(sbOut);
    }

    /**
     * 清除对象上指定的属性
     * @param list -  属性列表
     * @param object - 处理的对象
     * @param <T> - 对象的类型
     * @return 处理的对象
     */
    public static <T> T exclude(List<String> list, T object) {
        Class<?> c = object.getClass();

        for (String fieldName : list) {
            Method[] methods = c.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getName().equals(getMethodName(fieldName, "set"))) {
                    Class<?> param_class = method.getParameterTypes()[0];
                    try {
                        logger.info("Invoking: " + method.getName());
                        method.invoke(object, param_class.cast(null));
                        logger.info("Invoked: " + method.getName());
                    } catch (IllegalAccessException e) {
                        logger.warn("IllegalAccessException");
                    } catch (InvocationTargetException e) {
                        logger.warn("InvocationTargetException");
                    }
                }
            }
        }

        return object;
    }

    public static Map<String, Object> exclude(List<String> list, Map<String, Object> object) {
        list.parallelStream().forEach((e)-> object.remove(e.trim()));
        return object;
    }
}
