/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.engines.marytts;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;
import kkdev.kksystem.plugin.tts.engines.ITTSEngine;
import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.config.MaryConfig;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.MaryRuntimeUtils;
import static sun.nio.ch.IOUtil.load;

/**
 *
 * @author sayma_000
 */
public class MaryTTS implements ITTSEngine {
    MaryInterface mary = null;
    Clip clip;
    boolean State;
    public  MaryTTS()
    {
      InitTTS();
    }
    private synchronized void InitTTS()
    {
      State=true;
        try {
            URLClassLoader CLoader;
          try {
              CLoader = new URLClassLoader(new URL[]{(new File("../lib/marytts-common-5.2-beta3.jar")).toURI().toURL()});
                mary = (LocalMaryInterface) CLoader.loadClass("LocalMaryInterface.class").newInstance();
          } catch (MalformedURLException ex) {
              Logger.getLogger(MaryTTS.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(MaryTTS.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              Logger.getLogger(MaryTTS.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              Logger.getLogger(MaryTTS.class.getName()).log(Level.SEVERE, null, ex);
          }
                //
              
            mary = new LocalMaryInterface();
            clip = AudioSystem.getClip();
        } catch (MaryConfigurationException ex) {
            State=false;
            Logger.getLogger(MaryTTS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            State=false;
            Logger.getLogger(MaryTTS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void SayText(String Text) {
        if (!State)
            return;
        
           AudioInputStream audio = null;
        try {
            audio = mary.generateAudio(Text);
            clip.open(audio);
            clip.start();
            while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
            //Let the clip finish playing before closing
            }           

        } catch (SynthesisException ex) {
            Logger.getLogger(MaryTTS.class.getName()).log(Level.ALL, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(MaryTTS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MaryTTS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
