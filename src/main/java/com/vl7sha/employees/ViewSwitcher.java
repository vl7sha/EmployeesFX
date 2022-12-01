package com.vl7sha.employees;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {

    public static Scene scene;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    public static void switchTo(View view){

        if(scene == null){
            System.out.println("No scene was set");
            return;
        }
        try {
            Parent root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFileName()));
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
