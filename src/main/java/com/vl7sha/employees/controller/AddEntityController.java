package com.vl7sha.employees.controller;

import com.vl7sha.employees.View;
import com.vl7sha.employees.ViewSwitcher;
import com.vl7sha.employees.model.Entity;
import com.vl7sha.employees.service.EntityService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddEntityController {
    private Entity entity;
    private EntityService entityService;
    public Label name;
    public TextField txtname;
    public Label manager;
    public TextField txtmanager;
    public Label salary;
    public TextField txtsalary;
    public TextField txtnamesubdivision;
    public TextField txtdepartmentcitylocation;
    public TextField txtcategoryets;
    public Button bntTitle;
    public Button bntAdd;
    public Button bntList;

    public void onPageList(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LISTENTITY);
    }

    public void add(ActionEvent actionEvent) {
        entity = new Entity();
        entityService = new EntityService();

        try {
            entity.setName(txtname.getText());
            entity.setManager(txtmanager.getText());
            entity.setSalary(Integer.parseInt(txtsalary.getText()));
            entity.setNameSubdivision(txtnamesubdivision.getText());
            entity.setDepartmentCityLocation(txtdepartmentcitylocation.getText());
            entity.setCategoryETS(Integer.parseInt(txtcategoryets.getText()));

            entityService.add(entity);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registation");

            alert.setHeaderText("Student Registation");
            alert.setContentText("Record Addedddd!");

            alert.showAndWait();


            txtname.setText("");
            txtmanager.setText("");
            txtsalary.setText("");
            txtnamesubdivision.setText("");
            txtdepartmentcitylocation.setText("");
            txtcategoryets.setText("");

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void onPageTitle(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.TITLE);
    }
}
