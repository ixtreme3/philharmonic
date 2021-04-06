CREATE TABLE cultural_building
(
    id_place         bigint NOT NULL,
    name             text NOT NULL,
    type_of_building text NOT NULL,
    address          text NOT NULL,
    capacity         integer NOT NULL,
    CONSTRAINT PK_cultural_buildings PRIMARY KEY ( id_place )
);

CREATE TABLE house_of_culture
(
    id_place    bigint NOT NULL,
    type text NOT NULL,
    CONSTRAINT PK_cinemas PRIMARY KEY ( id_place ),
    CONSTRAINT FK_24 FOREIGN KEY ( id_place ) REFERENCES cultural_building ( id_place )
);

CREATE TABLE theater
(
    id_place            bigint NOT NULL,
    scene               text NOT NULL,
    number_of_balconies integer NOT NULL,
    CONSTRAINT PK_theaters PRIMARY KEY ( id_place ),
    CONSTRAINT FK_21 FOREIGN KEY ( id_place ) REFERENCES cultural_building ( id_place )
);

