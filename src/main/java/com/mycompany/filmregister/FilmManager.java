/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmregister;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomas
 */
public class FilmManager {
    private List<Film> filmlista = new ArrayList<>();
    
    public void läggTillFilm(Film nyFilm) {
        filmlista.add(nyFilm);
    }

    public List<Film> getFilmlista() {
        return filmlista;
    }

    public void setFilmlista(List<Film> filmlista) {
        this.filmlista = filmlista;
    }
    
    

    @Override
    public String toString() {
        return "FilmManager{" + "filmlista=" + filmlista + '}';
    }
}
