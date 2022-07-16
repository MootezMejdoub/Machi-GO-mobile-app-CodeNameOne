/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author bureau
 */
public class Utilisateur {
    private int id;
    private String nom,prenom,adresse,numTel,email,mdp;
   private Date dateNaissance;
private String type;
    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String prenom, String adresse, String numTel, String email, String mdp, Date dateNaissance, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numTel = numTel;
        this.email = email;
        this.mdp = mdp;
        this.dateNaissance = dateNaissance;
        this.type = type;
    }

    public Utilisateur(String nom, String prenom, String adresse, String numTel, String email, String mdp, Date dateNaissance, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numTel = numTel;
        this.email = email;
        this.mdp = mdp;
        this.dateNaissance = dateNaissance;
        this.type = type;
    }

    public Utilisateur(String nom, String prenom,String email) {
          this.nom = nom;
        this.prenom = prenom;
                this.email = email;

    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + ", nom=" + nom + ", prenom=" + prenom +  ", email=" + email +  '}';
    }
    
    
    
    
}
