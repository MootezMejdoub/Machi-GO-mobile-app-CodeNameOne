/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Interest;
import com.mycompany.services.InterstService;
import java.io.IOException;


/**
 *
 * @author molka
 */
public class InterstForm extends Form {
    
    
        Resources theme;

         InterstService is = new InterstService();
    
         public InterstForm() throws IOException  {

                     super("Interst", BoxLayout.y());
            theme = UIManager.initFirstTheme("/theme");
      
               Label logi = new Label("Interst");
               
               
                                
                                  this.getToolbar().setUIID("tb");


               
               
               
               
               
               
               
               
               
               
               
               
               
               // current User://////////////////////////////////////////////////////////////////////////////////////////////
               for(Interest c: is.getInterstByUser(SessionManager.getId())){
           
 
                   this.add(addItem(c));
     
 
        }
    
}
         
         
    public Container addItem(Interest e) throws IOException{
            
        Container cn1=new Container(new BorderLayout());
        Container cn2=new Container(BoxLayout.y());
        Container cn3 = new Container(BoxLayout.y());
   
        
          Label libelle_food = new Label("Food :");
          libelle_food.setUIID("type1");
          Label libelle_health = new Label("Health :");
          libelle_food.setUIID("type1");
           Label libelle_history = new Label("History :");
          libelle_food.setUIID("type1");
          Label libelle_sport = new Label("Sport :");
          libelle_food.setUIID("type1");
          Label libelle_score = new Label("Score :");
          libelle_food.setUIID("type1"); 


          if (e.getFood().equals("true")){
          Label food=new Label("Yes");
          cn2.add(libelle_food).add(food);

          }
          else{
          Label food=new Label("No");
          cn2.add(libelle_food).add(food);
          }
          
          if (e.getHistory().equals("true")){
          Label history=new Label("Yes");
                  cn2.add(libelle_history).add(history);

          }
          else{
          Label history=new Label("No");
                  cn2.add(libelle_history).add(history);

          }
                    
          if (e.getHealth().equals("true")){
          Label health=new Label("Yes");
                  cn2.add(libelle_health).add(health);

          }
          else{
          Label health=new Label("No");
                  cn2.add(libelle_health).add(health);

          }
                              
          if (e.getSport().equals("true")){
          Label sport=new Label("Yes");
                  cn2.add(libelle_sport).add(sport);

          }
          else{
          Label sport=new Label("No");
                  cn2.add(libelle_sport).add(sport);

          }

          
       Label score=new Label(String.valueOf(e.getScore()));
  
        cn2.add(libelle_score).add(score);
        
      Button btn=new Button("Edit");
      
               cn3.add(btn);

      
      
              btn.addActionListener(e1->{
                  
            Form addPost = new Form("Edit Interst",BoxLayout.y());
            Label AJOUT = new Label("Edit Interst");
            addPost.add(AJOUT);
            
                CheckBox cb1 = new CheckBox("Food");
                
                CheckBox cb2 = new CheckBox("Healthy");

                CheckBox cb3 = new CheckBox("Sport");

                CheckBox cb4 = new CheckBox("History");


 

        Button save = new Button("Edit");
        addPost.add(cb1).add(cb2).add(cb3).add(cb4);
        addPost.add(save);

    
        save.addActionListener(l -> {

                           
                                Interest es = new Interest();
                                es.setIdIntrest(e.getIdIntrest());
                                
                                
                                if (cb1.isSelected())
                                    es.setFood("1");
                                else
                                     es.setFood("0");
                               
                                if (cb2.isSelected())
                                    es.setHealth("1");
                                else
                                     es.setHealth("0");

                                if (cb3.isSelected())
                                    es.setSport("1");
                                else
                                     es.setSport("0");
                                
                                if (cb4.isSelected())
                                    es.setHistory("1");
                                else
                                     es.setHistory("0");
                                
                                                                                                
                                                                
                                
                                
                                
                                
                                
                                
                                
                                if (is.ModifierInterst(es) == true) {
                                    Dialog.show("Interst", "Modefier Interst aves success ", "OK", null);
                                    try {
                                        new InterstForm().show();
                                    } catch (IOException ex) {
                                    }
                                    
                                    
                                } else {
                                    Dialog.show("Erreur", " Erreur d'ajout ", "OK", null);
                                }

                            

                        }
                        );
        
        addPost.show();
        });

          try {
                 ScaleImageLabel sep = new ScaleImageLabel(Image.createImage("/sepp.png"));
                
                        cn3.add(sep);

            } catch (IOException ex) {
            }
        cn2.add(cn3);
        cn1.add(BorderLayout.WEST, cn2);
      

        return cn1;
                
    }
    
         
         
         
         
         
         
         
         

}
