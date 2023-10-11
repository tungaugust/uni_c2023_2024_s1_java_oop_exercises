/*
 *  @ (#) CardTesting.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise15;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class CardTesting {
    public static void main(String[] args) {
        CardPack pack = new CardPack();
        System.out.println(pack);
        System.out.println("\nThứ tự bài sau khi xáo trộn: \n");
        pack.shuffleCardPack();
        System.out.println(pack);

    }
}
