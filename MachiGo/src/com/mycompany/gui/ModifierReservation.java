/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Reservation;
import com.mycompany.services.ServiceReservation;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.spinner.Picker;
import java.util.Date;


/**
 *
 * @author mbell
 */
public class ModifierReservation extends BaseForm{
   
    Form current;
    public ModifierReservation(Resources res, int num,String planres,int nbr ) {
         super("Reservation",BoxLayout.y()); 
           
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
         Reservation r =new Reservation();
         
         
           System.out.println(num);
         String placeVal = String.valueOf(r.getNbrPlace());
        TextField nbrplace = new TextField(String.valueOf(nbr), "place" , 20 , TextField.ANY);
        
        Picker datedebut=new Picker();
        datedebut.setType(Display.PICKER_TYPE_DATE);
        datedebut.setUIID("Date de debut");
        
        
        Picker datefin=new Picker();
        datefin.setType(Display.PICKER_TYPE_DATE);
        datefin.setUIID("Date de fin");
        

        TextField plan = new TextField(planres, "Plan", 20, TextField.ANY);
        
        nbrplace.setSingleLineTextArea(false);
        
        plan.setSingleLineTextArea(false);
        
        
       
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
           
           
          /*  try {
            int d = Integer.parseInt(nbrplace.getText());
        } catch (NumberFormatException nfe) {
            Dialog.show("Error", "nombre de place  doit etre numerique !", "OK", "Cancel"); 
        }*/
           
           
           
           if (nbrplace.getText().equals("")){
                 Dialog.show("nombre de place et plan  ne doivent pas etre vide ","","Annuler", "OK");
                }
           else{
           r.setNumReservation(num);
           r.setNbrPlace(Integer.parseInt(nbrplace.getText()));
           r.setDateDebut((Date) datedebut.getValue());
           r.setDateFin((Date) datefin.getValue()); 
         
       
       
       
       if(ServiceReservation.getInstance().modifierReservation(r)) { // if true
           new ListeReservationForm(res).show();
       }
           }
       
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           
           
           new ListeReservationForm(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(nbrplace),
                createLineSeparator(),
                datedebut,
                createLineSeparator(),
                datefin,
                createLineSeparator(),//ligne de séparation
                new FloatingHint(plan),
                createLineSeparator(),
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
    
    
    
    
}
