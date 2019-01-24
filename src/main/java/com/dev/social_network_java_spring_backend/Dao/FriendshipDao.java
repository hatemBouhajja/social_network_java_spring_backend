package com.dev.social_network_java_spring_backend.Dao;

import com.dev.social_network_java_spring_backend.Entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipDao extends JpaRepository<Friendship,Long> {
}
