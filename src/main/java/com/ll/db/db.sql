DROP DATABASE IF EXISTS hjDB;
CREATE DATABASE hjDB;
USE hjDB;

CREATE TABLE article (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title char(100) NULL UNIQUE,
	content text NOT NULL,
	memberId int UNSIGNED NOT NULL,
	regDate datetime DEFAULT now() NOT null,
    articleCode int NOT null
);
CREATE TABLE `member` (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	userId char(100) NOT NULL UNIQUE,
	password text NOT NULL,
	regDate datetime DEFAULT now() NOT null
);

-- DROP TABLE article;
DESC article; DESC member;
SELECT * FROM article;

INSERT INTO article (title, content, memberId)
VALUES('제목1', '내용1', 1);

INSERT INTO member (userId, `password`)
VALUES('User1', '1234');



SELECT * FROM article;