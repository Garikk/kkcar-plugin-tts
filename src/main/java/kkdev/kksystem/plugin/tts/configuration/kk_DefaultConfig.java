/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.configuration;


/**
 *
 * @author blinov_is
 *
 * 
 */
public abstract class kk_DefaultConfig {

    /**
     *
     * @return
     */
    public static TTSConfiguration MakeDefaultConfig() {

        return new TTSConfiguration();
    }
}
