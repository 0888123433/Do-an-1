package com.iamtoan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class thongke {
    static File filehoadon = new File("hoadon.txt");

    public static void thongkehomnay(ArrayList<hoadonbanhang> hoadonbanhangArrayList,ArrayList<muahang>muahangs,ArrayList<sanpham>sanphams) {
        double tong = 0;

        if (filehoadon.exists()) {
            try {
                FileReader fileReader = new FileReader(filehoadon);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    for (int i =1;i< hoadonbanhangArrayList.size() || i< hoadonbanhangArrayList.size()  ;i++){
                        String ngayban = line.split("#")[i];
                        if (ngayban.equals(java.time.LocalDateTime.now().getDayOfMonth() + "/" + java.time.LocalDateTime.now().getMonthValue() + "/" + java.time.LocalDateTime.now().getYear())) {
                            tong+=muahang.tinhTien(sanphams);
                        }
                    }
                }
                fileReader.close();
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tong doanh thu hom nay la: " + tong);
    }
}
