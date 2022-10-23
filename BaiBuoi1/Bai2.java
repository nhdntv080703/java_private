package BaiBuoi1;

import java.util.Scanner;
public class Bai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[4];
		for(int i=0;i<4;i++) {
			a[i]=sc.nextInt();
		}
		if(a[0]==a[1] && a[0]==a[2] && a[0]==a[3]) {
			System.out.println("Khong co so lon thu 2");
            return;
		}
		int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (a[i] > first) {
                second = first;
                first = a[i];
            }
            else if (a[i] > second) {
                second = a[i];
            }
        }
        if (second == Integer.MIN_VALUE)
            System.out.print("Khong ton tai phan tu lon thu 2 ");
        else
            System.out.print("Phan tu lon thu 2: " + second);
	}
}
