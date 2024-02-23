# POSBoss

How to Run the project
You can open the Maven Projects window and click on HelloFX -> Plugins -> compiler -> compiler:compile to compile the project, and click on HelloFX -> Plugins -> javafx -> javafx:run to execute the project.Run project

Note: In case JAVA_HOME is not set to 17, running from the Maven Projects window might fail. To avoid it, you can add the correct java command to the javafx-maven-plugin: /path/to/jdk-12/bin/java.

The project can be also run from a terminal. Make sure JAVA_HOME is set to 13, and run mvn clean javafx:run.
