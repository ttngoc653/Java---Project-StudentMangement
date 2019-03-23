/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bll;

import com.dal.HocsinhHibernate;
import com.dto.Hocsinh;
import java.util.List;
/**
 *
 * @author Jossion
 */
public class HocsinhController {
    List<Hocsinh> lHs;
    HocsinhHibernate hiber;
    private Hocsinh hs;
    
    public HocsinhController(){
        hiber=new HocsinhHibernate();
    }
    
    public Hocsinh get(int id){
        if(hs==null)
            hs=new Hocsinh();
        return hs;
    }
    
    public List<Hocsinh> getList(){
        if(lHs==null)
            lHs=hiber.getAll();
        return lHs;
    }
}
