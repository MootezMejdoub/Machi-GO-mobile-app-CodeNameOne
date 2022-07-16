/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author molka
 */
public class Interest {
    private int idIntrest;
    private String sport;
    private String history;
    private String food;
    private String health;
    private int score;

    public int getIdIntrest() {
        return idIntrest;
    }

    public void setIdIntrest(int idIntrest) {
        this.idIntrest = idIntrest;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Interest(int idIntrest, String sport, String history, String food, String health, int score) {
        this.idIntrest = idIntrest;
        this.sport = sport;
        this.history = history;
        this.food = food;
        this.health = health;
        this.score = score;
    }

    public Interest(String sport, String history, String food, String health, int score) {
        this.sport = sport;
        this.history = history;
        this.food = food;
        this.health = health;
        this.score = score;
    }

    public Interest() {
    }
    
    
    @Override
    public String toString() {
        return "Interest{" + "sport=" + sport + ", history=" + history + ", food=" + food + ", health=" + health + ", score=" + score + '}';
    }
    
    
    
    
    
    
}
