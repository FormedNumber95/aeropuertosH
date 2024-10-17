module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
	requires javafx.base;
    opens ctrl to javafx.fxml;
    exports es.aketzagonzalez.aeropuertosH;
    exports modelos;
    exports db;
}