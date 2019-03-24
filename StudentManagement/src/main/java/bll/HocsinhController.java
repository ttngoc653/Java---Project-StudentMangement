/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.HocsinhDAL;
import dto.Hocsinh;
import java.util.List;
/**
 *
 * @author Jossion
 */
public class HocsinhController {
    List<Hocsinh> lHs;
    HocsinhDAL hiber;
    private Hocsinh hs;
    
    public HocsinhController(){
        hiber=new HocsinhDAL();
    }
    
    public Hocsinh getById(int id){
        if(hs==null)
            hs=hiber.getById(id);
        return hs;
    }
    
    public Hocsinh getByName(String name){
        if(hs==null)
            hs=hiber.getByName(name);
        return hs;
    }
    
    public List<Hocsinh> getList(){
        if(lHs==null)
            lHs=hiber.getAll();
        return lHs;
    }
}
