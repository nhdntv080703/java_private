package BaiBuoi8_9.Bai1;

public class XeDap extends PhuongTien{

    public XeDap(String loaiPhuongTien, HangSX hangSanXuat) {
        super(loaiPhuongTien, hangSanXuat);
    }

    @Override
    public double layVanToc() {
        return 20.0;
    }
}
