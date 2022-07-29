package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class Connection extends Thread {

    protected Socket netClient;
    protected ObjectInputStream fromClient;
    protected PrintStream toClient;
    protected ArrayList<StaffMember> members;


    public Connection(Socket client, ArrayList<StaffMember> members) throws IOException {
        netClient = client;
        this.members = members;
    }

    @Override
    public void run() {
        Object obj;
        try {
            fromClient = new ObjectInputStream(netClient.getInputStream());
            /* Создается выходной поток, чтобы посылать данные клиенту */
            toClient = new PrintStream(netClient.getOutputStream());
        } catch (IOException e) {
            try {
                /* Закрывается сокет клиента */
                netClient.close();
            } catch (IOException e1) {
                System.err.println("Unable to set up streams" + e1);
                return;
            }
        }

        try {
            while (( obj = fromClient.readObject())!= null) {
                members.clear();
                members.addAll((ArrayList<StaffMember>)obj);
                System.out.println("Данные полученные сервером:\n");
                System.out.println(members);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception");
        }
    }
}


