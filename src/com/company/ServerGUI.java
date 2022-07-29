package com.company;

import jdk.dynalink.Operation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServerGUI extends JFrame{
    private Server server;
    private JPanel panel1;
    private JLabel jLabel1;
    private JButton отобразитьButton;
    private JTextArea textArea1;
    private JButton перезаписатьФайлButton;

    private String str;
    public ServerGUI() throws IOException {
        Settings();
        отобразитьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    str = "";
                    ArrayList<StaffMember> members = server.getMembers();
                    for(int i=0;i<members.size();i++)
                        str += (members.get(i).toString()) +"\n";
                Runnable runnable = () -> {
                    textArea1.selectAll();
                    textArea1.replaceSelection("");
                    textArea1.append(str);
                };
                runnable.run();
            }
        });

        перезаписатьФайлButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter("notes3.csv");
                    fw.write(str);
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void setServer(Server server)
    {
         this.server = server;
    }
    public void Settings(){
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setBounds(100,100,800,600);
    }

}
