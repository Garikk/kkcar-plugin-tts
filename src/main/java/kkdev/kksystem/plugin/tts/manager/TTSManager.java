package kkdev.kksystem.plugin.tts.manager;

import kkdev.kksystem.base.classes.notify.NotifyConsts.NOTIFY_METHOD;
import kkdev.kksystem.base.classes.notify.PinNotifyData;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerBase;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.plugin.tts.KKPlugin;
import kkdev.kksystem.plugin.tts.engines.festival_simple.Festival_Simple;

public class TTSManager extends PluginManagerBase {
    
    Festival_Simple Engine;

    public void Init(KKPlugin Conn) {
        this.Connector = Conn;
        //
    }
    public void Start() {
        Engine=new Festival_Simple();
    }
    
   
    
    
    public void ReceivePIN(PluginMessage Msg) {
        if (!Msg.PinName.equals(PluginConsts.KK_PLUGIN_BASE_NOTIFY_DATA)) 
            return;
        
        PinNotifyData PD=(PinNotifyData)Msg.PinData; 
        
        for (NOTIFY_METHOD NM:PD.NotifyMethod)
            if (NM==NOTIFY_METHOD.VOICE)
                Engine.SayText(PD.NotifyText);
            


    }

}
