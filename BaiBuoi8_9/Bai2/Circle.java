package BaiBuoi8_9.Bai2;

import java.util.Scanner;

public class Circle implements IShape {
    public Scanner sc = new Scanner(System.in);
    private double radius;

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() { 
        return this.radius * this.radius * Math.PI ;
    }

    @Override
    public double getPerimeter() { 
        return 2 * this.radius * Math.PI;
    }
    
    public void input(){
        System.out.println("Nhap ban kinh : ");
        setRadius(sc.nextDouble());
    }
    
    public void outputP(){
        System.out.printf("\t%-20f\n", getPerimeter());
    }
    public void outputA(){
        System.out.printf("\t%-20f\n", getArea());
    }
}
