/*
 *  @ (#) DataStreamTesting.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise04;

import java.io.*;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class DataStreamTesting {
    public static void main(String[] args) throws IOException {
        String fileFile = "src/chapter08/exercise04/test.txt";
        DataOutputStream dataOut = null;
        DataInputStream dataIn = null;
        try {
            dataOut = new DataOutputStream(new FileOutputStream(fileFile));
            dataOut.writeChar('A');
            dataOut.writeInt(20);
            dataOut.writeBoolean(true);
            dataOut.writeDouble(1.2);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            dataOut.close();
        }

        try {
            dataIn = new DataInputStream(new FileInputStream(fileFile));
            char c = dataIn.readChar();
            int i = dataIn.readInt();
            boolean bool = dataIn.readBoolean();
            double d = dataIn.readDouble();
            System.out.println(c + " " + i + " " + d + " " + bool);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            dataIn.close();
        }
    }
}
