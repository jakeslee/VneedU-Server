package asia.gkc.vneedu.common.property;

import asia.gkc.vneedu.utils.BaseTest;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/9/16.
 */
public class CdnPropertiesTest extends BaseTest {
    @Autowired
    private CdnProperties cdnProperties;

    @Test
    public void testProperties() {
        String bucketName = cdnProperties.getQiniuProperties().getBucketName();

        logger.info("Bucket name: " + bucketName);

        assertTrue(bucketName.length() > 0);
    }

    @Test
    public void upload() {
        Auth auth = Auth.create(cdnProperties.getQiniuProperties().getAccessKey(),
                cdnProperties.getQiniuProperties().getSecretKey());

        UploadManager uploadManager = new UploadManager();

        URL url = this.getClass().getResource("/testfile.txt");

        assertNotNull(url);

        try {
            String bucketName = cdnProperties.getQiniuProperties().getBucketName();

            Response response = uploadManager.put(url.getFile(), null,
                    auth.uploadToken(bucketName));
            logger.debug(response.bodyString());

            assertTrue(response.isOK());

            BucketManager bucketManager = new BucketManager(auth);

            bucketManager.delete(bucketName, (String) response.jsonToMap().get("key"));
        } catch (QiniuException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        }
    }
}