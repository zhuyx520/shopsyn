package com.qiyue.shopsyn.helper;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class PythonHelper {
//	python E:/tempfile/python/RemoveWaterMark.py E:/tempfile/input/mobile/big/n_v2a3b78cfb513442e78407ebd882193bb0.jpg E:/tempfile/output/mobile/big/n_v2a3b78cfb513442e78407ebd882193bb0.jpg E:/tempfile/python/shop_mask_logo.png
	public static void main(String[] args) throws IOException,InterruptedException {
        String exe = "python";
        String command = "E:\\tempfile\\python\\RemoveWaterMark.py";
        String str1 = "E:\\tempfile\\input\\mobile\\big\\n_v2a3b78cfb513442e78407ebd882193bb0.jpg";
        String str2 = "E:\\tempfile\\output\\mobile\\big\\n_v2a3b78cfb513442e78407ebd882193bb0.jpg";
        String str3 = "E:\\tempfile\\python\\shop_mask_logo.png";
        String[] cmdArr = new String[] {exe, command, str1, str2, str3};
//        String command = "C:\\Users\\Administrator\\PycharmProjects\\test_anaconda1\\test\\图片水印\\test1.py";
//        String str1 = "1";
//        String[] cmdArr = new String[] {exe, command, str1};
        Process process = Runtime.getRuntime().exec(cmdArr);			// 执行外部程序
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
        process.waitFor();
    }
	
	public static boolean removeWatermask(String pythonFile, String inputFile, String outputFile, String maskFile){
		String exe = "python";
        if(inputFile == null || outputFile == null || maskFile == null || maskFile == "") {
        	return false;
        }
        StringBuffer buffer = new StringBuffer();
        try {
        	String[] cmdArr = new String[] {exe, pythonFile, inputFile, outputFile, maskFile};
        	Process process = Runtime.getRuntime().exec(cmdArr);
        	BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
            	buffer.append(line);
            }
            in.close();
            process.waitFor();
            if(!"True".equals(buffer.toString())) {
            	return false;
            }
		} catch (IOException e) {
			return false;
		} catch (InterruptedException e) {
			return false;
		}
        return true;
	}
	
	public static boolean removeWatermaskList(String pythonFile, List<String> inputFile, List<String> outputFile, String maskFile){
		String exe = "python";
        if(inputFile == null || outputFile == null || maskFile == null || maskFile == "" ||inputFile.size() != outputFile.size()) {
        	return false;
        }
        try {
        	for(int i = 0; i < inputFile.size(); i++) {
        		StringBuffer buffer = new StringBuffer();
            	String[] cmdArr = new String[] {exe, pythonFile, inputFile.get(i), outputFile.get(i), maskFile};
            	Process process = Runtime.getRuntime().exec(cmdArr);
            	BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                	buffer.append(line);
                }
                in.close();
                process.waitFor();
                if(!"True".equals(buffer.toString())) {
                	return false;
                }
            }
		} catch (IOException e) {
			return false;
		} catch (InterruptedException e) {
			return false;
		}
        return true;
	}

}
