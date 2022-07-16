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
import com.mycompany.entities.Plan;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServicesPlan;
import com.mycompany.services.ServicesReclamtion;

/**
 *
 * @author Lenovo
 */
public class ModifierPlanForm extends BaseForm {
    
    Form current;
    public ModifierPlanForm(Resources res ,Plan r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Plan");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
         TextField titre = new TextField(String.valueOf(r.getTitre()) , "Titre" , 20 , TextField.ANY);
        TextField description = new TextField(r.getDescription() , "Description" , 20 , TextField.ANY);
               TextField prix = new TextField(String.valueOf(r.getPrix()) , "Prix" , 20 , TextField.ANY);
               TextField max = new TextField(String.valueOf(r.getNmbrPlacesMax()) , "MaxPlaces" , 20 , TextField.ANY);
               
               TextField reste = new TextField(String.valueOf(r.getNmbrPlacesReste()) , "PlacesDispo" , 20 , TextField.ANY);
   TextField note = new TextField(String.valueOf(r.getNote()) , "Note" , 20 , TextField.ANY);

 
               
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
        
       // ComboBox etatCombo = new ComboBox();
        
     //   etatCombo.addItem("Non Traiter");
        
       // etatCombo.addItem("Traiter");
        
     
        
        
        
       
        description.setUIID("NewsTopLine");
        titre.setUIID("NewsTopLine");
         prix.setUIID("NewsTopLine");
        max.setUIID("NewsTopLine");
        reste.setUIID("NewsTopLine");
        note.setUIID("NewsTopLine");
        
        
        description.setSingleLineTextArea(true);
        titre.setSingleLineTextArea(true);
         prix.setSingleLineTextArea(true);
        max.setSingleLineTextArea(true); 
        reste.setSingleLineTextArea(true);
        note.setSingleLineTextArea(true);
        
        
        
        
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
          
           r.setDescription(description.getText());
            r.setTitre(titre.getText());
            
              r.setPrix(Integer.parseInt( (prix.getText()   )) );
              r.setNmbrPlacesMax(Integer.parseInt( (max.getText()   )) );
               r.setNmbrPlacesReste(Integer.parseInt( (reste.getText()   )) );
                r.setNote(Integer.parseInt( (note.getText()   )) );
         
           
      
       
       //appel fonction modfier reclamation men service
       
       if(ServicesPlan.getInstance().modifierPlan(r)) { // if true
           new ListePlanForm(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListePlanForm(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
              
                new FloatingHint(titre),
                createLineSeparator(),
                //etatCombo,
                new FloatingHint(description),
                createLineSeparator(),//ligne de séparation
                new FloatingHint(prix),
                createLineSeparator(),//ligne de séparation
                new FloatingHint(max),
                createLineSeparator(),//ligne de séparation
                new FloatingHint(reste),
                createLineSeparator(),//ligne de séparation
                new FloatingHint(note),
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}