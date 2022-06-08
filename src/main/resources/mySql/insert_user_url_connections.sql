USE pagerank;

INSERT INTO pagerank.user (name,pass)
VALUES
( "Dima", "Dimapass"),
( "Alexandra", "Alexandrapass"),
( "Marina", "Marinapass"),
( "Andrey", "Andreypass");


INSERT INTO pagerank.url (url,user_id)
VALUES
("http://www.google.com/", "1"),
("https://www.youtube.com/", "2"),
("https://music.youtube.com/", "3"),
("https://ads.google.com/", "4");

INSERT INTO `pagerank`.`connections`
(`V1_id`, `V2_id1`)
VALUES
(1,2),
(2,3),
(3,4),
(4,1),
(4,2);
