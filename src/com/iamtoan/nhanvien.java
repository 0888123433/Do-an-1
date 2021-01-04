package com.iamtoan;

import java.util.ArrayList;
import java.util.Scanner;

public class nhanvien {
    private String maNhanvien;
    private String hoTen;
    private int namSinh;
    private String gioiTinh;
    private String diaChi;
    private int SDT;

    public nhanvien(String maNhanvien ,String hoTen, int namSinh, String gioiTinh, String diaChi, int SDT) {
        this.maNhanvien = maNhanvien;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }

    public nhanvien(){}
    public String toString(){
        return maNhanvien+"#"+hoTen+"#"+namSinh+"#"+gioiTinh+"#"+diaChi+"#"+SDT;
    }
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getMaNhanvien() {
        return maNhanvien;
    }

    public void setMaNhanvien(String maNhanvien) {
        this.maNhanvien = maNhanvien;
    }
/// Phần Nhập dữ liệu thông tin của nhân viên

    static Scanner scanner = new Scanner(System.in);
    public void nhapNhanVien(ArrayList<nhanvien>nhanvienArrayList){
        nhanvienArrayList.add(new nhanvien(maNhanvien(),hoten(),namsinh(),gioitinh(),diachi(),sdt()));

    }
    public  String maNhanvien(){
        System.out.print("Nhap ma nhan vien: ");
        String str = scanner.nextLine();
        return str;
    }
    public String hoten(){
        System.out.print("Nhap ten nhan vien: ");
        String str = scanner.nextLine();
        return str;
    }
    public int namsinh(){
        System.out.print("Nhap nam sinh cua nhan vien: ");
        int str = Integer.parseInt(scanner.nextLine());
        return str;
    }
    public String gioitinh(){
        System.out.print("Nhap gioi tinh: ");
        String str = scanner.nextLine();
        return str;
    }
    public String diachi(){
        System.out.print("Nhap dia chi nhan vien: ");
        String str = scanner.nextLine();
        return str;
    }
    public int sdt(){
        System.out.print("Nhap so dien thoai nhan vien: ");
        int str = Integer.parseInt(scanner.nextLine());
        return str;
    }
}
