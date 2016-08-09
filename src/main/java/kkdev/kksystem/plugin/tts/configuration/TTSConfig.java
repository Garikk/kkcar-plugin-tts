/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.configuration;

import kkdev.kksystem.base.classes.plugins.PluginConfiguration;
import kkdev.kksystem.base.constants.SystemConsts;

/**
 *
 * @author blinov_is
 */
public class TTSConfig extends PluginConfiguration {

    /**
     *
     */
    public boolean useNarrator = false;
    public boolean useNarratorSystemInfo = false;
    public boolean useNarratorSystemWarn = false;
    public boolean useNarratorCarWarn = false;
    public boolean useNarratorCarAlert = false;
    public boolean useNarratorCarInfo = false;
    public boolean useNarratorRoadWarn = false;
    public boolean useNarratorRoadAlert = false;
    public boolean useNarratorRoadInfo = false;

    public enum TTS_Engines {

        /**
         * TTS Engine Festivale, stupid shell access
         */
        TTS_ENG_FESTIVALE
    }

    public TTSConf TTSConfigurations;

    public void initQuickParameters() {
        for (String name : PluginSettings.MainConfiguration.getParametrsBoolean()) {
            setLocalQuickParameter(name, PluginSettings.MainConfiguration.getParameterBoolean(name));
        }
    }

    @Override
    public void setParameterBool(String Name, Boolean Value) {
        super.setParameterBool(Name, Value);
        setLocalQuickParameter(Name, Value);

    }

    private void setLocalQuickParameter(String Name, Boolean Value) {
        switch (QuickParameterTypes.fromString(Name)) {
            case BOOL_USE_NARRATOR:
                useNarrator = Value;
                break;
            case BOOL_USE_NARRATOR_CAR_ALERT:
                useNarratorCarAlert = Value;
                break;
            case BOOL_USE_NARRATOR_SYSTEM_INFO:
                useNarratorSystemInfo = Value;
                break;
            case BOOL_USE_NARRATOR_SYSTEM_WARN:
                useNarratorSystemWarn = Value;
                break;
            case BOOL_USE_NARRATOR_CAR_INFO:
                useNarratorCarInfo = Value;
                break;
            case BOOL_USE_NARRATOR_CAR_WARN:
                useNarratorCarWarn = Value;
                break;
            case BOOL_USE_NARRATOR_ROAD_INFO:
                useNarratorRoadInfo = Value;
                break;
            case BOOL_USE_NARRATOR_ROAD_WARN:
                useNarratorRoadWarn = Value;
                break;
            case BOOL_USE_NARRATOR_ROAD_ALERT:
                useNarratorRoadAlert = Value;
                break;
            default:
            //nothing for do

        }
    }

}
