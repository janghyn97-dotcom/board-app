package com.javja.board.dto;

import java.time.LocalDateTime;
import com.javja.board.domain.Member;

public record MemberResponse(Long id, String nickname, LocalDateTime createdAt) {
    public static MemberResponse from(Member m) {
        return new MemberResponse(m.getId(), m.getNickname(), m.getCreatedAt());
    }
}