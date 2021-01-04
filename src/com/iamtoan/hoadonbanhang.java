package com.iamtoan;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class hoadonbanhang {
    private String mahoadonban,ngayban;
    public hoadonbanhang(String mahoadonban, String ngayban) {
        this.mahoadonban = mahoadonban;
        this.ngayban = ngayban;

    }

    @Override
    public String toString(){
        return  mahoadonban+"#"+ngayban;
    }
    public String getMahoadonban() {
        return mahoadonban;
    }

    public void setMahoadonban(String mahoadonban) {
        this.mahoadonban = mahoadonban;
    }
    public String getNgayban() {
        return ngayban;
    }
    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
    }
}


class muahang {
    private static String masp;
    private static String mahoadonban;
    private static int soluong;

    public String getMahoadonban() {
        return mahoadonban;
    }

    public void setMahoadonban(String mahoadonban) {
        this.mahoadonban = mahoadonban;
    }

    @Override
    public String toString(){
        return mahoadonban+"#"+masp+"#"+soluong;
    }
    public static double tinhTien(ArrayList<sanpham> sanphamArrayList){
        double tong = 0;
        for (sanpham sanpham:sanphamArrayList
        ) {
            if(masp.equalsIgnoreCase(sanpham.getMaSP())){
                tong=soluong*sanpham.getDonGia();
                break;
            }
        }
        return tong;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public muahang(String mahoadonban,String masp, int soluong) {
        this.masp = masp;
        this.soluong = soluong;
        this.mahoadonban= mahoadonban;
    }
}
class filehoadon{
    static File file = new File("HoaDonBanHang.txt");
    public static void DocFile(ArrayList<hoadonbanhang>hoadonbanhangArrayList) throws IOException {
        if(file.exists()){
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine())!=null){
                String mahoadon = line.split("#")[0];
                String ngayban = line.split("#")[1];

                hoadonbanhangArrayList.add(new hoadonbanhang(mahoadon,ngayban));
            }
            fileReader.close();
            bufferedReader.close();
        }
    }
    public static void GhiFile(ArrayList<hoadonbanhang>hoadonbanhangArrayList) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (hoadonbanhang hoadonbanhang:hoadonbanhangArrayList
        ) {
            fileWriter.write(hoadonbanhang.toString()+"\n");
        }
        fileWriter.close();
    }
}

class filemuahang{
    static File file = new File("MuaHang.txt");
    public static void DocFile(ArrayList<muahang> muahangs) throws IOException {
        if(file.exists()){
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine())!=null){
                String[]arr = line.split("#");
                muahangs.add(new muahang(arr[0],arr[1],Integer.parseInt(arr[2]) ));
            }
            fileReader.close();
            bufferedReader.close();
        }
    }
    public static void GhiFile(ArrayList<muahang>muahangs) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (muahang muahang:muahangs
        ) {
            fileWriter.write(muahang.toString()+"\n");
        }
        fileWriter.close();
    }
}
class QuanLyBanHang {
    static Scanner scanner = new Scanner(System.in);

    public static String getsanpham(ArrayList<sanpham> sanphams) {
        String hang = scanner.nextLine();
        boolean kt = true;
        while (kt) {
            for (sanpham sanpham : sanphams
            ) {
                if (hang.equalsIgnoreCase(sanpham.getMaSP())) kt = false;
            }
            if (kt == true) {
                System.out.println("Không tồn tại sản phẩm, nhập lại");
                hang = scanner.nextLine();
            }
        }
        return hang;
    }

    public static void nhapThongTin(ArrayList<hoadonbanhang> hoadonbanhangArrayList, ArrayList<muahang> muahangs, ArrayList<sanpham> sanphams) {
        System.out.println("Nhập mã hóa đơn bán");
        String mahoadonban = scanner.nextLine();
        System.out.println("Nhập ngày bán");
        String ngayban = scanner.nextLine();
        String masp;
        while (true) {
            System.out.println("Nhập mã sản phẩm: ");
            masp = getsanpham(sanphams);
            System.out.println("Nhập số lượng");
            int soluong = Integer.parseInt(scanner.nextLine());
            muahangs.add(new muahang(mahoadonban, masp, soluong));
            System.out.println("Bạn có muốn nhập thêm sản phẩm không?C/K");
            String chon = scanner.nextLine();
            if (chon.equalsIgnoreCase("k")) break;
        }
        hoadonbanhangArrayList.add(new hoadonbanhang(mahoadonban,ngayban));
    }

    public static hoadonbanhang find(ArrayList<hoadonbanhang> hoadonbanhangArrayList, String keyword) {
        hoadonbanhang result = null;
        for (hoadonbanhang hoadonbanhang : hoadonbanhangArrayList
        ) {
            if (keyword.equalsIgnoreCase(hoadonbanhang.getMahoadonban())) {
                result = hoadonbanhang;
            }
        }
        return result;
    }

    public static void display(hoadonbanhang hoadonbanhang) {
        System.out.printf("|%-20s|%-20s|\n", hoadonbanhang.getMahoadonban(), hoadonbanhang.getNgayban());
    }

    public static void inHoaDon(ArrayList<hoadonbanhang> hoadonbanhangArrayList,ArrayList<muahang>muahangs,ArrayList<sanpham>sanphams) {
        System.out.println("Nhập hóa đơn bán, hoặc ngày bán");
        String keyword = scanner.nextLine();
        int tong = 0;
        hoadonbanhang result = find(hoadonbanhangArrayList, keyword);
        if (result == null) {
            System.out.println("Không tìm thấy hóa đơn");
        } else {
            System.out.println("HÓA ĐƠN THANH TOÁN");
            display(result);
            System.out.println("Sản phẩm đã mua:");
            System.out.printf("|%-20s|%-20s|%-20s\n","Mã sản phẩm","Số lượng","Đơn giá");
            for (muahang muahang:muahangs
            ) {
                if(result.getMahoadonban().equalsIgnoreCase(muahang.getMahoadonban())){
                    tong+=muahang.tinhTien(sanphams);
                    System.out.printf("|%-20s|%-20s|%-20s|\n",muahang.getMasp(),muahang.getSoluong(),muahang.tinhTien(sanphams));
                }
            }
        }
        System.out.println("Số tiền phải trả là "+tong);
    }

    public static void hienHoaDonBanHang(ArrayList<hoadonbanhang> hoadonbanhangArrayList) {
        System.out.printf("|%-20s|%-20s|%-20s|\n", "Mã hóa đơn bán", "Mã sản phẩm", "Ngày bán");
        for (hoadonbanhang hoadonbanhang : hoadonbanhangArrayList
        ) {
            display(hoadonbanhang);
        }
    }
}
class QuanLyBanHangmain{

    private static void Menu(){
        System.out.println("                         ╔══════════════════════════════╗");
        System.out.println("                         ║   QUẢN LÝ HÓA ĐƠN BÁN HÀNG   ║");
        System.out.println("                         ╠══════════════════════════════╣");
        System.out.println("                         ║ 1.THÊM HÓA ĐƠN BÁN HÀNG      ║");
        System.out.println("                         ╠══════════════════════════════╣");
        System.out.println("                         ║ 2.IN ĐƠN BÁN HÀNG            ║");
        System.out.println("                         ╠══════════════════════════════╣");
        System.out.println("                         ║ 3.HIỂN THỊ LẠI HÓA ĐƠN BÁN   ║");
        System.out.println("                         ╠══════════════════════════════╣");
        System.out.println("                         ║ 4.THOAT                      ║");
        System.out.println("                         ╚══════════════════════════════╝");
    }
    static Scanner scanner = new Scanner(System.in);
    public static void chon(ArrayList<hoadonbanhang> hoadonbanhangArrayList, ArrayList<muahang>muahangs, ArrayList<sanpham>sanphams) throws IOException {
        int chon;
        while(true){
            Menu();
            chon = Integer.parseInt(scanner.nextLine());
            if(chon ==0)break;
            switch (chon){
                case 1:
                    QuanLyBanHang.nhapThongTin(hoadonbanhangArrayList,muahangs,sanphams);
                    filehoadon.GhiFile(hoadonbanhangArrayList);
                    break;
                case 2:
                    QuanLyBanHang.inHoaDon(hoadonbanhangArrayList, muahangs, sanphams);
                    break;
                case 3:
                    QuanLyBanHang.hienHoaDonBanHang(hoadonbanhangArrayList);
                    break;
                case 4:
                    break;
                default:break;
            }
        }
    }
}