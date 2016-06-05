package asia.gkc.vneedu.utils;

import asia.gkc.vneedu.model.User;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/7/16.
 */
public class FilterUtilTest {
    @Test
    public void exclude() throws Exception {
        User user = new User();
        user.setAtId("10");
        user.setScore(20);
        FilterUtil.exclude(Arrays.asList("atId", "score"), user);

        assertNull(user.getAtId());

        assertNull(user.getScore());
    }

}