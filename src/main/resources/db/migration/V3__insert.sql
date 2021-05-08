INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (1, 'Новосибирский театр оперы и балета', 'Красный проспект, 36', 1500);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (2, 'Глобус', 'Каменская, 1', 500);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (3, 'Старый дом', 'Большевистская, 45', 125);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (4, 'Красный факел', 'Ленина, 19', 150);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (5, 'Новосибирский музыкальный театр', 'Каменская, 43', 250);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (6, 'Дворец культуры им. М. Горького', 'Богдана Хмельницкого, 40', 500);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (7, 'Дом культуры Академия', 'Ильича, 4', 75);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (8, 'Дворец культуры железнодорожников', 'Челюскинцев, 11', 350);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (9, 'Дом культуры им. Октябрьской Революции', 'Ленина, 24', 80);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (10, 'Дом культуры и творчества им. В.П. Чкалова', 'пр. Дзержинского, 34/1', 50);

INSERT INTO theater (id_place, scene, number_of_balconies) VALUES (1, 'Большая полукруглая сцена', 6);
INSERT INTO theater (id_place, scene, number_of_balconies) VALUES (2, 'Многоуровневая сцена', 2);
INSERT INTO theater (id_place, scene, number_of_balconies) VALUES (3, 'Узкая сцена квадратной формы', 0);
INSERT INTO theater (id_place, scene, number_of_balconies) VALUES (4, 'Узкая сцена квадратной формы', 2);
INSERT INTO theater (id_place, scene, number_of_balconies) VALUES (5, 'Широкая сцена квадратной формы', 1);

INSERT INTO house_of_culture (id_place, type) VALUES (6, 'Территориальный ДК');
INSERT INTO house_of_culture (id_place, type) VALUES (7, 'Территориальный ДК');
INSERT INTO house_of_culture (id_place, type) VALUES (8, 'ДК профсоюзов предприятий');
INSERT INTO house_of_culture (id_place, type) VALUES (9, 'Территориальный ДК');
INSERT INTO house_of_culture (id_place, type) VALUES (10, 'Дом народного творчества');

INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (1, 5, 'Поющие гитары', 600, '2021-02-20', '2021-02-26');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (2, 4, 'Тот самый день', 500, '2021-01-13', '2021-01-20');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (3, 2, 'Три поросенка', 200, '2021-04-05', '2021-04-15');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (4, 7, 'Сиротливый запад', 700, '2021-03-17', '2021-03-29');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (5, 8, 'На-на', 200, '2021-03-20', '2021-04-01');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (6, 6, 'Чайф', 550, '2021-04-20', '2021-04-29');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (7, 3, 'Весенний романс', 1000, '2021-04-08', '2021-04-13');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (8, 10, '«Мельница»', 700, '2020-11-20', '2020-11-27');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (9, 1, 'Хансард', 1500, '2020-10-06', '2020-10-10');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (10, 9, 'Ха!Мы!', 800, '2020-12-15', '2020-12-22');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (11, 2, 'Песни военных лет', 0, '2019-05-08', '2019-05-10');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (12, 2, '«Светлый май»', 450, '2020-05-11', '2020-05-15');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (13, 4, 'Сибирь зажигает звезды!', 0, '2021-02-11', '2021-02-24');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (14, 2, 'Международный конкурс-фестиваль «Планета талантов»', 0, '2019-07-16', '2019-07-27');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (15, 5, 'Конкурс инструментального исполнительства «ProДВИЖЕНИЕ»', 0, '2020-08-01', '2020-08-08');
INSERT INTO event (id_event, id_place, name, visit_price, start_date, end_date)  VALUES (16, 1, 'Конкурс хореографического искусства «ProДВИЖЕНИЕ»', 0, '2020-08-09', '2020-09-16');

INSERT INTO concert (id_event, live_music) VALUES (1, true);
INSERT INTO concert (id_event, live_music) VALUES (5, true);
INSERT INTO concert (id_event, live_music) VALUES (6, true);
INSERT INTO concert (id_event, live_music) VALUES (11, true);

INSERT INTO performance (id_event, intermission_length) VALUES (2, 5);
INSERT INTO performance (id_event, intermission_length) VALUES (3, 0);
INSERT INTO performance (id_event, intermission_length) VALUES (4, 10);
INSERT INTO performance (id_event, intermission_length) VALUES (7, 15);
INSERT INTO performance (id_event, intermission_length) VALUES (8, 5);
INSERT INTO performance (id_event, intermission_length) VALUES (9, 20);
INSERT INTO performance (id_event, intermission_length) VALUES (10, 0);
INSERT INTO performance (id_event, intermission_length) VALUES (12, 0);

INSERT INTO contest (id_event, number_of_participants) VALUES (13, 268);
INSERT INTO contest (id_event, number_of_participants) VALUES (14, 498);
INSERT INTO contest (id_event, number_of_participants) VALUES (15, 99);
INSERT INTO contest (id_event, number_of_participants) VALUES (16, 79);

INSERT INTO organizer (id_organizer, full_name, gender) VALUES (1, 'Александров Роман Егорович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (2, 'Баженова Ксения Антоновна', 'Женщина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (3, 'Басов Виктор Вадимович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (4, 'Леонов Александр Макарович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (5, 'Горшков Владимир Даниилович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (6, 'Семенов Иван Александрович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (7, 'Никольский Григорий Максимович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (8, 'Соколов Платон Артёмович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (9, 'Исаков Дмитрий Владимирович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (10, 'Павлов Тимофей Константинович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (11, 'Агафонов Леонид Степанович', 'Мужчина');
INSERT INTO organizer (id_organizer, full_name, gender) VALUES (12, 'Фадеева Алина Евгеньевна', 'Женщина');

INSERT INTO event_organizer (id_event, id_organizer) VALUES (1, 1);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (1, 2);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (2, 6);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (3, 10);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (4, 8);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (5, 2);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (6, 1);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (7, 9);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (8, 10);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (8, 7);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (9, 8);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (9, 2);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (9, 3);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (10, 6);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (11, 5);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (12, 8);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (13, 11);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (14, 12);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (15, 11);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (16, 12);

INSERT INTO artist (id_artist, full_name, age, gender) VALUES (1, 'Лазарев Олег Олегович', 20, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (2, 'Харламов Сергей Иосифович', 25, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (3, 'Сусоев Павел Станиславович', 30, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (4, 'Голубкин Варлаам Максович', 36, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (5, 'Бобров Тимур Евгеньевич', 46, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (6, 'Новичков Вольдемар Романович', 55, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (7, 'Анисимов Пётр Валериевич', 23, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (8, 'Колесник Денис Вадимович', 24, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (9, 'Сахаров Люсьен Кириллович', 43, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (10, 'Жданов Михаил Иванович', 18, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (11, 'Ильин Валерий Павлович', 23, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (12, 'Ершова Маргарита Вячеславовна', 25, 'Женщина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (13, 'Жданов Михаил Иванович', 60, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (14, 'Быков Николай Анатольевич', 37, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (15, 'Панов Олег Валерьевич', 26, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (16, 'Александров Пётр Григориевич', 44, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (17, 'Данилов Никита Егорович', 41, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (18, 'Кудрявцева София Вадимовна', 29, 'Женщина');

INSERT INTO event_artist(id_event, id_artist) VALUES (1, 1);
INSERT INTO event_artist(id_event, id_artist) VALUES (1, 17);
INSERT INTO event_artist(id_event, id_artist) VALUES (2, 2);
INSERT INTO event_artist(id_event, id_artist) VALUES (3, 16);
INSERT INTO event_artist(id_event, id_artist) VALUES (3, 18);
INSERT INTO event_artist(id_event, id_artist) VALUES (4, 4);
INSERT INTO event_artist(id_event, id_artist) VALUES (5, 9);
INSERT INTO event_artist(id_event, id_artist) VALUES (5, 13);
INSERT INTO event_artist(id_event, id_artist) VALUES (6, 10);
INSERT INTO event_artist(id_event, id_artist) VALUES (7, 11);
INSERT INTO event_artist(id_event, id_artist) VALUES (8, 3);
INSERT INTO event_artist(id_event, id_artist) VALUES (9, 5);
INSERT INTO event_artist(id_event, id_artist) VALUES (10, 8);
INSERT INTO event_artist(id_event, id_artist) VALUES (11, 14);
INSERT INTO event_artist(id_event, id_artist) VALUES (12, 15);

INSERT INTO event_artist(id_event, id_artist) VALUES (13, 7);
INSERT INTO event_artist(id_event, id_artist) VALUES (13, 2);
INSERT INTO event_artist(id_event, id_artist) VALUES (13, 6);
INSERT INTO event_artist(id_event, id_artist) VALUES (14, 12);
INSERT INTO event_artist(id_event, id_artist) VALUES (15, 2);
INSERT INTO event_artist(id_event, id_artist) VALUES (16, 7);

INSERT INTO prizewinner (id_prizewinner, id_event, id_artist, place) VALUES (1, 13, 7, 1);
INSERT INTO prizewinner (id_prizewinner, id_event, id_artist, place) VALUES (2, 13, 2, 2);
INSERT INTO prizewinner (id_prizewinner, id_event, id_artist, place) VALUES (3, 13, 6, 3);
INSERT INTO prizewinner (id_prizewinner, id_event, id_artist, place) VALUES (4, 14, 12, 3);
INSERT INTO prizewinner (id_prizewinner, id_event, id_artist, place) VALUES (5, 15, 2, 1);
INSERT INTO prizewinner (id_prizewinner, id_event, id_artist, place) VALUES (6, 16, 7, 2);

INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (1, 'Афанасьев Никита Степанович', 47, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (2, 'Сазонов Даниил Павлович', 54, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (3, 'Дмитриев Геннадий Георгиевич', 56, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (4, 'Гущин Юрий Егорович', 60, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (5, 'Крылов Евгений Иванович', 61, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (6, 'Савин Константин Петрович', 38, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (7, 'Харитонов Валерий Степанович', 50, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (8, 'Дроздов Максим Витальевич', 35, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (9, 'Мишин Виталий Сергеевич', 27, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (10, 'Логинов Владимир Валерьевич', 35, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (11, 'Мишин Вадим Васильевич', 29, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (12, 'Буров Тимур Фёдорович', 55, 'Мужчина');

INSERT INTO genre (id_genre, genre_name) VALUES (1, 'Комедия');
INSERT INTO genre (id_genre, genre_name) VALUES (2, 'Драма');
INSERT INTO genre (id_genre, genre_name) VALUES (3, 'Мелодрама');
INSERT INTO genre (id_genre, genre_name) VALUES (4, 'Трагедия');
INSERT INTO genre (id_genre, genre_name) VALUES (5, 'Мюзикл');
INSERT INTO genre (id_genre, genre_name) VALUES (6, 'Трагикомедия');
INSERT INTO genre (id_genre, genre_name) VALUES (7, 'Водевиль');

INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (1, 1);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (1, 2);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (1, 3);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (2, 10);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (3, 6);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (4, 4);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (5, 7);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (5, 9);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (6, 5);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (7, 5);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (8, 2);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (9, 8);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (10, 3);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (11, 3);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (12, 11);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (13, 12);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (14, 12);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (15, 9);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (16, 7);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (17, 4);
INSERT INTO artist_impresario (id_artist, id_impresario) VALUES (18, 5);

INSERT INTO artist_genre (id_artist, id_genre) VALUES (1, 1);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (1, 4);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (2, 5);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (3, 6);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (3, 7);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (4, 3);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (5, 5);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (6, 2);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (7, 1);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (8, 4);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (9, 7);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (10, 3);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (11, 1);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (12, 3);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (13, 7);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (14, 4);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (15, 2);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (16, 6);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (17, 2);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (18, 4);
INSERT INTO artist_genre (id_artist, id_genre) VALUES (18, 1);






