CREATE TABLE cultural_building
(
    id_place         bigint NOT NULL,
    name             text NOT NULL,
    address          text NOT NULL,
    capacity         integer NOT NULL,
    CONSTRAINT PK_cultural_building PRIMARY KEY ( id_place )
);

CREATE TABLE house_of_culture
(
    id_place    bigint NOT NULL,
    type text NOT NULL,
    CONSTRAINT PK_cinema PRIMARY KEY ( id_place ),
    CONSTRAINT FK_24 FOREIGN KEY ( id_place ) REFERENCES cultural_building ( id_place )
);

CREATE TABLE theater
(
    id_place            bigint NOT NULL,
    scene               text NOT NULL,
    number_of_balconies integer NOT NULL,
    CONSTRAINT PK_theater PRIMARY KEY ( id_place ),
    CONSTRAINT FK_21 FOREIGN KEY ( id_place ) REFERENCES cultural_building ( id_place )
);

CREATE TABLE event
(
    id_event      bigint NOT NULL,
    event_type    text NOT NULL,
    name          text NOT NULL,
    visit_prise   integer NOT NULL,
    start_date    date NOT NULL,
    end_date      date NOT NULL,
    CONSTRAINT PK_event PRIMARY KEY ( id_event )
);

CREATE TABLE event_building
(
    id_event bigint NOT NULL,
    id_place bigint NOT NULL,
    CONSTRAINT PK_event_building PRIMARY KEY ( id_event, id_place ),
    CONSTRAINT FK_41 FOREIGN KEY ( id_place ) REFERENCES cultural_building ( id_place ),
    CONSTRAINT FK_37 FOREIGN KEY ( id_event ) REFERENCES event ( id_event )
);


