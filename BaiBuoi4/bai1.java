import java.util.Scanner;

public class bai1 {
	static int[] danhdau = new int[257];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			danhdau[s.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (danhdau[s.charAt(i)] != 0 && s.charAt(i) != ' ') {
				System.out.println(s.charAt(i) + ": " + danhdau[s.charAt(i)]);
				danhdau[s.charAt(i)] = 0;
			}
		}
	}
}