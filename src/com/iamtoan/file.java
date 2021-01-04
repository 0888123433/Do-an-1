package com.iamtoan;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;


public class file {
    static File file = new File("sanpham.txt");

    public static void ghifilesanpham(ArrayList<sanpham> sanphamArrayList) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (sanpham sanpham : sanphamArrayList) {
            fileWriter.write(sanpham.toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static void docfilesanpham(ArrayList<sanpham> sanphamArrayList) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sanphamArrayList.add(new sanpham(line.split("#")[0], line.split("#")[1], Integer.parseInt(line.split("#")[2]), Double.parseDouble(line.split("#")[3])));
        }
        bufferedReader.close();
        fileReader.close();
    }

    static File filenv = new File("nhanvien.txt");

    public static void ghifilenv(ArrayList<nhanvien> nhanvienArrayList) throws IOException {
        FileWriter fileWriter = new FileWriter(filenv);
        for (nhanvien nhanvien : nhanvienArrayList) {
            fileWriter.write(nhanvien.toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static void docfilenv(ArrayList<nhanvien> nhanvienArrayList) throws IOException {
        FileReader fileReader = new FileReader(filenv);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            nhanvienArrayList.add(new nhanvien(line.split("#")[0], line.split("#")[1], Integer.parseInt(line.split("#")[2]), line.split("#")[3], line.split("#")[4], Integer.parseInt(line.split("#")[5])));
        }
        bufferedReader.close();
        fileReader.close();
    }
}
