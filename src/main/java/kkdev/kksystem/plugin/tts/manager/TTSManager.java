package kkdev.kksystem.plugin.tts.manager;

import kkdev.kksystem.base.classes.notify.NotifyConsts.NOTIFY_METHOD;
import kkdev.kksystem.base.classes.notify.NotifyConsts.NOTIFY_TYPE;
import kkdev.kksystem.base.classes.notify.PinDataNotify;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerBase;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.plugin.tts.KKPlugin;
import kkdev.kksystem.plugin.tts.configuration.PluginSettings;
import kkdev.kksystem.plugin.tts.engines.festival_simple.Festival_Simple;

/**
 *
 * @author blinov_is
 */
public class TTSManager extends PluginManagerBase {
    
    Festival_Simple Engine;
    /**
     *
     * @param Conn
     */
    public void Init(KKPlugin Conn) {
        this.setPluginConnector(Conn);
         //
    }

    /**
     *
     */
    public void Start() {
        Engine=new Festival_Simple();
    }
    
    /**
     *
     * @param Msg
     */
    public void ReceivePIN(PluginMessage Msg) {
        if (!PluginSettings.MainConfiguration.useNarrator)
            return;
        
        if (!Msg.pinName.equals(PluginConsts.KK_PLUGIN_BASE_NOTIFY_DATA)) 
            return;
        
        PinDataNotify PD=(PinDataNotify)Msg.getPinData(); 
        
        if (!checkNarratorActive(PD.notifyType))
            return;
        
        for (NOTIFY_METHOD NM:PD.notifyMethod)
            if (NM.equals(NOTIFY_METHOD.VOICE))
            {
                Engine.SayText(PD.notifyText);
            }
    }
    
    private boolean checkNarratorActive(NOTIFY_TYPE NotifyType)
    {
        switch (NotifyType)
                {
            case SYSTEM_INFO:
                return PluginSettings.MainConfiguration.useNarratorSystemInfo;
            case SYSTEM_WARN:
                return PluginSettings.MainConfiguration.useNarratorSystemWarn;
            case CAR_INFO:
                return PluginSettings.MainConfiguration.useNarratorCarInfo;
            case CAR_WARN:
                return PluginSettings.MainConfiguration.useNarratorCarWarn;
            case CAR_ALERT:
                return PluginSettings.MainConfiguration.useNarratorCarAlert;
            case ROAD_INFO:
                return PluginSettings.MainConfiguration.useNarratorSystemInfo;
            case ROAD_WARN:
                return PluginSettings.MainConfiguration.useNarratorSystemInfo;
            case ROAD_ALERT:
                return PluginSettings.MainConfiguration.useNarratorSystemInfo;
            default:
                return false;
        
        }
                
    }

}
