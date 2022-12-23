package BaiBuoi8_9.Bai3;

import java.util.Scanner;

public class TestZoo {
    static Scanner sc = new Scanner(System.in);
    static Service service = new Service();
    public static void main(String[] args) {
        do {
            System.out.println("\tMENU");
            System.out.println("1.Them 1 chuong");
            System.out.println("2.Them 1 con vat");
            System.out.println("3.Xoa 1 con vat");
            System.out.println("4.Xoa 1 chuong");
            System.out.println("5.Xem tat ca cac con vat");
            System.out.println("6.Thoat chuong trinh.");

            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    service.themMotChuong();
                    break;
                }
                case 2: {
                    service.themMotConVat();
                    break;
                }
                case 3: {
                    service.xoaMotConVat();
                    break;
                }
                case 4: {
                    service.xoaMotChuong();
                    break;
                }
                case 5: {
                    service.xuatThongTin();
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
}
