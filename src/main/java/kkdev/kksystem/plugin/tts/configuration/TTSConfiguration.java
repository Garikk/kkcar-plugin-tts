/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.configuration;

import kkdev.kksystem.base.classes.plugins.ManagedParameter;
import kkdev.kksystem.base.classes.plugins.PluginConfiguration;
/**
 *
 * @author blinov_is
 */
public class TTSConfiguration extends PluginConfiguration {

    /**
     *
     */
    @ManagedParameter(DisplayName = "Narrator", Description = "Use Narrator")
    public boolean useNarrator = false;
    @ManagedParameter(DisplayName = "Alert SysInfo", Description = "Use Narrator for system info events")
    public boolean useNarratorSystemInfo = false;
    @ManagedParameter(DisplayName = "Alert SysWarn", Description = "Use Narrator for system warning events")
    public boolean useNarratorSystemWarn = false;
    @ManagedParameter(DisplayName = "Alert CarWarn", Description = "Use Narrator for vehicle warning events")
    public boolean useNarratorCarWarn = false;
    @ManagedParameter(DisplayName = "Alert CarAlert", Description = "Use Narrator for vehicle alert events")
    public boolean useNarratorCarAlert = false;
    @ManagedParameter(DisplayName = "Alert CarInfo", Description = "Use Narrator for vehicle info events")
    public boolean useNarratorCarInfo = false;
    @ManagedParameter(DisplayName = "Alert RoadWarn", Description = "Use Narrator for road warning events")
    public boolean useNarratorRoadWarn = false;
    @ManagedParameter(DisplayName = "Alert RoadAlert", Description = "Use Narrator for road Alert events")
    public boolean useNarratorRoadAlert = false;
    @ManagedParameter(DisplayName = "Alert RoadInfo", Description = "Use Narrator for road info events")
    public boolean useNarratorRoadInfo = false;

    public enum TTS_Engines {

        /**
         * TTS Engine Festivale, stupid shell access
         */
        TTS_ENG_FESTIVALE
    }
    public TTSFeatureCofiguration TTSConfigurations;

}
