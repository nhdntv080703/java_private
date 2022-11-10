import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.trim().toLowerCase();
        String tmp = "";
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            }
            if (s.charAt(i) == ' ' && !flag) {
                flag = true;
                tmp += ' ';               
            }
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {        
                if ((tmp.length() > 0 && tmp.charAt(tmp.length() - 1) == ' ') || tmp.length() == 0) {
                    tmp += (char)(s.charAt(i) - 32);
                } else {
                    tmp += s.charAt(i);
                }
                flag = false;
            }
        }
        System.out.println(tmp);
    }
} 
