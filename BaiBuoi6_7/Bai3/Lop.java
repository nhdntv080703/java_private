package BaiBuoi6_7.Bai3;

import java.util.Scanner;

public class Lop {
    public static Scanner sc = new Scanner(System.in);

    private String maLop;
    private String tenlop;

    public Lop() {

    }
    public Lop(String maLop, String tenlop) {
        this.maLop = maLop;
        this.tenlop = tenlop;
    }

    public String getMaLop() {
        return maLop;
    }
    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    public String getTenlop() {
        return tenlop;
    }
    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public void input() {
        System.out.println("Nhap ma lop: ");
        setMaLop(sc.nextLine());
        System.out.println("Ten lop: ");
        setTenlop(sc.nextLine());
    }

    public void output() {
        System.out.printf("%-20s %-20s", getMaLop(), getTenlop());
    }
}
