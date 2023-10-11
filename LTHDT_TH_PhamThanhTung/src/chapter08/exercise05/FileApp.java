/*
 *  @ (#) FileApp.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise05;

import java.io.File;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class FileApp {
    public static void main(String[] args) {
        String dirPath = "src/chapter08/exercise05/";
        File curDir = new File(dirPath);
        String[] dirs = curDir.list();
        for (int i = 0; i < dirs.length; i++) {
            File file = new File(dirPath + dirs[i]);
            if (file.isDirectory()) {
                System.out.println("<DIR> " + dirs[i]);
            } else {
                System.out.println("      " + dirs[i]);
            }
        }
    }
}
