/*
 *  @ (#) BufferedFileApp.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise02;

import java.io.*;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class BufferedFileApp {


    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream("src/chapter08/exercise02/test.txt");
            inputStreamReader = new InputStreamReader(fileInputStream, "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            int ch = 0;
            while ((ch = bufferedReader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e){
            System.out.println(e);
        } finally {
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        }
    }

}
