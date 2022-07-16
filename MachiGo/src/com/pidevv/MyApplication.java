package com.pidevv;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.mycompany.gui.AddReservation;
import com.mycompany.gui.AjouterPlanForm;
import com.mycompany.gui.AjouterReclamationForm;
import com.mycompany.gui.InterstForm;
import com.mycompany.gui.ListeAll;
import com.mycompany.gui.ListePlanForm;
import com.mycompany.gui.ListeReclamationForm;
import com.mycompany.gui.SignInForm;
import com.mycompany.gui.SignUpForm;
import com.mycompany.gui.StatistiquePieForm;


/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
       // new ListeReclamationForm(theme).show();
       //new AjouterReclamationForm(theme).show();
      //  new SignInForm(theme).show();
      //new StatistiquePieForm(theme).show();
    //  new AjouterPlanForm(theme).show();
      //new ListePlanForm(theme).show();
     new SignUpForm(theme).show();
////        try {
////            new InterstForm().show();
////            //new ListeAll(theme).show();
////        } catch (IOException ex) {
////
////        }
   }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
