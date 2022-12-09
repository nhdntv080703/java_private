package BaiBuoi6_7.Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinh> dsts = new ArrayList<>();
        System.out.println("MENU");
        System.out.println("1. Them 1 thi sinh");
        System.out.println("2. In ra danh sach thi sinh");
        System.out.println("3. Tim kiem sinh vien theo so bao danh");
        System.out.println("4. Thoat chuong trinh");

        int choose;
        while(true){
            System.out.print("Nhap lua chon: ");
            choose = sc.nextInt();
            sc.nextLine();
            if(choose == 1) {
                ThiSinh ts = new ThiSinh();
                ThiSinh.themThiSinh(dsts, ts);
            }
            if(choose == 2)
                ThiSinh.xuatThisinh(dsts);
            if(choose == 3){
                System.out.print("Nhap SBD muon tim: ");
                int other_sbd = sc.nextInt();
                sc.nextLine();
                ThiSinh timThiSinh = ThiSinh.timThiSinhTheoSbd(dsts, other_sbd);
                if (timThiSinh == null) {
                    System.out.println("Khong tim thay thi sinh");
                } else {
                    timThiSinh.output();
                }
            }
            if(choose == 4)
                return;
        }
    }
}
