package BaiBuoi8_9.Bai1;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		HangSX hangSanXuat1 = new HangSX("Ford", "America");
		Oto oto1 = new Oto("Oto", hangSanXuat1, "Xang");
		MayBay mayBay1 = new MayBay("MayBay", hangSanXuat1, "Dau");
		XeDap xeDap1 = new XeDap("XeDap", hangSanXuat1);
		
		List<PhuongTien> phuongTien = new ArrayList<>();
		phuongTien.add(oto1);
		phuongTien.add(mayBay1);
		phuongTien.add(xeDap1);
		
		double max = 0;
		int cnt = 0;
		for (int i = 0; i < phuongTien.size(); i++) {
			double vanToc = phuongTien.get(i).layVanToc();
			if (max < vanToc) {
				max = vanToc;
				cnt = i;
			}
		}
		
		System.out.println("Phuong tien co van toc lon nhat la " + phuongTien.get(cnt).getLoaiPhuongTien() + " cua hang " + phuongTien.get(cnt).layTenHangSanXuat() + " voi van toc la " + max);
	}

}
