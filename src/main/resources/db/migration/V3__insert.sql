INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (1, 'Новосибирский театр оперы и балета', 'Красный проспект, 36', 1500);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (2, 'Глобус', 'Каменская, 1', 500);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (3, 'Старый дом', 'Большевистская, 45', 150);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (4, 'Дворец культуры им. М. Горького', 'Богдана Хмельницкого, 40', 400);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (5, 'Дом культуры Академия', 'Ильича, 4', 75);
INSERT INTO cultural_building (id_place, name, address, capacity) VALUES (6, 'Дворец культуры железнодорожников', 'Челюскинцев, 11', 350);

INSERT INTO theater (id_place, scene, number_of_balconies) VALUES (1, 'Большая полукруглая сцена', 6);
INSERT INTO theater (id_place, scene, number_of_balconies) VALUES (2, 'Многоуровневая сцена', 2);
INSERT INTO theater (id_place, scene, number_of_balconies) VALUES (3, 'Узкая сцена квадратной формы', 0);

INSERT INTO house_of_culture (id_place, type) VALUES (4, 'Территориальный ДК');
INSERT INTO house_of_culture (id_place, type) VALUES (5, 'Территориальный ДК');
INSERT INTO house_of_culture (id_place, type) VALUES (6, 'ДК профсоюзов предприятий');

INSERT INTO event (id_event, name, visit_price, start_date, end_date)  VALUES (1, 'Поющие гитары', 600, '2010-01-20', '2020-01-20');
INSERT INTO event (id_event, name, visit_price, start_date, end_date)  VALUES (2, 'Тот самый день', 500, '2010-01-20', '2020-01-20');
INSERT INTO event (id_event, name, visit_price, start_date, end_date)  VALUES (3, 'Три поросенка', 200, '2010-01-20', '2020-01-20');
INSERT INTO event (id_event, name, visit_price, start_date, end_date)  VALUES (4, 'Сиротливый запад', 700, '2010-01-20', '2020-01-20');
INSERT INTO event (id_event, name, visit_price, start_date, end_date)  VALUES (5, 'На-на', 200, '2010-01-20', '2020-01-20');

INSERT INTO event_building (id_event, id_place) VALUES (1, 6);
INSERT INTO event_building (id_event, id_place) VALUES (2, 3);
INSERT INTO event_building (id_event, id_place) VALUES (3, 2);
INSERT INTO event_building (id_event, id_place) VALUES (4, 2);
INSERT INTO event_building (id_event, id_place) VALUES (5, 2);

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

INSERT INTO event_organizer (id_event, id_organizer) VALUES (1, 1);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (1, 2);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (2, 6);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (3, 10);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (4, 8);
INSERT INTO event_organizer (id_event, id_organizer) VALUES (5, 4);

INSERT INTO artist (id_artist, full_name, age, gender) VALUES (1, 'Сахаров Люсьен Кириллович', 20, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (2, 'Харламов Сергей Иосифович', 25, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (3, 'Сусоев Павел Станиславович', 30, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (4, 'Голубкин Варлаам Максович', 36, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (5, 'Бобров Тимур Евгеньевич', 46, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (6, 'Новичков Вольдемар Романович', 55, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (7, 'Анисимов Пётр Валериевич', 23, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (8, 'Колесник Денис Вадимович', 24, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (9, 'Сахаров Люсьен Кириллович', 43, 'Мужчина');
INSERT INTO artist (id_artist, full_name, age, gender) VALUES (10, 'Жданов Михаил Иванович', 36, 'Мужчина');

INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (1, 'Афанасьев Никита Степанович', 47, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (2, 'Сазонов Даниил Павлович', 54, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (3, 'Дмитриев Геннадий Георгиевич', 56, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (4, 'Гущин Юрий Егорович', 60, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (5, 'Крылов Евгений Иванович', 61, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (6, 'Савин Константин Пётрович', 38, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (7, 'Харитонов Валерий Степанович', 50, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (8, 'Дроздов Максим Витальевич', 35, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (9, 'Мишин Виталий Сергеевич', 27, 'Мужчина');
INSERT INTO impresario (id_impresario, full_name, age, gender) VALUES (10, 'Логинов Владимир Валерьевич', 37, 'Мужчина');

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




