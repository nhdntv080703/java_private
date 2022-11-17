/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC ACER
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Oto> otos = new ArrayList<>();
        System.out.println("Nhập số lượng ô tô");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Nhập tên chủ sở hữu");
            String owner = sc.nextLine();
            System.out.println("Nhập tên xe");
            String carName = sc.nextLine();
            System.out.println("Nhập hãng xe");
            String brand = sc.nextLine();
            System.out.println("Nhập giá");
            float price = sc.nextFloat();
            System.out.println("Nhập năm bắt đầu mua xe");
            int year = sc.nextInt();
            sc.nextLine();
            otos.add(new Oto(owner,carName,brand,price,year));
        }
        
        Oto.sortByCurrentPrice(otos);
        
        System.out.printf("\n%-20s %-20s %-20s %-20s %-20s %-20s\n", "Owner", "Name", "Brand", "Price(billion)", "Year of use", "Current price(billion)");
        for (Oto oto : otos) {
            System.out.println(oto.toString());
        }
        Oto.displayCarOutOfPrice(otos);
    }
}
//2
//Nguyen Thi B
//Toyota Cross
//Toyota
//0.9
//2
//Nguyen Van A
//Lexus ES250
//Lexus
//2.5 
//3


