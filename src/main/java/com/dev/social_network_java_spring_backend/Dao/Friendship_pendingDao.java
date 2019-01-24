package com.dev.social_network_java_spring_backend.Dao;

import com.dev.social_network_java_spring_backend.Entity.Friendship_pending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Friendship_pendingDao extends JpaRepository<Friendship_pending,Long> {
     List<Friendship_pending> findBySender(Long id);
     List<Friendship_pending> findByReceiver(Long id);
}
