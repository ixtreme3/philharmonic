CREATE TABLE cultural_building
(
    id_place         bigint NOT NULL,
    name             text NOT NULL,
    address          text NOT NULL,
    capacity         integer NOT NULL CHECK (capacity > 0),
    CONSTRAINT PK_cultural_building PRIMARY KEY ( id_place )
);

CREATE TABLE house_of_culture
(
    id_place    bigint NOT NULL,
    type text   NOT NULL,
    CONSTRAINT PK_cinema PRIMARY KEY ( id_place ),
    CONSTRAINT FK_24 FOREIGN KEY ( id_place ) REFERENCES cultural_building ( id_place )
);

CREATE TABLE theater
(
    id_place            bigint NOT NULL,
    scene               text NOT NULL,
    number_of_balconies integer NOT NULL CHECK (number_of_balconies >= 0),
    CONSTRAINT PK_theater PRIMARY KEY ( id_place ),
    CONSTRAINT FK_21 FOREIGN KEY ( id_place ) REFERENCES cultural_building ( id_place )
);

CREATE TABLE event
(
    id_event    bigint NOT NULL,
    id_place    bigint NOT NULL,
    name        text NOT NULL,
    visit_price integer NOT NULL CHECK (visit_price >= 0),
    start_date  date NOT NULL,
    end_date    date NOT NULL,
    CONSTRAINT PK_events PRIMARY KEY ( id_event ),
    CONSTRAINT FK_161 FOREIGN KEY ( id_place ) REFERENCES cultural_building ( id_place )
);

CREATE TABLE artist
(
    id_artist bigint NOT NULL,
    full_name text NOT NULL,
    age       integer NOT NULL CHECK (age >= 0),
    gender    text NOT NULL,
    CONSTRAINT PK_artist PRIMARY KEY ( id_artist )
);

CREATE TABLE genre
(
    id_genre   bigint NOT NULL,
    genre_name text NOT NULL,
    CONSTRAINT PK_genre PRIMARY KEY ( id_genre )
);

CREATE TABLE impresario
(
    id_impresario bigint NOT NULL,
    full_name     text NOT NULL,
    age           integer NOT NULL CHECK (age >= 0),
    gender        text NOT NULL,
    CONSTRAINT PK_impresario PRIMARY KEY ( id_impresario )
);

CREATE TABLE organizer
(
    id_organizer bigint NOT NULL,
    full_name    text NOT NULL,
    gender       text NOT NULL,
    CONSTRAINT PK_organizer PRIMARY KEY ( id_organizer )
);

CREATE TABLE artist_genre
(
    id_artist bigint NOT NULL,
    id_genre  bigint NOT NULL,
    CONSTRAINT PK_artist_genre PRIMARY KEY ( id_artist, id_genre ),
    CONSTRAINT FK_69 FOREIGN KEY ( id_artist ) REFERENCES artist ( id_artist ),
    CONSTRAINT FK_73 FOREIGN KEY ( id_genre ) REFERENCES genre ( id_genre )
);

CREATE TABLE artist_impresario
(
    id_artist     bigint NOT NULL,
    id_impresario bigint NOT NULL,
    CONSTRAINT PK_producing PRIMARY KEY ( id_artist, id_impresario ),
    CONSTRAINT FK_57 FOREIGN KEY ( id_artist ) REFERENCES artist ( id_artist ),
    CONSTRAINT FK_61 FOREIGN KEY ( id_impresario ) REFERENCES impresario ( id_impresario )
);

CREATE TABLE event_organizer
(
    id_organizer bigint NOT NULL,
    id_event     bigint NOT NULL,
    CONSTRAINT PK_organizer_event PRIMARY KEY ( id_organizer, id_event ),
    CONSTRAINT FK_90 FOREIGN KEY ( id_organizer ) REFERENCES organizer ( id_organizer ),
    CONSTRAINT FK_94 FOREIGN KEY ( id_event ) REFERENCES event ( id_event )
);

CREATE TABLE event_artist
(
    id_event     bigint NOT NULL,
    winner_place integer NULL,
    id_artist    bigint NOT NULL,
    CONSTRAINT PK_events_artists PRIMARY KEY ( id_event, id_artist ),
    CONSTRAINT FK_78 FOREIGN KEY ( id_event ) REFERENCES event ( id_event ),
    CONSTRAINT FK_82 FOREIGN KEY ( id_artist ) REFERENCES artist ( id_artist )
);

CREATE TABLE concert
(
    id_event   bigint NOT NULL,
    live_music boolean NOT NULL,
    CONSTRAINT PK_concert PRIMARY KEY ( id_event ),
    CONSTRAINT FK_113 FOREIGN KEY ( id_event ) REFERENCES event ( id_event )
);

CREATE TABLE contest
(
    id_event               bigint NOT NULL,
    number_of_participants integer NOT NULL CHECK (number_of_participants > 0),
    CONSTRAINT PK_contest PRIMARY KEY ( id_event ),
    CONSTRAINT FK_110 FOREIGN KEY ( id_event ) REFERENCES event ( id_event )
);

CREATE TABLE performance
(
    id_event            bigint NOT NULL,
    intermission_length integer NOT NULL CHECK (intermission_length >= 0),
    CONSTRAINT PK_performance PRIMARY KEY ( id_event ),
    CONSTRAINT FK_116 FOREIGN KEY ( id_event ) REFERENCES event ( id_event )
);

CREATE TABLE artist_logs
(
    "text" text,
    "added" timestamp without time zone
);