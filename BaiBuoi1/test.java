package BaiBuoi1;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int cnt = 0, tmp = 0, x = n;
            while(n != 0){
                if(n%2!=0) {
                    tmp++;
                }
                if(tmp == 2){
                    n+=1;
                    tmp = 0;
                }
                cnt += n/2;
                n/=2;
            }
            System.out.println(cnt+x);
        }
    }
}
