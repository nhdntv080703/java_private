package BaiBuoi8_9.Bai3;

import java.util.Scanner;

public class Cat extends Animal{
    public static Scanner sc = new Scanner(System.in);

    public Cat(String ten, int tuoi, String moTa) {
        super(ten, tuoi, moTa);
    }

    @Override
    void tiengKeu() {
        System.out.println("Meoww Meoww");
    }
    
    @Override
    void xemThongTin() {
        System.out.printf("%-20s %-20s %-20s", getTen(), getTuoi(), getMoTa());
        tiengKeu();
    }

}
