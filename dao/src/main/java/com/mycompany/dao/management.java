/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;


import com.mycompany.service.Item;
import com.mycompany.service.Page;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;


/**
 *
 * @author celos
 */
public class management {

    public static final String FILENAME = "C:\\Users\\celos\\Desktop\\java\\FirstMavenProject\\dao\\src\\text.txt";

    public static void main(String[] args) throws MalformedURLException, FileNotFoundException, Exception {
     //   String json = readUrl("http://www.javascriptkit.com/dhtmltutors/javascriptkit.json");
     //   Gson gson = new Gson();
     //   Page page = gson.fromJson(json, Page.class);
     //   save(page);
    }
    
    


    public static void save(Page page) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            for (Item ab : page.getItems()) {
                bw.write("Title: " + ab.title + " Link: " + ab.link + " Description: " + ab.description +"\r\n" );

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }

    }
}
