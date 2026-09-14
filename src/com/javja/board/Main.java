package com.javja.board;

import com.javja.board.dto.PostCreate;
import com.javja.board.dto.PostResponse;
import com.javja.board.dto.PostUpdate;
import com.javja.board.repository.InMemoryMemberRepository;
import com.javja.board.repository.InMemoryPostRepository;
import com.javja.board.repository.MemberRepository;
import com.javja.board.repository.PostRepository;
import com.javja.board.service.DailyLimitExceededException;
import com.javja.board.service.PostNotFoundException;
import com.javja.board.service.PostService;

public class Main {
    public static void main(String[] args) {
        PostRepository repo = new InMemoryPostRepository();
        MemberRepository memberRepo = new InMemoryMemberRepository();
        PostService service = new PostService(repo, memberRepo);

        // C — 등록
        PostResponse created = service.create(1L,
                new PostCreate("첫 글", "안녕하세요"));
        System.out.println("등록: " + created);

        // R — 목록과 단건
        System.out.println("목록: " + service.findAll());
        System.out.println("단건: " + service.findById(created.id()));

        // U — 수정
        service.update(created.id(), new PostUpdate("고친 제목", "고친 내용"));
        System.out.println("수정 후: " + service.findById(created.id()));

        // D — 삭제
        service.delete(created.id());
        System.out.println("삭제 후 목록: " + service.findAll());

        // 없는 글
        try {
            service.findById(999L);
        } catch (PostNotFoundException e) {
            System.out.println("기대한 예외: " + e.getMessage());
        }

        // 하루 10개 제한
        try {
            for (int i = 0; i < 11; i++) {
                service.create(2L, new PostCreate("글 " + i, "내용"));
            }
        } catch (DailyLimitExceededException e) {
            System.out.println("기대한 예외: " + e.getMessage());
        }
    }
}