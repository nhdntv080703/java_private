package BaiBuoi8_9.Bai1;

public abstract class PhuongTien {

    private String loaiPhuongTien;
    private HangSX hangSX;

    public PhuongTien(String loaiPhuongTien, HangSX hangSanXuat) {
		this.loaiPhuongTien = loaiPhuongTien;
		this.hangSX = hangSanXuat;
	}
    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }
    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }
    public HangSX getHangSX() {
        return hangSX;
    }
    public void setHangSX(HangSX hangSX) {
        this.hangSX = hangSX;
    }

    public String layTenHangSanXuat(){
        return this.hangSX.getTenHangSanXuat();
    }

    public void batDau(){
        System.out.println("Khoi dong");
    }
    public void tangToc(){
        System.out.println("Tang toc");
    }
    public void dungLai(){
        System.out.println("Dung lai");
    }  
    
    public abstract double layVanToc();
}
