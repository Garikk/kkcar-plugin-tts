/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.engines.externalttsserver;


import kkdev.kksystem.base.interfaces.IPluginKKConnector;
import kkdev.kksystem.plugin.tts.engines.ITTSEngine;
import static sun.nio.ch.IOUtil.load;

/**
 *
 * @author sayma_000
 */
public class ExternalTTS implements ITTSEngine {
    TTSUDPClient TTS;

    boolean State;
    public  ExternalTTS()
    {
        TTS=new TTSUDPClient();
        TTS.StartWDUDPClient();
        
    }
    @Override
    public void SayText(String Text) {
        TTS.SendMessage(Text);
    }
}
