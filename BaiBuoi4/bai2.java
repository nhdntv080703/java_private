import java.util.Scanner;

public class bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1, str2, str3 = "";
		int dem = 0, max = 0;
		str1 = sc.nextLine();
		str2 = sc.nextLine();
		for (int i = 0; i < str2.length(); i++) {
			String s = str2.substring(i, i + 1);
			str3 = str3.concat(s);
			if (str1.contains(str3) == false || s.compareTo(" ") == 0) {
				max = Math.max(max, dem);
				str3 = "";
				dem = 0;
			} else {
				dem++;
			}
		}
		max = Math.max(max, str3.length());
		System.out.println(max);
	}
}
