package com.gamescore.gamescore.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamescore.gamescore.model.UsersGames;
import com.gamescore.gamescore.service.usersGamesService;

@RestController
@RequestMapping("/usersGames")
public class usersGamesController {

    @Autowired
    private usersGamesService usersGamesService;

    @GetMapping
    public List<UsersGames> getUsersGames() {
        System.out.println("Get Users Games");
        return usersGamesService.getAllUsers();
    }

    @GetMapping("/highScores")
    public List<UsersGames> getUsersHighScores() {
        System.out.println("High Scores");

        List<UsersGames> users = usersGamesService.getAllUsers();

        for (UsersGames i : users) {
            System.out.println("user " + i.getUserId() + " Game " + i.getGameId() + " score " + i.getScore());
        }

        List<UsersGames> distinctHighestScores = new ArrayList<>();

        distinctHighestScores = users.stream()
                .collect(Collectors.groupingBy(p -> Pair.of(p.getUserId(), p.getGameId()),
                        Collectors.maxBy(Comparator.comparingDouble(UsersGames::getScore))))
                .values()
                .stream()
                .map(Optional::get)
                .collect(Collectors.toList());

        for (UsersGames i : distinctHighestScores) {
            System.out.println(
                    " filterd user id " + i.getUserId() + " game id " + i.getGameId() + " score " + i.getScore());
        }

        return distinctHighestScores; // server will send the User ID and Game ID, In the front end these ids need to
                                      // map relavane user name and game name
    }

    @GetMapping("/top10")
    public List<UsersGames> gettop10(@RequestParam int gameId) {
        System.out.println("Get top 10 users");

        List<UsersGames> allRecs = usersGamesService.getAllUsers();

        List<UsersGames> top10t = allRecs.stream().filter(list-> list.getGameId() == gameId)
                .sorted(Comparator.comparing(UsersGames::getScore).reversed())
                .limit(10)
                .collect(Collectors.toList());

        return top10t;

    }

    @PostMapping
    public ResponseEntity<UsersGames> createUser(@RequestBody UsersGames usersGames) { // Frontend will send the userId and GameId in the body rather
                                                                                       // than sending user name and game name
        System.out.println("Save UsersGames");
        try {
            UsersGames savedUsersGames = usersGamesService.savedUsersGames(usersGames);
            return new ResponseEntity<>(savedUsersGames, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
