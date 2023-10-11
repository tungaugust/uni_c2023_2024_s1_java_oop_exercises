/*
 *  @ (#) RandomSelection.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise06;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class RandomSelection {
    public static void main(String[] args) throws IOException {
        String dirPath = "src/chapter08/exercise06/dir01/";
        File curDir = new File(dirPath);
        String[] dirs = curDir.list();
        Random random = new Random();
        int index = random.nextInt(dirs.length);
        String selectedDir = dirs[index];
        DataOutputStream dataOut = null;
        DataInputStream dataIn = null;
        try {
            String filePath = dirPath + selectedDir;
            System.out.println("File được chọn là [" + filePath + "]");
            dataOut = new DataOutputStream(new FileOutputStream(filePath));
            int times = 6;
            double number = 0.0;
            for (int i = 0; i < times; i++) {
                number = random.nextDouble()*100;
                dataOut.writeDouble(number);
                System.out.println("Ghi số double thứ " + (i + 1) + ": " + number);
            }
            dataIn = new DataInputStream((new FileInputStream(filePath)));
            for (int i = 0; i < times; i++) {
                number = dataIn.readDouble();
                System.out.println("Đọc số double thứ " + (i + 1) + ": " + number);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            dataOut.close();
            dataIn.close();
        }
    }
}
