INSERT INTO `pagerankdb`.`users`
(`login`, `password`)
VALUES("admin", "password"), ("user", "123456"), ("guest", "guest");

INSERT INTO `pagerankdb`.`pagestorank`
(`user_id`, `page_id`, `rank`)
VALUES
(1, 2, 0.5), (1, 1, 0.64), (2, 3, 0.73);

INSERT INTO `pagerankdb`.`pages`
(`url`, `user_id`)
VALUES
("http://www.google.com/", 1), ("https://www.youtube.com/", 2), ("https://music.youtube.com/", 3);

INSERT INTO `pagerankdb`.`relationsbetweenpages`
(`pageToRank_id1`, `pageToRank_id2`)
VALUES (1, 2), (2, 3), (1, 3);
