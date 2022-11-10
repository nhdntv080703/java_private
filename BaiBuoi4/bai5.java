import java.util.Scanner;

public class bai5 {
	static int[] value = { 1, 5, 10, 50, 100, 500, 1000 };
	static char[] key = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };

	static int map(char c) {
		for (int i = 0; i < key.length; i++) {
			if (c == key[i]) {
				return value[i];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int res = map(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			int first = map(s.charAt(i));
			int second = map(s.charAt(i + 1));
			if (first >= second) {
				res += first;
			} else {
				res -= first;
			}
		}
		System.out.println(res);
	}
}