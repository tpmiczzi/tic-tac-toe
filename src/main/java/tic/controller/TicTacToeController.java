package tic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tic.model.Game;
import tic.model.Step;
import tic.services.FieldServiceImpl;
import tic.services.GameServiceImpl;
import tic.services.StepServiceImpl;


@Controller
public class TicTacToeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String IS_SHOW_LIST_GAME = "isShowListGame";
    private static final String LIST_GAMES = "games";
    private static final String CREATE_NEW_GAME = "createNewGame";
    private static final String GAME_STARTED = "gameStarted";
    private static final String NEW_GAME = "newGame";
    private static final String PLAYING_FIELD = "playingField";
    private static final String FIGURE = "figure";
    private static final String FIELD_STOP = "fieldStop";
    private static final String HOME_PAGE = "homePage";


    @Autowired
    private GameServiceImpl gameService;

    @Autowired
    private FieldServiceImpl fieldService;

    @Autowired
    private StepServiceImpl stepService;

    @RequestMapping("/")
    public String homePage(Model model) {
        logger.info("LOG: start page application, url - /");
        gameService.setShowListGame(true);
        model.addAttribute(IS_SHOW_LIST_GAME, gameService.isShowListGame());
        model.addAttribute(LIST_GAMES, gameService.listGames());
        gameService.setCreateNewGame(false);
        model.addAttribute(CREATE_NEW_GAME, gameService.isCreateNewGame());
        gameService.setGameStarted(false);
        model.addAttribute(GAME_STARTED, gameService.isGameStarted());
        gameService.setGameStarted(true);
        logger.info("LOG: start page has a next attribute: isShowListGame - " + gameService.isShowListGame()
                        + ", createNewGame - "+ gameService.isCreateNewGame() + ", gameStarted - "+ gameService.isGameStarted());
        return HOME_PAGE;
    }

    @RequestMapping("/new")
    public String newGame(Model model) {
        logger.info("LOG: page create new game, url - /new");
        gameService.setCreateNewGame(true);
        model.addAttribute(CREATE_NEW_GAME, gameService.isCreateNewGame());
        gameService.setGameStarted(false);
        model.addAttribute(GAME_STARTED, gameService.isGameStarted());
        model.addAttribute(IS_SHOW_LIST_GAME, gameService.isShowListGame());
        model.addAttribute(NEW_GAME, new Game());
        logger.info("LOG: page new game has a next attribute: isShowListGame - " + gameService.isShowListGame()
                + ", createNewGame - "+ gameService.isCreateNewGame() + ", gameStarted - "+ gameService.isGameStarted());
        return HOME_PAGE;
    }

    @RequestMapping(value = "/newGame", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Game game, Model model) {
        logger.info("LOG: page start new game, url - /newGame");
        gameService.setShowListGame(false);
        model.addAttribute(IS_SHOW_LIST_GAME, gameService.isShowListGame());
        gameService.setCreateNewGame(false);
        model.addAttribute(CREATE_NEW_GAME, gameService.isCreateNewGame());
        gameService.setGameStarted(true);
        model.addAttribute(GAME_STARTED, gameService.isGameStarted());
        gameService.setAmountAllStep(0);
        logger.info("LOG: amount step - " + gameService.getAmountAllStep());
        fieldService.initField();
        gameService.setActiveGame(game);
        model.addAttribute(PLAYING_FIELD, fieldService.getField());
        model.addAttribute(NEW_GAME, new Game());
        model.addAttribute(FIELD_STOP, "play");
        logger.info("LOG: page start new game has a next attribute: isShowListGame - " + gameService.isShowListGame()
                + ", createNewGame - "+ gameService.isCreateNewGame() + ", gameStarted - "+ gameService.isGameStarted());
        return HOME_PAGE;
    }

    @RequestMapping("/list")
    public String listGame(@ModelAttribute Game game, Model model) {
        logger.info("LOG: page list all game, url - /list");
        gameService.setShowListGame(true);
        model.addAttribute(IS_SHOW_LIST_GAME, gameService.isShowListGame());
        gameService.setCreateNewGame(false);
        model.addAttribute(CREATE_NEW_GAME, gameService.isCreateNewGame());
        gameService.setGameStarted(false);
        model.addAttribute(GAME_STARTED, gameService.isGameStarted());
        model.addAttribute(LIST_GAMES, gameService.listGames());
        model.addAttribute(FIELD_STOP, "play");
        logger.info("LOG: page list all game has a next attribute: isShowListGame - " + gameService.isShowListGame()
                + ", createNewGame - "+ gameService.isCreateNewGame() + ", gameStarted - "+ gameService.isGameStarted());
        return HOME_PAGE;
    }


    @RequestMapping(value = "/addFigure", method = RequestMethod.GET)
    public String addFigure(@RequestParam("osiX") int osiX, @RequestParam("osiY") int osiY, Model model) {
        logger.info("LOG: page one step, set figure, url - /addFigure");
        fieldService.setFigure(osiX, osiY, fieldService.getFigure());
        stepService.saveStep(new Step(gameService.getActiveGame().getNameGame(), fieldService.getFigure(),osiX + " " + osiY ));
        String resultGame = gameService.checkWinner(fieldService.getField());
        if (resultGame == "win") {
            model.addAttribute(FIELD_STOP, "stop");
            gameService.getActiveGame().setStatusGame(fieldService.getFigure() + " won");
            gameService.addGame(gameService.getActiveGame());
            model.addAttribute(CREATE_NEW_GAME, gameService.isCreateNewGame());
            model.addAttribute(GAME_STARTED, gameService.isGameStarted());
            model.addAttribute(IS_SHOW_LIST_GAME, gameService.isShowListGame());
            model.addAttribute(PLAYING_FIELD, fieldService.getField());
            model.addAttribute(FIGURE, fieldService.getFigure());
            model.addAttribute(NEW_GAME, new Game());
        } else if (resultGame == "drow") {
            model.addAttribute(FIELD_STOP, "drow");
            gameService.getActiveGame().setStatusGame("drow");
            gameService.addGame(gameService.getActiveGame());
            model.addAttribute(CREATE_NEW_GAME, gameService.isCreateNewGame());
            model.addAttribute(GAME_STARTED, gameService.isGameStarted());
            model.addAttribute(IS_SHOW_LIST_GAME, gameService.isShowListGame());
            model.addAttribute(PLAYING_FIELD, fieldService.getField());
            model.addAttribute(FIGURE, fieldService.getFigure());
            model.addAttribute(NEW_GAME, new Game());
        } else {
            fieldService.changeFigure();
            model.addAttribute(CREATE_NEW_GAME, gameService.isCreateNewGame());
            model.addAttribute(GAME_STARTED, gameService.isGameStarted());
            model.addAttribute(IS_SHOW_LIST_GAME, gameService.isShowListGame());
            model.addAttribute(PLAYING_FIELD, fieldService.getField());
            model.addAttribute(FIGURE, fieldService.getFigure());
            model.addAttribute(NEW_GAME, new Game());
        }
        logger.info("LOG: page list all game has a next attribute: isShowListGame - " + gameService.isShowListGame()
                + ", createNewGame - "+ gameService.isCreateNewGame() + ", gameStarted - "+ gameService.isGameStarted());
        return HOME_PAGE;
    }
}
