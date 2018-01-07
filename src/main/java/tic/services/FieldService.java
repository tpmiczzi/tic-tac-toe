package tic.services;

public interface FieldService {

    void initField();

    void setFigure(int x, int y, String value);

    void setFigure(String figure);

    void changeFigure();
}
