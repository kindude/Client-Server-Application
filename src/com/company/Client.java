package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    Socket socket;
    ObjectOutputStream out = null; // Объект для записи в сокет
    BufferedReader in = null; // Объект для чтения из сокета
    Server server;
    public Client(Server server) throws IOException {

        this.server = server;
    }

    public void ConnectServerFromClient() throws IOException {
        socket = new Socket("localhost", 8001);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }
    public void WriteSocket(Object obj) throws IOException {
        out.writeObject(obj);
        System.out.println(obj);
    }


}
