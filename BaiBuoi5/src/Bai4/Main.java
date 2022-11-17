/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC ACER
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<NhanVien1> nhanViens = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập tên");
            String ten = sc.nextLine();
            System.out.println("Nhập tuổi");
            int tuoi = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhập địa chỉ");
            String diaChi = sc.nextLine();
            System.out.println("Nhập giới tính");
            String gioiTinh = sc.nextLine();
            System.out.println("Nhập số giờ làm");
            int soGioLam = sc.nextInt();
            System.out.println("Nhập số tiền nhận được trong 1 giờ làm");
            int hourlyRate = sc.nextInt();
            sc.nextLine();
            nhanViens.add(new NhanVien1(ten,tuoi,diaChi,gioiTinh,soGioLam,hourlyRate));
        }

          int lc;
        while(true) {
            System.out.println("\n\n1: Thêm 1 nhân viên");
            System.out.println("2: Hiển thị danh sách nhân viên");
            System.out.println("3: Hiển thị top 3 nhân viên chăm chỉ nhất");
            System.out.println("4: Tìm nhân viên theo tên");
            System.out.println("5: Dừng chương trình\n");

            System.out.print("\nNhập lựa chọn của bạn: ");
            lc = sc.nextInt();
            sc.nextLine();
            if (lc == 1) {
                String ten = sc.nextLine();
                int tuoi = sc.nextInt();
                sc.nextLine();
                String diaChi = sc.nextLine();
                String gioiTinh = sc.nextLine();
                int soGioLam = sc.nextInt();
                int hourlyRate = sc.nextInt();
                sc.nextLine();
                nhanViens.add(new NhanVien1(ten,tuoi,diaChi,gioiTinh,soGioLam,hourlyRate));
            } else if (lc == 2) {
                NhanVien1.output(nhanViens, nhanViens.size());
            } else if (lc == 3) {
                NhanVien1.sortByHoursWorked(nhanViens);
                NhanVien1.output(nhanViens, 3);
            } else if (lc == 4) {
                System.out.print("\nNhập tên người bạn muốn tìm kiếm: ");
                String findName = sc.nextLine();
                NhanVien1.findByName(nhanViens, findName);
            }
            else if(lc == 5){
                return;
            }
        }
    }
}
//2
//Nguyen Hoang Dung
//19
//Nghe An
//Nam
//50
//100
//Do Quang Lam
//18
//Ninh Binh
//Nam
//30
//50
//Nguyen The Dat
//20
//Thai Binh
//Nam
//20