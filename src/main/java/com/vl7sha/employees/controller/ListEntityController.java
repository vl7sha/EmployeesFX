package com.vl7sha.employees.controller;

import com.vl7sha.employees.View;
import com.vl7sha.employees.ViewSwitcher;
import com.vl7sha.employees.model.Entity;
import com.vl7sha.employees.service.EntityService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListEntityController  implements Initializable {// вывод всех сотрудников и по поику
    private final EntityService entityService = new EntityService();

    public TableView<Entity> table;
    public TableColumn<Entity, Integer> idcolnm;
    public TableColumn<Entity, String>  namecolnm;
    public TableColumn<Entity, String>  managercolnm;
    public TableColumn<Entity, Double>  salarycolnm;
    public TableColumn<Entity, String>  namesubcolnm;
    public TableColumn<Entity, String> departcitycolnm;
    public TableColumn<Entity, Integer> categcolnm;
    public Button bntTitle;
    public Button bntDelete;
    public Button bntAdd;
    public Button bntSearch;
    public TextField txtidsearch;


    public void onPageAdd(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.ADDENTITY);
    }

    public void table() throws SQLException {

      try {
          ObservableList<Entity> entities = FXCollections.observableList(entityService.getAll());

          idcolnm.setCellValueFactory(new PropertyValueFactory<Entity,Integer>("idEmployee"));// парсинг в нужную ячейку
          namecolnm.setCellValueFactory(new PropertyValueFactory<Entity,String>("name"));
          managercolnm.setCellValueFactory(new PropertyValueFactory<Entity,String>("manager"));
          salarycolnm.setCellValueFactory(new PropertyValueFactory<Entity,Double>("salary"));
          namesubcolnm.setCellValueFactory(new PropertyValueFactory<Entity,String>("nameSubdivision"));
          departcitycolnm.setCellValueFactory(new PropertyValueFactory<Entity,String>("departmentCityLocation"));
          categcolnm.setCellValueFactory(new PropertyValueFactory<Entity,Integer>("categoryETS"));

          table.setItems(entities);
      } catch (Exception e){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Error");
          alert.setHeaderText("Error");
          alert.setContentText(e.getMessage());
          alert.showAndWait();
          table();
      }

    }

    public void delete(ActionEvent actionEvent) throws SQLException {
       try {
           int myIndex = table.getSelectionModel().getSelectedIndex();
           int id =Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getIdEmployee()));

           entityService.delete(id);

           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Student Registationn");

           alert.setHeaderText("Student Registation");
           alert.setContentText("Deletedd!");

           alert.showAndWait();
           table();
       } catch (Exception e){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Error");
           alert.setHeaderText("Error");
           alert.setContentText(e.getMessage());
           alert.showAndWait();
           table();
       }

    }

    public void onPageTitle(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.TITLE);
    }

    public void search(ActionEvent actionEvent) throws SQLException {
      try{
          ObservableList<Entity> entities = FXCollections.observableArrayList(
                  entityService.getById(
                          Integer.parseInt(
                                  txtidsearch.getText())));

          idcolnm.setCellValueFactory(new PropertyValueFactory<Entity,Integer>("idEmployee"));
          namecolnm.setCellValueFactory(new PropertyValueFactory<Entity,String>("name"));
          managercolnm.setCellValueFactory(new PropertyValueFactory<Entity,String>("manager"));
          salarycolnm.setCellValueFactory(new PropertyValueFactory<Entity,Double>("salary"));
          namesubcolnm.setCellValueFactory(new PropertyValueFactory<Entity,String>("nameSubdivision"));
          departcitycolnm.setCellValueFactory(new PropertyValueFactory<Entity,String>("departmentCityLocation"));
          categcolnm.setCellValueFactory(new PropertyValueFactory<Entity,Integer>("categoryETS"));

          table.setItems(entities);
      } catch (Exception e){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Error");
          alert.setHeaderText("Error");
          alert.setContentText(e.getMessage());
          alert.showAndWait();
          table();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            table();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
