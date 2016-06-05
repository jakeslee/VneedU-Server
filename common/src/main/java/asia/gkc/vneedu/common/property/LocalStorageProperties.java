package asia.gkc.vneedu.common.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * File Name: LocalStorageProperties.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 5:53 PM
 */

@Component
public final class LocalStorageProperties {
    private final String name;
    private final String urlPath;
    private final String storeInDir;

    @Autowired
    public LocalStorageProperties(@Value("${app.storage.cdn.local.urlPath}") String urlPath,
                                  @Value("${app.storage.cdn.local.storeInDir}") String storeInDir,
                                  @Value("${app.storage.cdn.local.name}") String name) {
        this.name = name;
        this.urlPath = urlPath;
        this.storeInDir = storeInDir;

        File baseDir = new File(storeInDir);
        if (!baseDir.exists())
            baseDir.mkdirs();
    }

    public String getName() {
        return name;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public String getStoreInDir() {
        return storeInDir;
    }
}
