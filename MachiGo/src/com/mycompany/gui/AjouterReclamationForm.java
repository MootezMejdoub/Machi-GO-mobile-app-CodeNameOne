///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.gui;
//
//import com.codename1.components.InfiniteProgress;
//import com.codename1.ui.Button;
//import com.codename1.ui.Command;
//import com.codename1.ui.Dialog;
//import com.codename1.ui.Form;
//import com.codename1.ui.Label;
//import com.codename1.ui.TextField;
//import com.codename1.ui.Toolbar;
//import com.codename1.ui.events.ActionEvent;
//import com.codename1.ui.events.ActionListener;
//import com.codename1.ui.layouts.BorderLayout;
//import com.codename1.ui.layouts.BoxLayout;
//import com.codename1.ui.util.Resources;
//import com.mycompany.entities.Reclamation;
//import com.mycompany.services.ServicesReclamtion;
////import static com.mycompany.services.ServicesReclamtion.reference;
////import java.time.LocalDate;
////import java.time.format.DateTimeFormatter;
//
///**
// *
// * @author Tox
// */
//public class AjouterReclamationForm extends BaseForm{
//    Form current;
//    public AjouterReclamationForm(Resources res){
//        super("Newsfeed",BoxLayout.y());
//        Toolbar tb=new Toolbar(true);
//        current =this;
//        setToolbar(tb);
//        getTitleArea().setUIID("container");
//        setTitle("Ajouter Reclamation");
//        getContentPane().setScrollVisible(false);
//        
//        TextField description= new TextField("","enter description");
//                description.setUIID("TextFieldBlack");
//                addStringValue("Description",description);
//               
//                Button btnAjouter=new Button("ajouter");
//                addStringValue("", btnAjouter);
//
////            @Override
////            public void actionPerformed(ActionEvent evt) {
////                if ((description.getText().length()==0))
////                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
////                else
////                {
////                    try {
////                         Reclamation r=new Reclamation(String.valueOf(description.getText().toString()));
////                    System.out.println("data reclamation =="+r);
////                    ServicesReclamtion.getInstance().ajouterReclamation(r);
////                       
////                    } catch (NumberFormatException e) {
////                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
////                    }
////                    
////                }
////                
////                
////            }
////        });
//        btnAjouter.addActionListener(e->{
//            try  {
//                if(description.getText()==""){
//                    Dialog.show("verifier vos donnees!","","annuler","OK");
//                    
//                }
//                else{
//                    InfiniteProgress ip =new InfiniteProgress();
//                    
//                    final Dialog iDialog=ip.showInfiniteBlocking();
//                     
//                            
//       
//        Reclamation r=new Reclamation(String.valueOf(description.getText().toString()));
//                    System.out.println("data reclamation =="+r);
//                    ServicesReclamtion.getInstance().ajouterReclamation(r);
//                    Dialog.show("Success","Reclamation envoyee",new Command("OK"));
//                    iDialog.dispose();
//                
//                    refreshTheme();
//                }
//                    
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//        });
//        
//    }
//
//    private void addStringValue(String s    , TextField v) {
//
//        
//        add(BorderLayout.west(new Label(s,"PaddedLabel")).add(BorderLayout.CENTER,v));
//        add(   createLineSeparator(0xeeeeee));
//         
//    }
//
//    private void addStringValue(String string, Button btnAjouter) {
//add(BorderLayout.west(new Label(string,"PaddedLabel")).add(BorderLayout.CENTER,btnAjouter));
//        add(   createLineSeparator(0xeeeeee));
//             }
//
//   
//}





////////////




package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServicesReclamtion;
import com.mycompany.utils.SmsWhatsapp;
import java.util.ArrayList;
import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.smtp.SMTPTransport;
import com.twilio.Twilio;
import java.util.Properties;



/**
 *
 * @author Lenovo
 */
public class AjouterReclamationForm extends BaseForm {
    
    

    Form current;
    public AjouterReclamationForm(Resources res ) {
        super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    super.addSideMenu(res);
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
        
        
        tb.addSearchCommand(e ->  {
            
        });
        
        Tabs swipe = new Tabs();
        
        Label s1 = new Label();
        Label s2 = new Label();
        
        addTab(swipe,s1, res.getImage("back-logo.jpeg"),"","",res);
        
        //
        
         swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Stats", barGroup);
        mesListes.setUIID("SelectBar");
       
        RadioButton partage = RadioButton.createToggle("Reclamer", barGroup);
        partage.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("Liste Rec", barGroup);
        liste.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");
        
        liste.addActionListener((e) -> {
            new ListeReclamationForm(res).show();
               InfiniteProgress ip = new InfiniteProgress();
        
        
        //  ListReclamationForm a = new ListReclamationForm(res);
          //  a.show();
           
        });

        mesListes.addActionListener((e) -> {
            new StatistiquePieForm(res).show();
               InfiniteProgress ip = new InfiniteProgress();
        
    
        //  ListReclamationForm a = new ListReclamationForm(res);
        //  a.show();
           
        });
        

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes, liste, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

        
        //
        
      
    
        
        TextField description = new TextField("", "entrer description!!");
        description.setUIID("TextFieldBlack");
        addStringValue("Description",description);
        
        
        Button btnAjouter = new Button("Ajouter");
        addStringValue("", btnAjouter);
        
        
        //onclick button event 

        btnAjouter.addActionListener((e) -> {
            
            
            try {
                
                if( description.getText().equals("")||description.getText().equals("0")||description.getText().equals("00")||description.getText().equals("1")||description.getText().equals("11")||description.getText().equals("01")||description.getText().equals("012")||description.getText().equals("12")) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }
                
                else {
                    InfiniteProgress ip = new InfiniteProgress();; //Loading  after insert data
                
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    //njibo iduser men session (current user)
                   Reclamation r=new Reclamation(String.valueOf(description.getText().toString()));
                    System.out.println("data reclamation =="+r);
                    ServicesReclamtion.getInstance().ajouterReclamation(r);
                    
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                      sendMail(res);
                      
                      SmsWhatsapp.msg();
                      
                      
            Dialog.show("Reclamation envoyee","Veuillez vérifier votre boite de réception",new Command("OK"));
                    
                    //ba3d ajout net3adaw lel ListREclamationForm
                    new ListeReclamationForm(res).show();
                    
                    
                    refreshTheme();//Actualisation
                            
                }
                
            }catch(Exception ex ) {
                
            }
            
            
            
            
            
        });
        
        
    }

    private void addStringValue(String s, Component v) {
        
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        add(createLineSeparator(0xeeeeee));
    }

    private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        
        if(image.getHeight() < size) {
            image = image.scaledHeight(size);
        }
        
        
        
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 3 ) {
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Label overLay = new Label("","ImageOverlay");
        
        
        Container page1 = 
                LayeredLayout.encloseIn(
                imageScale,
                        overLay,
                        BorderLayout.south(
                        BoxLayout.encloseY(
                        new SpanLabel(text, "LargeWhiteText"),
                                        spacer
                        )
                    )
                );
        
        swipe.addTab("",res.getImage("back-logo.jpeg"), page1);
        
        
        
        
    }
    
    
    
    public void bindButtonSelection(Button btn , Label l ) {
        
        btn.addActionListener(e-> {
        if(btn.isSelected()) {
            updateArrowPosition(btn,l);
        }
    });
    }

    private void updateArrowPosition(Button btn, Label l) {
        
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth()  / 2  - l.getWidth() / 2 );
        l.getParent().repaint();
    }
    
    
    
    
    //ENVOI MTAA L MAIL
    public void sendMail(Resources res) {
        try {
            
            Properties props = new Properties();
                props.put("mail.transport.protocol", "smtp"); //SMTP protocol
		props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtps.auth", "true"); //enable authentication
             
            Session session = Session.getInstance(props,null); // aleh 9rahach 5ater mazlna masabinach javax.mail .jar
            
            
            MimeMessage msg = new MimeMessage(session);
            
            msg.setFrom(new InternetAddress("mootez.mejdoub@esprit.tn"));
            msg.setRecipients(Message.RecipientType.TO, SessionManager.getEmail());
            msg.setSubject("Reclamation mobile ♥ ");
            msg.setSentDate(new Date(System.currentTimeMillis()));
            
          
           String txt = "Reclamation coté mobile jawha bahy ♥";
           
           
           msg.setText(txt);
           
          SMTPTransport  st = (SMTPTransport)session.getTransport("smtps") ;
            
          st.connect("smtp.gmail.com",465,"mootez.mejdoub@esprit.tn","213JMT1330");
           
          st.sendMessage(msg, msg.getAllRecipients());
            
          System.out.println("server response : "+st.getLastServerResponse());
          
        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
    
   
   
    
}



