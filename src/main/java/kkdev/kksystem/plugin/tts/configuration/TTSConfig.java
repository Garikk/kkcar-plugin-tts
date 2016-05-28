/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.configuration;

import kkdev.kksystem.base.classes.plugins.ExternalConfiguration;
import kkdev.kksystem.base.constants.SystemConsts;

/**
 *
 * @author blinov_is
 */
public class TTSConfig  extends ExternalConfiguration {
    public enum TTS_Engines {
        TTS_ENG_FESTIVALE,
        TTS_ENG_MARYTTS
    }
    
    
    public TTSConf TTSConfigurations;

}
