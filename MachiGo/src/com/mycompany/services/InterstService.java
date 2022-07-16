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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.Format;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Interest;
import com.mycompany.utils.DataSource;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author molka
 */
public class InterstService {
    
    
    private ConnectionRequest request;
    private boolean responseResult;
    
    public ArrayList<Interest> recs;
    
    
    public InterstService() {
            request = DataSource.getInstance().getRequest();

    }
    
    
            public ArrayList<Interest> getInterstByUser(int id) {
        String url = Statics.BASE_URL + "/scoreShow/"+id;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    recs = parseType(new String(request.getResponseData()));
                    request.removeResponseListener(this);
                } catch (ParseException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return recs;
    }
            
            
     public ArrayList<Interest> parseType(String jsonText) throws ParseException {
        try {
            recs = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            System.out.println("ssss"+list);
            for (Map<String, Object> obj : list) {
            
            int id = (int)Float.parseFloat(obj.get("idIntrest").toString());
            int score = (int)Float.parseFloat(obj.get("score").toString());
            String sport = obj.get("sport").toString();
            String history = obj.get("history").toString();
            String health = obj.get("health").toString();
            String food = obj.get("food").toString();
            





            
      
                  System.err.println("hhelo"+new Interest(id, sport, history, food, health, score));
                recs.add(new Interest(id, sport, history, food, health, score));
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return recs;
    }
        

      public boolean addInterst(Interest p,int id) {
     
        String url = Statics.BASE_URL + "/api/addInterst/"+id+"?history=" + p.getHistory()+ "&food=" + p.getFood()+"&health="+p.getHealth()+"&sport="+p.getSport();
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
                    
   
      public boolean ModifierInterst(Interest p) {
     
        String url = Statics.BASE_URL + "/api/updateInterst?history=" + p.getHistory()+ "&food=" + p.getFood()+"&health=" + p.getHealth()+"&sport=" + p.getSport()+"&id=" + p.getIdIntrest();
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
      
      
      
      

    
}
