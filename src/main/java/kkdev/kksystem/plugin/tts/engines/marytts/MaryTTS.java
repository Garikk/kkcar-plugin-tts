/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.engines.marytts;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import kkdev.kksystem.plugin.tts.engines.ITTSEngine;
import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.MaryRuntimeUtils;

/**
 *
 * @author sayma_000
 */
public class MaryTTS implements ITTSEngine {
    LocalMaryInterface mary = null;
    boolean State;
    public MaryTTS()
    {
        State=true;
        try {
            MaryRuntimeUtils.getVoices();
            mary = new LocalMaryInterface();
        } catch (MaryConfigurationException ex) {
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
        } catch (SynthesisException ex) {
            Logger.getLogger(MaryTTS.class.getName()).log(Level.ALL, null, ex);
        }
    }
}
