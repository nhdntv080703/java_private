package BaiBuoi6_7.Bai4;

import java.util.Scanner;

public class CBGV {
    public static Scanner sc=new Scanner(System.in);
    
    private float luongCung;
    private float luongThuong;
    private float luongPhat;

    public CBGV(){
    }

    public CBGV(float luongCung, float luongThuong, float luongPhat) {
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.luongPhat = luongPhat;
    }

    public float getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(float luongCung) {
        this.luongCung = luongCung;
    }

    public float getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(float luongThuong) {
        this.luongThuong = luongThuong;
    }

    public float getLuongPhat() {
        return luongPhat;
    }

    public void setLuongPhat(float luongPhat) {
        this.luongPhat = luongPhat;
    }
    
    public void inPut(){
        System.out.println("Nhập lương cứng:");
        setLuongCung(sc.nextFloat());
        System.out.println("Nhập lương thưởng:");
        setLuongThuong(sc.nextFloat());
        System.out.println("Nhập lương phạt:");
        setLuongPhat(sc.nextFloat());
    }
    public float luong(){
        float tongLuong = 0;
        tongLuong += (luongCung+luongThuong)-luongPhat;
        return tongLuong;
    }

    public void outPut(){
        System.out.printf("%-15f %-15f %-15f %-15f\n",getLuongCung(),getLuongThuong(),getLuongPhat(),luong());
    }

}
