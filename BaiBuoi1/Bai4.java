package BaiBuoi1;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;       
        do {
            System.out.print("Nhap n: ");
            n = sc.nextInt();
        } while (n <= 0);
        int []a = new int[n];
        int flag = 0, i = 0;
        while (n > 0) {
            if (n%10 == 1 || n%10 == 4 || n%10 == 9) {
                a[i++] = n%10;
                flag = 1;
            }
            n /= 10;
        }
        if (flag == 0) {
            System.out.println("No");
        }
        else{
            for(int j = i-1; j >= 0; j--){
                System.out.print(a[j] + " ");
            }
        }
    }
}
