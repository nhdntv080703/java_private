/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PC ACER
 */
public class Oto {
    private String owner;
    private String carName;
    private String brand;
    private float price;
    private int year;

    public Oto(String owner, String carName, String brand, float price, int year) {
        this.owner = owner;
        this.carName = carName;
        this.brand = brand;
        this.price = price;
        this.year = year;
    }
    
    public float getCurrentPrice() {
        return this.price - (this.price * this.year * (this.price < 1 ? (float) 0.07 : (this.price <= 2 ? (float) 0.05 : (float) 0.03)));
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-20f %-20d %-20f", this.owner, this.carName, this.brand, this.price, this.year, this.getCurrentPrice());
    }
    
    public static void sortByCurrentPrice(ArrayList<Oto> arr){
        Collections.sort(arr, new SortByCurrentPrice());
    }
    
    public static void displayCarOutOfPrice(ArrayList<Oto> otos) {
        System.out.println("");
        System.out.println("Các oto đã hết giá trị là : ");
        int dem = 0;
        for (Oto oto : otos) {
            if (oto.getCurrentPrice() <= 0) {
                System.out.println(oto.toString());
                dem++;
            }
        }
        if(dem == 0) System.out.println("Không có oto nào hết giá trị");
    }
}
