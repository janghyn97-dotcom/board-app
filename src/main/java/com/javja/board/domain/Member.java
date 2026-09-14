package com.javja.board.domain;

import java.time.LocalDateTime;

public class Member {
    private Long id;          // 시스템이 부여
    private String email;
    private String password;  // ← 밖으로 나가면 안 됨
    private String nickname;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public Member(Long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }
}