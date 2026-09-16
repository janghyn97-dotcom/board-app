erDiagram
MEMBER ||--o{ POST    : "작성"
MEMBER ||--o{ COMMENT : "작성"
POST   ||--o{ COMMENT : "달림"

    MEMBER {
        bigint      id PK
        varchar_100 email UK
        varchar_200 password
        varchar_30  nickname
        datetime    created_at
    }
    POST {
        bigint      id PK
        varchar_100 title
        text        content
        bigint      author_id FK
        int         view_count
        datetime    created_at
    }
    COMMENT {
        bigint      id PK
        bigint      post_id FK
        bigint      author_id FK
        varchar_500 content
        datetime    created_at
    }