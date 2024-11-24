package com.gamescore.gamescore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamescore.gamescore.model.Game;

@Repository
public interface gameRepository extends JpaRepository<Game, Long> {

}
