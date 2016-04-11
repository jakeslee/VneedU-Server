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
 * @DateTime 4/9/16 9:30 PM
 */

public class FileUtil {
    public static final Log logger = LogFactory.getLog(FileUtil.class);
    public static String join(String dir, String file) {
        return dir + File.separator + file;
    }

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
