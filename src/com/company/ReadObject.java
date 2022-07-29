package com.company;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadObject {
private String fileName;
private Exception e = null;
private String InitFile;
    public ReadObject(String fileName)
    {
        this.fileName = fileName;
    }

    public ArrayList<StaffMember> ProcessDesirializing() throws IOException {
       ArrayList<StaffMember> object =  null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            object = (ArrayList<StaffMember>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

            this.e = e;
        }
        return object;
}
    public String LogInfo() throws IOException {
        if(e!= null) return e.toString();
        else return "Deserializing success";
    }

    public ArrayList<StaffMember> ReadInitialFile(String InitFile ) throws IOException
    {
        ArrayList<StaffMember> InitObjects= new ArrayList<>();
        FileReader fr;
        Scanner scan;
        fr = new FileReader(InitFile);
        scan = new Scanner(fr);
        String [] temporary;
        while(scan.hasNextLine())
        {
            temporary = (((String)(scan.nextLine())).split(","));
            if (temporary.length == 4)
            {
               StaffMember sm =  new StaffMember(temporary[0], temporary[1], Integer.parseInt(temporary[2]), Double.parseDouble(temporary[3]));
               InitObjects.add(sm);
            }
            else
            {
               PartTimeMember ptm =  new PartTimeMember(temporary[0],temporary[1],Integer.parseInt(temporary[2]),Double.parseDouble(temporary[3]),temporary[4],Integer.parseInt(temporary[5]),Double.parseDouble(temporary[6]));
              InitObjects.add(ptm);
            }
        }
        return InitObjects;
    }
}
