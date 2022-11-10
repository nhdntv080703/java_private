import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("NHAP CHUOI: ");
		String s = sc.nextLine();
		boolean check = false;
		double tong = 0;
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int numb = c - '0';
			if (numb >= 0 && numb <= 9) {
				check = true;
				tong += numb;
				cnt++;
			}
		}
		if (check == true) {
			double res = tong / cnt;
			System.out.println("true");
			System.out.println(String.format("%.3f", res));
		} else {
			System.out.println("false");
		}
	}
}