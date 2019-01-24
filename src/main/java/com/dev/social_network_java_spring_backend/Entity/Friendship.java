package com.dev.social_network_java_spring_backend.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Friendship implements Serializable {

    @Id
    private Long id;
    private Long sender;
    private Long receiver;

    public Friendship() {
    }

    public Friendship(Long id, Long sender, Long receiver) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }
}
