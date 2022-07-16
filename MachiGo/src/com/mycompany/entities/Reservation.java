package com.mycompany.entities;



import java.util.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mbell
 */
public class Reservation {
    
    private int numReservation;
    
    private int nbrPlace ; 
    private Date dateDebut;
    private Date dateFin;
    private String datetestdebut,datetestfin;

    public String getDatetestfin() {
        return datetestfin;
    }

    public void setDatetestfin(String datetestfin) {
        this.datetestfin = datetestfin;
    }

    public String getDatetest() {
        return datetestdebut;
    }

    public void setDatetest(String datetest) {
        this.datetestdebut = datetest;
    }
    private String plan;
    private int idClient;
    
    
    public Reservation(){
        
    }

    public Reservation(int nbrPlace, Date dateDebut, Date dateFin, String plan) {
        this.nbrPlace = nbrPlace;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.plan = plan;
    }
    

    public Reservation(int numReservation, int nbrPlace, Date dateDebut, Date dateFin, String plan, int idClient) {
        this.numReservation = numReservation;
        this.nbrPlace = nbrPlace;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.plan = plan;
        this.idClient = idClient;
    }

    public int getNumReservation() {
        return numReservation;
    }

    public void setNumReservation(int numReservation) {
        this.numReservation = numReservation;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    
    
    
    
    
    
    
    
    
}
