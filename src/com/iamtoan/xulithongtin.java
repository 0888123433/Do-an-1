package com.iamtoan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class xulithongtin {
    //Sửa, xóa, tìm kiếm, sắp xếp
    public static void suanhanvien(ArrayList<nhanvien> nhanvienArrayList, String keyword) {
        nhanvien nv = new nhanvien();
        boolean kt = false;
        for (int i = 0; i < nhanvienArrayList.size(); i++) {
            if (keyword.equalsIgnoreCase(nhanvienArrayList.get(i).getMaNhanvien())) {
                kt = true;
                System.out.println("Co tim thay thong tin");
                nhanvienArrayList.set(i, new nhanvien(nv.maNhanvien(),nv.hoten(), nv.namsinh(), nv.gioitinh(), nv.diachi(), nv.sdt()));
            }
        }
        if (kt == false) System.out.println("Khong tim thay ten nhan vien!!!");
    }

    public static void xoanhanvien(ArrayList<nhanvien> nhanvienArrayList, String keyword) {
        boolean kt = false;
        for (int i = 0; i < nhanvienArrayList.size(); i++) {
            if (keyword.equalsIgnoreCase(nhanvienArrayList.get(i).getMaNhanvien())) {
                kt = true;
                System.out.println("Xoa thanh cong " + nhanvienArrayList.get(i).getMaNhanvien());
                nhanvienArrayList.remove(i);
            }
        }
        if (kt == false) System.out.println("Khong tim thay ma nhan vien !!!");
    }

    public static void timkiemnhanvien(ArrayList<nhanvien> nhanvienArrayList, String keyword) {
        boolean kt = false;
        for (nhanvien nhanvien : nhanvienArrayList) {
            if (nhanvien.getHoTen().endsWith(keyword)) {
                System.out.println("Tìm kiếm thành công");
                hienthithongtin hienthithongtin = new hienthithongtin();
                System.out.println("-------------------------------------------------------------------------------");
                System.out.printf("|%8s|%20s|%10s|%10s|%13s|%11s|\n", "Ma NV", "Tên NV", "Năm Sinh", "Giới Tính", "Địa Chỉ", "SDT");
                System.out.println("-------------------------------------------------------------------------------");
                hienthithongtin.Hiennv(nhanvien);
                kt = true;
            }
        }
        if (kt == false) System.out.println("Khong tim thay !!!");
    }

    public static void sapxepnhanvienAdenZ(ArrayList<nhanvien> nhanvienArrayList) {
        Collections.sort(nhanvienArrayList, new Comparator<nhanvien>() {
            @Override
            public int compare(nhanvien o1, nhanvien o2) {
                if (o1.getHoTen().compareToIgnoreCase(o2.getHoTen()) == 1) return 1;
                else return -1;
            }
        });
    }

    //Sửa, xóa, tìm kiếm, sắp xếp
    public static void suasanpham(ArrayList<sanpham> sanphamArrayList, String keyword){
        sanpham sp = new sanpham();
        boolean kt = false;
        for(int i=0; i< sanphamArrayList.size();i++){
            if(keyword.equalsIgnoreCase(sanphamArrayList.get(i).getMaSP())){
                kt = true;
                System.out.println("Co tim thay thong tin");
                sanphamArrayList.set(i,new sanpham(sanphamArrayList.get(i).getMaSP(),sp.tensp(),sp.soluong(),sp.dongia()));
                System.out.println("Sửa thông tin san phẩm "+keyword+" thành công !");
                break;
            }
        }
        if (kt==false) System.out.println("Khong tim thay !!!");
    }
    public static void xoasanpham(ArrayList<sanpham> sanphamArrayList, String keyword){
        boolean kt = false;
        for(int i=0; i< sanphamArrayList.size();i++){
            if(keyword.equalsIgnoreCase(sanphamArrayList.get(i).getMaSP())){
                kt = true;
                System.out.println("Xoa thanh cong "+ sanphamArrayList.get(i).getMaSP());
                sanphamArrayList.remove(i);
            }
        }
        if (kt==false) System.out.println("Khong tim thay !!!");
    }

    public static void timkiemsanpham(ArrayList<sanpham> sanphamArrayList, String keyword){
        boolean kt = false;
        for(sanpham sanpham:sanphamArrayList){
            if(keyword.equalsIgnoreCase(sanpham.getMaSP())){
                System.out.println("Tìm kiếm thành công");
                hienthithongtin hienthithongtin = new hienthithongtin();
                System.out.println("---------------------------------------------------------------------------");
                System.out.printf("|%10s|%20s|%20s|%20s|\n","Mã SP","Tên SP","Số Luọng","ĐƠn Giá");
                System.out.println("---------------------------------------------------------------------------");
                hienthithongtin.Hien(sanpham);
                kt = true;
            }
        }
        if(kt==false) System.out.println("Khong tim thay !!!");
    }
    public static void sapxeptheogiatientuLondenBe(ArrayList<sanpham> sanphamArrayList){
        Collections.sort(sanphamArrayList, new Comparator<sanpham>() {
            @Override
            public int compare(sanpham o1, sanpham o2) {
                if(o1.getDonGia()<o2.getDonGia()) return -1;
                return  1;
            }
        });
    }
}
