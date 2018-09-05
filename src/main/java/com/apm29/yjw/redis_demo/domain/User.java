package com.apm29.yjw.redis_demo.domain;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.data.domain.ExampleMatcher;

import javax.persistence.*;

@Table
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true,nullable = false)
    private String userName;

    public User() {
    }

    public User(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
