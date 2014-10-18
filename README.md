#JOOQ - DSL interne pour Java du langage SQL#

###Auteur###
Hacault Robin

###Installation et configuration###
- Télécharger et installer XAMPP pour MySQL : www.apachefriends.org
- Télécharger et extraire l'archive de JOOQ : www.jooq.org
- Télécharger Java MySQL connector : http://dev.mysql.com/downloads/connector/j/5.1.html
- Lancer XAMPP --> Manager Servers --> Start MySQL database (Changer le port de MySQL si échec)
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
    INSERT INTO `users` VALUES (4, 'Hacault', 'Robin', 21);
```
   Cette requête permet de créer une nouvelle base avec une table "users" remplie avec 5 tuples.
- Importer le projet IDM-SQL depuis GitHub dans Eclipse
- Ajouter ces 3 fichiers .jar de JOOQ au classpath du projet
  - jooq-3.4.4.jar
  - jooq-codegen-3.4.4.jar
  - jooq-meta-3.4.4.jar
- Et ajouter le .jar de Java MySQL connector
  - mysql-connector-java-5.1.33-bin.jar
- Ouvrir dans eclipse le fichier src/users.xml puis modifier
    - L'url de la database si le port que vous avez spécifié n'est pas 3307
    - Le login et mot de passe si besoin
    - L'inputschema si différent de "idmdatabase"
    - Le nom du package de destination pour le code généré, et le chemin correspondant
- Générer le code avec Jooq (à répéter à chaque modification de users.xml)
    - Clic-droit sur le projet --> Run as --> Run configurations
    - Créer une nouvelle configuration et sélectionner la classe main org.jooq.util.GenerationTool
    - Dans l'onglet arguments, mettre l'url de users.xml : /users.xml
    - Cliquer sur "Run", des fichiers utiles à Jooq vont être générés dans le package spécifié dans users.xml

Maintenant le paramétrage terminé, on va s'intéresser à l'utilisation de Jooq en tant que DSL interne de SQL.

###Utilisation###
La classe Queries contient 3 exemples de requêtes SQL vers la table users de idmdatabase, que nous avons configuré précédemment.

Il peut également être nécessaire de modifier dans ce fichier les variables contenant les informations de connexion à la base de données.

Dans le point d'entrée du programme, on se connecte à la base de données, et après les différentes vérifications, on lance 4 requêtes dont 3 différentes :
    - Sélection de tous les utilisateurs de la table users et affichage de tous les champs correspondants
    - Sélection des utilisateurs d'age compris entre 20 et 50
    - Incrémentation de l'age des utilisateurs dont le nom de famille commence par "D"
    - Sélection de tous les utilisateurs de la table users et affichage de tous les champs correspondants
    
Ainsi, ces exemples nous montrent que le DSL interne Jooq se montre très puissant pour l'exécution de requêtes SQL. Il nous permet de les effectuer en manipulant des objets et méthodes Java.

