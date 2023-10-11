/*
 *  @ (#) ReaderTesting.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class ReaderTesting {
    public static void main(String[] args) throws IOException {
        System.out.print("Nhập chuỗi kí tự: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        StringBuffer stringBuffer = new StringBuffer(input);    // or stringBuffer.append(input)
        System.out.println("Chuỗi nhập vào: " + stringBuffer);
        System.out.println("Chuỗi đã đảo: " + stringBuffer.reverse());
    }
}
