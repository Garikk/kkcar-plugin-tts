/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.engines.festival_simple;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kkdev.kksystem.plugin.tts.engines.ITTSEngine;

/**
 *
 * @author sayma_000
 */
public class Festival_Simple implements ITTSEngine {
 

    boolean State;

    @Override
    public void SayText(String Text) {
        try {
             String s = null;
            //TODO WARNING!!!! CHANGE THIS!!!
           
         //Runtime.getRuntime().exec("./tts.sh \"" + Text+"\"");
         Runtime.getRuntime().exec("./tts.sh " + Text);
         
            //==============
        } catch (IOException ex) {
            Logger.getLogger(Festival_Simple.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
        
    }

