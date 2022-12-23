package BaiBuoi8_9.Bai3;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    
    public List<Chuong> chuongs;

    public Zoo() {
        this.chuongs = new ArrayList<>();
    }

    public void themChuong(Chuong c){
        chuongs.add(c);
    }

    public void xoaChuong(int maChuongg){
        int dem = 0;
        for(Chuong x : chuongs){
            if(x.getMaChuong() == maChuongg){
                break;
            }
            dem++;
        }
        this.chuongs.remove(dem);
    }

    public void inPut(){
        for(Chuong x : chuongs){
            System.out.println("Danh sach cac dong vat trong chuong " + x.getMaChuong() + ":");
            x.inPut();
        }
    }
}
