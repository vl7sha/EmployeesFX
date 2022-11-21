package com.vl7sha.employees;

public enum View {
    TITLE("title.fxml"),
    ADDENTITY("add-entity.fxml"),
    LISTENTITY("list-entity.fxml");

    private String fileName;

    View(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
}
