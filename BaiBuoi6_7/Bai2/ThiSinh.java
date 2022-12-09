package BaiBuoi6_7.Bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThiSinh {
    public static Scanner sc = new Scanner(System.in);
    
    private long sbd;
    private String hoTen;
    private String diaChi;
    private String mucUuTien;
    private Khoi khoi = new Khoi();

    public ThiSinh() {

    }
    public ThiSinh(long sbd, String hoTen, String diaChi, String mucUuTien, Khoi khoi) {
        this.sbd = sbd;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
        this.khoi = khoi;
    }
    
    public long getSbd() {
        return sbd;
    }
    public void setSbd(long sbd) {
        this.sbd = sbd;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getMucUuTien() {
        return mucUuTien;
    }
    public void setMucUuTien(String mucUuTien) {
        this.mucUuTien = mucUuTien;
    }
    public Khoi getKhoi() {
        return khoi;
    }
    public void setKhoi(Khoi khoi) {
        this.khoi = khoi;
    }

    public void input() {
        System.out.print("Nhap SBD: ");
        setSbd(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap ho ten: ");
        setHoTen(sc.nextLine());
        System.out.print("Nhap dia chi: ");
        setDiaChi(sc.nextLine());
        System.out.print("Nhap muc uu tien: ");
        setMucUuTien(sc.nextLine());
        System.out.println("Nhap cac mon thi: ");
        System.out.print("Mon 1: ");
        getKhoi().setMon1(sc.nextLine());
        System.out.print("Mon 2: ");
        getKhoi().setMon2(sc.nextLine());
        System.out.print("Mon 3: ");
        getKhoi().setMon3(sc.nextLine());
    }

    public String locKhoi(ThiSinh ts) {
        String khoiThi;

        List<String> monThiKhoiA = new ArrayList<>();
        monThiKhoiA.add("toan");
        monThiKhoiA.add("ly");
        monThiKhoiA.add("hoa");

        List<String> monThiKhoiB = new ArrayList<>();
        monThiKhoiA.add("toan");
        monThiKhoiA.add("hoa");
        monThiKhoiA.add("sinh");

        List<String> monThiKhoiC = new ArrayList<>();
        monThiKhoiA.add("van");
        monThiKhoiA.add("su");
        monThiKhoiA.add("dia");

        if(monThiKhoiA.contains(ts.getKhoi().getMon1().toLowerCase()) && monThiKhoiA.contains(ts.getKhoi().getMon2().toLowerCase()) && monThiKhoiA.contains(ts.getKhoi().getMon3().toLowerCase())) {
            khoiThi = "A";
        } else if (monThiKhoiB.contains(ts.getKhoi().getMon1().toLowerCase()) && monThiKhoiB.contains(ts.getKhoi().getMon2().toLowerCase()) && monThiKhoiB.contains(ts.getKhoi().getMon3().toLowerCase())) {
            khoiThi = "B";
        } else if (monThiKhoiC.contains(ts.getKhoi().getMon1().toLowerCase()) && monThiKhoiC.contains(ts.getKhoi().getMon2().toLowerCase()) && monThiKhoiC.contains(ts.getKhoi().getMon3().toLowerCase())) {
            khoiThi = "C";
        } else {
            khoiThi = "Khong xac dinh";
        }

        return khoiThi;
    }

    public static void themThiSinh(List<ThiSinh> thiSinhs, ThiSinh thiSinh) {
        thiSinh.input();
        thiSinhs.add(thiSinh);
    }

    public void output() {
        System.out.printf("%-20d %-20s %-20s %-20s %s\n",this.getSbd(), this.getHoTen(), this.getDiaChi(), this.getMucUuTien(), this.locKhoi(this));
    }

    public static void output1() {
        System.out.printf("%-20s %-20s %-20s %-20s %s\n","SBD", "Ho Ten", "Dia Chi", "Muc Uu Tien", "Khoi Thi");
    }

    public static void xuatThisinh(List<ThiSinh> thiSinhs) {
        output1();
        for(ThiSinh ts:thiSinhs) {
            ts.output();
        }
    }

    public static ThiSinh timThiSinhTheoSbd(List<ThiSinh> thiSinhs, int sbd) {
        for (ThiSinh thiSinh : thiSinhs) {
            if(thiSinh.getSbd() == sbd) {
                return thiSinh;
            }
        }
        return null;
    }
}
