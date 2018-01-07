package tic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    private String nameGame;
    private String statusGame;

    public Game() {
    }

    public Game(String nameGame) {
        this.nameGame = nameGame;
    }

    public Game(String nameGame, String statusGame) {
        this.nameGame = nameGame;
        this.statusGame = statusGame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public String getStatusGame() {
        return statusGame;
    }

    public void setStatusGame(String statusGame) {
        this.statusGame = statusGame;
    }


}
