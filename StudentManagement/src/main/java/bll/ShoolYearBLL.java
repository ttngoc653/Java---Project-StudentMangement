/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

/**
 *
 * @author Tan
 */
public class ShoolYearBLL {
    public boolean ktnamhople(String nam) {
        int temp;
        try {
            temp = Integer.parseInt(nam);
        } catch (NumberFormatException e) {
            return false;
        }
        if (temp > 1900 && temp < 2100) {
            return true;
        }
        return false;

    }
    
}
