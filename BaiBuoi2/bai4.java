package BaiBuoi2;

import java.util.Scanner;

public class bai4 {
    public static boolean snt(int n){
        if(n<2) return false;
        for(int i = 2; i*i <= n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
    
    public static boolean check(int n){
        while(n != 0){
            int tmp = n%10;
            if(tmp!=2&&tmp!=3&&tmp!=5&&tmp!=7){
                return false;
            }
            n/=10;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int flag = 0;
        int []a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            if(check(a[i])&&snt(a[i])==true){
                flag = 1;
                System.out.print(a[i] + " ");
            } 
        }
        if(flag == 0) System.out.println("NO");
    }
}
