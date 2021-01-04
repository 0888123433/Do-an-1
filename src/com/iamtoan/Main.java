package com.iamtoan;

//import com.iamtoan.hoadon;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void Menu(ArrayList<nhanvien> nhanvienArrayList, ArrayList<sanpham> sanphamArrayList, sanpham sanpham, nhanvien nhanvien, xulithongtin xulithongtin, file file, file filenv) throws IOException {
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                             QUẢN LÝ SHOP QUẦN ÁO                           ║");
        System.out.println("╠════════════════════════╦═══════════════════════════╦═══════════════════════╣");
        System.out.println("║   1.XU LÝ THONG TIN    ║       2.  HOA DON         ║    3.  DOANH THU      ║");
        System.out.println("╚════════════════════════╩═══════════════════════════╩═══════════════════════╝");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời chọn: ");
        int chon;
        chon = Integer.parseInt(scanner.nextLine());
        while (true) {
            if (chon == 0) break;
            switch (chon) {
                case 1: {
                    Giaodien.Menuxulithongtin();
                    while (true) {
                        int chontt;
                        System.out.print("Chọn: ");
                        chontt = Integer.parseInt(scanner.nextLine());
                        if (chontt == 0) break;
                        switch (chontt) {
                            case 1: {
                                while (true) {
                                    Giaodien.Menusanpham();
                                    int chonsp;
                                    System.out.print("Chọn: ");
                                    chonsp = Integer.parseInt(scanner.nextLine());
                                    switch (chonsp) {
                                        case 1:
                                            sanpham.nhapSanPham(sanphamArrayList);
                                            file.ghifilesanpham(sanphamArrayList);
                                            break;
                                        case 2:
                                            hienthithongtin.HienALL(sanphamArrayList);
                                            break;
                                        case 3:
                                            System.out.print("Nhap MA SAN PHAM muon xoa: ");
                                            String tkxoa = scanner.nextLine();
                                            xulithongtin.xoasanpham(sanphamArrayList, tkxoa);
                                            file.ghifilesanpham(sanphamArrayList);
                                            break;
                                        case 4:
                                            System.out.println("Nhap MA SAN PHAM muon sua: ");
                                            String tk = scanner.nextLine();
                                            xulithongtin.suasanpham(sanphamArrayList, tk);
                                            file.ghifilesanpham(sanphamArrayList);
                                            break;
                                        case 5:
                                            System.out.println("Nhap MA SAN PHAM tim kiem: ");
                                            String keyword = scanner.nextLine();
                                            xulithongtin.timkiemsanpham(sanphamArrayList, keyword);
                                            break;
                                        case 6:
                                            xulithongtin.sapxeptheogiatientuLondenBe(sanphamArrayList);
                                            System.out.println("Sap xep thanh cong!");
                                            break;
                                        case 7:
                                            Menu(nhanvienArrayList, sanphamArrayList, sanpham, nhanvien, xulithongtin, file, filenv);
                                            break;
                                        default:
                                            System.out.print("Nhap lại: ");
                                    }

                                }
                            }
                            case 2: {
                                while (true) {
                                    Giaodien.Menunhanvien();
                                    int chonnv;
                                    System.out.print("Chọn: ");
                                    chonnv = Integer.parseInt(scanner.nextLine());
                                    switch (chonnv) {
                                        case 1:
                                            nhanvien.nhapNhanVien(nhanvienArrayList);
                                            filenv.ghifilenv(nhanvienArrayList);
                                            break;
                                        case 2:
                                            // Hien thi nhan vien
                                            hienthithongtin.HienALLnv(nhanvienArrayList);
                                            break;
                                        case 3:
                                            System.out.print("Nhap MA NHAN VIEN muon xoa: ");
                                            String tkxoa = scanner.nextLine();
                                            xulithongtin.xoanhanvien(nhanvienArrayList, tkxoa);
                                            file.ghifilenv(nhanvienArrayList);
                                            break;
                                        case 4:
                                            System.out.println("Nhap ma nhan vien muon sua: ");
                                            String tk = scanner.nextLine();
                                            xulithongtin.suanhanvien(nhanvienArrayList, tk);
                                            file.ghifilenv(nhanvienArrayList);
                                            break;
                                        case 5:
                                            System.out.println("Nhap ten nhan vien tim kiem: ");
                                            String keyword = scanner.nextLine();
                                            xulithongtin.timkiemnhanvien(nhanvienArrayList, keyword);
                                            break;
                                        case 6:
                                            xulithongtin.sapxepnhanvienAdenZ(nhanvienArrayList);
                                            System.out.println("Sap xep thanh cong!");
                                            break;
                                        case 7:
                                            Menu(nhanvienArrayList, sanphamArrayList, sanpham, nhanvien, xulithongtin, file, filenv);
                                            break;
                                        default:
                                            System.out.print("Nhap lại: ");
                                    }

                                }
                            }
                            case 3: {
                                Menu(nhanvienArrayList, sanphamArrayList, sanpham, nhanvien, xulithongtin, file, filenv);
                                break;
                            }
                            default: {
                                System.out.println("Nhap lai!!!");
                            }
                        }
                    }
                }
                case 2: {
                    ArrayList<hoadonbanhang> hoadonbanhangArrayList = new ArrayList<>();
                    ArrayList<muahang> muahangs = new ArrayList<>();
                    filehoadon.DocFile(hoadonbanhangArrayList);
                    QuanLyBanHangmain.chon(hoadonbanhangArrayList, muahangs, sanphamArrayList);
                    break;
                }
                case 3: {
                    ArrayList<hoadonbanhang> hoadonbanhangArrayList = new ArrayList<>();
                    ArrayList<muahang> muahangs = new ArrayList<>();
                    filehoadon.DocFile(hoadonbanhangArrayList);
                    thongke.thongkehomnay(hoadonbanhangArrayList, muahangs, sanphamArrayList);
                    break;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ArrayList<sanpham> sanphamArrayList = new ArrayList<>();
        ArrayList<nhanvien> nhanvienArrayList = new ArrayList<>();
        sanpham sanpham = new sanpham();
        xulithongtin xulithongtin = new xulithongtin();
        nhanvien nhanvien = new nhanvien();
        file file = new file();
        file filenv = new file();
        file.docfilesanpham(sanphamArrayList);
        filenv.docfilenv(nhanvienArrayList);
        Menu(nhanvienArrayList, sanphamArrayList, sanpham, nhanvien, xulithongtin, file, filenv);

    }
}
