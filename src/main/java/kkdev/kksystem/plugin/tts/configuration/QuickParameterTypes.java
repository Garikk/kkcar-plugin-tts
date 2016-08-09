/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.configuration;

/**
 *
 * @author blinov_is
 */
public enum QuickParameterTypes {
    BOOL_USE_NARRATOR("USE_NARRATOR"),
    BOOL_USE_NARRATOR_SYSTEM_INFO("USE_NARRATOR_SYSTEM_INFO"),
    BOOL_USE_NARRATOR_SYSTEM_WARN("USE_NARRATOR_SYSTEM_WARN"),
    BOOL_USE_NARRATOR_CAR_INFO("USE_NARRATOR_CAR_INFO"),
    BOOL_USE_NARRATOR_CAR_WARN("USE_NARRATOR_CAR_WARN"),
    BOOL_USE_NARRATOR_CAR_ALERT("USE_NARRATOR_CAR_ALERT"),
    BOOL_USE_NARRATOR_ROAD_INFO("USE_NARRATOR_ROAD_INFO"),
    BOOL_USE_NARRATOR_ROAD_WARN("USE_NARRATOR_ROAD_WARN"),
    BOOL_USE_NARRATOR_ROAD_ALERT("USE_NARRATOR_ROAD_ALERT");
    
    String myValue;

    QuickParameterTypes(String myVal) {
        myValue = myVal;
    }
    public String getValue()
    {
        return myValue;
    }
  public static QuickParameterTypes fromString(String text) {
    if (text != null) {
      for (QuickParameterTypes b : QuickParameterTypes.values()) {
        if (text.equalsIgnoreCase(b.myValue)) {
          return b;
        }
      }
    }
    return null;
  }
}
