package BaiBuoi1;

public class Bai3 {
    public static void main(String[] args) {
        int Case = 0;
        for(int i = 1; i < 20; i++){
            for(int j = 1; j < 34; j++){
                if(14*i+8*j==200){
                    System.out.println("Trường hợp " + ++Case);
                    System.out.println("Trau dung: " +i);
                    System.out.println("Trau nam: " +j);
                    System.out.println("Trau gia: " + (300-15*i-9*j));
                }
            }
        }
    }
}