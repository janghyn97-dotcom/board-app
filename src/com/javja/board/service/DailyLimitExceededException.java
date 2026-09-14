package com.javja.board.service;

public class DailyLimitExceededException extends RuntimeException {
    public DailyLimitExceededException(Long memberId) {
        super("하루 작성 제한을 초과했습니다: " + memberId);
    }
}