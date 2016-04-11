package asia.gkc.vneedu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
}
