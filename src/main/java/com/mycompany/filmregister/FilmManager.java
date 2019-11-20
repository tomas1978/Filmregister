/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmregister;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author tomas
 */
public class FilmManager {
    private final List<Film> filmlista = new ArrayList<>();
    private ObservableList<Film> obsFilmLista;
    
    public void läggTillFilm(Film nyFilm) {
        filmlista.add(nyFilm);
        obsFilmLista.add(nyFilm);
    }

    public ObservableList<Film> getObsFilmLista() {
        return obsFilmLista;
    }

    public void setObsFilmLista(ObservableList<Film> obsFilmLista) {
        this.obsFilmLista = obsFilmLista;
    }

    public FilmManager() {
        this.obsFilmLista = FXCollections.observableList(filmlista);
    }

    public List<Film> getFilmlista() {
        return filmlista;
    }

    @Override
    public String toString() {
        return "FilmManager{" + "filmlista=" + filmlista + '}';
    }
}
