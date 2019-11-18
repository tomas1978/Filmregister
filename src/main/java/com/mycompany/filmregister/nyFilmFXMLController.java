/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmregister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author tomas
 */
public class nyFilmFXMLController {
    @FXML
    private TextField titelTextBox;

    @FXML
    private TextField regissörTextBox;

    @FXML
    private TextField längdTextBox;

    @FXML
    private TextField betygTextBox;

    @FXML
    void läggTillFilmAction(ActionEvent event) {
        Film nyFilm=new Film(titelTextBox.getText(), regissörTextBox.getText(), 
                                Integer.parseInt(längdTextBox.getText()), 
                                Float.parseFloat(betygTextBox.getText()));
        System.out.println(nyFilm);
    }
}
