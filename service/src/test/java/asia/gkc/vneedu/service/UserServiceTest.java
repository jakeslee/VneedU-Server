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
    UserService userService;

    private User user;

    @Before
    public void init() {
        user = new User();
        user.setName("Test Name");
        user.setPassword("Pppassword");
        user.setPhone("13221061445");
    }

    @Test
    public void checkExistenceOfPhone() throws Exception {
        userService.addObject(user);
        boolean ret = userService.checkExistenceOfPhone("13221061445");
        assertTrue(ret);
    }

    @Test
    public void getUserByPhone() throws Exception {
        userService.addObject(user);
        User user1 = userService.getUserByPhone("13221061445");

        assertEquals(user.getName(), user1.getName());
    }

    @Test
    public void verifyPasswordOfUserById() throws Exception {
        userService.addObject(user);

        assertNotNull(userService.verifyPasswordOfUserByPhone(user.getPhone(), "Pppassword"));
    }
}