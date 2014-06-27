/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.File;

/**
 *
 * @author NTN
 */
public final class contants {
    public static final String path_datafile = "/models/data";
    
    //GetLocalFile
    public static File getLocalFile(String filepath) {
        if (contants.class.getResource(filepath) != null)  {
            return new File(contants.class.getResource(filepath).getPath());
        } else {
            return null;
        }
    }
}
