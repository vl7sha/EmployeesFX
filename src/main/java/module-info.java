module com.vl7sha.employees {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.vl7sha.employees to javafx.fxml;
    exports com.vl7sha.employees;
    exports com.vl7sha.employees.controller;
    exports com.vl7sha.employees.model;
    exports com.vl7sha.employees.util;
    exports com.vl7sha.employees.service;
}