package BaiBuoi6_7.Bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static List<SinhVien> sinhViens = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("MENU");
            System.out.println("1.Them 1 sinh vien");
            System.out.println("2.In thong tin cac sinh vien");
            System.out.println("3.In thong tin cac sinh vien 20 tuoi");
            System.out.println("4.Cho biet so luong sinh vien tuoi 23 va que o DN");
            System.out.println("5.Sap xep sinh vien tang dan theo que quan");
            System.out.println("6.Thoat chuong trinh.");

            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    nhap();
                    break;
                }
                case 2: {
                    xuat();
                    break;
                }
                case 3: {
                    hienThi();
                    break;
                }
                case 4: {
                    demHocSinh();
                    break;
                }
                case 5: {
                    sapXep();
                    break;
                }
                case 6: {
                    return;
                }
                default:
                    System.out.println("Khong co trong MENU");
            }
        } while (true);
    }

    public static void nhap() {
        System.out.println("Nhap thong tin 1 sv: ");
        SinhVien sinhVien = new SinhVien();
        sinhVien.input();
        sinhViens.add(sinhVien);
    }

    public static void output1() {
        System.out.printf("%-20s %-20s  %-20s %-20s %-20s \n", "Ho ten", "Tuoi", "Que quan", "Ma lop", "Ten lop");
    }

    public static void xuat() {
        if (check()) {
            output1();
            for (int i = 0; i < sinhViens.size(); i++) {
                sinhViens.get(i).output();
                System.out.println();
            }
        } else {
            System.out.println("chua co hoc sinh nao");
        }
    }

    public static void hienThi() {
        if (check()) {
            int dem = 0;
            for (int i = 0; i < sinhViens.size(); i++) {
                if (sinhViens.get(i).getTuoi() == 20) {
                    dem++;
                    if (dem == 1) {
                        output1();
                    }
                    sinhViens.get(i).output();
                    System.out.println("");
                }
            }
            if (dem == 0) {
                System.out.println("Khong co hoc sinh 20 tuoi");
            }
        } else {
            System.out.println("chua co hoc sinh nao");
        }
    }

    public static void demHocSinh() {
        if (check()) {
            int dem = 0;
            for (int i = 0; i < sinhViens.size(); i++) {
                if (sinhViens.get(i).getTuoi() == 23 && sinhViens.get(i).getQueQuan().compareTo("DN") == 0) {
                    dem++;
                }
            }
            System.out.println("So hoc sinh 23 tuoi qua o DN la: " + dem);
        } else {
            System.out.println("chua co hoc sinh nao");
        }

    }

    public static void sapXep() {
        for (int i = 0; i < sinhViens.size() - 1; i++) {
            for (int j = i + 1; j < sinhViens.size(); j++) {
                if (sinhViens.get(i).getQueQuan().compareTo(sinhViens.get(j).getQueQuan()) > 0) {
                    SinhVien item = sinhViens.get(i);
                    sinhViens.set(i, sinhViens.get(j));
                    sinhViens.set(j, item);
                }
            }
        }
    }

    public static boolean check() {
        return !sinhViens.isEmpty();
    }
}
