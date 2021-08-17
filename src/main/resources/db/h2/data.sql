INSERT INTO access_level (ID, DESCRIPTION) VALUES
(1, 'None'),
(2, 'Employee'),
(3, 'Suport'),
(4, 'Administrator');

INSERT INTO locality (LOCALITY_ID, ACCESS_LEVEL_ID, DESCRIPTION) VALUES
(1, 1, 'Lobby'),
(2, 2, 'Parking Lot'),
(3, 4, 'Parking Lot'),
(4, 2, 'Office'),
(5, 3, 'Office'),
(6, 4, 'Office'),
(7, 3, 'Server Room');

INSERT INTO user_category (ID, DESCRIPTION) VALUES
(1, 'Visitor'),
(2, 'Outsourced'),
(3, 'Employed'),
(4, 'Administrator');

INSERT INTO work_journey (ID, DESCRIPTION) VALUES
(1, 'Intern'),
(2, 'PJ'),
(3, 'CLP');

INSERT INTO company (ID, DESCRIPTION, CNPJ, DISTRICT, CITY, STATE) VALUES
(1, 'POA Tech', '00.612.563/0001-30', 'Centro', 'Porto Alegre', 'RS');

INSERT INTO phone (ID, NUMBER, TYPE) VALUES
(1, '(53)3223-2332', 'COMMERCIAL'),
(2, '(53)3223-2334', 'COMMERCIAL');

INSERT INTO company_phones (COMPANY_ID, PHONES_ID) VALUES
(1, 1),
(1, 2);

INSERT INTO user (ID, NAME, USER_CATEGORY_ID, COMPANY_ID, ACCESS_LEVEL_ID, WORK_JOURNEY_ID, DELAY_TOLERANCE, BEGIN_JOURNEY, END_JOURNEY) VALUES
(1, 'Gabriel', 3, 1, 2, 2, 15, '2021-08-17 08:30:00', '2021-08-17 17:00:00');