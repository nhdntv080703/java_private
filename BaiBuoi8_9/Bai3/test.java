package BaiBuoi8_9.Bai3;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> in = new ArrayList<>();
        in.add(2);
        in.add(3);
        in.add(4);
        in.add(5);
        in.add(6);
        in.add(7);
        System.out.println(in.stream().sorted().filter(i -> (i % 2 == 0)).count());
    }
    
    
}
