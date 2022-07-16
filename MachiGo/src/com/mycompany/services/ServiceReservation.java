/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import java.lang.Object;
import com.mycompany.entities.Reservation;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;

import com.codename1.ui.BrowserComponent;
import com.mycompany.gui.SessionManager;



/**
 *
 * @author mbell
 */
public class ServiceReservation {
    
    public static ServiceReservation instance = null;
    
    public static boolean resultOk = true;
    
    
    private ConnectionRequest req ;
    
    
    
    public static ServiceReservation getInstance(){
        
        if(instance==null){
            instance =new ServiceReservation();
        }
          return instance ;

    }
    
    public ServiceReservation (){
        
        req=new ConnectionRequest();
       
    }
    
    //ajouter
    public void AjouterReservation(Reservation res){
        
        String url="http://127.0.0.1:8000/reservation/addReservationJSON/new?nbrplace="+res.getNbrPlace()+"&id="+SessionManager.getId()+ "&datedebut="+res.getDateDebut()+ "&datefin="+res.getDateFin()+"&plan="+res.getPlan()                              ;
        req.setUrl(url);
        
        req.addResponseListener((e)->{
            
           String str=new String(req.getResponseData());
            System.err.println("data ==" + str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        
        System.out.println("add success");
        
    }
    
    //affichage 
    public ArrayList<Reservation>affichageReservation(){
        
        ArrayList<Reservation> result=new ArrayList<>();
        
        String url="http://127.0.0.1:8000/reservation/Reservationmobile";  
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

               JSONParser jsonp;
               
                jsonp=new JSONParser();
                
              try{
                  Map<String,Object>mapReservation=jsonp.parseJSON(new CharArrayReader(new String (req.getResponseData()).toCharArray()));
                    
                  List<Map<String,Object>>listOfMaps=(List<Map<String,Object>>) mapReservation.get("root");
              
                  for(Map <String,Object> obj: listOfMaps){
                     Reservation  res =new Reservation (); 
                     
                     float nbP=Float.parseFloat(obj.get("nbrplace").toString());
                    // Date dateDebut = Date(obj.get("datedebut").toString()) ;
//                      String dateConverter = obj.get("datedebut").toString().substring(obj.get("datedebut").toString().indexOf("timestamp")+10,obj.get("obj").toString().lastIndexOf("}"));
//                        Date date =new Date(Double.valueOf(dateConverter).longValue()*1000); 
//                         SimpleDateFormat formatter =new SimpleDateFormat("yyyy-mm-dd");       
//                        String dateStr=formatter.format(date);
                        
                    //Date dateFin = Date(obj.get("datefin").toString()) ;        
                     
                    String dd= obj.get("datedebut").toString();
                            String df= obj.get("datefin").toString();

                            res.setDatetest(dd);
                            

                            res.setDatetestfin(df);
                    
                     String plan =obj.get("plan").toString();
                    // float idClient=Float.parseFloat(obj.get("idclient").toString());
                     
                     //res.setDateDebut(res.getDateDebut());
                     //res.setDateFin(res.getDateFin());
                     res.setNbrPlace((int)nbP);
                    // res.setIdClient((int)idClient);
                     res.setPlan(plan);
                     
                     
                     result.add(res);
                     
                  }
                  
                  
              }      
                catch(Exception e ){
                   e.printStackTrace();        
                }
            
            }
            
        });
                
             NetworkManager.getInstance().addToQueueAndWait(req);

             return result;
             
    }
    
    
    /***********************/
    
        public ArrayList<Reservation> detailsReservation(){
            ArrayList<Reservation> result = new ArrayList<>();
            Reservation res=new Reservation();
            String url = "http://127.0.0.1:8000/reservation/showResMobile?id="+SessionManager.getId();
            req.setUrl(url);
            
            
            
            req.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent evt) {
                    JSONParser jsonp=new JSONParser();
                        
                    try{
                        Map<String,Object>obj=jsonp.parseJSON(new CharArrayReader(new String (req.getResponseData()).toCharArray()));

                        List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) obj.get("root");
                        for(Map<String,Object> obj1 : listOfMaps){
                            
                            Reservation res = new Reservation();
                            float num = Float.parseFloat(obj1.get("numreservation").toString());
                            float nombre = Float.parseFloat(obj1.get("nbrplace").toString());
                            String dd= obj1.get("datedebut").toString();
                            String df= obj1.get("datefin").toString();
//                            String DateConverter =  dd.substring(dd.indexOf("timestamp") + 10 , dd.lastIndexOf("}"));
//                            Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
//                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                            String dateString = formatter.format(currentTime);
                            res.setDatetest(dd);
                            
//                            String DateConverter1 =  dd.substring(dd.indexOf("timestamp") + 10 , dd.lastIndexOf("}"));
//                            Date currentTime1 = new Date(Double.valueOf(DateConverter1).longValue() * 1000);
//                            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
//                            String dateString1 = formatter1.format(currentTime1);
                            res.setDatetestfin(df);
                            
                            res.setNumReservation((int) num);
                            res.setNbrPlace((int) nombre);
                            
                            result.add(res);
                        }
                       
                    }
                    catch(Exception e ){
                        e.printStackTrace();
                    }
                    
                }
            });
               
                  NetworkManager.getInstance().addToQueueAndWait(req);
            
                 return result;
                 
        }
        
        
           public boolean deleteReclamation(int id ) {
        String url ="http://127.0.0.1:8000/reservation/deleteReservationJSON?numreservation="+id;
        
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
           
           public boolean modifierReservation(Reservation res ){
               
              
               
                String url="http://127.0.0.1:8000/reservation/updateReservationJSON/"+res.getNumReservation()+"?nbrplace="+res.getNbrPlace()+"&datedebut="+res.getDateDebut()+"&datefin="+res.getDateFin()+"&plan="+res.getPlan()  ;
               
               req.setUrl(url);
               
               req.addResponseListener(new ActionListener<NetworkEvent>(){
             @Override
             public void actionPerformed(NetworkEvent evt) {
                    
              resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);   
                 
             }
               });
               
               
              NetworkManager.getInstance().addToQueueAndWait(req);
                return resultOk; 
               
               
           }           
           
           
//           public String Recaptcha()  {
//                   
//        System.out.println("******");
//    
//        String url ="https://www.google.com/recaptcha/api/siteverify?secret=6Lf-fLYeAAAAALntWUcfkc5ZOikC5IzZtrbtZLEA&response="+key;
//       
//        req.setUrl(url);
//        req.setPost(false);
//
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                 result = new String(req.getResponseData());
//                
//            }
//
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return result;
//
//    }
           
 
   
    
    
    
    
}
