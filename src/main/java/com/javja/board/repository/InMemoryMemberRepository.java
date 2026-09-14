package com.javja.board.repository;

import com.javja.board.domain.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> store = new HashMap<>();

    public InMemoryMemberRepository() {
        store.put(1L, new Member(1L, "hong@javja.dev", "길동"));
        store.put(2L, new Member(2L, "young@javja.dev", "영희"));
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}