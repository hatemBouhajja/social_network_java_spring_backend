package com.dev.social_network_java_spring_backend.Service;

import com.dev.social_network_java_spring_backend.Entity.User;
import com.dev.social_network_java_spring_backend.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserDao userDao;


    public Collection<User> userGetAll(){
        return userDao.findAll();
    }

    public User userGetById(Long id){
        Optional<User> tempUser = userDao.findById(id);
        if(tempUser.isPresent()){
            return tempUser.get();
        }else {
            return null;
        }
    }

    public Collection<User> userGetByName(String name){
        return userDao.findByUserNameContaining(name);
    }

    public String createUserAccount(User user) {
        User existentUser = userDao.findByEmail(user.getEmail());
        if (existentUser == null) {
            user.setCreationDate(new Timestamp(System.currentTimeMillis()));
            user.setUserName(user.getFirstName()+"_"+ user.getLastName());
            userDao.save(user);
            return "Status 200";
        }else {
            return "Email Already Exists";
        }
    }

    public String userDelete(Long id){
        User tempUser = userGetById(id);
        userDao.delete(tempUser);
        return "Status 200";
    }

}
