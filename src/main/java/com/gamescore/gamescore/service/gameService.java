package com.gamescore.gamescore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamescore.gamescore.model.Game;
import com.gamescore.gamescore.repository.gameRepository;

@Service
public class gameService {

    @Autowired
    private gameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

}
