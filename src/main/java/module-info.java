module com.example.toxic_pizzaui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.toxic_pizzaui to javafx.fxml;
    exports com.example.toxic_pizzaui;
    exports com.example.toxic_pizzaui.controller;
    opens com.example.toxic_pizzaui.controller to javafx.fxml;
}