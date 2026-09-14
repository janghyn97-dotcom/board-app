package com.javja.board.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long          id;          // 시스템이 부여
    private String        content;
    private Long          postId;      // 어떤 글에 달렸나 (Post.id)
    private Long          authorId;    // 누가 썼나 (Member.id)
    private LocalDateTime createdAt;   // 시스템이 부여

    // ① 새 댓글을 쓸 때 — id · createdAt 은 우리가 정합니다
    public Comment(String content, Long postId, Long authorId) {
        this.content = content;
        this.postId = postId;
        this.authorId = authorId;
        this.createdAt = LocalDateTime.now();
    }

    // ② 이미 있는 댓글을 되살릴 때 — 다섯 값을 다 아는 경우
    public Comment(Long id, String content, Long postId,
                   Long authorId, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.postId = postId;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }
    public String getContent() { return content; }
    public Long getPostId() { return postId; }
    public Long getAuthorId() { return authorId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}