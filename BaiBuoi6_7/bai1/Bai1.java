package BaiBuoi6_7.bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    public static void timKiem(List<String> tens, String ten) {
        for (int i = 0; i < tens.size(); i++) {
            if (tens.get(i).contains(ten)) {
                System.out.println(tens.get(i));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> tens = new ArrayList<>();
        System.out.println("Nhập các chuỗi: ");
        for (int i = 0; i < n; i++) {
            String x = sc.nextLine();
            tens.add(x);
        }
        System.out.print("Nhập chuỗi con: ");
        String ten = sc.nextLine();
        System.out.println("Các chuỗi chứa chuỗi con là: ");
        timKiem(tens, ten);
    }
}
