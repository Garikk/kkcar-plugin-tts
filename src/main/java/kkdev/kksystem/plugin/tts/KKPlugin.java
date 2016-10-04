package kkdev.kksystem.plugin.tts;

import kkdev.kksystem.base.classes.plugins.PluginConfiguration;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.KKPluginBase;
import kkdev.kksystem.plugin.tts.configuration.PluginSettings;
import kkdev.kksystem.plugin.tts.manager.TTSManager;
import kkdev.kksystem.base.interfaces.IBaseConnection;



/**
 *
 * @author blinov_is
 */
public final class KKPlugin extends KKPluginBase {


    /**
     * Default constructor
     */
    public KKPlugin() {
        super(new TTSPluginInfo());
        Global.TM=new TTSManager();
    }

    /**
     *
     * @param BaseConnector
     * @param GlobalConfUID
     */
    @Override
    public void pluginInit(IBaseConnection BaseConnector, String GlobalConfUID) {
        super.pluginInit(BaseConnector, GlobalConfUID);
        PluginSettings.InitConfig(this.globalConfID, this.pluginInfo.getPluginInfo().PluginUUID);
        Global.TM.Init(this);
    }

    /**
     *
     * @param Pin
     * @return
     */
    @Override
    public void executePin(PluginMessage Pin) {
        super.executePin(Pin);
        Global.TM.ReceivePIN(Pin);
    }
    
    /**
     *
     */
    @Override
    public void pluginStart() {
         super.pluginStart();
         Global.TM.Start();
    }

    @Override
    public PluginConfiguration getPluginSettings() {
       return PluginSettings.MainConfiguration;
    }

}
