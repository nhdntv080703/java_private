package BaiBuoi2;

import java.util.HashMap;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = (int)-1e9, flag = 0;
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(max<x) max = x;
            map.put(x,1);
        }
        for(int i = 1; i <= max; i++){
            if(!map.containsKey(i)) {
                System.out.print(i + " ");
                flag = 1;
            }
        }
        if(flag == 0) System.out.println("YES");
    }
}
