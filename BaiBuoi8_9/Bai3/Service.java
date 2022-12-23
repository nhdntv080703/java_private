package BaiBuoi8_9.Bai3;

import java.util.Scanner;

public class Service {
    public static Scanner sc = new Scanner(System.in);
    public static Zoo zoo = new Zoo();

    public void themMotChuong(){
        System.out.println("Nhap ma chuong");
        int maChuong = sc.nextInt();
        Chuong a = new Chuong(maChuong);
        zoo.themChuong(a);
        System.out.println("Them chuong thanh cong");
    }
    
    public void themMotConVat(){
        int dem = 0;
        System.out.println("Nhap ma chuong");
        int maChuong = sc.nextInt();
        sc.nextLine();
        for(Chuong chuong : zoo.chuongs){
            if(chuong.getMaChuong() == maChuong){
                System.out.println("Nhap ten con vat");
                String ten = sc.nextLine();
                System.out.println("Nhap tuoi ");
                int tuoi = Integer.parseInt(sc.nextLine());
                System.out.println("Nhap mo ta hinh dang con vat");
                String moTa = sc.nextLine();
                System.out.println("Nhap loai con vat ban muon them(cat/dog/tiger)");
                String a = sc.nextLine();
                if(a.equalsIgnoreCase("dog")){
                    Animal x = new Dog(ten,tuoi,moTa);
                    chuong.themConVat(x);
                    System.out.println("Them thanh cong loai cho");
                }
                else if (a.equalsIgnoreCase("cat")){
                    Animal x = new Cat(ten,tuoi,moTa);
                    chuong.themConVat(x);
                    System.out.println("Them thanh cong loai meo");
                }
                else if(a.equalsIgnoreCase("tiger")){
                    Animal x = new Tiger(ten,tuoi,moTa);
                    chuong.themConVat(x);
                    System.out.println("Them thanh cong loai ho");
                }
                else{
                    System.out.println("Loai con vat ban nhap vao khong hop le");
                }
                dem++;
            }
        }
        if(dem == 0) System.out.println("Ma chuong nhap vao khong hop le");   
    }

    public void xoaMotConVat(){
        System.out.print("Nhap ma chuong: ");
        int machuong = sc.nextInt();
        sc.nextLine();
        for (Chuong chuong : zoo.chuongs) {
            if (chuong.getMaChuong() == machuong) {
                System.out.print("Nhap ten con vat muon xoa: ");
                String ten = sc.nextLine();
                chuong.xoaConVat(ten);
                System.out.println("Da xoa thanh cong");
                break;
            }
        }
    }

    public void xoaMotChuong(){
        System.out.print("Nhap ma chuong: ");
        int machuong = sc.nextInt();
        zoo.xoaChuong(machuong);
        System.out.println("Đa xoa thanh cong!");
    }

    public void xuatThongTin(){
        zoo.inPut();
    }
}
