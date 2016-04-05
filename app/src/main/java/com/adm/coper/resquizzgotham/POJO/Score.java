package com.adm.coper.resquizzgotham.POJO;

/**
 * Created by coper on 2/03/16.
 */
public class Score {
    private User player;
    private int score;

    public Score(User player, int score) {
        this.player = player;
        this.score = score;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
