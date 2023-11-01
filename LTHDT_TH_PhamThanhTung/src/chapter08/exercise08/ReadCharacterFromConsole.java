/*
 *  @ (#) ReadCharacterFromConsole.java      1.0 01/11/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Dùng BufferedReader đọc từng ký tự từ Console. Việc đọc kết thúc khi gặp dấu chấm (dấu chấm để kết thúc chương trình).
 * @author: tungpt
 * @version: 1.0
 * @since: November 01, 2023
 */
public class ReadCharacterFromConsole {
    public static void main(String[] args) {
        char c;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            do {
                c = (char) reader.read();
                System.out.println("Character: " + c);
                if (c == '.'){
                    break;
                }
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
