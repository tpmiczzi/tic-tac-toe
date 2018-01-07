package tic.services;

import tic.model.Game;

import java.util.List;

public interface GameService {
    List<Game> listGames();

    void addGame(Game game);

    String checkWinner(String[][] tmpField);
}
