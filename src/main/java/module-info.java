module com.example.seokyungkim_s3939114 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.seokyungkim_s3939114 to javafx.fxml;
    exports com.example.seokyungkim_s3939114;
    exports com.example.seokyungkim_s3939114.Controller;
    opens com.example.seokyungkim_s3939114.Controller to javafx.fxml;
    exports com.example.seokyungkim_s3939114.Request;
    opens com.example.seokyungkim_s3939114.Request to javafx.fxml;
    exports com.example.seokyungkim_s3939114.Model;
    opens com.example.seokyungkim_s3939114.Model to javafx.fxml;
}