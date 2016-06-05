/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.tts.engines.externalttsserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blinov_is
 */
public class TTSUDPClient {
    private final int WD_UDPPORT=39877;
    private boolean Stop;
    Queue<String> SendMessage;

    public TTSUDPClient()
    {
     SendMessage=new ArrayDeque<>();
    }
    public void Stop() {
        Stop = true;
    }

    public void SendMessage(String Text)
    {
        if (!Stop)
            SendMessage.add(Text+"$$$$");
    }
    public void StartWDUDPClient() {
        Thread myThready = new Thread(new Runnable() {
            @Override
            public void run() {
                DatagramSocket clientSocket = null;

                try {
                    clientSocket = new DatagramSocket();
                } catch (SocketException ex) {
                    Logger.getLogger(TTSUDPClient.class.getName()).log(Level.SEVERE, null, ex);
                }

                 InetAddress IPAddress=null;
                try {
                    IPAddress = InetAddress.getByName("localhost");
                } catch (UnknownHostException ex) {
                    Stop=true;
                    Logger.getLogger(TTSUDPClient.class.getName()).log(Level.SEVERE, null, ex);
                 }
                try {
                    while (!Stop) {
                        if (!SendMessage.isEmpty())
                        {
                            String Msg=(String)SendMessage.poll();
                            
                            byte[] sendData=Msg.getBytes();

                            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, WD_UDPPORT);
                            clientSocket.send(sendPacket);
                        }
                    }
                    clientSocket.close();
                } catch (IOException ex) {
                    Stop=true;
                    Logger.getLogger(TTSUDPClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("STOP UDP");
            }
        });
        myThready.start();
    }
}
