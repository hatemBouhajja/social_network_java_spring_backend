package com.dev.social_network_java_spring_backend.Service;


import com.dev.social_network_java_spring_backend.Dao.CommentDao;
import com.dev.social_network_java_spring_backend.Entity.Comment;
import com.dev.social_network_java_spring_backend.Entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private PostService postService;

    public String addComment(Comment comment){
        Comment newComment = new Comment(comment.getCommenter(),comment.getCommenterId(),comment.getCommenterImage(),comment.getContent(),comment.getIdPost());

        Post concernedPost = postService.PostGetById(comment.getIdPost());

        List<Comment> newList = concernedPost.getComments();
        newList.add(newComment);

        concernedPost.setComments(newList);

        commentDao.save(newComment);

        return "added";
    }
}
