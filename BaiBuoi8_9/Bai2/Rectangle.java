package BaiBuoi8_9.Bai2;

import java.util.Scanner;

public class Rectangle implements IShape{
    public static Scanner sc = new Scanner(System.in);

    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }

    @Override
    public double getPerimeter() {
        return (this.length+this.width)*2;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void input(){
        System.out.println("Nhap chieu dai :");
        setLength(sc.nextDouble());
        System.out.println("Nhap chieu rong : ");
        setWidth(sc.nextDouble());
    }

    public void outputP(){
        System.out.printf("\t%-20f\n", getPerimeter());
    }
    public void outputA(){
        System.out.printf("\t%-20f\n", getArea());
    }
}
