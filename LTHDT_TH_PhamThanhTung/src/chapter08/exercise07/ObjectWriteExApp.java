/*
 *  @ (#) ObjectWriteExApp.java      1.0 01/11/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise07;

import java.io.*;
import java.util.Date;

/**
 * Thực hiện đọc ghi đối tượng dùng ObjectInputStream và ObjectOutputStream
 * @author: tungpt
 * @version: 1.0
 * @since: November 01, 2023
 */
public class ObjectWriteExApp {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oStream = null;
        try {
            oStream = new ObjectOutputStream(new FileOutputStream("src/chapter08/exercise07/container.txt"));
            // ghi đối tượng String
            oStream.writeObject(new String("Hello World"));
            // ghi đối tượng Fruit
            oStream.writeObject(new Fruit("Orange", 10));
            oStream.writeObject(new Fruit("Apple", 5));
            // ghi đối tượng Date
            oStream.writeObject(new Date());
            System.out.println("Ghi 4 doi tuong vao tap tin Container.txt");
        }catch(IOException e){
            System.out.println(e.getMessage());
        } finally {
            oStream.close();
        }
        System.out.println();
        ObjectInputStream iStream = null;
        try {
            iStream = new ObjectInputStream(new FileInputStream("src/chapter08/exercise07/container.txt"));
            // đọc đối tượng String
            String strObj = (String) iStream.readObject();
            // đọc các đối tượng Fruit
            System.out.println(strObj);
            Fruit fruit01 = (Fruit) iStream.readObject();
            Fruit fruit02 = (Fruit) iStream.readObject();
            System.out.println(fruit01);
            System.out.println(fruit02);
            // đọc đối tượng Date
            Date date = (Date) iStream.readObject();
            System.out.println(date);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            iStream.close();
        }
    }
}
class Fruit implements Serializable{
    String name = "";
    int weight = 0;
    public Fruit(String name,int weight){
        this.name = name;
        this.weight= weight;
    }

    private void writeObject(ObjectOutputStream out)
            throws IOException{
        out.writeObject("X " + this.name);
        out.writeInt(this.weight - 1);
    }

    private void readObject(ObjectInputStream in)
            throws IOException,ClassNotFoundException{
        this.name = (String)in.readObject();
        this.weight = in.readInt();
    }

    @Override
    public String toString() {
        return name + " " + weight + " g";
    }
}
