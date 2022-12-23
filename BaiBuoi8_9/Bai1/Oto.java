package BaiBuoi8_9.Bai1;

public class Oto extends PhuongTien{
    private String loaiNhienLieu;

    public Oto(String loaiPhuongTien, HangSX hangSanXuat, String loaiNhienLieu) {
        super(loaiPhuongTien, hangSanXuat);
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }
    @Override
    public double layVanToc(){
        return 60.0;
    }
}
