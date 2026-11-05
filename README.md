# GestionNotes

Application console de gestion des notes d'une promotion, en Java.
Réalisée dans le cadre du module R1.01 (Initiation au développement, cycle 3) du BUT Informatique.

Deux profils sont proposés :

- **Étudiant** : consulter ses notes par UE et par semestre, ainsi que la moyenne, le minimum et le maximum de chaque UE, et savoir si l'année est validée.
- **Directeur des études** : afficher les notes, les moyennes et les absences des étudiants, modifier une moyenne, gérer les tuteurs.

Les données sont générées aléatoirement au lancement.

## Lancer le programme

```bash
javac -d out src/gestionnotes/GestionNotes.java
java -cp out gestionnotes.GestionNotes
```

## Lancer les tests (JUnit 4)

```bash
javac -cp junit-4.13.2.jar -d out src/gestionnotes/GestionNotes.java test/gestionnotes/GestionNotesTest.java
java -cp out:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore gestionnotes.GestionNotesTest
```

5 tests sur 7 passent. Les tests de gestion des tuteurs (`testplusTutrice`, `testminusTutrice`) échouent encore.
