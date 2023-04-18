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
public class QuanLyNV {
    Scanner s = new Scanner(System.in);
    int choose = 0;
    
    private static ArrayList<QuanLy> dsQuanLy = new ArrayList<>();
    private static ArrayList<LapTrinhVien> dsLapTrinhVien = new ArrayList<>();
    private static ArrayList<ThietKeVien> dsThietKeVien = new ArrayList<>();
    private static ArrayList<KiemThuVien> dsKiemThuVien = new ArrayList<>();
    private static ArrayList<ThanNhan> dsThanNhan = new ArrayList<>();

    public ArrayList<QuanLy> getDsQuanLy() {
        return dsQuanLy;
    }
    
    public void setDsQuanLy(QuanLy ql) {
        QuanLyNV.dsQuanLy.add(ql);
    }

    public ArrayList<LapTrinhVien> getDsLapTrinhVien() {
        return dsLapTrinhVien;
    }

    public void setDsLapTrinhVien(LapTrinhVien ltv) {
        QuanLyNV.dsLapTrinhVien.add(ltv);
    }
    
    public ArrayList<ThietKeVien> getDsThietKeVien() {
        return dsThietKeVien;
    }

    public void setDsThietKeVien(ThietKeVien tkv) {
        QuanLyNV.dsThietKeVien.add(tkv);
    }
    
    public ArrayList<KiemThuVien> getDsKiemThuVien() {
        return dsKiemThuVien;
    }

    public void setDskKiemThuVien(KiemThuVien ktv) {
        QuanLyNV.dsKiemThuVien.add(ktv);
    }
    
    public ArrayList<ThanNhan> getDsThanNhan() {
        return dsThanNhan;
    }

    public void setDsThanNhan(ThanNhan tn) {
        QuanLyNV.dsThanNhan.add(tn);
    }
    
//    Menu chọn loại nhân viên
    public String MenuLoaiNV() throws SQLException{
        do {
            System.out.println("");
            System.out.println("~~~~ CHON LOAI NHAN VIEN ~~~~");
            System.out.println("1. Quan ly");
            System.out.println("2. Lap trinh vien");
            System.out.println("3. Thiet ke vien");
            System.out.println("4. Kiem thu vien");
            System.out.println("0. Tro ve");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Choose: ");
            choose = s.nextInt();
            if (choose > 4){
                System.out.print("Nhap sai vui long nhap lai!");
                System.out.println("");
            }
            else{
                switch (choose) {
                    case 1 -> {
                        return "quanly";
                    }
                    case 2 -> {
                        return "laptrinhvien";
                    }
                    case 3 -> {
                        return "thietkevien";
                    }
                    case 4 -> {
                        return "kiemthuvien";
                    }
                }
            }
        } while (choose > 4);
        if (choose == 0) {
            Menu m = new Menu();
            m.EmployeeMenu();
        }
        return "";
    }
    
//    Menu chọn loại tìm kiếm
    public int MenuTimNV() throws SQLException{
        do {   
            System.out.println("");
            System.out.println("~~~~ TIM THEO ~~~~");
            System.out.println("1. Ma nhan vien");
            System.out.println("2. Ten nhan vien");
            System.out.println("3. Ngay sinh nhan vien");
            System.out.println("4. So tuoi nhan vien");
            System.out.println("5. Do tuoi nhan vien");
            System.out.println("0. Tro ve");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Choose: ");
            choose = s.nextByte();
            if (choose > 5){
                System.out.print("Nhap sai vui long nhap lai!");    
            }
        } while (choose > 5);
        if (choose == 0) {
            Menu m = new Menu();
            m.EmployeeMenu();
        }
        return choose;
    }
    
//    Xuất dữ liệu của từng loại nhân viên
    public void xuatDuLieu(String loaiNV){
        switch (loaiNV) {
            case "quanly" -> {
                if (dsQuanLy.isEmpty())
                    System.out.println("Khong co thong tin quan ly");
                else {
                    for (QuanLy ql : dsQuanLy) {
                        ql.xuatThongTin();
                    }
                }
            }
            case "laptrinhvien" -> {
                if (dsLapTrinhVien.isEmpty())
                    System.out.println("Khong co thong tin lap trinh vien");
                else {
                    for (LapTrinhVien ltv : dsLapTrinhVien) {
                        ltv.xuatThongTin();
                    }
                }
            }
            case "thietkevien" -> {
                if (dsThietKeVien.isEmpty())
                    System.out.println("Khong co thong tin thiet ke vien");
                else {
                    for (ThietKeVien tkv : dsThietKeVien) {
                        tkv.xuatThongTin();
                    }
                }
            }
            case "kiemthuvien" -> {
                if (dsKiemThuVien.isEmpty())
                    System.out.println("Khong co thong tin kiem thu vien");
                else {
                    for (KiemThuVien ktv : dsKiemThuVien) {
                        ktv.xuatThongTin();
                    }
                }
            }
        }
    }
    
//      NHÂN VIÊN
//    Xem danh sách nhân viên
    public void xemDanhSachNV() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        String loaiNV = MenuLoaiNV();
        sql.layNhanVien(loaiNV);
        System.out.println("");
        System.out.printf("~~~~    DANH SACH NHAN VIEN (%s)   ~~~~\n", loaiNV);
        xuatDuLieu(loaiNV);
    }
    
//    Thêm mới một nhân viên
    public void themNV() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        String loaiNV = MenuLoaiNV();
        switch (loaiNV) {
            case "quanly" -> {
                QuanLy ql = new QuanLy();
                ql.nhapThongTin();
                sql.themQuanLy(ql);
            }
            case "laptrinhvien" -> {
                LapTrinhVien ltv = new LapTrinhVien();
                ltv.nhapThongTin();
                sql.themLapTrinhVien(ltv);
            }
            case "thietkevien" -> {
                ThietKeVien tkv = new ThietKeVien();
                tkv.nhapThongTin();
                sql.themThietKe(tkv);
            }
            case "kiemthuvien" -> {
                KiemThuVien ktv = new KiemThuVien();
                ktv.nhapThongTin();
                sql.themKiemThu(ktv);
            }
        }        
    }
    
//    Xóa nhân viên
    public void xoaNV() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int id;
        String loaiNV;
        loaiNV = MenuLoaiNV();
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN NHAN VIEN MUON XOA ~~~~");
        System.out.print("Ma nhan vien: ");
        id = s.nextInt();
        sql.xoaNV(id, loaiNV);
    }
    
//    Xử lý chọn loại tìm kiếm
    public void xuLyTim() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int tuoi;
        String loaiNV, query = "";
        loaiNV = MenuLoaiNV();
        int loaiTimKiem = MenuTimNV();
        System.out.println("");
        switch (loaiTimKiem) {
            case 1 -> {
                timNV(loaiNV);
            }
            case 2 -> {
                System.out.println("~~~~ NHAP TEN NHAN VIEN ~~~~");
                s.nextLine();
                System.out.print("Ten nhan vien: ");
                String ten = s.nextLine();
                query = String.format("SELECT * FROM %s WHERE hoTen LIKE '%s'", loaiNV, ten);
                System.out.println("");
                System.out.printf("~~~~ DANH SACH NHAN VIEN CO TEN %s ~~~~\n", ten);
                sql.timNVTheoDK(query, loaiNV);
                xuatDuLieu(loaiNV);
            }
            case 3 -> {
                System.out.println("~~~~    NHAP NGAY SINH    ~~~~");
                s.nextLine();
                System.out.print("Ngay sinh(yyyy-mm-dd): ");
                String day = s.nextLine();
                query = String.format("SELECT * FROM %s WHERE ngaySinh = '%s'", loaiNV, day);
                System.out.println("");
                System.out.printf("~~~~ DANH SACH NHAN VIEN CO NGAY SINH %s ~~~~\n", day);
                sql.timNVTheoDK(query, loaiNV);
                xuatDuLieu(loaiNV);
            }
            case 4 -> {
                System.out.println("~~~~ NHAP TUOI NHAN VIEN ~~~~");
                System.out.print("Tuoi nhan vien: ");
                tuoi = s.nextInt();
                int year = Calendar.getInstance().get(Calendar.YEAR) - tuoi;
                query = String.format("SELECT * FROM %s WHERE YEAR(ngaySinh) LIKE %d;", loaiNV, year);
                System.out.println("");
                System.out.printf("~~~~ DANH SACH NHAN VIEN CO TUOI %d ~~~~\n", tuoi);
                sql.timNVTheoDK(query, loaiNV);
                xuatDuLieu(loaiNV);
            }
            case 5 -> {
                int tu, den;
                System.out.println("~~~~ NHAP DO TUOI NHAN VIEN ~~~~");
                System.out.print("Tuoi nhan vien tu: ");
                tu = s.nextInt();
                System.out.print("Tuoi nhan vien den: ");
                den = s.nextInt();
                int fromYear = Calendar.getInstance().get(Calendar.YEAR) - den;
                int toYear = Calendar.getInstance().get(Calendar.YEAR) - tu;
                query = String.format("SELECT * FROM %s WHERE YEAR(ngaySinh) BETWEEN %d AND %d;", loaiNV, fromYear, toYear);
                System.out.println("");
                System.out.printf("~~~~ DANH SACH NHAN VIEN TUOI TU %d DEN %d ~~~~\n", tu, den);
                sql.timNVTheoDK(query, loaiNV);
                xuatDuLieu(loaiNV);
            }
        }
    }
    
//    Tìm nhân viên theo mã
    public void timNV(String loaiNV) throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int id;
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN NHAN VIEN MUON TIM ~~~~");
        System.out.print("Ma nhan vien: ");
        id = s.nextInt();
        System.out.println("");
        System.out.println("~~~~ THONG TIN NHAN VIEN ~~~~");
        switch (loaiNV) {
            case "quanly" -> {
                QuanLy ql = (QuanLy) sql.timNV(id ,loaiNV);
                ql.xuatThongTin();
            }
            case "laptrinhvien" -> {
                LapTrinhVien ltv = (LapTrinhVien) sql.timNV(id ,loaiNV);
                ltv.xuatThongTin();
            }
            case "thietkevien" -> {
                ThietKeVien tkv = (ThietKeVien) sql.timNV(id ,loaiNV);
                tkv.xuatThongTin();
            }
            case "kiemthuvien" -> {
                KiemThuVien ktv = (KiemThuVien) sql.timNV(id ,loaiNV);
                ktv.xuatThongTin();
            }
        }
    }
    
//    Cập nhật nhân viên
    public void capNhatNV() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int maNV;
        String loaiNV = MenuLoaiNV();
        System.out.println("");
        System.out.print("Ma nhan vien: ");
        maNV = s.nextInt();
        switch (loaiNV) {
            case "quanly" -> {
                QuanLy ql = new QuanLy();
                ql.nhapThongTin();
                sql.capNhatQL(ql, maNV);
            }
            case "laptrinhvien" -> {
                LapTrinhVien ltv = new LapTrinhVien();
                ltv.nhapThongTin();
                sql.capNhatLTV(ltv, maNV);
            }
            case "thietkevien" -> {
                ThietKeVien tkv = new ThietKeVien();
                tkv.nhapThongTin();
                sql.capNhatTKV(tkv, maNV);
            }
            case "kiemthuvien" -> {
                KiemThuVien ktv = new KiemThuVien();
                ktv.nhapThongTin();
                sql.capNhatKTV(ktv, maNV);
            }
        }
    }
    
//    Lấy dự án nhân viên
    public void layDuAnNV() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        QuanLyDA qlda = new QuanLyDA();
        String loaiNV = MenuLoaiNV();
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN NHAN VIEN ~~~~");
        System.out.print("Ma nhan vien: ");
        int id = s.nextInt();
        System.out.println("");
        System.out.printf("~~~~ DANH SACH DU AN CUA NHAN VIEN %d ~~~~\n", id);
        sql.layDuAnNV(id, loaiNV);
        qlda.xuatDuAn();
    }
    
//    Lấy danh sách thân nhân của nhân viên
    public void layThanNhanNV() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int id;
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN NHAN VIEN ~~~~");
        System.out.print("Ma nhan vien: ");
        id = s.nextInt();
        System.out.println("");
        System.out.println("~~~~ DANH SACH THAN NHAN NHAN VIEN ~~~~");
        sql.layThanNhanNV(id);
        for (ThanNhan tn : dsThanNhan) {
            tn.xuatThongTin();
        }
    }
    
//      THÂN NHÂN
//    Xem danh sách toàn bộ thân nhân
    public void xemDanhSachTN() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        sql.layNhanVien("thannhan");
        for (ThanNhan tn : dsThanNhan) {
            tn.xuatThongTin();
        }
    }
    
//    Thêm mới một thân nhân
    public void themThanNhan() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        ThanNhan tn = new ThanNhan();
        tn.nhapThongTin();
        sql.themThanNhan(tn);
    }

//    Xóa thân nhân
    public void xoaTN() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int id;
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN THAN NHAN MUON XOA ~~~~");
        System.out.print("Ma than nhan: ");
        id = s.nextInt();
        sql.xoaTN(id);
    }

//    Tìm thân nhân theo mã nhân viên
    public void timTN() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int id;
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN THAN NHAN ~~~~");
        System.out.print("Ma nhan vien: ");
        id = s.nextInt();
        System.out.println("");
        System.out.println("~~~~ THONG TIN THAN NHAN ~~~~");
        sql.timNV(id, "thannhan");
        if (dsThanNhan.isEmpty())
            System.out.println("Khong co thong tin than nhan");
        else {
            for (ThanNhan tn : dsThanNhan) {
                tn.xuatThongTin();
            }
        }
    }

//    Cập nhật thông tin thân nhân
    public void capNhatTN() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        int maNV;
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN THAN NHAN ~~~~");
        System.out.print("Ma nhan vien: ");
        ThanNhan tn = (ThanNhan) sql.timNV(s.nextInt(), "thannhan");
        maNV = tn.getMaNV();
        tn.nhapThongTin();
        sql.capNhatTN(tn, maNV);
    }
    
//    Lấy danh sách nhân viên của một phòng ban
    public void layNhanVienPB() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN PHONG BAN    ~~~~");
        System.out.print("Ma phong ban: ");
        int id = s.nextInt();
        sql.layNVPhongBan(id, "quanly");
        sql.layNVPhongBan(id, "laptrinhvien");
        sql.layNVPhongBan(id, "thietkevien");
        sql.layNVPhongBan(id, "kiemthuvien");
        System.out.println("");
        System.out.println("~~~~    THONG TIN DANH SACH NHAN VIEN CUA PHONG BAN    ~~~~");
        System.out.println("QUAN LY");
        xuatDuLieu("quanly");
        System.out.println("LAP TRINH VIEN");
        xuatDuLieu("laptrinhvien");
        System.out.println("THIET KE VIEN");
        xuatDuLieu("thietkevien");
        System.out.println("KIEM THU VIEN");
        xuatDuLieu("kiemthuvien");
    }
    
//    Xuất file danh sách nhân viên
    public void xuatFileNV() throws SQLException{
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        ConnectMySQL sql = new ConnectMySQL();
        String path = String.format("src/main/resources/NhanVien_%d%d.txt", month, year);
        String fileName = path.substring(19);
        File f = new File(path);
        try {
            PrintWriter writer = new PrintWriter(f);
            sql.layNhanVien("quanly");
            sql.layNhanVien("laptrinhvien");
            sql.layNhanVien("thietkevien");
            sql.layNhanVien("kiemthuvien");
            writer.println("DANH SACH NHAN VIEN CONG TY");
            writer.println(" ");
            writer.println(" ");
            writer.println("1. QUAN LY: ");
            for (QuanLy ql : dsQuanLy) {
                writer.println("Ho ten: " + ql.getHoTen());
                writer.println("Ngay sinh: " + ql.getNgaySinh() + "     " + "Gioi tinh: " + ql.getGioiTinh());
                writer.println("Email: " + ql.getEmail() + "     " + "Phong Ban: " + ql.getPhongBan());
                writer.println("Ngay nham chuc: " + ql.getNgayNhamChuc());
                writer.println("Quan ly phong ban: " + ql.getPhongBan1() + ", " + ql.getPhongBan2());
                writer.println(" ");
            }
            writer.println(" ");
            writer.println(" ");
            writer.println("2. LAP TRINH VIEN: ");
            for (LapTrinhVien ltv : dsLapTrinhVien) {
                writer.println("Ho ten: " + ltv.getHoTen());
                writer.println("Ngay sinh: " + ltv.getNgaySinh() + "     " + "Gioi tinh: " + ltv.getGioiTinh());
                writer.println("Email: " + ltv.getEmail() + "     " + "Phong Ban: " + ltv.getPhongBan());
                writer.println("Over-time: " + ltv.getOverTime());
                writer.println(" ");
            }
            writer.println(" ");
            writer.println(" ");
            writer.println("3. THIET KE VIEN: ");
            for (ThietKeVien tkv : dsThietKeVien) {
                writer.println("Ho ten: " + tkv.getHoTen());
                writer.println("Ngay sinh: " + tkv.getNgaySinh() + "     " + "Gioi tinh: " + tkv.getGioiTinh());
                writer.println("Email: " + tkv.getEmail() + "     " + "Phong Ban: " + tkv.getPhongBan());
                writer.println("Bonus: " + tkv.getBonus() + "VND");
                writer.println(" ");
            }
            writer.println(" ");
            writer.println("4. KIEM THU VIEN: ");
            for (KiemThuVien ktv : dsKiemThuVien) {
                writer.println("Ho ten: " + ktv.getHoTen());
                writer.println("Ngay sinh: " + ktv.getNgaySinh() + "     " + "Gioi tinh: " + ktv.getGioiTinh());
                writer.println("Email: " + ktv.getEmail() + "     " + "Phong Ban: " + ktv.getPhongBan());
                writer.println("So luong loi: " + ktv.getError() + "errors");
                writer.println(" ");
            }
            writer.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("Khong the tao file %s\n", fileName);
        }
    }
}
