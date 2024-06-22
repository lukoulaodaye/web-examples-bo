package com.Android.homework;

import java.io.*;

public class FileCopyUtil {


    public static void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
        try (
                // 创建输入流，读取源文件
                InputStream inputStream = new FileInputStream(sourceFilePath);
                // 创建输出流，写入目标文件
                OutputStream outputStream = new FileOutputStream(destinationFilePath)
        ) {
            // 字节缓冲区大小
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 循环读取源文件内容并写入目标文件
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // 输出流flush确保所有数据都写入文件
            outputStream.flush();

            // 无需显式关闭流，因为try-with-resources会自动关闭
        } catch (FileNotFoundException e) {
            throw new IOException("源文件未找到: " + sourceFilePath, e);
        }
    }

    public static void main(String[] args) {
        String sourceFile = "D:/workspace-java/file.txt";
        String destinationFile = "D:/workspace-java/file1.txt";

        try {
            // 调用方法复制文件
            copyFile(sourceFile, destinationFile);
            System.out.println("文件复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("文件复制失败: " + e.getMessage());
        }
    }
}