package com.dev.social_network_java_spring_backend.Service;


import com.dev.social_network_java_spring_backend.Dao.ProfileDao;
import com.dev.social_network_java_spring_backend.Entity.Profile;
import com.dev.social_network_java_spring_backend.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileDao profileDao;


    public Profile profileGetById(Long id){
        Optional<Profile> tempProfile = profileDao.findById(id);
        if(tempProfile.isPresent()){
            return tempProfile.get();
        }else {
            return null;
        }
    }


    public String updateProfile (Profile newProfile){
        profileDao.save(newProfile);
        return "updated";
    }


}
