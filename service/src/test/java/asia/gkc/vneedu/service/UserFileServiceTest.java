package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.UserFile;
import asia.gkc.vneedu.utils.DataTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/11/16.
 */
public class UserFileServiceTest extends DataTest {
    @Autowired
    private UserFileService userFileService;

    @Test
    public void testExistenceChecking() {
        UserFile userFile = userFileService.getObjectById("123");

        logger.info(userFile);
        assertNull(userFile);
    }
}