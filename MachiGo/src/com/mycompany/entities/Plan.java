/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author Tox
 */
public class Plan {
    private int  id,prix,nmbrPlacesMax,nmbrPlacesReste,note,idGuide,pointDepart;
    private String titre,description,dateDebut,DateFin;
    private Date dateDebutt,DateFint;
    public Plan() {
    }

    public Plan(int id, int prix, int nmbrPlacesMax, int nmbrPlacesReste, int note, int idGuide, int pointDepart, String titre, String description) {
        this.id = id;
        this.prix = prix;
        this.nmbrPlacesMax = nmbrPlacesMax;
        this.nmbrPlacesReste = nmbrPlacesReste;
        this.note = note;
        this.idGuide = idGuide;
        this.pointDepart = pointDepart;
        this.titre = titre;
        this.description = description;
    }

    public Plan(int id, int prix, int nmbrPlacesMax, int nmbrPlacesReste, int note, int idGuide, int pointDepart, String titre, String description, String dateDebut, String DateFin) {
        this.id = id;
        this.prix = prix;
        this.nmbrPlacesMax = nmbrPlacesMax;
        this.nmbrPlacesReste = nmbrPlacesReste;
        this.note = note;
        this.idGuide = idGuide;
        this.pointDepart = pointDepart;
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.DateFin = DateFin;
    }

    public Plan(int prix, int nmbrPlacesMax, int nmbrPlacesReste, int note, String titre, String description) {
        this.prix = prix;
        this.nmbrPlacesMax = nmbrPlacesMax;
        this.nmbrPlacesReste = nmbrPlacesReste;
        this.note = note;
        this.titre = titre;
        this.description = description;
       
                
    }

    public Plan(int prix, int nmbrPlacesMax, int nmbrPlacesReste, int note, int idGuide, String titre, String description) {
        this.prix = prix;
        this.nmbrPlacesMax = nmbrPlacesMax;
        this.nmbrPlacesReste = nmbrPlacesReste;
        this.note = note;
        this.idGuide = idGuide;
        this.titre = titre;
        this.description = description;
    }

    public Plan(int prix, int nmbrPlacesMax, int nmbrPlacesReste, int note, int idGuide, int pointDepart, String titre, String description) {
        this.prix = prix;
        this.nmbrPlacesMax = nmbrPlacesMax;
        this.nmbrPlacesReste = nmbrPlacesReste;
        this.note = note;
        this.idGuide = idGuide;
        this.pointDepart = pointDepart;
        this.titre = titre;
        this.description = description;
    }

    public Plan(int prix, int nmbrPlacesMax, int nmbrPlacesReste, int note, int idGuide, int pointDepart, String titre, String description, String dateDebut, String DateFin) {
        this.prix = prix;
        this.nmbrPlacesMax = nmbrPlacesMax;
        this.nmbrPlacesReste = nmbrPlacesReste;
        this.note = note;
        this.idGuide = idGuide;
        this.pointDepart = pointDepart;
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.DateFin = DateFin;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNmbrPlacesMax() {
        return nmbrPlacesMax;
    }

    public void setNmbrPlacesMax(int nmbrPlacesMax) {
        this.nmbrPlacesMax = nmbrPlacesMax;
    }

    public int getNmbrPlacesReste() {
        return nmbrPlacesReste;
    }

    public void setNmbrPlacesReste(int nmbrPlacesReste) {
        this.nmbrPlacesReste = nmbrPlacesReste;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getIdGuide() {
        return idGuide;
    }

    public void setIdGuide(int idGuide) {
        this.idGuide = idGuide;
    }

    public int getPointDepart() {
        return pointDepart;
    }

    public void setPointDepart(int pointDepart) {
        this.pointDepart = pointDepart;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public void setDateFin(String DateFin) {
        this.DateFin = DateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
