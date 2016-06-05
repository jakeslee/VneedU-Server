package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.File;
import asia.gkc.vneedu.repository.FileMapper;
import asia.gkc.vneedu.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File Name: FileServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/8/16 11:33 AM
 */

@Service
public class FileServiceImpl extends BaseService<File> implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public File searchFileViaHash(String hash) {
        return fileMapper.getFileByHash(hash);
    }
}
