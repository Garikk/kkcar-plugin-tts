package kkdev.kksystem.plugin.tts.manager;

import kkdev.kksystem.base.classes.base.PinBaseDataTaggedObj;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerBase;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_BASIC_TAGGEDOBJ_DATA;
import kkdev.kksystem.base.constants.SystemConsts;
import kkdev.kksystem.plugin.tts.KKPlugin;
import kkdev.kksystem.plugin.tts.configuration.PluginSettings;

public class TTSManager extends PluginManagerBase {


    public void Init(KKPlugin Conn) {
        this.Connector = Conn;
        //
    }
    public void Start() {
  //      Adapter.StartAdapter(this);
    }
    private void ConfigAndInitHW() {
        //Init HW adapter
     
    }
    
   
    
    
    public void ReceivePIN(PluginMessage Msg) {
        if (Msg.PinName.equals(KK_PLUGIN_BASE_BASIC_TAGGEDOBJ_DATA)) {

        }
    }

}
