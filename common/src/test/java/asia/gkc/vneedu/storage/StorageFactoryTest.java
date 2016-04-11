package asia.gkc.vneedu.storage;

import asia.gkc.vneedu.utils.BaseTest;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/9/16.
 */
public class StorageFactoryTest extends BaseTest {
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
        Storage storage = StorageFactory.getStorage("qiniu");

        assertNotNull(storage);

        String path = storage.uploadFile(createTextFile(), "/hello/haha.txt");

        logger.debug(path);

        assertTrue(path != null && path.length() > 0);
    }

}