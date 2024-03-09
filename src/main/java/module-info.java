module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // Add missing module declaration for java.sql

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
}