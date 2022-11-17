/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author PC ACER
 */
public class NhanVien {
    static int dem = 1;
    private int id;
    private String hoTen;
    private String kieuNhanVien;
    private int soNgayLam;
    private int namVaoLam;

    public NhanVien( String hoTen, String kieuNhanVien, int soNgayLam, int namVaoLam) {
        this.id = dem++;
        this.hoTen = hoTen;
        this.kieuNhanVien = kieuNhanVien;
        this.soNgayLam = soNgayLam;
        this.namVaoLam = namVaoLam;
    }
    
    public long luongNhanVien(){
        long luong = 0;
        if(this.kieuNhanVien.equals("San xuat"))
            luong = (long)this.soNgayLam * 350000;
        else 
            luong = (long)this.soNgayLam * 400000;
        return luong;
    }
    public long phuCap(){
        long luongPhuCap = 100000 + (2022-(long)this.namVaoLam)*200000;
        return luongPhuCap;
    }
    public long tongLuongNhanVien(){
        long tongLuong = luongNhanVien() + phuCap();
        return tongLuong;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-20s %-15s %-15d %-15d %-20d %-10d %-10d",id,hoTen,kieuNhanVien,soNgayLam,namVaoLam,luongNhanVien(), phuCap(),tongLuongNhanVien());
    }
    
}
