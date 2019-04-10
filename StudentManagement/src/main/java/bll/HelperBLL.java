/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.Random;

/**
 *
 * @author Normal_User
 */
public class HelperBLL {
    public static String randomPassword(){
        String str="";
        Random rd= new Random();
        for (int i = 0; i < 8; i++) {
            // r from 32 to 126 by type char
            str += Character.toString((char)(rd.nextInt(126-32)+32));
        }
        return str;
    }
}
