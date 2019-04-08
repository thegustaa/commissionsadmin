-- Script para carga de datos --

USE `commissionsAdminDb`;
DELETE FROM `CommissionStudent`;
DELETE FROM `StudentSituation`;
DELETE FROM `Student`;
DELETE FROM `Commission`;
DELETE FROM `Timeshift`;
DELETE FROM `Semester`;
DELETE FROM `Professorship`;
DELETE FROM `Subject`;
DELETE FROM `Career`;
DELETE FROM `Faculty`;

INSERT INTO `Faculty` (id, name) VALUES (2, "Facultad de Ingeniería");
INSERT INTO `Faculty` (id, name) VALUES (3, "Facultad de Medicina");

INSERT INTO `Career` (id, name, id_faculty) VALUES (3, "Ingeniería Civil", 2);
INSERT INTO `Career` (id, name, id_faculty) VALUES (4, "Ingeniería Informática", 2);
INSERT INTO `Career` (id, name, id_faculty) VALUES (5, "Neurología", 3);

INSERT INTO `Subject` (id, name, id_career) VALUES (3, "Análisis Matemático I", 3);
INSERT INTO `Subject` (id, name, id_career) VALUES (4, "Análisis Matemático II", 3);
INSERT INTO `Subject` (id, name, id_career) VALUES (5, "Algoritmos I", 4);
INSERT INTO `Subject` (id, name, id_career) VALUES (6, "Algoritmos II", 4);
INSERT INTO `Subject` (id, name, id_career) VALUES (7, "Análisis Matemático III", 4);
INSERT INTO `Subject` (id, name, id_career) VALUES (8, "Otorrinonaringologia", 5);
INSERT INTO `Subject` (id, name, id_career) VALUES (9, "Anatomia Cerebral", 5);

INSERT INTO `Professorship` (id, name, id_subject) VALUES (1, "Balduino, Blanco", 3);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (2, "Baltasar, Blesa", 3);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (3, "Babara, Bravo", 4);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (4, "Bartolome Caballero", 4);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (5, "Basileo, Cabrera", 5);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (6, "Beatriz, Calvo", 5);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (7, "Bego, Cambil", 6);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (8, "Bel, Campos", 6);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (9, "Beltrán, Cano", 7);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (10, "Benedicto, Carmona", 7);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (11, "Benigno, Carrasco", 8);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (12, "Benito, Castillo", 8);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (13, "Benjamín, Castro", 9);
INSERT INTO `Professorship` (id, name, id_subject) VALUES (14, "Bernaba Corte", 9);

INSERT INTO `Semester` (id, name) VALUES ("P", "1er sem.");
INSERT INTO `Semester` (id, name) VALUES ("S", "2do sem.");

INSERT INTO `Timeshift` (id, name) VALUES ("M", "Mañana");
INSERT INTO `Timeshift` (id, name) VALUES ("T", "Tarde");
INSERT INTO `Timeshift` (id, name) VALUES ("N", "Noche");

INSERT INTO `StudentSituation` (id, name) VALUES ("R", "Regular");
INSERT INTO `StudentSituation` (id, name) VALUES ("L", "Libre");

INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (1, "2019", "P", 1, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (2, "2019", "P", 2, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (3, "2019", "P", 3, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (4, "2019", "S", 4, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (5, "2019", "P", 5, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (6, "2019", "P", 6, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (7, "2019", "S", 7, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (8, "2019", "P", 8, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (9, "2019", "S", 9, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (10, "2019", "P", 10, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (11, "2019", "P", 11, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (12, "2019", "P", 12, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (13, "2019", "P", 13, "M");
INSERT INTO `Commission` (id, year, id_semester, id_professorship, id_timeshift) VALUES (14, "2019", "P", 14, "M");

INSERT INTO `Student` (id, firstname, lastname) VALUES (1, "Guido","Muñoz");
INSERT INTO `Student` (id, firstname, lastname) VALUES (2, "Guillermo","Navarro");
INSERT INTO `Student` (id, firstname, lastname) VALUES (3, "Gustavo","Nieto");
INSERT INTO `Student` (id, firstname, lastname) VALUES (4, "Guzmán","Naiz");
INSERT INTO `Student` (id, firstname, lastname) VALUES (5, "Héctor","Ortega");
INSERT INTO `Student` (id, firstname, lastname) VALUES (6, "Heliodoro","Ortiz");
INSERT INTO `Student` (id, firstname, lastname) VALUES (7, "Heraclio","Parra");
INSERT INTO `Student` (id, firstname, lastname) VALUES (8, "Heriberto","Pascual");
INSERT INTO `Student` (id, firstname, lastname) VALUES (9, "Hilaria","Pastor");
INSERT INTO `Student` (id, firstname, lastname) VALUES (10, "Hildegarda","Peña");
INSERT INTO `Student` (id, firstname, lastname) VALUES (11, "Homero","Páez");
INSERT INTO `Student` (id, firstname, lastname) VALUES (12, "Honorato","Prieto");
INSERT INTO `Student` (id, firstname, lastname) VALUES (13, "Honorio","Ramirez");
INSERT INTO `Student` (id, firstname, lastname) VALUES (14, "Hugo","Ramos");
INSERT INTO `Student` (id, firstname, lastname) VALUES (15, "Humberto","Rey");
INSERT INTO `Student` (id, firstname, lastname) VALUES (16, "Ifigenia","Reyes");
INSERT INTO `Student` (id, firstname, lastname) VALUES (17, "Ignacio","Rodriguez");
INSERT INTO `Student` (id, firstname, lastname) VALUES (18, "Ildefonso","Roma");
INSERT INTO `Student` (id, firstname, lastname) VALUES (19, "Inés","Romero");
INSERT INTO `Student` (id, firstname, lastname) VALUES (20, "Inmaculada","Rubio");
INSERT INTO `Student` (id, firstname, lastname) VALUES (21, "Inocencio","Ruiz");
INSERT INTO `Student` (id, firstname, lastname) VALUES (22, "Irene","Sáez");
INSERT INTO `Student` (id, firstname, lastname) VALUES (23, "Ireneo","Sanchez");
INSERT INTO `Student` (id, firstname, lastname) VALUES (24, "Isaac","Santana");
INSERT INTO `Student` (id, firstname, lastname) VALUES (25, "Isabel","Santiago");
INSERT INTO `Student` (id, firstname, lastname) VALUES (26, "Isaac","Santos");
INSERT INTO `Student` (id, firstname, lastname) VALUES (27, "Isidro","Sanz");
INSERT INTO `Student` (id, firstname, lastname) VALUES (28, "Ismael","Serrano");
INSERT INTO `Student` (id, firstname, lastname) VALUES (29, "Iván","Soler");
INSERT INTO `Student` (id, firstname, lastname) VALUES (30, "Jacinto","Soto");
INSERT INTO `Student` (id, firstname, lastname) VALUES (31, "Jacob","Suaez");
INSERT INTO `Student` (id, firstname, lastname) VALUES (32, "Jacobo","Torres");
INSERT INTO `Student` (id, firstname, lastname) VALUES (33, "Jaime","Vargas");
INSERT INTO `Student` (id, firstname, lastname) VALUES (34, "Jaume","Vázquez");
INSERT INTO `Student` (id, firstname, lastname) VALUES (35, "Javier","Vega");
INSERT INTO `Student` (id, firstname, lastname) VALUES (36, "Jeremis","Velasco");
INSERT INTO `Student` (id, firstname, lastname) VALUES (37, "Jerimo","Vicente");
INSERT INTO `Student` (id, firstname, lastname) VALUES (38, "Jesús","Vidal");

INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (1, null, 1, "R", 1);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (2, null, 1, "R", 2);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (3, null, 1, "L", 3);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (4, null, 1, "L", 4);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (5, null, 1, "R", 5);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (6, null, 1, "R", 6);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (7, null, 2, "R", 2);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (8, null, 3, "R", 3);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (9, null, 4, "R", 4);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (10, null, 5, "R", 5);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (11, null, 6, "L", 6);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (12, null, 7, "R", 7);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (13, null, 8, "R", 8);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (14, null, 9, "R", 9);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (15, null, 10, "L", 10);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (16, null, 11, "R", 11);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (17, null, 12, "R", 12);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (18, null, 13, "R", 13);
INSERT INTO `CommissionStudent` (id, finalscore, id_commission, id_studentsituation, id_student) VALUES (19, null, 14, "R", 14);




