package com.javja.board.dto;

public record PostCreate(String title, String content) {
    public PostCreate {                       // 괄호 없음에 주의
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("제목은 필수입니다");
        title = title.trim();                 // 값을 바꿔서 담습니다
        if (title.length() > 100)
            throw new IllegalArgumentException("제목은 100자 이하여야 합니다");

        if (content == null || content.isBlank())
            throw new IllegalArgumentException("내용은 필수입니다");
        content = content.trim();
        if (content.length() > 5000)
            throw new IllegalArgumentException("내용은 5000자 이하여야 합니다");
    }
}