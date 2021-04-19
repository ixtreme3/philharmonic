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