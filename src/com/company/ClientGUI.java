package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;


public class ClientGUI extends JFrame {
    public JPanel panel1;
    private JButton файлButton;
    private JButton отобразитьButton;
    private JTextArea textArea1;
    private JButton сериализоватьButton;
    private JButton передатьНаСерверButton;
    private JButton подключитсяКСерверуButton;
    JFileChooser fileChooser = new JFileChooser();
    private final int[] result = new int[1];
    private JLabel label1;
    private JLabel label2;
    private ReadObject ro;
    private WriteObject wo;
    private File selectedFile;
    private ArrayList<StaffMember> members;
    private String str;
    Client cl;
    static Server server;
    public ClientGUI() throws IOException {
        Settings();
        cl = new Client(this.server);

        файлButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                try {
                    fileChooser.setCurrentDirectory(new File(("D:\\")).getCanonicalFile());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                result[0] = fileChooser.showOpenDialog(getParent());
                if (result[0] == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    try {
                        readFile();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        отобразитьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Display();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        сериализоватьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    str = toString(members);
                    Display();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            private String toString(Serializable o ) throws IOException {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream( baos );
                oos.writeObject( o );
                oos.close();
                return Base64.getEncoder().encodeToString(baos.toByteArray());
            }
        });
        подключитсяКСерверуButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cl.ConnectServerFromClient();
                    System.out.println("Клиент подключился к серверу. Ожидание данных...\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        передатьНаСерверButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Данные переданы на сервер:\n");
                    cl.WriteSocket(members);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void readFile() throws IOException {
        ro = new ReadObject(selectedFile.toString());
        members = ro.ReadInitialFile(String.valueOf(selectedFile));
    }

    public void Display() throws IOException {
      textArea1.selectAll();
      textArea1.replaceSelection("");
        if(str == null)
        {   str = members.get(0).toString() +"\n";
            for(int i=1;i<members.size();i++)
                str += members.get(i).toString() +"\n";
            textArea1.append(str);
        }
        else{
            textArea1.append(str);
        }
    }
    public void Settings()
    {
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setBounds(100,100,800,600);
    }
}
