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
    public void PluginInit(IPluginBaseInterface BaseConnector, String GlobalConfUID) {
        super.PluginInit(BaseConnector, GlobalConfUID);
        PluginSettings.InitConfig(this.GlobalConfID, this.PluginInfo.GetPluginInfo().PluginUUID);
        Global.TM.Init(this);
    }

    
    @Override
    public PluginMessage ExecutePin(PluginMessage Pin) {
        super.ExecutePin(Pin);
        Global.TM.ReceivePIN(Pin);
        return null;
    }
    
    
     @Override
    public void PluginStart() {
         super.PluginStart();
         Global.TM.Start();
    }

}
