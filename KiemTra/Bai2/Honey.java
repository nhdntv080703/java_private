package KiemTra.Bai2;

import java.util.List;

public class Honey extends Persion{
    private String ten;
    private int tuoi;
    private String sdt; 
    private String id;
    private List<Favorite> favoriteList;

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
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public List<Favorite> getFavoriteList() {
        return favoriteList;
    }
    public void setFavoriteList(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }
    public Honey(String ten, int tuoi, String sdt, List<Favorite> favoriteList) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.sdt = sdt;
        this.favoriteList = favoriteList;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    

    
    
    
}
