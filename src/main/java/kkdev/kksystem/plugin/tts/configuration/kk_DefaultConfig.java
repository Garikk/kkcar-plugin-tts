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
    public static TTSConfig MakeDefaultConfig() {
        
        TTSConfig DefConf = new TTSConfig();
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR.getValue(), Boolean.FALSE);
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR_CAR_ALERT.getValue(), Boolean.FALSE);
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR_CAR_INFO.getValue(), Boolean.FALSE);
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR_CAR_WARN.getValue(), Boolean.FALSE);
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR_ROAD_ALERT.getValue(), Boolean.FALSE);
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR_ROAD_INFO.getValue(), Boolean.FALSE);
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR_ROAD_WARN.getValue(), Boolean.FALSE);
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR_SYSTEM_INFO.getValue(), Boolean.FALSE);
        DefConf.setParameterBool(TTSQuickParameters.BOOL_USE_NARRATOR_SYSTEM_WARN.getValue(), Boolean.FALSE);
        return DefConf;
    }
}
