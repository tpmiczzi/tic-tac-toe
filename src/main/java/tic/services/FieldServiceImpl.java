package tic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tic.model.Field;


@Service
public class FieldServiceImpl implements FieldService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public FieldServiceImpl() {
    }

    @Autowired
    private Field field;

    @Override
    public void initField() {
        logger.info("LOG: Creating field");
        field.setPlayingField(new String[getFieldSize()][getFieldSize()]);
        for (int i = 0; i < getFieldSize(); i++) {
            for (int j = 0; j < getFieldSize(); j++) {
                field.getPlayingField()[i][j] = " ";
            }
        }
    }

    @Override
    public void setFigure(int x, int y, String figure) {
        logger.info("LOG: set figure " + figure + ", coordinate X - " + x + ", Y - " + y );
        field.getPlayingField()[x][y] = figure;
    }

    public String[][] getField() {
        return field.getPlayingField();
    }

    public int getFieldSize() {
        return field.getFieldSize();
    }

    public String getFigure() {
        return field.getFigure();
    }

    @Override
    public void setFigure(String figure) {
        logger.info("LOG: set figure " + figure);
        field.setFigure(figure);
    }

    @Override
    public void changeFigure() {
        if (getFigure() == "X") {
            setFigure("O");
        } else {
            setFigure("X");
        }
    }
}
