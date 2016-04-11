package asia.gkc.vneedu.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * File Name: FileUtil.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 4/9/16 9:30 PM
 */

public class FileUtil {
    public static final Log logger = LogFactory.getLog(FileUtil.class);

    /**
     * 创建路径中的目录
     *
     * @param dir - 路径
     * @return 创建结果
     */
    public static boolean buildDir(String dir) {
        if (dir.endsWith(File.separator))
            return buildDir(new File(dir));
        String path = dir.substring(0, dir.lastIndexOf(File.separator));

        return buildDir(new File(path));
    }

    /**
     * 创建路径中的目录
     *
     * @param dirs - 路径文件
     * @return 创建结果
     */
    public static boolean buildDir(File dirs) {
        return dirs.exists() || dirs.mkdirs();
    }

    /**
     * 拼接路径
     *
     * @param dir - 目录
     * @param file - 文件
     * @return 拼接完成的路径
     */
    public static String join(String dir, String file) {
        return (dir.endsWith(File.separator) ? dir : dir + File.separator) +
                (file.startsWith(File.separator) ? file.substring(1) : file);
    }

    /**
     * 移动文件
     *
     * @param source - 文件所在位置
     * @param destination - 文件目的位置
     * @return 移动是否成功
     * @throws IOException
     */
    public static boolean transferFile(File source, File destination) throws IOException {
        if (!destination.exists()) {
            logger.debug(destination.getPath());
            destination.createNewFile();
        }

        FileChannel src, dest;

        src = new FileInputStream(source).getChannel();
        dest = new FileOutputStream(destination).getChannel();

        long count = 0;
        long size = src.size();

        while ((count += dest.transferFrom(src, count, size - count)) < size) ;

        return true;
    }
}
