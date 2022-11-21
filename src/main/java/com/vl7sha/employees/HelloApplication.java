package com.vl7sha.employees;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new AnchorPane());

        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.TITLE);

        stage.setTitle("Приложение");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}