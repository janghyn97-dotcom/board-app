package com.javja.board.repository;

import com.javja.board.domain.Post;
import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);                  // C — 새 글
    Optional<Post> findById(Long id);      // R — 하나
    List<Post> findAll();                  // R — 전부
    void update(Post post);                // U — 고치기
    void deleteById(Long id);              // D — 지우기
    int countTodayBy(Long memberId);       // 하루 10개 규칙에 필요
}