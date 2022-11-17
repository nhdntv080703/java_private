/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author PC ACER
 */
public class NhanVien1 {
    private String ten;
    private int tuoi;
    private String diaChi;
    private String gioiTinh;
    private int soGioLam;
    private int hourlyRate;

    public NhanVien1(String ten, int tuoi, String diaChi, String gioiTinh, int soGioLam, int hourlyRate) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.soGioLam = soGioLam;
        this.hourlyRate = hourlyRate;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public float getHourlyRate() {
        return (float) (hourlyRate > 45 ? 45 + (hourlyRate - 45) * 1.5 : hourlyRate);
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // some deductive attributes below
    public float getSalary() {
        return this.soGioLam * getHourlyRate();
    }

    public float getTax() {
        return (float) (getSalary() > 300 ? 0.02 : 0);
    }

    public float getLuong() {
        return getSalary() - getSalary() * getTax();
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20d %-20s %-20d %-20f %-20f %-20f", this.ten, this.tuoi, this.diaChi, this.soGioLam, getHourlyRate(), getSalary(), getLuong());
    }
    public static void output(ArrayList<NhanVien1> nhanViens, int n) {
        System.out.printf("\n%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Tên", "Tuổi", "Địa chỉ", "Số giờ làm ", "Số tiền/1h", "Lương", "Tổng thu nhập");
        for (int i = 0; i < n; i++) {
            System.out.println(nhanViens.get(i).toString());
        }
    }
    public static void findByName(ArrayList<NhanVien1> nhanViens, String name) {
        int dem = 0;
        System.out.printf("\n%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Tên", "Tuổi", "Địa chỉ", "Số giờ làm ", "Số tiền/1h", "Lương", "Tổng thu nhập");
        for(NhanVien1 nv : nhanViens){
            if(nv.getTen().equals(name) == true){
                System.out.println(nv.toString());
                dem++;
            }
        }
        if (dem == 0) {
            System.out.print("\nKhông tìm thấy");
        }
    }

    public static void sortByHoursWorked(ArrayList<NhanVien1> nhanViens) {
        Collections.sort(nhanViens, new SortByHoursWorked());
    }
}
