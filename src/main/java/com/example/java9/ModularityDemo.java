package com.example.java9;

/*
 * Bonjour à vous, élèves ! Ce fichier est un guide pour apprendre les modules introduits dans Java 9.
 * Vous allez transformer une petite application de gestion de bibliothèque en un projet modulaire.
 * Suivez les étapes ci-dessous pour comprendre comment organiser votre code avec le Java Platform Module System (JPMS).
 * Objectif : Migrer progressivement de Java 8 à Java 9, en maîtrisant les bases des modules.
 */

 /*
 * Étape 1 : Préparation de l’environnement
 * - Assurez-vous d’avoir un JDK 9 (ou supérieur) installé sur votre machine.
 * - Créez un dossier nommé "LibraryDemo" pour votre projet.
 * - Structure initiale (non modulaire pour commencer) :
 *   LibraryDemo/
 *   ├── src/
 *   │   ├── com/
 *   │       ├── library/
 *   │           ├── model/
 *   │           │   └── Book.java
 *   │           ├── app/
 *   │           │   └── Main.java
 */

 /*
 * Étape 2 : Code initial (non modulaire)
 * Commencez par créer ces deux fichiers pour une application simple sans modules.
 */

 /*
 * Fichier Book.java (dans src/com/library/model/)
 * Contenu :
 * package com.library.model;
 * public class Book {
 *     private String title;
 *     private String author;
 *     public Book(String title, String author) {
 *         this.title = title;
 *         this.author = author;
 *     }
 *     public String getTitle() { return title; }
 *     public String getAuthor() { return author; }
 *     @Override
 *     public String toString() { return title + " by " + author; }
 * }
 */

 /*
 * Fichier Main.java (dans src/com/library/app/)
 * Contenu :
 * package com.library.app;
 * import com.library.model.Book;
 * public class Main {
 *     public static void main(String[] args) {
 *         Book book = new Book("Le Petit Prince", "Antoine de Saint-Exupéry");
 *         System.out.println("Livre : " + book);
 *     }
 * }
 */

 /*
 * Testez votre code initial :
 * 1. Compilez depuis le dossier LibraryDemo :
 *    javac -d out src/com/library/model/Book.java src/com/library/app/Main.java
 * 2. Exécutez :
 *    java -cp out com.library.app.Main
 * Résultat attendu : "Livre : Le Petit Prince by Antoine de Saint-Exupéry"
 * Note : À ce stade, vous utilisez une structure classique de Java 8, sans modules.
 */

 /*
 * Étape 3 : Introduction des modules
 * Maintenant, vous allez modulariser votre projet. Modifiez la structure comme suit :
 *   LibraryDemo/
 *   ├── src/
 *   │   ├── com.library.model/
 *   │   │   ├── module-info.java
 *   │   │   └── com/
 *   │   │       ├── library/
 *   │   │           ├── model/
 *   │   │               └── Book.java
 *   │   ├── com.library.app/
 *   │   │   ├── module-info.java
 *   │   │   └── com/
 *   │   │       ├── library/
 *   │   │           ├── app/
 *   │   │               └── Main.java
 */

 /*
 * Ajoutez ces fichiers module-info.java :
 */

 /*
 * Fichier module-info.java (dans src/com.library.model/)
 * Contenu :
 * module com.library.model {
 *     exports com.library.model;
 * }
 * Explication : "exports" rend le package com.library.model accessible aux autres modules.
 */

 /*
 * Fichier module-info.java (dans src/com.library.app/)
 * Contenu :
 * module com.library.app {
 *     requires com.library.model;
 * }
 * Explication : "requires" indique que ce module dépend de com.library.model.
 */

 /*
 * Étape 4 : Compilation et exécution modulaire
 * 1. Compilez vos modules :
 *    javac -d out --module-source-path src $(find src -name "*.java")
 *    (Sur Windows, remplacez $(find src -name "*.java") par une liste explicite des fichiers si besoin.)
 * 2. Exécutez :
 *    java --module-path out --module com.library.app/com.library.app.Main
 * Résultat attendu : Identique à l’étape 2.
 * Note : "--module-path" remplace "-cp", et "--module" spécifie le module et la classe principale.
 */

 /*
 * Étape 5 : Expérimentez avec les modules
 * Essayez ces petites tâches pour mieux comprendre :
 * 1. Supprimez "exports com.library.model" dans com.library.model/module-info.java.
 *    - Recompilez et observez l’erreur. Que se passe-t-il ? Sans "exports", le package n’est plus accessible.
 * 2. Ajoutez une classe Library dans com.library.app qui utilise Book. Vérifiez que tout fonctionne.
 * 3. Retirez "requires com.library.model" dans com.library.app/module-info.java.
 *    - Recompilez. Pourquoi cela échoue-t-il ? Les dépendances doivent être explicites.
 */

 /*
 * Étape 6 : Réflexion
 * Posez-vous ces questions :
 * - Pourquoi les modules sont-ils utiles ? (Encapsulation, clarté des dépendances)
 * - Qu’est-ce qui change par rapport à Java 8 ?
 * - Comment cela prépare-t-il à Java 17 ? (Les modules évoluent avec des ajouts comme "requires transitive" dont on parlera dans la suite du cours)
 */

 /*
 * Bonus : Créez des fichiers JAR (facultatif)
 * 1. Créez un JAR pour com.library.model :
 *    jar --create --file out/com.library.model.jar -C out/com.library.model .
 * 2. Créez un JAR pour com.library.app :
 *    jar --create --file out/com.library.app.jar --main-class com.library.app.Main -C out/com.library.app .
 * 3. Exécutez :
 *    java --module-path out --module com.library.app
 * Note: si vous avez des erreurs du type "Two versions of module com.library.app found in out (com.library.app.jar and com.library.app)" c'est tout simplement parce
 * que dans JPMS (Java Module System), un module ne peut être défini qu'une seule fois dans le --module-path.
 * Avec cette erreur, vous comprenez que vous avez le module sous forme  de dossier compilé (out/com.library.app)
 * et le même module empaqueté en JAR (out/com.library.app.jar).
 * Donc, Java ne sait pas lequel choisir, d'où l'erreur.
 * Vous pouvez soit, supprimer le JAR et utiliser le dossier compilé, soit l'inverse
 * et n'utiliser que les JAR.
 */

 /*
 * Félicitations ! Vous avez créé votre premier projet modulaire avec Java 9.
 * Vous êtes prêts à explorer d’autres nouveautés ou à passer à Java 17.
 * Amusez-vous bien avec les modules !
 */
public class ModularityDemo {

    public static void main(String[] args) {
        System.out.println("Ouvrez le fichier src/main/java/com/example/java9/ModularityDemo.java pour suivre le tutoriel");
    }
}
