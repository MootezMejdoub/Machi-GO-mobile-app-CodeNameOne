/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Reclamation;
import com.mycompany.gui.SessionManager;
import com.mycompany.utils.Statics;
import java.io.IOException;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import static sun.security.krb5.Confounder.longValue;

/**
 *
 * @author Tox
 */
public class ServicesReclamtion {
     public static int countAtt;
     public static int countTraite;
    public static ServicesReclamtion instance=null;
    
     public static boolean resultOk = true;
    private  ConnectionRequest req;

    public static ServicesReclamtion getInstance(){
        if(instance==null)
            instance=new ServicesReclamtion();
        return instance;
    }    
    public ServicesReclamtion() {
        req=new ConnectionRequest();
        
    }
//    public static String reference(){
//    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//            + "0123456789"
//            + "abcdefghijklmnopqrstuvxyz";
//    StringBuilder s = new StringBuilder(8);
//    for(int i=0;i<8;i++){ 
//    int index= (int) (AlphaNumericString.length()* Math.random());
//    s.append(AlphaNumericString.charAt(index));
//}
//    return s.toString();
//    }
//    String ref = reference();
//    
//    
    public void  ajouterReclamation(Reclamation reclamtion){
        String url="http://127.0.0.1:8000/reclamation/addReclamation?description="+reclamtion.getDescription()+"&id="+SessionManager.getId();
        
        req.setUrl(url);
        req.addResponseListener((e)->{
            String str= new String (req.getResponseData());
            System.out.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueue(req);//execution si nn mayet3adach obli!
        
    }

      
    public ArrayList<Reclamation>affichageReclamations() {
        ArrayList<Reclamation> result = new ArrayList<>();
        
        String url = "http://127.0.0.1:8000/reclamation/displayReclamations";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapReclamations.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Reclamation re = new Reclamation();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        String etat = obj.get("etat").toString();
                        
                        String description = obj.get("description").toString();
                        String reference = obj.get("recReference").toString();

                        
                        re.setId((int)id);
                        re.setDescription(description);
                        re.setEtat(etat);       
                        re.setReference(reference);
                        if(re.getEtat().equals("en attente"))
                            countAtt=countAtt+1;
                        if(re.getEtat().equals("trait??"))
                            countTraite=countTraite+1;
                        //Date countAtt=countAll+1;
                        //Date 
//                         String DateConverter =  obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10 , obj.get("date").toString().lastIndexOf("}"));
//                        
//                       Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
//                        
//                      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                      String dateString = formatter.format(currentTime);
//                      re.setDate(dateString);
                        
                        //insert data into ArrayList result
                        result.add(re);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
   
    public boolean deleteReclamation(int id ) {
        String url = "http://127.0.0.1:8000/reclamation/deleteReclamation?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
       public boolean modifierReclamation(Reclamation reclamation) {
        String url = "http://127.0.0.1:8000/reclamation/updateReclamation?id="+reclamation.getId()+"&description="+reclamation.getDescription();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
//    public ArrayList<Reclamation> result;
//    public ArrayList<Reclamation> parseTasks(String jsonText){
//        try {
//            result=new ArrayList<>();
//            JSONParser j = new JSONParser();
//            Map<String,Object> tasksListJson = 
//               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            
//            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
//            for(Map<String,Object> obj : list){
//                Reclamation t = new Reclamation();
//                float id = Float.parseFloat(obj.get("id").toString());
//                t.setId((int)id);
//                t.setEtat(obj.get("etat").toString());
//                t.setDescription(obj.get("description").toString());
//                
//            }
//            
//            
//        } catch (IOException ex) {
//            
//        }
//        return result;
//    }
     
    
    
    
}
