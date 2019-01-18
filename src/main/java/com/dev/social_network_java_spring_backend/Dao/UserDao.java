package com.dev.social_network_java_spring_backend.Dao;
import com.dev.social_network_java_spring_backend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface UserDao extends JpaRepository<User,Long>{
    User findByEmail(String email);
    Collection <User> findByUserNameContaining(String name);
}

