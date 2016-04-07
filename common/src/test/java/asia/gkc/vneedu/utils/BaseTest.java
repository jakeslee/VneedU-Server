package asia.gkc.vneedu.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: BaseTest.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/3/16 11:26 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public abstract class BaseTest {
    protected Log logger = LogFactory.getLog(this.getClass());
}
