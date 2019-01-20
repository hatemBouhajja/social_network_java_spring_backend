package com.dev.social_network_java_spring_backend.Controller;

import com.dev.social_network_java_spring_backend.Entity.Profile;
import com.dev.social_network_java_spring_backend.Service.LoginCredentials;
import com.dev.social_network_java_spring_backend.Service.ProfileService;
import com.dev.social_network_java_spring_backend.Service.UserService;
import com.dev.social_network_java_spring_backend.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String running() {
        return "Application is running";
    }

    @RequestMapping(value = "/user/get/all",method = RequestMethod.GET)
    public Collection<User> userGetAll() {
        return userService.userGetAll();
    }

    @RequestMapping(value = "/user/get/id/{id}",method = RequestMethod.GET)
    public User userGetById(@PathVariable("id") Long id) {
        return userService.userGetById(id);
    }

    @RequestMapping(value = "/user/get/name/{name}",method = RequestMethod.GET)
    public Collection<User> userGetByName(@PathVariable("name") String name) {
        return userService.userGetByName(name);
    }

    @RequestMapping(value = "/user/reg", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody User user){
        return userService.createUserAccount(user);
    }

    @RequestMapping(value = "/user/delete/{id}",method = RequestMethod.DELETE)
    public String userDeleteById(@PathVariable("id") Long id){
        return userService.userDelete(id);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public User userLogin(@RequestBody LoginCredentials loginCredentials){ return userService.login(loginCredentials);}

    @RequestMapping(value = "/user/update", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody User newUser){
       return userService.updateUser(newUser);
    }


//*******************************************************************************

    @Autowired
    public ProfileService profileService;

    @RequestMapping(value = "/profile/get/id/{id}",method = RequestMethod.GET)
    public Profile profileGetById(@PathVariable("id") Long id) {
        return profileService.profileGetById(id);
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateProfile(@RequestBody Profile newProfile){
        return profileService.updateProfile(newProfile);
    }

}
