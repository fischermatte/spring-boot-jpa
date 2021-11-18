package com.example.springbootpostgres.blog.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {

    @Id
    private String id;

    private String title;

    private String content;

    protected Blog() {
        // JPA
    }

    public Blog(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
