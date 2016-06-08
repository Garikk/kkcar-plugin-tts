package kkdev.kksystem.plugin.tts;

import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.KKPluginBase;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.plugin.tts.configuration.PluginSettings;
import kkdev.kksystem.plugin.tts.manager.TTSManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author blinov_is
 */
public final class KKPlugin extends KKPluginBase {
    public KKPlugin() {
        super(new TTSPluginInfo());
        Global.TM=new TTSManager();
    }

    @Override
    public void pluginInit(IPluginBaseInterface BaseConnector, String GlobalConfUID) {
        super.pluginInit(BaseConnector, GlobalConfUID);
        PluginSettings.InitConfig(this.globalConfID, this.pluginInfo.getPluginInfo().PluginUUID);
        Global.TM.Init(this);
    }

    
    @Override
    public PluginMessage executePin(PluginMessage Pin) {
        super.executePin(Pin);
        Global.TM.ReceivePIN(Pin);
        return null;
    }
    
    
     @Override
    public void pluginStart() {
         super.pluginStart();
         Global.TM.Start();
    }

}
