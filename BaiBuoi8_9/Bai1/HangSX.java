package BaiBuoi8_9.Bai1;

import java.util.Scanner;

public class HangSX {
    public static Scanner sc = new Scanner(System.in);

    private String tenHangSanXuat;
    private String tenQuocGia;
    
    public HangSX(String tenHangSanXuat, String tenQuocGia) {
		this.tenHangSanXuat = tenHangSanXuat;
		this.tenQuocGia = tenQuocGia;
	}

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }
    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }
    public String getTenQuocGia() {
        return tenQuocGia;
    }
    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }
    
    public void inPut(){
        System.out.println("Nhap ten hang san xuat : ");
        setTenHangSanXuat(sc.nextLine());
        System.out.println("Nhap ten quoc gia : ");
        setTenQuocGia(sc.nextLine());
    }

    public void outPut(){
        System.out.printf("%-20d %-20d\n", getTenHangSanXuat(), getTenQuocGia());
    }
}
