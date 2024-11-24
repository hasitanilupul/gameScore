package com.gamescore.gamescore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamescore.gamescore.model.Game;
import com.gamescore.gamescore.service.gameService;

@RestController
@RequestMapping("/games")
public class gameController {

    @Autowired
    private gameService gameService;

    @GetMapping
    public List<Game> getGames() {
        System.out.println("Get Games");
        return gameService.getAllGames();
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        System.out.println("Save Game");
        try {
            Game savedGame = gameService.saveGame(game);
            return new ResponseEntity<>(savedGame, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
