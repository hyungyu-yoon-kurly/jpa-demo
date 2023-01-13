DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS member;
CREATE TABLE member
(
    id    INT PRIMARY KEY auto_increment,
    email VARCHAR(30),
    name  VARCHAR(30),
    tel   VARCHAR(30)
);

CREATE TABLE orders
(
    id       INT primary key auto_increment,
    item     VARCHAR(50),
    memberId INT,
    foreign key (memberId) references member (id)
);

INSERT INTO `member` (`id`, `email`, `name`, `tel`)
VALUES (1, 'kim@naver.com', 'Kim', '010-0000-0001'),
       (2, 'janny@naver.com', 'Janny', '010-0000-0002'),
       (3, 'billie@naver.com', 'Billie Eilish', '010-0000-0003'),
       (4, 'taylor@naver.com', 'Taylor Swift', '010-0000-0004'),
       (5, 'jack@naver.com', 'Jack', '010-3212-0005'),
       (6, 'hong@hanmail.net', '홍길동', '010-5244-0006'),
       (7, 'kang@naver.com', '강감찬', '010-0000-1111'),
       (8, 'kim@naver.com', '김구', '010-1234-1111'),
       (9, 'lee@naver.com', '이순신', '010-3234-1111'),
       (10, 'park@naver.com', '박찬호', '010-5464-1111');

INSERT INTO `orders` (`id`, `item`, `memberId`)
VALUES (10001, 'TV', 1),
       (10002, 'Notebook', 1),
       (10003, 'Phone', 1),
       (10004, 'Monitor', 2),
       (10005, 'Washer', 2),
       (10006, 'Car', 2),
       (10007, 'Table', 3),
       (10008, 'Beer', 4),
       (10009, 'Bike', 5),
       (10010, 'Boat', 6);
