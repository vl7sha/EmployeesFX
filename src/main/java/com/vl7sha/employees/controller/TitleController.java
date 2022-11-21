package com.vl7sha.employees.controller;//

import com.vl7sha.employees.View;
import com.vl7sha.employees.ViewSwitcher;
import javafx.event.ActionEvent;

public class TitleController {// титульная страница кнопик перехода на страницы


    public void onPageAdd(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.ADDENTITY);
    }

    public void onPageList(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LISTENTITY);
    }
}
