package com.qiyue.shopsyn.util;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class PictureOperationUtil {
	
	/*
	 * 下载图片
	 */
	public static boolean downloadPicture(String urlList,String path) {
		boolean flag = true;
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
 
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
 
            byte[] buffer = new byte[1024];
            int length;
 
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
        	flag = false;
            e.printStackTrace();
        } catch (IOException e) {
        	flag = false;
            e.printStackTrace();
        }
        return flag;
    }
	
	/*
	 * 读取文件内容
	 */
	public static MultipartFile getMulFileByPath(String filePath, String fileName) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        FileItem fileItem = factory.createItem(fileName, "text/plain", true,
                "MyFileName" + extFile);
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try
        {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = fileItem.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192))
                    != -1)
            {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        MultipartFile mfile = new CommonsMultipartFile(fileItem);
        return mfile;
    }

}
