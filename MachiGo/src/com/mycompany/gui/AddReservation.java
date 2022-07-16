/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.gui;
import com.mycompany.entities.Reservation;
import com.codename1.components.InfiniteProgress;

import com.codename1.components.FloatingHint;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Dimension;
import com.mycompany.services.ServiceReservation;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Signup UI
 *
 * @author mbell
 */
public class AddReservation extends BaseForm {

    public AddReservation(Resources res) {
        super(new BorderLayout());
         super.addSideMenu(res);
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
        
        getContentPane().setScrollVisible(false);
        BrowserComponent browser = new BrowserComponent();
        browser.setURL("http://localhost/recaptcha.html");
         browser.setPreferredSize(new Dimension(200,900));
        
        
                
        TextField nbrplace = new TextField("", "Nombre de place", 20, TextField.NUMERIC);
        
        
        
        
        Picker datedebut=new Picker();
        datedebut.setType(Display.PICKER_TYPE_DATE);
        datedebut.setUIID("Date de debut");
        
        
        Picker datefin=new Picker();
        datefin.setType(Display.PICKER_TYPE_DATE);
        datefin.setUIID("Date de fin");
        
       
        

        TextField plan = new TextField("", "Plan", 20, TextField.ANY);
        
        nbrplace.setSingleLineTextArea(false);
        
        plan.setSingleLineTextArea(false);
        
        
        
        Button next = new Button("Ajouter");
        
       
        
        
        
        Container content = BoxLayout.encloseY(
                new Label("Reservation", "LogoLabel"),
                new FloatingHint(nbrplace),
                createLineSeparator(),
                datedebut,
                createLineSeparator(),
                datefin,
                createLineSeparator(),
                
                createLineSeparator(),
                new FloatingHint(plan),
                createLineSeparator()
                
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next
        ));
        next.requestFocus();
        next.addActionListener(e -> {
            try{
                
                
                
                
                try {
            int d = Integer.parseInt(nbrplace.getText());
        } catch (NumberFormatException nfe) {
            Dialog.show("Error", "nombre de place  doit etre numerique !", "OK", "Cancel"); 
        }
                
              
                
                
                if (nbrplace.getText().equals("")|| plan.getText().equals("") ){
                 Dialog.show("nombre de place et plan  ne doivent pas etre vide ","","Annuler", "OK");
                }
                
               
             
                else{
                
                InfiniteProgress ip = new InfiniteProgress();
                final Dialog iDialog = ip.showInfiniteBlocking();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Reservation res1=new Reservation(Integer.parseInt(nbrplace.getText()),datedebut.getDate(),datefin.getDate(),String.valueOf(plan.getText()));
                ServiceReservation.getInstance().AjouterReservation(res1);
                System.out.println("data = "+res1);
                iDialog.show();
                new ListeReservationForm(res).show();
                //new ListeAll(res).show();
                }
            }catch(Exception ex){
            ex.printStackTrace();
        }
            
               
              
            
            
            
            
            
            
            
        });
    }
    
    
        
    
    
    
    
    
    
}
