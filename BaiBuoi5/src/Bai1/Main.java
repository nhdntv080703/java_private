/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.util.Scanner;

/**
 *
 * @author PC ACER
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        NhanVien []a = new NhanVien[n];
        for(int i = 0; i < n; i++){
            System.out.println("Nhập họ tên");
            String hoTen = sc.nextLine();
            System.out.println("Nhập kiểu nhân viên");
            String kieuNhanVien = sc.nextLine();
            System.out.println("Nhập số ngày vào làm");
            int soNgayLam = sc.nextInt();
            System.out.println("Nhập năm vào làm");
            int namVaoLam = sc.nextInt();
            sc.nextLine();
            a[i] = new NhanVien(hoTen,kieuNhanVien,soNgayLam,namVaoLam);
        }
         System.out.printf("%-10s %-20s %-15s %-15s %-15s %-20s %-10s %-10s\n","ID","Tên","Kiểu","Số ngày làm","Năm bắt đầu","Lương (million)","Phụ cấp","Tổng");
        for(NhanVien i : a){
            System.out.println(i.toString());
        }
    }
    
}
//2
//Nguyen Van A
//San xuat
//27
//2022
//Nguyen Thi B
//Van phong
//26
//2019