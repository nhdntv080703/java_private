package BaiBuoi2;

import java.util.Scanner;
import java.util.TreeMap;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer,Integer> map = new TreeMap<>(); 
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(map.containsKey(x)){
                int tanSuat = map.get(x);
                ++tanSuat;
                map.put(x, tanSuat);
            }else {
                map.put(x,1);
            }
        }
        for (Integer key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
