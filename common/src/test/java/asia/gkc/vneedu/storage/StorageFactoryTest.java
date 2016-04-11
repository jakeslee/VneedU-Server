package asia.gkc.vneedu.storage;

import asia.gkc.vneedu.utils.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/9/16.
 */
public class StorageFactoryTest extends BaseTest {
    private final String tmp = "/hello/haha.txt";

    @Autowired
    private Storage storage;

    private File createTextFile() throws Exception {
        String testFile = this.getClass().getResource("/").getFile() + "the-file-name.txt";
        PrintWriter writer = new PrintWriter(testFile, "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.close();
        return new File(testFile);
    }

    @Test
    public void getStorage() throws Exception {
        assertNotNull(storage);

        String path = storage.uploadFile(createTextFile(), tmp);

        logger.debug(path);

        assertTrue(path != null && path.length() > 0);
    }

    @Test
    public void deleteFile() {
        assertNotNull(storage);

        storage.deleteFile(tmp);
    }
}