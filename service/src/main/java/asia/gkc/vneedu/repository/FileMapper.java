package asia.gkc.vneedu.repository;

import asia.gkc.vneedu.model.File;
import tk.mybatis.mapper.common.Mapper;

public interface FileMapper extends Mapper<File> {
    File getFileByHash(String hash);
}