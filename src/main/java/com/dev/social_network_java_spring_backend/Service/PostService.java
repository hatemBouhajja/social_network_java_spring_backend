package com.dev.social_network_java_spring_backend.Service;


import com.dev.social_network_java_spring_backend.Dao.CommentDao;
import com.dev.social_network_java_spring_backend.Dao.PostDao;
import com.dev.social_network_java_spring_backend.Entity.Comment;
import com.dev.social_network_java_spring_backend.Entity.Post;
import com.dev.social_network_java_spring_backend.Entity.Profile;
import com.dev.social_network_java_spring_backend.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private ProfileService profileService;

    public String CreatePost(Post post){
        Post newPost = new Post(post.getOwner(),post.getOwnerId(),post.getOwnerPhoto(),post.getType(),post.getBody(),post.getDate());

        Profile concernedProfile = profileService.profileGetById(post.getOwnerId());

        List<Post> newList = concernedProfile.getPosts();
        newList.add(newPost);

        concernedProfile.setPosts(newList);

        postDao.save(newPost);
        return "created";
    }

    public Post PostGetById(Long id){
        Optional<Post> tempPost = postDao.findById(id);
        if(tempPost.isPresent()){
            return tempPost.get();
        }else {
            return null;
        }
    }

    public List<Post> getAllPostsByUserId(Long id){
        return postDao.findAllByOwnerId(id);
    }


}
