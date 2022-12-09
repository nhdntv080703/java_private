package BaiBuoi6_7.Bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static Scanner sc = new Scanner(System.in);
    public static List<Nguoi> nguois= new ArrayList<>();
    public static void main(String[] args) {
        while(true){
            System.out.println("-----DANH SÁCH CÁC LỰA CHỌN-----");
            System.out.println("1.Thêm giáo viên");
            System.out.println("2.Hiển thị danh sách");
            System.out.println("3.Xóa giáo viên theo MaGV");
            int choose = sc.nextInt();
            if(choose ==1)
                nhap();
            else if(choose == 2)
                xuat();
            else if(choose == 3)
                xoaGV();
            else break;
            }
        }
    private static void xoaGV(){
        if (Empty()){
            System.out.println("Nhập mã giáo viên cần xóa:");
            int mgv=sc.nextInt();
            for(int i=0;i<nguois.size();i++){
                if(nguois.get(i).getMaGV()==mgv){
                        nguois.remove(i);
                }
            }

        }else{
            System.out.println("Chưa có giáo viên nào!");
        }
    } 
    private static void title(){
        System.out.printf("%-15s %-15s %-10s %-15s %-15s %-15s %-15s %-15s\n","Họ Tên","Tuổi","Địa Chỉ","Mã giáo viên","Lương cứng","Lương thưởng","Lương phạt","Tổng lương");
    }
    private static void nhap(){
        System.out.println("Nhập thông tin giáo viên:");
        Nguoi themGV=new Nguoi();
        themGV.inPut();
        nguois.add(themGV);
    }
    private static void xuat(){
        if(Empty()){
            title();
            for(Nguoi item:nguois){
                item.outPut();
            }
        }else{
            System.out.println("Chưa có giáo viên nào!");
        }
    }
    public static boolean Empty(){
        return !nguois.isEmpty();
    }
}
