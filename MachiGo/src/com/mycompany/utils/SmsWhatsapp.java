/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author Tox
 */
public class SmsWhatsapp {
    
    public static final String ACCOUNT_SID = "AC11504623102e397beac52ffbea6fef4d";
    public static final String AUTH_TOKEN = "bda3355dce262c9246f1a90f0ce7611f";
    public static void msg(){
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+21627066310"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Une reclamation a ete envoyee vous pouvez le contacter sur 27 066 310 ")
            .create();

        System.out.println(message.getSid());
    }
    
}
