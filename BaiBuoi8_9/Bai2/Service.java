package BaiBuoi8_9.Bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    static Scanner sc = new Scanner(System.in);
    public static List<Circle> circles = new ArrayList<>();
    public static List<Rectangle> rectangles = new ArrayList<>();

    public void nhap(){
        System.out.println("Nhap loai hinh ban muon : ");
        String a = sc.nextLine();
        if(a.contains("circle")){
            Circle x = new Circle();
            x.input();
            circles.add(x);
        }
        else if (a.contains("rectangle")){
            Rectangle x = new Rectangle();
            x.input();
            rectangles.add(x);
        }
        else 
            System.out.println("Loai hinh khong phu hop");
    }

    void title(){
        System.out.println("\tChu vi");
    }
    void title( int n){
        System.out.println("\tDien tich");
    }

    public void xuatP(){
        title();
        for(Circle x : circles){
            x.outputP();
        }
        for(Rectangle x : rectangles){
            x.outputP();
        }
    }

    public void xuatA(){
        title(1);
        for(Circle x : circles){
            x.outputA();
        }
        for(Rectangle x : rectangles){
            x.outputA();
        }
    }

    public void xoa(){
        System.out.println("Nhap vao loai hinh muon xoa");
        String a = sc.nextLine();
        if(a.contains("circle")){
            System.out.println("Nhap vao ban kinh hinh muon xoa");
            double radiuss = sc.nextDouble();
            for(Circle x : circles){
                if(x.getRadius() == radiuss){
                    circles.remove(x);
                    System.out.println("Hinh da duoc xoa");
                    return;
                }
            }
            System.out.println("Ban kinh ban nhap khong co trong danh sach");
        }
        else if (a.contains("rectangle")){
            System.out.println("Nhap vao chieu dai, chieu rong hinh muon xoa");
            double lengthh = sc.nextDouble();
            double widthh = sc.nextDouble();
            for(Rectangle x : rectangles){
                if(x.getLength() == lengthh && x.getWidth() == widthh){
                    rectangles.remove(x);
                    System.out.println("Hinh da duoc xoa");
                    return;
                }
            }
            System.out.println("Chieu dai, chieu rong ban nhap khong co trong danh sach");
        }
        else 
            System.out.println("Loai hinh khong phu hop");
    }
}
