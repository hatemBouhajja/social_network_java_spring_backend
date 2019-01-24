package com.dev.social_network_java_spring_backend.Service;


import com.dev.social_network_java_spring_backend.Dao.Friendship_pendingDao;
import com.dev.social_network_java_spring_backend.Entity.Friendship_pending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Friendship_pendingService {

    @Autowired
    private Friendship_pendingDao friendship_pendingDao;

    public String addUsersToPending(Long id_a,Long id_b){
        Friendship_pending friendRequest = new Friendship_pending(id_a,id_b);
        friendship_pendingDao.save(friendRequest);
        return "pending";
    }

    public List<Friendship_pending> getReceivedPendingReq(Long id){
        return friendship_pendingDao.findByReceiver(id);
    }

    public List<Friendship_pending> getSentPendingReq(Long id){
        return friendship_pendingDao.findBySender(id);
    }



}
