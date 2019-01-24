package com.dev.social_network_java_spring_backend.Dao;

import com.dev.social_network_java_spring_backend.Entity.Post;
import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostDao extends JpaRepository<Post,Long> {
    List<Post> findAllByOwnerId(Long id);
}
