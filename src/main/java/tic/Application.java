package tic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tic.db.GameRepository;
import tic.model.Game;

@SpringBootApplication
public class Application {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(GameRepository gameRepository){
        logger.info("LOG: create test bean");

        return args -> {
            gameRepository.save(new Game("game1", "In progress"));
            gameRepository.save(new Game("game2", "X won "));
            gameRepository.save(new Game("game3", "O won "));
            gameRepository.save(new Game("game4", "Draw"));
        };
    }



}
