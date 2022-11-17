/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC ACER
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên ");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<SinhVien> sinhViens = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            System.out.println("Nhập tên");
            String name = sc.nextLine();
            System.out.println("Nhập địa chỉ");
            String address = sc.nextLine();
            System.out.println("Nhập số điện thoại");
            String phoneNumber = sc.nextLine();
            System.out.println("Nhập điểm");
            float score = sc.nextFloat();
            sc.nextLine();
            sinhViens.add(new SinhVien(name,address,phoneNumber,score));
        }

        int lc;
        while(true){
            System.out.println("\n\n1: Hiển thị sinh viên tăng dần theo điểm");
            System.out.println("2: Tìm sinh viên theo tên");
            System.out.println("3: Hiển thị sinh viên tăng dần theo tên");
            System.out.println("4: Dừng chương trình \n");
            
            System.out.println("Nhập lựa chọn của bạn");
            lc = sc.nextInt();
            sc.nextLine();
            if (lc == 1) {
                SinhVien.sortByScore(sinhViens);
                SinhVien.output(sinhViens);
            } else if (lc == 2) {
                System.out.print("\nNhập tên sinh viên bạn muốn tìm kiếm: ");
                String findName = sc.nextLine();
                SinhVien.findByName(sinhViens, findName);
            } else if (lc == 3) {
                SinhVien.sortByName(sinhViens);
                SinhVien.output(sinhViens);
            }
            else {
                return ;
            }
        }
    }
}
//3
//Nguyen Hoang Dung
//Nghe An
//0962618566
//10
//Do Quang Lam
//Ninh Binh
//0945534135
//8.5
//Nguyen The Dat
//Thai Binh
//0565345654
//9.5
