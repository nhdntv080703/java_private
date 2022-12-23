package BaiBuoi8_9.Bai2;

import java.util.Scanner;

public class Main1 {
    static Scanner sc = new Scanner(System.in);
    static Service service = new Service();
    public static void main(String[] args) {
        do {
            System.out.println("MENU");
            System.out.println("1.Them 1 hinh");
            System.out.println("2.In thong chu vi cac hinh");
            System.out.println("3.In thong dien tich cac hinh");
            System.out.println("4.Xoa 1 hinh");
            System.out.println("5.Thoat chuong trinh.");

            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    service.nhap();
                    break;
                }
                case 2: {
                    service.xuatP();
                    break;
                }
                case 3: {
                    service.xuatA();
                    break;
                }
                case 4: {
                    service.xoa();
                    break;
                }
                case 5: {
                    return;
                }
                default:
                    System.out.println("Khong co trong MENU");
            }
        } while (true);
    }
}
