CREATE TABLE gamesmuseum
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `producent`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `firstname` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `game`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `rating`      float DEFAULT NULL,
    `title`       varchar(255) NOT NULL,
    `producent_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE game_gamesmuseum
(
    `game_id`  int DEFAULT NULL,
    `gamesMuseum_id` int DEFAULT NULL
);

INSERT INTO gamesmuseum(`id`, `name`)
VALUES ('1', 'Multikino');

INSERT INTO gamesmuseum(`id`, `name`)
VALUES ('2', 'IMAX');

INSERT INTO gamesmuseum(`id`,  `name`)
VALUES ('3',  'Cinema City');

INSERT INTO `producent`(`id`, `firstname`)
VALUES ('1', 'Steven');
INSERT INTO `producent`(`id`, `firstname`)
VALUES ('2', 'Woody');
INSERT INTO `producent`(`id`, `firstname`)
VALUES ('3', 'Guy');

INSERT INTO `game`(`id`, `rating`, `title`, `producent_id`)
VALUES ('1', '2.2', 'Jaws', '1');
INSERT INTO `game`(`id`, `rating`, `title`, `producent_id`)
VALUES ('2', '8.1', 'Saving Private Ryan', '1');
INSERT INTO `game`(`id`, `rating`, `title`, `producent_id`)
VALUES ('3', '7.1', 'E.T.', '1');
INSERT INTO `game`(`id`, `rating`, `title`, `producent_id`)
VALUES ('4',  '2');
INSERT INTO `game`(`id`, `rating`, `title`, `producent_id`)
VALUES ('5',  '2');
INSERT INTO `game`(`id`,`rating`, `title`, `producent_id`)
VALUES ('6',  '7.1', 'Snatch', '3');
INSERT INTO `game`(`id`, `rating`, `title`, `producent_id`)
VALUES ('7',  '7.1', 'RockNRolla', '3');

INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('1', '1');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('1', '3');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('2', '3');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('3', '1');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('3', '2');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('4', '1');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('4', '3');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('5', '2');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('5', '3');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('6', '1');
INSERT INTO game_gamesmuseum(`game_id`, `gamesMuseum_id`)
VALUES ('7', '2');
















CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');




