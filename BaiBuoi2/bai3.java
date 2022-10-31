package BaiBuoi2;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {     
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        int dem = 1, len = 1;
        for (int i = 1; i < n; ++i) {
            if (a[i - 1] < a[i]) {
                ++dem;
                if (dem >= len) {
                    len = dem;
                }
            }else {
                dem = 1;
            }
        }
        System.out.println(len);
    }
}
