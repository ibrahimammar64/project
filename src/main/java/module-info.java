module com.mycompany.project {
    requires javafx.controls;
    requires java.sql;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.project to javafx.fxml;
    exports com.mycompany.project;
}
