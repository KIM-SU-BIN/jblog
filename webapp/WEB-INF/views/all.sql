CREATE table users (
    userNo          NUMBER,
    id           varchar2(50) UNIQUE not null, 
    userName    varchar2(100) NOT NULL,
    password    varchar2(50)  NOT NULL,
    joinDate date NOT NULL,
    PRIMARY KEY (userNo)
);

CREATE table blog (
    id varchar2(50),
    blogTitle   varchar2(200) NOT NULL,
    logoFile    varchar2(200),
    PRIMARY KEY (id),
    CONSTRAINT blog_fk foreign key(id)
    REFERENCES users (id)
);

CREATE table category (
    cateNo NUMBER,
    id varchar2(50) ,
    cateName varchar2(200) NOT NULL,
    description varchar2(500),
    regDate date NOT NULL,
    PRIMARY KEY (cateNo),
    CONSTRAINT category_fk foreign key(id)
    REFERENCES blog (id)
);



CREATE table post (
    postNo number,
    cateNo number,
    postTitle varchar2(300)  NOT NULL,
    postContent varchar2(4000),
    regDate date  NOT NULL,
    PRIMARY KEY (postNo),
    CONSTRAINT post_fk  foreign key(cateNo)
    REFERENCES category (cateNo)
);

CREATE table comments (
    cmtNo number,
    postNo number,
    userNo number,
    cmtContent varchar2(1000) NOT NULL,
    regDate date  NOT NULL,
    PRIMARY KEY (cmtNo),
    CONSTRAINT comments_fk foreign key(postNo)
    REFERENCES post(postNo),
    CONSTRAINT comments_fk2 foreign key(userNo)
    REFERENCES users(userNo)
);




-- 시퀀스 생성 --
create sequence seq_users_no
increment by 1
start with 1
nocache;

create sequence seq_category_no
increment by 1
start with 1
nocache;

create sequence seq_post_no
increment by 1
start with 1
nocache;

create sequence seq_comments_no
increment by 1
start with 1
nocache;

