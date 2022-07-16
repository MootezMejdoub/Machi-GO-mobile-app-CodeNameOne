/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Utilisateur;
import com.mycompany.services.ServiceUser;
import javafx.scene.control.ToolBar;

/**
 *
 * @author bureau
 */
public class AjoutUserForm extends BaseForm{
    Form current;
    
    public AjoutUserForm(Resources res)
    {
        super("Newsfeed",BoxLayout.y());
        Toolbar tb=new Toolbar(true);
        current=this;
        setToolbar(tb);
        getTitleArea().setUIID("container");
        setTitle("ajout user");
        getContentPane().setScrollVisible(false);
         TextField nom = new TextField("", "Nom");
               TextField prenom = new TextField("", "Prenom");
        nom.setUIID("TextFieldBlack");

         
         TextField email = new TextField("", "EMail");
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        addStringValue("nom", nom);
                addStringValue("prenom", prenom);
                        addStringValue("email", email);

        prenom.setUIID("TextFieldBlack");
                email.setUIID("TextFieldBlack");


        Button btnAjouter=new Button("ajouter");
        addStringValue("", btnAjouter);
        
        /////
       Button btnSupprimer=new Button("suuprimer");
        
        
        btnAjouter.addActionListener((e)-> 
        {
            try
            {
                if(nom.getText().length()== 0 || prenom.getText().length()==0 || email.getText().length()==0 )
                {
                    Dialog.show("verifier vos données","annuler","ok",null);
                }
                else
                {
                    System.out.println(nom.getText());
                                        System.out.println(prenom.getText());
                                                            System.out.println(email.getText());

                    System.out.println(String.valueOf(prenom.getText()).toString());
                    InfiniteProgress ip=new InfiniteProgress();
                    final Dialog iDialog=ip.showInfiniteBlocking();
               Utilisateur utilisateur= new Utilisateur(String.valueOf(nom.getText()).toString(),
               String.valueOf(prenom.getText()).toString(),
               String.valueOf(email.getText()).toString());
                    System.out.println("data user=="+utilisateur.toString());
                    ServiceUser.getInstance().ajouterUser(utilisateur);
                    iDialog.dispose();
                    
                    ///affichage///
                new ListUsersForm(res).show();
                    
                    refreshTheme();
                }
                
                    
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        });
    
       
    }
    private void addStringValue(String s,Component v)
    {
      add(BorderLayout.west(new Label(s,"PaddelLabel"))
      .add(BorderLayout.CENTER,v));
      add(createLineSeparator(0xeeeeee));
    }
    
}
