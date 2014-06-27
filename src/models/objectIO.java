/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Trung Nhan s3425479
 */
public class objectIO {

    private final File appdatafile;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private FileReader fr;
    private BufferedReader br;

    //Contructor - create or load data file into appdatafile and use that file to the end of program.
    public objectIO() {
        if (contants.getLocalFile(contants.path_datafile) != null) {
            appdatafile = contants.getLocalFile(contants.path_datafile);
        } else {
            appdatafile = new File("/models/data");
            try {
                appdatafile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(objectIO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NTLN-Error: Failure to create file!!!");
            }
        }
    }

    public void savedata(Object obj) {
        try {
            fos = new FileOutputStream(appdatafile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(objectIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NTLN-Error: Failure to write object to file!!!");
        }
    }

    public void savefile(File savefile, String content) {
        try {
            fos = new FileOutputStream(savefile);
            fos.write(content.getBytes());
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(objectIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NTLN-Error: Failure to save SQL to file!!!");
        }
    }

    public String loadfile(File openfile) {
        try {
            fr = new FileReader(openfile);
            br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            while (str != null) {
                sb.append(str).append("\n");
                str = br.readLine();
            }
            sb.delete(sb.length() - 1, sb.length());
            br.close();
            fr.close();
            return sb.toString();
        } catch (EOFException | FileNotFoundException ex) {
            Logger.getLogger(objectIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NTLN-Error: File not found!!!");
            return null;
        } catch (IOException ex) {
            Logger.getLogger(objectIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NTLN-Error: Failure to read file!!!");
            return null;
        }
    }

    public Object loaddata() {
        try {
            fis = new FileInputStream(appdatafile);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ois.close();
            fis.close();
            return obj;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(objectIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NTLN-Error: File not found!!!");
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(objectIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NTLN-Error: Failure to read object from file!!!");
            return null;
        }
    }
}
