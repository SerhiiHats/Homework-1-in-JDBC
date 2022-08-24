-- DROP DATABASE myjoinsdb;

CREATE DATABASE myjoinsdb;

USE myjoinsdb;

CREATE TABLE employees (
id_emp INT AUTO_INCREMENT PRIMARY KEY,
l_name_emp VARCHAR(50) NOT NULL,
f_name_emp VARCHAR(50) NOT NULL,
m_name_emp VARCHAR(50),
phone_emp VARCHAR(15) NOT NULL);

CREATE INDEX l_name_index ON employees(l_name_emp);                     -- индекс к имени сотрудника добавит упорядочености и скорости к поиску по имени

CREATE TABLE position_employee (
id_pos INT AUTO_INCREMENT,
id_emp INT NOT NULL,
salary_pos DOUBLE NOT NULL DEFAULT 0,
title_pos VARCHAR(50) NOT NULL DEFAULT 'Trenee',
PRIMARY KEY (id_pos),
FOREIGN KEY (id_emp) REFERENCES employees (id_emp));

ALTER TABLE position_employee ADD INDEX title_pos_index (title_pos);   -- индекс к должности сотрудника добавит упорядочености и скорости к поиску по должности сотрудника

CREATE TABLE description_employee (
id_des INT AUTO_INCREMENT PRIMARY KEY,
id_emp INT NOT NULL UNIQUE,
married_des VARCHAR (15) NOT NULL,
birthday_des DATE NOT NULL,
address_des VARCHAR(50),
FOREIGN KEY (id_emp) REFERENCES employees (id_emp));

CREATE INDEX married_des_index ON description_employee (married_des); -- индекс к семейному положению сотрудника добавит упорядочености и скорости к поиску по семейному положению сотрудника

CREATE INDEX birthday_des_index ON description_employee (birthday_des); -- индекс к дате рождения сотрудника добавит упорядочености и скорости к поиску по дате рождения сотрудника сотрудника

INSERT INTO employees (l_name_emp, f_name_emp, m_name_emp, phone_emp) VALUES
('Веретенина','Людмила','Владимировна','+38(067)8758419'),
('Хлебников','Александр','Викторович','+38(098)5861716'),
('Блажкова','Оксана','Сергеевна','+38(097)9718853'),
('Кондур','Анатолий','Иванович','+38(098)9854409'),
('Бостан','Денис','Ивановича','+38(063)5055520'),
('Койчева','Татьяна','Сергеевна','+38(097)7758415'),
('Миндов','Руслан','Денисович','+38(063)0045457'),
('Покора','Людмила','Ивановна','+38(098)7851796'),
('Жукова','Оксана','Артемовна','+38(067)5257896'),
('Пышненко','Юрий','Викторович','+38(097)7512525');

INSERT INTO position_employee (id_emp, salary_pos, title_pos) VALUES
(1, 19500.5, 'главный директор'),
(2, 15500.5, 'менеджер'),
(3, 16755.5, 'менеджер'),
(4, 7985.0, 'рабочий'),
(5, 9852.5, 'рабочий'),
(6, 11457.5, 'рабочий'),
(7, 9957.0, 'рабочий'),
(8, 12570.5, 'рабочий'),
(9, 14553.0, 'рабочий'),
(10, 8855.5, 'рабочий');

INSERT INTO description_employee (id_emp, married_des, birthday_des, address_des) VALUES
(1, 'married', '1988-04-15', 'Одесса...'),
(2, 'not married', '1980-12-10', 'Одесса...'),
(3, 'married', '1993-01-07', 'Киев...'),
(4, 'not married', '1987-02-04', 'Умань...'),
(5, 'not married', '1980-05-07', 'Кривой Рог...'),
(6, 'married', '1989-11-21', 'Днепр...'),
(7, 'not married', '1995-10-12', 'Одесса...'),
(8, 'married', '1997-08-10', 'Киев...'),
(9, 'married', '1989-09-03', 'Измаил...'),
(10, 'not married', '1984-03-22', 'Винница...');



