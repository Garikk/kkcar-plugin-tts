/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.engines.festival_simple;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sayma_000
 */
public class Festival_Simple {

    Queue<String> SayQueue;
    boolean Start=false;
    boolean State;
    Thread SayWork = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Festival_Simple.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (SayQueue.size() > 0) {
                    try {
                        String Text = SayQueue.poll();
                        Process P;
                        P = Runtime.getRuntime().exec("./tts.sh " + Text);
                        P.waitFor();
                    } catch (IOException ex) {
                        Logger.getLogger(Festival_Simple.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Festival_Simple.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    });

    public Festival_Simple() {
        SayQueue = new ArrayDeque<>();
    }

    public void SayText(String Text) {
        SayQueue.add(Text);
        if (!Start)
        {
            SayWork.start();
            Start=true;
        }

    }
}
