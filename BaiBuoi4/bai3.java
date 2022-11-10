import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		boolean check = false;

		float tong = 0;

		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int numb = c - 48;
			if (numb >= 0 && numb <= 9) {
				check = true;
				tong += numb;
				cnt++;
			}
		}

		if (check == true) {
			float res = tong/cnt;
			System.out.println("true");
			System.out.printf("%.3f", res);
		} else {
			System.out.println("false");
		}
	}
}