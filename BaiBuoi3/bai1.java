package BaiBuoi4;

import java.util.Scanner;

public class bai1 {
    public static double chuVi (double r){
        double P = Math.PI * 2 * r;
        return P;
    }
    public static double dienTich (double r){
        double S = Math.PI * r*r;
        return S;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        System.out.println(chuVi(r));
        System.out.println(dienTich(r));
    }
}
