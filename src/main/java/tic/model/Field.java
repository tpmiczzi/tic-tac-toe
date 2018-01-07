package tic.model;

import org.springframework.stereotype.Component;

@Component
public class Field {
    private static final int FIELD_SIZE = 3;

    private String figure = "X";

    private String[][] playingField;

    public String[][] getPlayingField() {
        return playingField;
    }

    public int getFieldSize() {
        return FIELD_SIZE;
    }

    public void setPlayingField(String[][] playingField) {
        this.playingField = playingField;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}
