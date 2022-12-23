package BaiBuoi8_9.Bai3;

import java.util.Scanner;

public class Dog extends Animal{
    public static Scanner sc = new Scanner(System.in);

    public Dog(String ten, int tuoi, String moTa) {
        super(ten, tuoi, moTa);
    }

    @Override
    void tiengKeu() {
        System.out.println("Gau Gau Gau");
    }
    
    @Override
    void xemThongTin() {
        System.out.printf("%-20s %-20s %-20s", getTen(), getTuoi(), getMoTa());
        tiengKeu();
    }

}
