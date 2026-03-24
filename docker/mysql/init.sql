CREATE TABLE `producent`
(
    `id`    int          NOT NULL AUTO_INCREMENT,
    `nazwa` varchar(255) NOT NULL,
    `opis`  varchar(255) DEFAULT NULL,
    `logo`  varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `cydr`
(
    `id`           int          NOT NULL AUTO_INCREMENT,
    `nazwa`        varchar(255) NOT NULL,
    `styl`         varchar(255) NOT NULL,
    `cena`         double       NOT NULL,
    `dostepny`     boolean      DEFAULT TRUE,
    `producent_id` int          DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_cydr_producent` FOREIGN KEY (`producent_id`) REFERENCES `producent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `zamowienie`
(
    `id`     int          NOT NULL AUTO_INCREMENT,
    `numer`  varchar(255) NOT NULL,
    `status` varchar(50)  NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `zamowienie_cydr`
(
    `zamowienie_id` int NOT NULL,
    `cydr_id`       int NOT NULL,
    CONSTRAINT `fk_z_cydr` FOREIGN KEY (`cydr_id`) REFERENCES `cydr` (`id`),
    CONSTRAINT `fk_z_zamowienie` FOREIGN KEY (`zamowienie_id`) REFERENCES `zamowienie` (`id`)
);


INSERT INTO `producent`(`id`, `nazwa`, `opis`, `logo`)
VALUES (1, 'Cydr Chyliczki', 'Rzemieślniczy cydr z Mazowsza', 'https://cydrchyliczki.pl/logo.png'),
       (2, 'Cydr Lubelski', 'Popularny cydr przemysłowy', 'https://cydrlubelski.pl/logo.png'),
       (3, 'Kwaśne Jabłko', 'Ekologiczna cydrownia z Warmii', 'https://kwasnejablko.pl/logo.png');

INSERT INTO `cydr`(`id`, `nazwa`, `styl`, `cena`, `dostepny`, `producent_id`)
VALUES (101, 'Szara Reneta', 'Wytrawny', 25.00, true, 1),
       (102, 'Klasyczny', 'Półsłodki', 12.50, true, 2),
       (103, 'Lodowy', 'Słodki/Deserowy', 45.00, true, 3),
       (104, 'Krąplewo', 'Wytrawny', 28.00, true, 3);

INSERT INTO `zamowienie`(`id`, `numer`, `status`)
VALUES (501, 'ORD-2024-001', 'NOWE'),
       (502, 'ORD-2024-002', 'WYSŁANE');

INSERT INTO `zamowienie_cydr`(`zamowienie_id`, `cydr_id`)
VALUES (501, 101),
       (501, 103),
       (502, 102);


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
VALUES ('user1', 'user1'),

INSERT INTO role(username, role)
VALUES ('user1', 'ROLE_ADMIN'),
