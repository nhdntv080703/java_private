/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

import java.util.Comparator;
import java.util.function.Function;

/**
 *
 * @author PC ACER
 */
public class SortByName implements Comparator<SinhVien>{
    public String layRaTen(String name){
        String []s = name.split("\\s+");
        return s[s.length-1];
    }
    @Override
    public int compare(SinhVien t, SinhVien t1){
        if(layRaTen(t.getName()).compareTo(layRaTen(t1.getName())) > 0) return 1;
        else return -1;
    }


}
