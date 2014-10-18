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
- 

