package com.gamescore.gamescore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UsersGames {

    @Id
    private int id;
    private int userId;
    private int gameId;
    private Double score;

    public UsersGames() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public UsersGames(UsersGames usersGames) {
        this.userId = usersGames.userId;
        this.gameId = usersGames.gameId;
        this.score = usersGames.score;
    }

}
