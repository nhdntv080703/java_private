package BaiBuoi8_9.Bai1;

public class MayBay extends PhuongTien{
    private String loaiNhienLieu;

    public MayBay(String loaiPhuongTien, HangSX hangSanXuat, String loaiNhienLieu) {
        super(loaiPhuongTien, hangSanXuat);
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public void catCanh(){
        System.out.println("Cat canh");
    }
    public void haCanh(){
        System.out.println("Ha canh");
    }
    @Override
    public double layVanToc(){
        return 400.0;
    }

}
