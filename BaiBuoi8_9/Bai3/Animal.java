package BaiBuoi8_9.Bai3;

public abstract class Animal {
    private String ten;
    private int tuoi;
    private String moTa;
    abstract void xemThongTin();
    abstract void tiengKeu();
    
    public Animal() {
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
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public Animal(String ten) {
        this.ten = ten;
    }
    public Animal(int tuoi) {
        this.tuoi = tuoi;
    }
    public Animal(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }
    public Animal(int tuoi, String moTa) {
        this.tuoi = tuoi;
        this.moTa = moTa;
    }
    public Animal(String ten, String moTa) {
        this.ten = ten;
        this.moTa = moTa;
    }
    public Animal(String ten, int tuoi, String moTa) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.moTa = moTa;
    }
    
}
