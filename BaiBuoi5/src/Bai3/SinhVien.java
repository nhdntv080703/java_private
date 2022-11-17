/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author PC ACER
 */
public class SinhVien {
    private static int cnt = 0;
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private float score;

    public SinhVien() {
        this.id = ++cnt;
    }

    public SinhVien(String name, String address, String phoneNumber, float score) {
        this.id = ++cnt;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return String.format("%-10d %-20s %-20s %-20s %-20s", getId(), getName(), getAddress(), getPhoneNumber(), getScore());
    }
    public static void output(ArrayList<SinhVien> sinhViens) {
        System.out.printf("\n%-10s %-20s %-20s %-20s %-20s\n", "ID", "Name", "Address", "Phone number", "Score");
        for (SinhVien sv : sinhViens) {
            System.out.println(sv.toString());
        }
    }

    public int dem(String name){
        String []s = name.split("\\s+");
        return s.length;
    }
    
    public static void sortByScore(ArrayList<SinhVien> sinhViens) {
        Collections.sort(sinhViens, new SortByScore());
    }
    public static void sortByName(ArrayList<SinhVien> sinhViens) {
        Collections.sort(sinhViens, new SortByName());
    }
    
    public static void findByName(ArrayList<SinhVien> sinhViens, String name) {
        int dem = 0;
        System.out.printf("\n%-10s %-20s %-20s %-20s %-20s\n", "ID", "Name", "Address", "Phone number", "Score");
        for(SinhVien sv : sinhViens){
            if(sv.getName().equals(name) == true){
                System.out.println(sv.toString());
                dem++;
            }
        }
        if (dem == 0) {
            System.out.print("\nNot found");
        }
    }
    
}
