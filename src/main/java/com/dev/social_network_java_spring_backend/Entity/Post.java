package com.dev.social_network_java_spring_backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String ownerPhoto;
    private Long ownerId;
    private String type;
    private String body;
    private Date date;
    private String tempComment;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;


    @JsonBackReference(value = "post")
    @ManyToMany(mappedBy = "posts", cascade=CascadeType.ALL)
    private List<Profile> profiles;


    public Post() {
    }

    public Post(String owner,Long ownerId, String ownerPhoto, String type, String body, Date date) {
        this.owner = owner;
        this.ownerId = ownerId;
        this.ownerPhoto = ownerPhoto;
        this.type = type;
        this.body = body;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerPhoto() {
        return ownerPhoto;
    }

    public void setOwnerPhoto(String ownerPhoto) {
        this.ownerPhoto = ownerPhoto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
