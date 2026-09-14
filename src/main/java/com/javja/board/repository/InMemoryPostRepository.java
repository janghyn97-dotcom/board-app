package com.javja.board.repository;

import com.javja.board.domain.Post;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPostRepository implements PostRepository {

    private final Map<Long, Post> store = new HashMap<>();
    private long sequence = 0L;

    @Override
    public Post save(Post post) {
        post.setId(++sequence);            // 저장하면서 id를 부여합니다
        store.put(post.getId(), post);
        return post;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Post post) {
        store.put(post.getId(), post);     // 같은 키에 덮어씁니다
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public int countTodayBy(Long memberId) {
        LocalDate today = LocalDate.now();
        return (int) store.values().stream()
                .filter(p -> p.getAuthorId().equals(memberId))
                .filter(p -> p.getCreatedAt().toLocalDate().equals(today))
                .count();
    }
}