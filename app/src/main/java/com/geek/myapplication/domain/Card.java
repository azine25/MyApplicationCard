package com.geek.myapplication.domain;

public class Card<Content> {

    private int id;
    private boolean isFaceUp;
    private boolean isMatch;
    private Content content;

    public Card(boolean isFaceUp, boolean isMatch, int id, Content content) {
        this.isFaceUp = isFaceUp;
        this.isMatch = isMatch;
        this.id = id;
        this.content = content;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}