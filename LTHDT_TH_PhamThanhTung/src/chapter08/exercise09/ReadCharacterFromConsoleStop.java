/*
 *  @ (#) ReadCharacterFromConsoleStop.java      1.0 01/11/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Dùng BufferedReader đọc chuỗi ký tự từ Console. Chương trình kết thúc khi gặp chuỗi đọc là chuỗi “stop”.
 * @author: tungpt
 * @version: 1.0
 * @since: November 01, 2023
 */
public class ReadCharacterFromConsoleStop {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.print("Enter: ");
                line = (String) reader.readLine();
                System.out.println("String: " + line);
                if(line.equalsIgnoreCase("stop")) {
                    break;
                }
                strList.add(line);
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("\nResult: ");
        strList.stream().forEach(o -> System.out.print(o + " "));
    }
}
