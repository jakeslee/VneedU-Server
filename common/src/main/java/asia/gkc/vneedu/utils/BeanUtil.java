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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * File Name: BeanUtil.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 8:03 PM
 */

@Component
public class BeanUtil {
    private static BeanUtil instance;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        instance = this;
    }

    public static <T> T getBean(Class<T> clazz) {
        return instance.applicationContext.getBean(clazz);
    }

    public static Map<String, Object> beanToMap(Object object, Class<?> beanClass) {
        return Arrays.stream(beanClass.getDeclaredMethods())
                .filter(p -> !p.getName().startsWith("set"))
                .filter(p -> !p.getName().startsWith("getClass"))
                .filter(p -> !p.getName().startsWith("setClass"))
                .collect(Collectors.toMap(
                        d -> {
                            char c[] = d.getName().toCharArray();
                            c[3] = Character.toLowerCase(c[3]);
                            return new String(c, 3, c.length - 3);
                        },
                        m -> {
                            try {
                                Object result = m.invoke(object);
                                return result != null ? result : "";
                            } catch (Exception e) {
                                return "";
                            }
                        },
                        (p1, p2) -> p1
                ));
    }
}
