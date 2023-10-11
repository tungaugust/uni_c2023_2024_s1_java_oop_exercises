/*
 *  @ (#) CardPack.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class CardPack {
    private List<Card> pack;

    public CardPack() {
        setPack();
    }

    private void setPack(){
        this.pack = new ArrayList<>();
        Card card = null;
        int count  = 0;
        while (count < 52) {
            card = new Card();
            if (this.pack.add(card)){
                count++;
            }
        }
    }
    private boolean addCard(Card card) {
        if (!this.pack.contains(card)){
            this.pack.add(card);
            return true;
        }
        return false;
    }

    public void shuffleCardPack() {
        Collections.shuffle(pack);
    }

    @Override
    public String toString() {
        return this.pack.stream().map(o -> o.toString()).collect(Collectors.joining("\n"));
    }
}
