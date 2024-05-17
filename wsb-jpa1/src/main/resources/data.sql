-- Tworzenie adresu
INSERT INTO address (id, address_line1, address_line2, city, postal_code)
VALUES (1, 'xx', 'yy', 'city', '62-030');

-- Dodanie kolumny DELETED do tabeli doctor i wstawienie danych
ALTER TABLE doctor ADD COLUMN DELETED BOOLEAN DEFAULT FALSE NOT NULL;
INSERT INTO doctor (first_name, last_name, telephone_number, email, doctor_number, specialization, DELETED)
VALUES ('Anna', 'Kowalska', '555-100-100', 'akowalska@clinic.com', '12345', 'Kardiolog', FALSE),
       ('Piotr', 'Nowak', '555-200-200', 'pnowak@clinic.com', '67890', 'Pediatra', FALSE);

-- Wstawianie danych do tabeli patient
INSERT INTO patient (first_name, last_name, date_of_birth, telephone_number, email, patient_number, address_id)
VALUES ('Ewa', 'Maj', '1990-05-20', '555-300-300', 'emaj@gmail.com', 'PN001', 1),
       ('Marek', 'Biały', '2005-10-11', '555-400-400', 'mbiały@gmail.com', 'PN002', 1);

-- Wstawianie danych do tabeli visit
INSERT INTO visit (description, time, doctor_id, patient_id)
VALUES ('Rutynowa Kontrola', '2024-04-20 10:00:00', 1, 1),
       ('Rutynowa Kontrola', '2024-05-20 10:00:00', 1, 1),
       ('Rutynowa Kontrola', '2024-06-20 10:00:00', 1, 1),
       ('Zabieg Pediatryczny', '2024-04-20 10:00:00', 2, 2);

-- Wstawianie danych do tabeli medical_treatment
INSERT INTO medical_treatment (description, type, visit_id)
VALUES ('Porbranie krwi', 'sprawdzenie', 1),
       ('Szczepienie na Covid', 'szczepionka', 2);

--znalezienie pacjentów po nazwisku
SELECT * FROM patient WHERE last_name = 'Maj';

-- Znajdź wszystkie wizyty pacjenta po jego ID
SELECT * FROM visit WHERE patient_id = 1;

--Znajdź pacjentów, którzy mieli więcej niż X wizyt
SELECT p.*
FROM patient p
WHERE (SELECT COUNT(*) FROM visit v WHERE v.patient_id = p.id) > 2;

--Znajdź pacjentów po dodanym przez Ciebie polu - np. data urodzenia
SELECT * FROM patient WHERE date_of_birth > '1989-01-01';
