/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

import java.util.Comparator;

/**
 *
 * @author PC ACER
 */
public class SortByScore implements Comparator<SinhVien>{
    @Override
    public int compare(SinhVien t, SinhVien t1) {
        if(t.getScore() > t1.getScore()) return -1;
        else return 1;
    }
}
