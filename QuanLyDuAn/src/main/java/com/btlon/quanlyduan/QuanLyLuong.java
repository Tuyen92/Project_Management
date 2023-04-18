/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class QuanLyLuong {
    private static ArrayList<Luong> dsLuong = new ArrayList<>();
    private static ArrayList<PhongBan> dsPhongBan = new ArrayList<>();

    Scanner s = new Scanner(System.in);

    public ArrayList<Luong> getDsLuong() {
        return dsLuong;
    }
    
    public void setDsLuong(Luong luong) {
        QuanLyLuong.dsLuong.add(luong);
    }

    public ArrayList<PhongBan> getDsPhongBan() {
        return dsPhongBan;
    }

    public void setDsPhongBan(PhongBan phongBan) {
        QuanLyLuong.dsPhongBan.add(phongBan);
    }
    
//   PHÒNG BAN 
//    Thêm mới phòng ban
    public void themPhongBan() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        PhongBan pb = new PhongBan();
        pb.nhapPhongBan();
        sql.themPhongBan(pb);
    }
    
//    Xóa một phòng ban
    public void xoaPhongBan() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN PHONG BAN MUON XOA    ~~~~");
        System.out.print("Ma phong ban: ");
        int id = s.nextInt();
        sql.xoaPhongBan(id);
    }
    
//    Lấy danh sách phòng ban
    public void layPhongBan() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        sql.layPhongBan();
        System.out.println("~~~~    DANH SACH PHONG BAN   ~~~~");
        for (PhongBan pb : dsPhongBan) {
            System.out.println(pb);
        }
    }
    
//    Tìm thông tin phòng ban theo mã phòng ban
    public void timPhongBan() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN PHONG BAN MUON TIM    ~~~~");
        System.out.print("Ma phong ban: ");
        int id = s.nextInt();
        PhongBan pb = (PhongBan) sql.timPhongBan(id);
        System.out.println("~~~~    THONG TIN PHONG BAN    ~~~~");
        System.out.println(pb);
    }
    
//    LƯƠNG BỔNG
//    Xem danh sách lương
    public void xemDanhSachLuong() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        sql.xemDanhSachLuong();
        System.out.println("");
        System.out.println("~~~~    DANH SACH LUONG    ~~~~");
        for (Luong luong : dsLuong) {
            System.out.println(luong);
        }
    }
    
//    Lấy thông tin lương của một nhân viên
    public void layLuongNV() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN NHAN VIEN    ~~~~");
        System.out.print("Ma nhan vien: ");
        int id = s.nextInt();
        Luong luong = sql.layLuongNV(id);
        System.out.println("");
        System.out.println("~~~~    LUONG NHAN VIEN    ~~~~");
        System.out.println(luong);
    }
    
//    Thống kê lương (lương cao nhất, lương thấp nhất, bình quân lương, số lượng lương trên dưới)
    public void thongKeLuong() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~ NHAP MUC LUONG MUON THONG KE ~~~~");
        System.out.print("Muc luong: ");
        int giaLuong = s.nextInt();
        System.out.println("");
        System.out.println("~~~~ THONG TIN LUONG THONG KE ~~~~");
        System.out.println("So luong nhan vien co luong cao hon " + giaLuong + ": " + sql.thongKeTrenLuong(giaLuong));
        System.out.println("So luong nhan vien co luong bang va thap hon " + giaLuong + ": " + sql.thongKeDuoiLuong(giaLuong));
        System.out.printf("Luong cao nhat: %.02f\n", sql.layMaxLuong());
        System.out.println("Luong thap nhat: " + sql.layMinLuong());
        System.out.printf("Luong binh quan: %.02f\n" + sql.layLuongBinhQuan());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
//    Cập nhật thông tin phòng ban
    public void capNhatPB() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    CAP NHAT PHONG BAN    ~~~~");
        System.out.print("Ma phong ban: ");
        int id = s.nextInt();
        PhongBan pb = (PhongBan) sql.timPhongBan(id);
        pb.nhapPhongBan();
        sql.capNhatPB(pb);
    }
    
//    Thêm mới lương cơ bản
    public void themLuongCoBan() throws SQLException{
        double luongCB;
        String cv;
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN LUONG    ~~~~");
        System.out.print("Luong co ban: ");
        luongCB = s.nextDouble();
        System.out.print("Chuc vu: ");
        cv = s.nextLine();
        sql.themLuongCB(luongCB, cv);
    }
    
//    Thêm hệ số mới
    public void themHeSo() throws SQLException{
        double hs;
        String cv;
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN HE SO    ~~~~");
        System.out.print("He so: ");
        hs = s.nextDouble();
        System.out.print("Chuc vu: ");
        cv = s.nextLine();
        sql.themHeSo(hs, cv);
    }
    
//    Nhập & lưu thông tin lương
    public void nhapLuong() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        QuanLyNV qlnv = new QuanLyNV();
        String loaiNV = qlnv.MenuLoaiNV();
        double hs = 0, luongCoBan = 0, congThem = 0, tongLuong = 0;
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN TINH LUONG    ~~~~");
        System.out.print("Ma nhan vien: ");
        int id = s.nextInt();
        switch (loaiNV) {
            case "quanly" -> {
                QuanLy ql = (QuanLy) sql.timNV(id, loaiNV);
                hs = sql.layHeSo(loaiNV);
                luongCoBan = sql.layLuongCB(loaiNV);
                congThem = ql.tinhCongThem();
                tongLuong = ql.tinhLuong(hs, luongCoBan);
            }
            case "laptrinhvien" -> {
                LapTrinhVien ltv = (LapTrinhVien) sql.timNV(id ,loaiNV);
                luongCoBan = sql.layLuongCB(loaiNV);
                hs = sql.layHeSo(loaiNV);
                congThem = ltv.tinhCongThem();
                tongLuong = ltv.tinhLuong(luongCoBan, hs);
            }
            case "thietkevien" -> {
                ThietKeVien tkv = (ThietKeVien) sql.timNV(id ,loaiNV);
                luongCoBan = sql.layLuongCB(loaiNV);
                hs = sql.layHeSo(loaiNV);
                congThem = tkv.tinhCongThem();
                tongLuong = tkv.tinhLuong(luongCoBan, hs);
            }
            case "kiemthuvien" -> {
                KiemThuVien ktv = (KiemThuVien) sql.timNV(id ,loaiNV);
                luongCoBan = sql.layLuongCB(loaiNV);
                hs = sql.layHeSo(loaiNV);
                congThem = ktv.tinhCongThem();
                tongLuong = ktv.tinhLuong(luongCoBan, hs);
            }
        }
        Luong luong = new Luong(id, tongLuong, luongCoBan, hs, congThem);
        sql.tinhLuong(luong);
    }
    
//    Xuất danh sách lương theo tháng
    public void xuatFileLuong() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String path = String.format("src/main/resources/Luong_%d%d.txt", month, year);
        String fileName = path.substring(19);
        File f = new File(path);
        sql.xemDanhSachLuong();
        try {
            PrintWriter write = new PrintWriter(f);
            if (dsLuong.isEmpty())
                write.println("Khong co du lieu!");
            else{
                write.printf("BANG LUONG NHAN VIEN THANG %d/%d\n", month, year);
                write.println(" ");
                write.println(" ");
                for (Luong luong : dsLuong) {
                    write.println("Ma nhan vien: " + luong.getMaNhanVien());
                    write.printf("Tong luong: %.02f VND\n", luong.getTongLuong());
                    write.println(" ");
                }
            }
            write.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("Khong the tao file %s\n", fileName);
        }
    }
}
