package com.dev.social_network_java_spring_backend.Service;

import com.dev.social_network_java_spring_backend.Entity.Profile;
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
    @Autowired
    public ProfileService profileService;

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

    public User getUserByEmail(String email){
        return userDao.findByEmail(email);
    }

    public User login(LoginCredentials loginCredentials){
        User potentielUser = getUserByEmail(loginCredentials.getEmail());
        if(potentielUser!=null){
            if(potentielUser.getPwd().equals(loginCredentials.getPwd())){
                return potentielUser;
            }
            else {
                return null;
            }

        }else {
            return null;
        }
    }

    public String createUserAccount(User user) {
        User existentUser = getUserByEmail(user.getEmail());
        if (existentUser == null) {
            user.setCreationDate(new Timestamp(System.currentTimeMillis()));
            user.setUserName(user.getFirstName()+"_"+ user.getLastName());



            Profile createdProfile = new Profile("City",0,"Country","Education/Job","Organisation","Civil status","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTez7mpG_Lfb01PnEMjHa4gYPOx7iNTab4KKVnVCdNSGpa1O2RJ");
            user.setProfile(createdProfile);
            user.getProfile().setUser(user);
            userDao.save(user);
            return "Status 200";
        }else {
            return "Email Already Exists";
        }
    }

    public String updateUser (User newUser){

        Profile newProfile = profileService.profileGetById(newUser.getId());
        newProfile.setUser(newUser);
        newUser.setProfile(newProfile);
        userDao.save(newUser);
        return "updated";
    }

    public String userDelete(Long id){
        User tempUser = userGetById(id);
        userDao.delete(tempUser);
        return "Status 200";
    }



}
