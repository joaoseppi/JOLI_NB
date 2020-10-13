/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.DaoGenerico;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Error_logs;

/**
 *
 * @author JGSS
 */
public class JSONTranslator {
    private Object data = null;
    private ObjectMapper json = new ObjectMapper();
    private String message = "";

    public JSONTranslator() {
    }
    
    public JSONTranslator(Object obj) {
        data = obj;
    }
    
    public String javaToJson(Object obj){
        try {
            message = json.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JSONTranslator.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            String er = "crud.JSONTranslator.javaToJson";
            new DaoGenerico().insert(new Error_logs(er, ex.toString()));
        }
        return message;
    }
    
    public Object jsonToJava(String mes){
        try {
            data = json.readValue(mes, Object.class);
        } catch (IOException ex) {
            Logger.getLogger(JSONTranslator.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            String er = "crud.JSONTranslator.jsonToJava";
            new DaoGenerico().insert(new Error_logs(er, ex.toString()));
        }
        return data;
    }

    public Object getMessage() {
        return data;
    }

    public void setMessage(Object message) {
        this.data = message;
    }

    public ObjectMapper getJson() {
        return json;
    }

    public void setJson(ObjectMapper json) {
        this.json = json;
    }
    
    
}
