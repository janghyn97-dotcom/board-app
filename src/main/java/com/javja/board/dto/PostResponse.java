package com.javja.board.dto;

import com.javja.board.domain.Post;

public record PostResponse(Long id, String title, String content,
                           String authorNickname, int viewCount) {
    public static PostResponse from(Post p, String authorNickname) {
        return new PostResponse(p.getId(), p.getTitle(), p.getContent(),
                authorNickname, p.getViewCount());
    }
}