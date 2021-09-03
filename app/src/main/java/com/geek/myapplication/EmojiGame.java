package com.geek.myapplication;

import static java.util.List.*;

import com.geek.myapplication.domain.Card;
import com.geek.myapplication.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiGame {

    private Game<String> game;

    public EmojiGame() {
        List<String> cards = new ArrayList<>();
        cards.add("\uD83D\uDE01");
        cards.add("\uD83D\uDE02");
        cards.add("\uD83D\uDE06");
        cards.add("\uD83D\uDE2A");
        cards.add("\uD83D\uDE0F");
        cards.add("\uD83D\uDE21");
        game = new Game<>(cards);
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }

    public void checkPairs(Card<String> card) {
        game.checkPairs(card);

    }
    public int removePairs(){
        return game.removePairs();
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }


}


