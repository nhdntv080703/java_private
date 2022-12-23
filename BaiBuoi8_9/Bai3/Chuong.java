package BaiBuoi8_9.Bai3;

import java.util.ArrayList;
import java.util.List;

public class Chuong {
    public List<Animal> animals ;

    private int maChuong;

    public Chuong(int maChuong) {
        this.animals = new ArrayList<>();
        this.maChuong = maChuong;
    }

    public int getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(int maChuong) {
        this.maChuong = maChuong;
    }

    public void themConVat(Animal x){
        if(x instanceof Dog){
            x = (Dog)x;
        }
        else if (x instanceof Cat){
            x = (Cat)x;
        }
        else if(x instanceof Tiger){
            x = (Tiger)x;
        }
        animals.add(x);
    }

    public void xoaConVat(String ten){
        int dem = 0;
        for(Animal x : animals){
            if(x.getTen().equals(ten)){         
                break;
            }
            dem++;
        }
        this.animals.remove(dem);
    }

    public void inPut(){
        System.out.printf("%-20s %-20s %-20s %-20s\n", "Ten", "Tuoi", "Mo ta", "Tieng keu");
        for(Animal x : animals){
            x.xemThongTin();
        }
    }
}
