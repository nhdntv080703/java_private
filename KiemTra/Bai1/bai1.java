package KiemTra.Bai1;

import java.util.Scanner;

public class bai1 {
<<<<<<< HEAD

=======
>>>>>>> origin/main

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int dem1 = 0; int dem2 = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '('){
                dem1++;
            }
            else{
                if (dem1 > 0){
                    dem1--;
                } 
                else{
                    dem2++;
                }
            }
        }
        System.out.println(dem1 + dem2);
    }
}
// ((())())
