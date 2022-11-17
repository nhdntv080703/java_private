/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

import java.util.Comparator;

/**
 *
 * @author PC ACER
 */
public class SortByHoursWorked implements Comparator<NhanVien1>{

    @Override
    public int compare(NhanVien1 t, NhanVien1 t1) {
        if(t.getSoGioLam() > t1.getSoGioLam()) return -1;
        else return 1;
    }
    
}
