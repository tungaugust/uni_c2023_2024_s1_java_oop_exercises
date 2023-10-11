/*
 *  @ (#) EVDictionaryTest.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise14;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class EVDictionaryTest {
    public static void main(String[] args) {
        EVDictionary dictionary = new EVDictionary();
        for (int i = 1; i < 10; i++){
            dictionary.addWord(new EVWordClass("Word" + i, "", "Tu thu " + i, ""));
        }
        System.out.println(dictionary);

        // Thêm từ
        EVWordClass word = new EVWordClass("Word2", "", "Tu thu ", "");
        if(!dictionary.addWord(word)) {
            System.out.println("Không thêm được.");
        }
        // Tra cứu từ
        word = dictionary.lookup("word2");
        if(word == null) {
            System.out.println("Không có trong từ điển.");
        } else {
            System.out.println("Tra được: " + word.toString());
        }
    }
}
