package BaiBuoi8_9.Bai1;

public class Main1 {

	public static void main(String[] args) {
		HangSX hangSanXuat1 = new HangSX("Ford", "America");
		Oto oto1 = new Oto("Oto", hangSanXuat1, "Xang");
		MayBay mayBay1 = new MayBay("MayBay", hangSanXuat1, "Dau");
		XeDap xeDap1 = new XeDap("XeDap", hangSanXuat1);
		
		PhuongTien[] phuongTien = new PhuongTien[3];
		phuongTien[0] = oto1;
		phuongTien[1] = mayBay1;
		phuongTien[2] = xeDap1;
		
		double max = 0;
		int cnt = 0;
		for (int i = 0; i < phuongTien.length; i++) {
			double vanToc = phuongTien[i].layVanToc();
			if (max < vanToc) {
				max = vanToc;
				cnt = i;
			}
		}
		
		System.out.println("Phuong tien co van toc lon nhat la " + phuongTien[cnt].getLoaiPhuongTien() + " cua hang " + phuongTien[cnt].layTenHangSanXuat() + " voi van toc la " + max);
	}

}
