package com.company;

import java.io.IOException;

public class Main {
    ClientGUI clientGUI1,clientGUI2;
    ServerGUI serverGUI;
    public static void main(String[] args) throws IOException {
        Server server =  new Server();
        ServerGUI serverGUI =  new ServerGUI();
        serverGUI.setServer(server);
        ClientGUI clientGUI2 = new ClientGUI();
        ClientGUI clientGUI1 = new ClientGUI();
    }
}
