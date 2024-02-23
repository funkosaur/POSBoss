# POSBoss

How to Run the project in IntelliJ
Open the Maven Projects window (View -> Tool Windows -> Maven) and click on demo -> Plugins -> compiler -> compiler:compile to compile the project, and click on demo -> Plugins -> javafx -> javafx:run to execute the project.

#

Note: In case JAVA_HOME is not set to 17 or greater, running from the Maven Projects window might fail. To avoid it, you can either add an environmental variable to Maven Runner:JavaHomeor set the correct java command to the javafx-maven-plugin: <configuration><executable>/path/to/jdk-21/bin/java</executable></configuration>.
The project can be also run from a terminal. Make sure JAVA_HOME is set to 11 or greater, and run mvn clean javafx:run.
