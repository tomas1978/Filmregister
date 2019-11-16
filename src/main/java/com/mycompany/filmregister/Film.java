/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filmregister;

/**
 *
 * @author tomas
 */
public class Film {
    private String titel;
    private String regissör;
    private int längd;
    private float imdbBetyg;

    public Film(String titel, String regissör, int längd, float imdbBetyg) {
        this.titel = titel;
        this.regissör = regissör;
        this.längd = längd;
        this.imdbBetyg = imdbBetyg;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getRegissör() {
        return regissör;
    }

    public void setRegissör(String regissör) {
        this.regissör = regissör;
    }

    public int getLängd() {
        return längd;
    }

    public void setLängd(int längd) {
        this.längd = längd;
    }

    public float getImdbBetyg() {
        return imdbBetyg;
    }

    public void setImdbBetyg(float imdbBetyg) {
        this.imdbBetyg = imdbBetyg;
    }

    @Override
    public String toString() {
        return "Film{" + "titel=" + titel + ", regiss\u00f6r=" + regissör + ", l\u00e4ngd=" + längd + ", imdbBetyg=" + imdbBetyg + '}';
    }
    
}
