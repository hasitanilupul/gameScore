package com.gamescore.gamescore.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gamescore.gamescore.model.User;

@Repository
public interface userRepository extends JpaRepository<User, Long>{

    User findByName(String name);
    
}
