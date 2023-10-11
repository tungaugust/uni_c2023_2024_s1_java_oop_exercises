/*
 *  @ (#) CopyFileApp.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise03;

import java.io.*;

/**
 * Ghi đè nội dung từ file này sang file khác
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class CopyFileApp {
    public static void main(String[] args) throws IOException {
        BufferedInputStream inFile = null;
        BufferedOutputStream outFile = null;
        String srcFilePath = "src/chapter08/exercise03/source_file.txt";
        String dstFilePath = "src/chapter08/exercise03/destination_file.txt";
        try {
            // Tạo bộ đệm đọc dữ liệu từ tập tin nguồn
            inFile = new BufferedInputStream(new FileInputStream(srcFilePath));
            // Lấy kích thước tập tin nguồn
            int inFileSize = inFile.available();
            // Tạo bộ đệm ghi dữ liệu vào tập tin đích
            outFile = new BufferedOutputStream(new FileOutputStream(dstFilePath));
            // Chuyển dữ liệu
            int ch = 0;
            while ((ch = inFile.read()) != -1) {
                outFile.write(ch);
            }
            System.out.println(inFileSize + " bytes da duoc copy xong.");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            inFile.close();
            outFile.close();
        }

    }
}
