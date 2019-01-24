package com.dev.social_network_java_spring_backend.Controller;

import com.dev.social_network_java_spring_backend.Dao.PostDao;
import com.dev.social_network_java_spring_backend.Entity.*;
import com.dev.social_network_java_spring_backend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    //*******************************************************************************

    @Autowired
    public Friendship_pendingService friendship_pendingService;


    @RequestMapping(value = "/user/addfriend/{id_a}/{id_b}",method = RequestMethod.GET)
    public String sendRequest (@PathVariable("id_a") Long id_a,@PathVariable("id_b") Long id_b){
        return friendship_pendingService.addUsersToPending(id_a,id_b);
    }

    @RequestMapping(value = "/user/getreceivedpendingreq/{id}",method = RequestMethod.GET)
    public List<Friendship_pending> getReceivedPendingReq(@PathVariable("id") Long id){
        return friendship_pendingService.getReceivedPendingReq(id);
    }

    @RequestMapping(value = "/user/getsentpendingreq/{id}",method = RequestMethod.GET)
    public List<Friendship_pending> getSentPendingReq(@PathVariable("id") Long id){
        return friendship_pendingService.getSentPendingReq(id);
    }

    //*******************************************************************************

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String CreatePost(@RequestBody Post post){
        return postService.CreatePost(post);
    }

    @RequestMapping(value = "/post/get/id/{id}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable("id") Long id){
       return postService.PostGetById(id);
    }

    @RequestMapping(value = "/post/get/all/user/id/{id}", method = RequestMethod.GET)
    public List<Post> getAllPostsByUserId(@PathVariable("id") Long id){
        return postService.getAllPostsByUserId(id);
    }

    //*******************************************************************************

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/post/comment/add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

}
