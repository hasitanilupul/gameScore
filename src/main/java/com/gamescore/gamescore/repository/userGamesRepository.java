package com.gamescore.gamescore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamescore.gamescore.model.UsersGames;

@Repository
public interface userGamesRepository extends JpaRepository<UsersGames, Long>{
    
}
