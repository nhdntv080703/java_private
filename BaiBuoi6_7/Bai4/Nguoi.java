package BaiBuoi6_7.Bai4;

public class Nguoi {
    private String hoTen;
    private int tuoi;
    private String diaChi;
    private int maGV;
    private CBGV cbgv = new CBGV();

    public Nguoi(){
    }

    public Nguoi(String hoTen, int tuoi, String diaChi, int maGV) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.maGV = maGV;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    
    public void inPut(){
        System.out.println("Nhập họ tên:");
        setHoTen(CBGV.sc.nextLine());
        System.out.println("Nhập tuổi:");
        setTuoi(CBGV.sc.nextInt());
        CBGV.sc.nextLine();
        System.out.println("Nhập địa chỉ:");
        setDiaChi(CBGV.sc.nextLine());
        System.out.println("Nhập mã giáo viên:");
        setMaGV(CBGV.sc.nextInt());
        CBGV.sc.nextLine();
        cbgv.inPut();
    }
    public void outPut(){
        System.out.printf("%-15s %-15d %-10s %-15d ",getHoTen(),getTuoi(),getDiaChi(),getMaGV());
        cbgv.outPut();
    }
}
