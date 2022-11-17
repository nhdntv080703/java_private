/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.Comparator;

/**
 *
 * @author PC ACER
 */
public class SortByCurrentPrice implements Comparator<Oto>{
    @Override
    public int compare(Oto t, Oto t1) {
        if(t.getCurrentPrice() > t1.getCurrentPrice()) return -1;
        else return 1;
    }
}
