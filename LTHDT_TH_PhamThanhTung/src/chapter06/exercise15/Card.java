/*
 *  @ (#) Card.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise15;

import java.util.Objects;
import java.util.Random;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */

public class Card {
    private final static int SUIT_COUNT = 4;    // suits
    private final static int RANK_COUNT = 13;   // ranks
    private int suit;
    private int rank;

    public Card() {
        this(SUIT_COUNT, RANK_COUNT);
    }

    public Card(int suit, int rank){
        setSuit(suit);
        setRank(rank);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank >= RANK_COUNT || rank < 0) {
            rank = new Random().nextInt(RANK_COUNT);
        }
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        if (suit >= SUIT_COUNT || suit < 0) {
            suit = new Random().nextInt(SUIT_COUNT);
        }
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card that = (Card) o;
        return this.getRank() == that.getRank() && this.getSuit() == that.getSuit();
    }
    @Override
    public String toString(){
        String cardName = "";
        switch(this.rank) {
            case 0: cardName = "Ace";break;
            case 1: cardName = "Deuce";break;   // Two
            case 2: cardName = "Trey";break;    // Three
            case 3: cardName = "Four";break;
            case 4: cardName = "Five";break;
            case 5: cardName = "Six";break;
            case 6: cardName = "Seven";break;
            case 7: cardName = "Eight";break;
            case 8: cardName = "Nine";break;
            case 9: cardName = "Ten";break;
            case 10: cardName = "Jack";break;   // or Knave
            case 11: cardName = "Queen";break;
            case 12: cardName = "King";break;
        }
        switch(this.suit){
            case 0: cardName += " of Hearts";break;
            case 1: cardName += " of Diamonds";break;
            case 2: cardName += " of Clubs";break;
            case 3: cardName += " of Spades";break;
        }
        return cardName;
    }

}
