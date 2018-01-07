package tic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tic.db.GameRepository;
import tic.model.Game;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private int amountAllStep = 0;

    @Autowired
    private GameRepository gameRepository;

    private boolean createNewGame = false;
    private boolean isGameStarted = false;
    private boolean isShowListGame = true;
    private Game activeGame;

    @Override
    public List<Game> listGames() {
        logger.info("LOG: get all games from databases");
        return (List<Game>) gameRepository.findAll();
    }

    @Override
    public void addGame(Game game) {
        logger.info("LOG: save game to databases");
        gameRepository.save(game);
    }

    public boolean isCreateNewGame() {
        return createNewGame;
    }

    public void setCreateNewGame(boolean createNewGame) {
        this.createNewGame = createNewGame;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        isGameStarted = gameStarted;
    }

    public boolean isShowListGame() {
        return isShowListGame;
    }

    public void setShowListGame(boolean showListGame) {
        isShowListGame = showListGame;
    }

    public void setActiveGame(Game game) {
        this.activeGame = game;
    }

    public Game getActiveGame() {
        return activeGame;
    }

    @Override
    public String checkWinner(String[][] tmpField) {
        if (getAmountAllStep() == 8) {
            return "drow";
        } else {
            setAmountAllStep(getAmountAllStep() + 1);
            if ((tmpField[0][0] == "X") & (tmpField[0][1] == "X") & (tmpField[0][2] == "X")) {
                return "win";
            }
            if ((tmpField[0][0] == "O") & (tmpField[0][1] == "O") & (tmpField[0][2] == "O")) {
                return "win";
            }
            if ((tmpField[1][0] == "X") & (tmpField[1][1] == "X") & (tmpField[1][2] == "X")) {
                return "win";
            }
            if ((tmpField[1][0] == "O") & (tmpField[1][1] == "O") & (tmpField[1][2] == "O")) {
                return "win";
            }
            if ((tmpField[2][0] == "X") & (tmpField[2][1] == "X") & (tmpField[2][2] == "X")) {
                return "win";
            }
            if ((tmpField[2][0] == "O") & (tmpField[2][1] == "O") & (tmpField[2][2] == "O")) {
                return "win";
            }
            if ((tmpField[0][0] == "X") & (tmpField[1][1] == "X") & (tmpField[2][2] == "X")) {
                return "win";
            }
            if ((tmpField[0][0] == "O") & (tmpField[1][1] == "O") & (tmpField[2][2] == "O")) {
                return "win";
            }
            if ((tmpField[0][2] == "X") & (tmpField[1][1] == "X") & (tmpField[2][0] == "X")) {
                return "win";
            }
            if ((tmpField[0][2] == "O") & (tmpField[1][1] == "O") & (tmpField[2][0] == "O")) {
                return "win";
            }
            if ((tmpField[0][0] == "X") & (tmpField[1][0] == "X") & (tmpField[2][0] == "X")) {
                return "win";
            }
            if ((tmpField[0][0] == "O") & (tmpField[1][0] == "O") & (tmpField[2][0] == "O")) {
                return "win";
            }
            if ((tmpField[0][1] == "X") & (tmpField[1][1] == "X") & (tmpField[2][1] == "X")) {
                return "win";
            }
            if ((tmpField[0][1] == "O") & (tmpField[1][1] == "O") & (tmpField[2][1] == "O")) {
                return "win";
            }
            if ((tmpField[0][2] == "X") & (tmpField[1][2] == "X") & (tmpField[2][2] == "X")) {
                return "win";
            }
            if ((tmpField[0][2] == "O") & (tmpField[1][2] == "O") & (tmpField[2][2] == "O")) {
                return "win";
            }
        }
        return "play";
    }

    public int getAmountAllStep() {
        return amountAllStep;
    }

    public void setAmountAllStep(int amountAllStep) {
        this.amountAllStep = amountAllStep;
    }
}
