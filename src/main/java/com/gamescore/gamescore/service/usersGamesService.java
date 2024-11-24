package com.gamescore.gamescore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamescore.gamescore.model.UsersGames;
import com.gamescore.gamescore.repository.userGamesRepository;

@Service
public class usersGamesService {

    @Autowired
    private userGamesRepository userGamesRepository;

    public List<UsersGames> getAllUsers() {
        return userGamesRepository.findAll();
    }

    public UsersGames savedUsersGames(UsersGames usersGames) {
        return userGamesRepository.save(usersGames);
    }
}
