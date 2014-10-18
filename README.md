Dépôt de l'exercice "SQL" d'IDM

###Auteur###
Hacault Robin

###Installation et configuration###
- Télécharger et installer XAMPP pour MySQL : www.apachefriends.org
- Télécharger et extraire l'archive de JOOQ : www.jooq.org
- Télécharger Java MySQL connector : http://dev.mysql.com/downloads/connector/j/5.1.html
- Lancer XAMPP --> Manager Servers --> Start MySQL database (Changer le port de MySQL si échec)
- Importer le projet IDM-SQL depuis GitHub dans Eclipse
- Ajouter ces 3 fichiers .jar de JOOQ au classpath du projet
  - jooq-3.4.4.jar
  - jooq-codegen-3.4.4.jar
  - jooq-meta-3.4.4.jar
- Et ajouter le .jar de Java MySQL connector
  - mysql-connector-java-5.1.33-bin.jar
- Lancer PhpMyAdmin : http://localhost/phpmyadmin et aller à l'onglet "SQL"
- Exécuter la requête ci-dessous
``` sql
CREATE DATABASE idmdatabase;
USE idmdatabase;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `age` int NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
);
INSERT INTO `users` VALUES (0, 'Dupont', 'Toto', 18);
INSERT INTO `users` VALUES (1, 'Dupond', 'Tutu', 15);
INSERT INTO `users` VALUES (2, 'Durand', 'Tita', 35);
INSERT INTO `users` VALUES (3, 'Quentin', 'Jacques', 57);
```
Cette requête permet de créer une nouvelle base avec une table "users" remplie avec 10 tuples.

