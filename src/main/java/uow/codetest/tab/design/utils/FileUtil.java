package uow.codetest.tab.design.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
*@ClassName: FileUtil
*@Description: 
*@author YY 
*@date 2016年8月26日  上午10:26:17
*@version 1.0
*/
public class FileUtil {

	/**
	 * Get File Type
	 * @param fileName
	 * @return
	 */
	public static String getFileExtName(String fileName) {
        if (fileName!=null ) {
            int i = fileName.lastIndexOf('.');
            if (i>-1) {
                return fileName.substring(i+1).toLowerCase();
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    public static byte[] getContent(File file) throws IOException {
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        fi.close();
        return buffer;
    }

    /**
	 * Upload File
	 * @param fileBytes
	 * @param filePath
	 * @param fileName
	 * @throws Exception
	 */
	public static void uploadFile(byte[] fileBytes, String filePath, String fileName) throws Exception {	
		File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(fileBytes);
        out.flush();
        out.close();
	}

}