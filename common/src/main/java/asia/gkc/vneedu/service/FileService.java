package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.File;

/**
 * File Name: FileService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 4:59 PM
 */

public interface FileService extends IService<File> {
    File searchFileViaHash(String hash);
}
