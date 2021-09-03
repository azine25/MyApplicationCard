package com.geek.myapplication.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<Content> {

    private List<Card<Content>> cards = new ArrayList<>();

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, (i * 2), contents.get(i)));
            cards.add(new Card<>(false, false, (i * 2) + 1, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {
        card.setFaceUp(!card.isFaceUp());
    }

    public void checkPairs(Card<Content> card) {
        int isOpened = -1;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isFaceUp()
                    && cards.get(i).getContent().equals(card.getContent())
                    && cards.get(i).getId() != card.getId()) {
                card.setMatch(true);
                cards.get(i).setMatch(true);

//                Log.d("TAG", "checkPairs: MATCH " + cards.get(i).getContent());
            } else if (cards.get(i).isFaceUp() && card.getId() != cards.get(i).getId()
                    && !card.isMatch() && !cards.get(i).isMatch()) {
                isOpened = i;
            }
        }
        if (isOpened != -1) {
            card.setFaceUp(false);
            cards.get(isOpened).setFaceUp(false);
        }

    }

    public int removePairs() {
        int allMatched = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isMatch()) {
                cards.get(i).setFaceUp(true);
                allMatched++;
            }
        }
        return allMatched;
    }


    public List<Card<Content>> getCards() {
        return cards;
    }

}