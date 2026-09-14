package com.javja.board.service;

import com.javja.board.domain.Member;
import com.javja.board.domain.Post;
import com.javja.board.dto.PostCreate;
import com.javja.board.dto.PostResponse;
import com.javja.board.dto.PostUpdate;
import com.javja.board.repository.MemberRepository;
import com.javja.board.repository.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository repo;          // 인터페이스 타입!
    private final MemberRepository memberRepo;   // 닉네임을 찾으려고

    public PostService(PostRepository repo, MemberRepository memberRepo) {
        this.repo = repo;                       // 생성자로 주입
        this.memberRepo = memberRepo;
    }

    public PostResponse create(Long memberId, PostCreate req) {
        if (repo.countTodayBy(memberId) >= 10) {
            throw new DailyLimitExceededException(memberId);
        }
        Post saved = repo.save(new Post(req.title(), req.content(), memberId));
        return toResponse(saved);
    }

    public PostResponse findById(Long id) {
        Post post = repo.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        return toResponse(post);
    }

    public List<PostResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public PostResponse update(Long id, PostUpdate req) {
        Post post = repo.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        post.update(req.title(), req.content());
        repo.update(post);
        return toResponse(post);
    }

    public void delete(Long id) {
        repo.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        repo.deleteById(id);
    }

    private PostResponse toResponse(Post post) {
        String nickname = memberRepo.findById(post.getAuthorId())
                .map(Member::getNickname)
                .orElse("알 수 없음");
        return PostResponse.from(post, nickname);
    }
}