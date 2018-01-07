package tic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Step {
    @Id
    @GeneratedValue
    private Long id;

    private String gameName;
    private String figure;
    private String oneStep;

    public Step() {
    }

    public Step(String gameName, String figure, String step) {
        this.gameName = gameName;
        this.figure = figure;
        this.oneStep = step;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getOneStep() {
        return oneStep;
    }

    public void setOneStep(String oneStep) {
        this.oneStep = oneStep;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
