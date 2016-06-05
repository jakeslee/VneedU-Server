package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.utils.DataTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/3/16.
 */
public class UserServiceTest extends DataTest {
    @Autowired
    private UserService userService;
    private User user;
    private final String TEST_PHONE = "13221111000";
    private final String TEST_ATID = "at_id_test";

    @Before
    public void init() {
        user = new User();
        user.setName("Test Name");
        user.setPassword("Pppassword");
        user.setPhone(TEST_PHONE);
        user.setAtId(TEST_ATID);
    }

    @Test
    public void checkExistenceOfPhone() throws Exception {
        userService.addObject(user);
        boolean ret = userService.checkExistenceOfPhone(TEST_PHONE);
        assertTrue(ret);
    }

    @Test
    public void getUserByPhone() throws Exception {
        userService.addObject(user);
        User user1 = userService.getUserByPhone(TEST_PHONE);

        assertEquals(user.getName(), user1.getName());
    }

    @Test
    public void verifyPasswordOfUserByPhone() throws Exception {
        userService.addObject(user);

        assertNotNull(userService.verifyPasswordOfUserByPhone(user.getPhone(), "Pppassword"));
    }

    @Test
    public void checkExistenceOfAtId() throws Exception {
        userService.addObjectWithoutNull(user);

        assertTrue(userService.checkExistenceOfAtId(TEST_ATID));
    }
}