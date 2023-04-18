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
public class QuanLyDA {
    Scanner s = new Scanner(System.in);
    private static ArrayList<DuAn> dsDuAn = new ArrayList<>();

    public ArrayList<DuAn> getDsDuAn() {
        return dsDuAn;
    }
    
    public void setDsDuAn(DuAn da) {
        QuanLyDA.dsDuAn.add(da);
    }
    
//    Xuất thông tin dự án
    public void xuatDuAn(){
        if (dsDuAn.isEmpty())
            System.out.println("khong co thong tin du an");
        else{
            for (DuAn da : dsDuAn) {
                da.xuatDuAn();
            }
        }
    }
    
//    Menu chọn loại thời gian dự án cần tìm
    public int menuThoiGian() throws SQLException{
        int choose;
        do {            
            System.out.println("");
            System.out.println("~~~~ CHON THOI GIAN DU AN MUON TIM ~~~~");
            System.out.println("1.  Ket thuc truoc ngay");
            System.out.println("2.  Bat dau sau ngay");
            System.out.println("0.  Tro ve");
            System.out.print("Chon: ");
            choose = s.nextInt();
            if (choose > 3)
                System.out.println("Nhap sai vui long nhap lai");
            else
                break;
        } while (choose != 0);
        if (choose == 0){
            Menu m = new Menu();
            m.ProjectMenu();
        }
        return choose;
    }
    
//    Lấy toàn bộ danh sách dự án
    public void layDuAn() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        sql.layDuAn();
        System.out.println("~~~~    DANH SACH DU AN   ~~~~");
        xuatDuAn();
    }
    
//    Tìm dự án theo tên
    public void timDuAn() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP DU AN MUON TIM  ~~~~");
        System.out.print("Ten du an: ");
        String ten = s.nextLine();
        sql.timDuAn(ten);
        System.out.println("~~~~    THONG TIN DU AN   ~~~~");
        xuatDuAn();
    }
    
//    Xóa thông tin một dự án
    public void xoaDuAn() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP DU AN MUON XOA  ~~~~");
        System.out.print("Ma du an: ");
        int id = s.nextInt();
        sql.xoaDuAn(id);
    }
    
//    Thêm mới một dự án
    public void themDuAn() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        DuAn da = new DuAn();
        da.nhapDuAn();
        sql.themDuAn(da);
    }
    
//    Tìm dự án theo thời gian
    public void timDuAnTheoThoiGian() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        String day;
        int c = menuThoiGian();
        System.out.println("~~~~    NHAP THOI GIAN DU AN    ~~~~");
        s.nextLine();
        System.out.print("Thoi gian (yyyy-mm-dd): ");
        day = s.nextLine();
        switch (c) {
            case 1 -> sql.timThoiGianKetThuc(day);
            case 2 -> sql.timThoiGianBatDau(day);
        }
        System.out.println("~~~~    DANH SACH CAC DU AN    ~~~~");
        xuatDuAn();
    }
    
//    Cập nhật thông tin dự án
    public void capNhatDA() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        DuAn da = new DuAn();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN DU AN    ~~~~");
        System.out.print("Ma du an: ");
        da.setMaDuAn(s.nextInt());
        da.nhapDuAn();
        sql.capNhatDA(da);
    }
    
//    Gán quản lý cho dự án
    public void ganQuanLy() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int maQL, maDA;
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN DU AN    ~~~~");
        System.out.print("Ma du an: ");
        maDA = s.nextInt();
        System.out.print("Ma quan ly: ");
        maQL = s.nextInt();
        if (sql.ktNhanVien(maQL, "quanly") == 1) {
            if (sql.ktSoLuongDA(maQL) < 3 && sql.ktSoLuongNV(maDA) < 10){
                sql.ganQuanLy(maDA, maQL);
                sql.ganNhanVien(maDA, maQL, "quanly");
            } else
                System.out.println("Du an da du nhan vien hoac nhan vien da du du an");
        } else {
            if (sql.ktNhanVien(maQL, "quanly") == 0) {
                System.out.println("Khong tim thay thong tin nhan vien!");
            }else
                System.out.println("loi xu ly khong thanh cong!");
        }
    }
    
//    Gán nhân viên  cho dự án
    public void ganNhanVien() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int maNV, maDA;
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN DU AN    ~~~~");
        System.out.print("Ma du an: ");
        maDA = s.nextInt();
        QuanLyNV qlnv = new QuanLyNV();
        String loai = qlnv.MenuLoaiNV();
        System.out.print("Ma nhan vien: ");
        maNV = s.nextInt();
        if (sql.ktNhanVien(maNV, loai) == 1) {
            if (sql.ktSoLuongDA(maNV) < 3 && sql.ktSoLuongNV(maDA) < 10)
                sql.ganNhanVien(maDA, maNV, loai);
            else
                System.out.println("So luong vuot qua cho phep!");
        } else {
            if (sql.ktNhanVien(maNV, loai) == 0) {
                System.out.println("Khong tim thay thong tin nhan vien!");
            }else
                System.out.println("loi xu ly khong thanh cong!");
        }
    }
    
//    Lấy danh sách nhân viên của một dự án
    public void layNhanvienDA() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        QuanLyNV qlnv = new QuanLyNV();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN DU AN    ~~~~");
        System.out.print("Ma du an: ");
        int id = s.nextInt();
        sql.layNhanVienDA(id);
        System.out.println("");
        System.out.printf("~~~~    DANH SACH NHAN VIEN THUOC DU AN %d    ~~~~\n", id);
        System.out.println("QUAN LY: ");
        qlnv.xuatDuLieu("quanly");
        System.out.println("LAP TRINH VIEN: ");
        qlnv.xuatDuLieu("laptrinhvien");
        System.out.println("THIET KE VIEN: ");
        qlnv.xuatDuLieu("thietkevien");
        System.out.println("KIEM THU VIEN: ");
        qlnv.xuatDuLieu("kiemthuvien");
    }
    
//    Sắp xếp dự án theo tổng kinh phí giảm dần
    public void sapXepDA() throws SQLException{
        layDuAn();
        QuanLyDA.dsDuAn.sort((da1, da2) -> {
            int tong1 = da1.getTongKinhPhi();
            int tong2 = da2.getTongKinhPhi();
            if (tong1 > tong2)
                return 1;
            else if (tong2 < tong1)
                return -1;
            return 0;
        });
    }
    
//    Xuất file danh sách dự án
    public void xuatFileDA(){
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String path = String.format("src/main/resources/DuAn_%d%d.txt", month, year);
        String fileName = path.substring(19);
        File f = new File(path);
        try {
            PrintWriter write = new PrintWriter(f);
            write.printf("DANH SACH DU AN CONG TY %d/%d\n", month, year);
            write.println(" ");
            write.println(" ");
            for (DuAn da : dsDuAn) {
                write.println("Ten du an: " + da.getTenDuAn() + " - " + da.getMaDuAn());
                write.println("Ngay bat dau: " + da.getThoiGianBD()+ "     " + "Ngay ket thuc: " + da.getThoiGianKT());
                write.println("Nguoi chu nhiem: " + da.getNguoiChuNhiem());
                write.println("Tong kinh phi: " + da.getTongKinhPhi() + " VND");
                write.println(" ");
            }
            write.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("Khong the tao file %s\n", fileName);
        }
    }
}
