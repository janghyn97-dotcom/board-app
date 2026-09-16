CREATE TABLE member (
                        id         BIGINT       AUTO_INCREMENT PRIMARY KEY,
                        email      VARCHAR(100) NOT NULL UNIQUE,
                        password   VARCHAR(200) NOT NULL,
                        nickname   VARCHAR(30)  NOT NULL,
                        role       VARCHAR(20)  NOT NULL DEFAULT 'USER',   -- 그림에 없음, 오늘 새로 추가
                        created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE post (
                      id         BIGINT       AUTO_INCREMENT PRIMARY KEY,
                      title      VARCHAR(100) NOT NULL,
                      content    TEXT         NOT NULL,
                      author_id  BIGINT       NOT NULL,
                      view_count INT          NOT NULL DEFAULT 0,        -- 그림에 없음
                      created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      CONSTRAINT fk_post_member
                          FOREIGN KEY (author_id) REFERENCES member(id)
);