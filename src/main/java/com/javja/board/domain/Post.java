package com.javja.board.domain;

import java.time.LocalDateTime;

public class Post {
    private Long          id;
    private String        title;
    private String        content;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public int getViewCount() {
        return viewCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private Long          authorId;
    private int           viewCount;
    private LocalDateTime createdAt;

    public Post(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.viewCount = 0;
        this.createdAt = LocalDateTime.now();
    }

    public Post(Long id, String title, String content,
                Long authorId, int viewCount, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
    }

    public void setId(Long id) { this.id = id; }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}