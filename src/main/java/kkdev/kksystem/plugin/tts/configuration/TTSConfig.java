/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.configuration;

import kkdev.kksystem.base.classes.plugins.PluginConfiguration;
import kkdev.kksystem.base.classes.plugins.QuickParameterInfo;
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
    QuickParameterInfo[] pluginQuickParameters;
    
    public enum TTS_Engines {

        /**
         * TTS Engine Festivale, stupid shell access
         */
        TTS_ENG_FESTIVALE
    }

    public TTSConf TTSConfigurations;

    public void initQuickParameters() {
        int i=0;
        pluginQuickParameters=new QuickParameterInfo[PluginSettings.MainConfiguration.getParametrsBoolean().length];
        for (String name : PluginSettings.MainConfiguration.getParametrsBoolean()) {
            setLocalQuickParameter(name, PluginSettings.MainConfiguration.getParameterBoolean(name));
            pluginQuickParameters=new QuickParameterInfo[i];
            pluginQuickParameters[i].Name=name;
            pluginQuickParameters[i].Description=name;
            i++;
        }
    }

    @Override
    public void setParameterBool(String Name, Boolean Value) {
        super.setParameterBool(Name, Value);
        setLocalQuickParameter(Name, Value);

    }

    @Override
    public QuickParameterInfo[] getQuickParametersInfo() {
       return pluginQuickParameters;
       //return null;
      
    }

    
    
    private void setLocalQuickParameter(String Name, Boolean Value) {
        switch (TTSQuickParameters.fromString(Name)) {
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
