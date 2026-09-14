package com.javja.board.repository;

import com.javja.board.domain.Member;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long id);
}