package BaiBuoi6_7.Bai3;

import java.util.Scanner;

public class SinhVien {
    public static Scanner sc = new Scanner(System.in);

    private String hoTen;
    private int tuoi;
    private String queQuan;
    private Lop lop = new Lop();

    public SinhVien() {

    }
    public SinhVien(String hoTen, int tuoi, String queQuan, Lop lop) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.lop = lop;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public String getQueQuan() {
        return queQuan;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public Lop getLop() {
        return lop;
    }
    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public void input() {
        System.out.println("Ho ten: ");
        setHoTen(sc.nextLine());
        System.out.println("Tuoi: ");
        setTuoi(sc.nextInt());
        sc.nextLine();
        System.out.println("Que quan:  ");
        setQueQuan(sc.nextLine());
        lop.input();

    }

    public void output() {    
        System.out.printf(" %-20s %-20d %-20s", getHoTen(), getTuoi(), getQueQuan());
        lop.output();
    }
    
}
