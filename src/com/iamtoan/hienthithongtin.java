package com.iamtoan;

import java.util.ArrayList;

public class hienthithongtin {
    public static void Hiennv(nhanvien nhanvien){
        System.out.printf("|%8s|%20s|%10s|%10s|%13s|%11s|\n",nhanvien.getMaNhanvien(),nhanvien.getHoTen(),nhanvien.getNamSinh(),nhanvien.getGioiTinh(),nhanvien.getDiaChi(),nhanvien.getSDT());
        System.out.println("-------------------------------------------------------------------------------");
    }
    public static void HienALLnv(ArrayList<nhanvien> nhanvienArrayList){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%8s|%20s|%10s|%10s|%13s|%11s|\n","Ma NV","Tên NV","Năm Sinh","Giới Tính","Địa Chỉ","SDT");
        System.out.println("-------------------------------------------------------------------------------");
        for (nhanvien nhanvien:nhanvienArrayList
        ) {
            Hiennv(nhanvien);
        }
    }
    public static void Hien(sanpham sanpham){
        System.out.printf("|%10s|%20s|%20s|%20s|\n",sanpham.getMaSP(),sanpham.getTenSP(),sanpham.getSoLuong(),sanpham.getDonGia());
        System.out.println("---------------------------------------------------------------------------");
    }
    public static void HienALL(ArrayList<sanpham> sanphamArrayList){
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("|%10s|%20s|%20s|%20s|\n","Mã SP","Tên SP","Số Luọng","ĐƠn Giá");
        System.out.println("---------------------------------------------------------------------------");
        for (sanpham sanpham:sanphamArrayList
        ) {
            Hien(sanpham);

        }
    }
}
