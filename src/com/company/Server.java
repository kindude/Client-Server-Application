package com.company;

import com.company.Connection;
import com.company.StaffMember;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends Thread{
    ServerSocket serverSocket;
    ArrayList<StaffMember> members;
    private JTextArea jTextArea;

    // Объект для чтения из сокета
    public Server() throws IOException {
        members = new ArrayList<>();
        try {
           // *//*Создание объекта ServerSocket, который принимает запросы
           //  * соединения от клиентов от порта 8001*//*
            serverSocket = new ServerSocket(8001);
            this.start();
            System.out.println("Server is running . . .");
        }
        catch (IOException e) {
            fail(e, "Could not start server.");
        }
    }
    @Override
    public void run() {

        try {
            while (true) {
                /* Принимаются запросы от клиентов */
                new Connection(serverSocket.accept(),members).start();
            }
        } catch (IOException e) {
            fail(e, "Not listening");
        }
    }
    public static void fail(Exception e, String str) {
        System.out.println(str + "." + e);
    }

    public  ArrayList<StaffMember> getMembers(){
        return members;
    }

}
