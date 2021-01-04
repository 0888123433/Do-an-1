package com.iamtoan;

import java.util.ArrayList;
import java.util.Scanner;

public class sanpham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;

    public sanpham(String maSP, String tenSP, int soLuong, double donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public sanpham(){}

    public String toString(){
        return maSP+"#"+tenSP+"#"+soLuong+"#"+donGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    // Nhập sản phẩm nè

    static Scanner scanner = new Scanner(System.in);
    public void nhapSanPham(ArrayList<sanpham>sanphamArrayList){
        sanphamArrayList.add(new sanpham(masp(),tensp(),soluong(),dongia()));
    }
    public String masp(){
        System.out.print("Nhap ma san pham:");
        maSP = scanner.nextLine();
        return maSP;
    }
    public String tensp(){
        System.out.print("Nhap ten san pham:");;
        tenSP = scanner.nextLine();
        return tenSP;
    }
    public int soluong(){
        System.out.print("Nhap so luong san pham: ");
        soLuong = Integer.parseInt(scanner.nextLine());
        return soLuong;
    }
    public double dongia(){
        System.out.print("Nhap don gia san pham: ");
        donGia = Double.parseDouble(scanner.nextLine());
        return donGia;
    }
}
