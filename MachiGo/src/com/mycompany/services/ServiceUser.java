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
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Utilisateur;
import com.mycompany.gui.AjoutUserForm;
import com.mycompany.gui.ListUsersForm;
import com.mycompany.gui.ProfileForm;
import com.mycompany.gui.SessionManager;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;


/**
 *
 * @author bureau
 */
public class ServiceUser {
    
   public static ServiceUser instance=null;
    String json;
        public static boolean resultOk = true;
         
 public static String nom2;
    public static String mdp2;
    public static String email2;
        public static String num2;

    private  ConnectionRequest req;

    public static ServiceUser getInstance(){
        if(instance==null)
            instance=new ServiceUser();
        return instance;
    }    
    public ServiceUser() {
        
        req=new ConnectionRequest();
        
        
    }
        
   public void ajouterUser(Utilisateur utilisateur)
   {
 String url="http://127.0.0.1:8000/utilisateur/addUser?nom="+utilisateur.getNom()+"&prenom="+utilisateur.getPrenom()+"&email="+utilisateur.getEmail();
       req.setUrl(url);
  req.addResponseListener((e)->
  {
      String str=new String(req.getResponseData());
      System.out.println("data === "+str);
  });
   
   NetworkManager.getInstance().addToQueueAndWait(req);
   }
   
   
   
   public ArrayList<Utilisateur>afficheUsers()
   {
       ArrayList<Utilisateur> result = new ArrayList<>();
        
        String url = "http://127.0.0.1:8000/utilisateur/json";
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
                       Utilisateur re = new Utilisateur();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        String nom = obj.get("nom").toString();
                        
                        String prenom = obj.get("prenom").toString();
                                                String email = obj.get("email").toString();

                        re.setId((int)id);
                        re.setNom(nom);
                        re.setPrenom(prenom);
                        re.setEmail(email);
                        
                        //Date 
                     /*   String DateConverter =  obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10 , obj.get("date").toString().lastIndexOf("}"));
                        
                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                        
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(currentTime);
                        re.setDate(dateString);
                        */
                        //insert data into ArrayList result
                        result.add(re);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
   }
   
   
   public Utilisateur DetailUser(int id,Utilisateur utilisateur)
   {
              String url="http://127.0.0.1:8000/utilisateur/detailUser?"+id;
              req.setUrl(url);
                    String str=new String(req.getResponseData());
                    req.addResponseListener(((evt)->
                    {
                         JSONParser jsonp;
          jsonp= new JSONParser();
          try
          {
             Map<String,Object>obj=jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray())); 
         utilisateur.setNom(obj.get("nom").toString());
utilisateur.setPrenom(obj.get("prenom").toString());
utilisateur.setEmail(obj.get("email").toString());
                 }catch(IOException ex)
          {
              System.out.println("error related to sql: ("+ex.getMessage());
          }
                        System.out.println("data==="+str);
          
                    })) ;

        NetworkManager.getInstance().addToQueueAndWait(req);
return utilisateur;
   }

public void signup (TextField nom,TextField prenom,TextField email,TextField numTel,TextField mdp,ComboBox roles,Resources res)
{
   
   String url="http://127.0.0.1:8000/utilisateur/addUser?nom="+nom.getText().toString()+"&prenom="+prenom.getText().toString()+"&email="+email.getText().toString()+"&mdp="+mdp.getText().toString()+"&numTel="+numTel.getText()+"&roles="+roles.getSelectedItem().toString();
req.setUrl(url);
 String nom2=nom.getText().toString();
                String email2=email.getText().toString();
                        String mdp2=mdp.getText().toString();
                        String num2=numTel.getText().toString();

 req.addResponseListener((e)->
  {
byte[]data= (byte[]) e.getMetaData();
String responseData=new String(data);

      System.out.println("data === "+responseData);
  });
       NetworkManager.getInstance().addToQueueAndWait(req);

    
    
}

public void signin(TextField mdp,TextField email,Resources res)
{
    
    
    String url ="http://127.0.0.1:8000/utilisateur/detailUser2?email="+email.getText().toString()+"&mdp="+mdp.getText().toString();
req.setUrl(url);
 req.addResponseListener((e)->
  {
JSONParser j=new JSONParser();
String json= new String(req.getResponseData())+"";

try
{
if(json.equals("password not found")||json.equals("user not found"))
{
    Dialog.show("Echec ","email ou mdp incorrect","OK",null);
}
else
    
{
    System.out.println("data=="+json);
    Map<String,Object> utilisateur= j.parseJSON(new CharArrayReader(json.toCharArray()));

                     //Session 
                float id = Float.parseFloat(utilisateur.get("id").toString());
                SessionManager.setId((int)id);//jibt id ta3 user ly3ml login w sajltha fi session ta3i
                SessionManager.setNumTel(utilisateur.get("numTel").toString());
                SessionManager.setPassowrd(utilisateur.get("mdp").toString());
                SessionManager.setUserName(utilisateur.get("nom").toString());
                SessionManager.setEmail(utilisateur.get("email").toString());
                System.out.println("current user =="+SessionManager.getId()+","+SessionManager.getEmail()+","+SessionManager.getPassowrd()+","+SessionManager.getUserName());
    
    if(utilisateur.size()>0)
    
{
    new ProfileForm(res).show();
}

}
}catch(Exception ex)
{
    ex.printStackTrace();
}

  });

       NetworkManager.getInstance().addToQueueAndWait(req);


}

public boolean  deleteUser(int id)
 {
     String url="http://127.0.0.1:8000/utilisateur/json/"+id;
     req.setUrl(url);
     req.addResponseListener(new ActionListener<NetworkEvent>() {
         @Override
         public void actionPerformed(NetworkEvent evt) {
             
             req.removeResponseCodeListener(this);
         }
         
         
     });
     NetworkManager.getInstance().addToQueueAndWait(req);
     return resultOk;
             
 }

 public String getPasswordByEmail(String email, Resources rs ) {
        
        
        String url = "http://127.0.0.1:8000/utilisateur/getPasswordByEmail?email="+email;
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        
        req.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            
            json = new String(req.getResponseData()) + "";
            
            
            try {
            
          
                System.out.println("data =="+json);
                
                Map<String,Object> password = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                
            
            
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    return json;
    }

 public boolean modifierReclamation(TextField email,TextField numTel,TextField nom,TextField password) {
        String url = "http://127.0.0.1:8000/utilisateur/updateUser?id="+SessionManager.getId()+"&email="+email.getText().toString()+"&nom="+nom.getText().toString()+"&numTel="+numTel.getText().toString()+"&mdp="+password.getText().toString();
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
}



