/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;
import com.mycompany.dao.management;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 *
 * @author dgebremichael
 */
public class GsonManager {

    private static Logger logger = Logger.getLogger("InfoLogging");
    private static String readUrl(String urlString) throws Exception {
        
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            
            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public void jsonRet() throws Exception {
        String json = GsonManager.readUrl("http://www.javascriptkit.com/dhtmltutors/javascriptkit.json");

        Gson gson = new Gson();
        Page page = gson.fromJson(json, Page.class);
        
        management.save(page);

   //     System.out.println(page.title);
//        for (Item item : page.items) {
//           System.out.println("    " + item.title+" "+item.description);
//           JOptionPane.showMessageDialog(null,item.title+" "+item.description);
//      logger.info(item.title+" "+item.description);
//        }
    }

    public static void main(String[] args) throws MalformedURLException, FileNotFoundException, Exception {

        new GsonManager().jsonRet();
    }

   
}
