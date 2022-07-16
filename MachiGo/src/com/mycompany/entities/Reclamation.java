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
public class Reclamation {
  private int id,user_id;
    private String etat, description,reference;
   
    private String date;    
    public Reclamation() {
    }    

    public Reclamation(int id, int user_id, String etat, String description, String reference, String date) {
        this.id = id;
        this.user_id = user_id;
        this.etat = etat;
        this.description = description;
        this.reference = reference;
        this.date = date;
    }

    public Reclamation(String etat, String description, String reference, String date) {
        this.etat = etat;
        this.description = description;
        this.reference = reference;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   

    public Reclamation(int user_id, String description) {
        this.user_id = user_id;
        this.description = description;
    }

    public Reclamation(String description, String reference) {
        this.description = description;
        this.reference = reference;
    }

    public Reclamation(String description) {
        this.description = description;
    }
 
    
    
    
}

