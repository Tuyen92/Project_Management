/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class ConnectMySQL {
    private static final String url = "jdbc:mysql://localhost:3306/quanlyduan";
    private static final String username = "root";
    private static final String password = "09022001";
    QuanLyNV qlnv = new QuanLyNV();
    QuanLyLuong qll = new QuanLyLuong();
    QuanLyDA qlda = new QuanLyDA();
    
//  Gán dữ liệu vào array list
    public void ganDuLieu(String loai, ResultSet rs) throws SQLException{
        switch (loai) {
                case "quanly" -> {
                    qlnv.getDsQuanLy().clear();
                    while (rs.next()) {
                        QuanLy ql = new QuanLy(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"), rs.getString("email"),
                                rs.getString("phongBan"), rs.getString("ngayNhamChuc"), rs.getString("phongBan1"), rs.getString("phongBan2"));
                            qlnv.setDsQuanLy(ql);
                    }
                }
                case "laptrinhvien" -> {
                    qlnv.getDsLapTrinhVien().clear();
                    while (rs.next()) {
                        LapTrinhVien ltv = new LapTrinhVien(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"),
                        rs.getString("email"), rs.getString("phongBan"), rs.getDouble("overTime"));
                        qlnv.setDsLapTrinhVien(ltv);
                    }
                }
                case "thietkevien" -> {
                    qlnv.getDsThietKeVien().clear();
                    while (rs.next()) {
                        ThietKeVien tkv = new ThietKeVien(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"),
                        rs.getString("email"), rs.getString("phongBan"), rs.getInt("bonus"));
                        qlnv.setDsThietKeVien(tkv);
                    }
                }
                case "kiemthuvien" -> {
                    qlnv.getDsKiemThuVien().clear();
                    while (rs.next()) {
                        KiemThuVien ktv = new KiemThuVien(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"),
                        rs.getString("email"),rs.getString("phongBan"), rs.getInt("Error"));
                        qlnv.setDskKiemThuVien(ktv);
                    }
                }
                case "thannhan" -> {
                    qlnv.getDsThanNhan().clear();
                    while (rs.next()) {
                        ThanNhan tn = new ThanNhan(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"),
                                "-", "-", rs.getString("moiQuanHe"), rs.getInt("maNhanVien"));
                        qlnv.setDsThanNhan(tn);
                    }
                }
                case "phongban" -> {
                    qll.getDsPhongBan().clear();
                    while (rs.next()) {
                        PhongBan pb = new PhongBan(rs.getInt("maPhongBan"), rs.getString("tenPhongBan"), rs.getInt("maQuanLy"));
                        qll.setDsPhongBan(pb);
                    }
                }
                case "duan" -> {
                    qlda.getDsDuAn().clear();
                    while (rs.next()) {
                        DuAn da = new DuAn(rs.getInt("maDuAn"), rs.getString("tenDuAn"), rs.getString("thoiGianBD"),
                                rs.getString("thoiGianKT"), rs.getInt("tongKinhPhi"), rs.getInt("nguoiChuNhiem"));
                        qlda.setDsDuAn(da);
                    }
                }
                case "luong" -> {
                    qll.getDsLuong().clear();
                    while (rs.next()) {
                        Luong luong = new Luong(rs.getInt("maNhanVien"), rs.getDouble("tongLuong"), rs.getDouble("luongCoBan"),
                                rs.getDouble("heSo"), rs.getDouble("congThem"));
                        qll.setDsLuong(luong);
                    }
                }
            }
    }
    
//    NHÂN VIÊN
//    Lấy toàn bộ nhân viên của một chức vụ
    public void layNhanVien(String loai) throws SQLException {
        try (Connection connect = getConnection(url, username, password)) {
            Statement state = connect.createStatement();
            String query = String.format("SELECT * FROM %s", loai);
            ResultSet rs = state.executeQuery(query);
            ganDuLieu(loai, rs);
        } catch(Exception e){
            System.out.println("Lay du lieu không thanh cong: " + e.getMessage());
        }
    }
    
//    Thêm mới một quản lý
    public void themQuanLy(QuanLy ql) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(ql.themSQL());
            System.out.println("Them quan ly moi thanh cong!");
        } catch(Exception e){
            System.out.println("Them quan ly moi khong thanh cong: " + e.getMessage());
        }
    }
    
//    Thêm mới một lập trình viên
    public void themLapTrinhVien(LapTrinhVien ltv) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(ltv.themSQL());
            System.out.println("Them lap trinh vien moi thanh cong!");
        } catch(Exception e){
            System.out.println("Them lap trinh vien moi khong thanh cong: " + e.getMessage());
        }
    }
    
//    Thêm mới một thiết kế viên
    public void themThietKe(ThietKeVien tkv) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(tkv.themSQL());
            System.out.println("Them thiet ke vien moi thanh cong!");
        } catch(Exception e){
            System.out.println("Them thiet ke vien moi khong thanh cong: " + e.getMessage());
        }
    }
    
//    Thêm mới một kiểm thử viên
    public void themKiemThu(KiemThuVien ktv) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(ktv.themSQL());
            System.out.println("Them kiem thu vien moi thanh cong!");
        } catch(Exception e){
            System.out.println("Them kiem thu vien moi khong thanh cong: " + e.getMessage());
        }
    }
    
//    Xóa một nhân viên
    public void xoaNV(int id, String loaiNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("DELETE FROM %s WHERE (maNhanVien = %d)", loaiNV, id);
            state.executeUpdate(query);
            System.out.println("Da xoa nhan vien thanh cong!");
        } catch(Exception e){
            System.out.println("xoa nhan vien khong thanh cong: " + e.getMessage());
        }
    }
    
//    Tìm một nhân viên theo mã nhân viên
    public Object timNV(int id, String loaiNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM %s WHERE (maNhanVien = %d)", loaiNV, id);
            ResultSet rs = state.executeQuery(query);
            switch (loaiNV) {
                case "quanly" -> {
                    while (rs.next()){
                        QuanLy ql = new QuanLy(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"), rs.getString("email"),
                        rs.getString("phongBan"), rs.getString("ngayNhamChuc"), rs.getString("phongBan1"), rs.getString("phongBan2"));
                        return ql;
                    }
                }
                case "laptrinhvien" -> {
                    while (rs.next()){
                        LapTrinhVien ltv = new LapTrinhVien(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"),
                        rs.getString("email"), rs.getString("phongBan"), rs.getDouble("overTime"));
                        return ltv;
                    }
                }
                case "thietkevien" -> {
                    while (rs.next()){
                        ThietKeVien tkv = new ThietKeVien(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"),
                        rs.getString("phongBan"), rs.getString("email"), rs.getInt("bonus"));
                        return tkv;
                    }
                }
                case "kiemthuvien" -> {
                    while (rs.next()){
                        KiemThuVien ktv = new KiemThuVien(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"),
                        rs.getString("email"), rs.getString("phongBan"), rs.getInt("error"));
                        return ktv;
                    }
                }
                case "thannhan" -> {
                    while (rs.next()) {                            
                        ThanNhan tn = new ThanNhan(rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("ngaySinh"), "", "",
                            rs.getString("moiQuanHe"), rs.getInt("maNhanVien"));
                        qlnv.setDsThanNhan(tn);
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
        return "";
    }
    
//    Tìm nhân viên theo tên, ngày sinh, tuổi, độ tuổi
    public void timNVTheoDK(String query, String loaiNV){
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            ResultSet rs = state.executeQuery(query);
            ganDuLieu(loaiNV, rs);
        } catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    Lấy dự án của một nhân viên
    public void layDuAnNV(int id, String loaiNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM duan da, chitietduan c WHERE (da.maDuAn = c. maDuAn AND c.maNhanVien = %d AND c.chucVu = '%s')", id, loaiNV);
            ResultSet rs = state.executeQuery(query);
            ganDuLieu("duan", rs);
        } catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }

//    Cập nhật thông tin một quản lý
    public void capNhatQL(QuanLy ql, int maNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(ql.capNhatSQL(maNV));
            System.out.println("Cap nhat quan ly thanh cong!");
            }catch(Exception e){
                System.out.println("Cap nhat quan ly khong thanh cong: " + e.getMessage());
            }
    }
    
//    Cập nhật thông tin của một lập trình viên
    public void capNhatLTV(LapTrinhVien ltv, int maNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(ltv.capNhatSQL(maNV));
            System.out.println("Cap nhat lap trinh vien thanh cong!");
            }catch(Exception e){
                System.out.println("Cap nhat lap trinh vien khong thanh cong: " + e.getMessage());
            }
    }
    
//    Cập nhật thông tin của một thiết kế viên
    public void capNhatTKV(ThietKeVien tkv, int maNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(tkv.capNhatSQL(maNV));
            System.out.println("Cap nhat thiet ke vien thanh cong!");
            }catch(Exception e){
                System.out.println("Cap nhat thiet ke vien khong thanh cong: " + e.getMessage());
            }
    }
    
//    Cập nhật thông tin của một kiểm thử viên 
    public void capNhatKTV(KiemThuVien ktv, int maNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(ktv.capNhatSQL(maNV));
            System.out.println("Cap nhat kiem thu vien thanh cong!");
            }catch(Exception e){
                System.out.println("Cap nhat kiem thu vien khong thanh cong: " + e.getMessage());
            }
    }
    
//   THÂN NHÂN 
//    Lấy danh sách thân nhân của một nhân viên
    public void layThanNhanNV(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM thannhan WHERE (maNhanVien = %d)", id);
            ResultSet rs = state.executeQuery(query);
            ganDuLieu("thannhan", rs);
        }catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }

//    Thêm mới một thân nhân
    public void themThanNhan(ThanNhan tn) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(tn.themSQL());
            System.out.println("Them than nhan moi thanh cong!");
        }catch(Exception e){
            System.out.println("Them nhan nhan khong thanh cong: " + e.getMessage());
        }
    }

//    Xóa thông tin một thân nhân
    public void xoaTN(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("DELETE FROM thannhan WHERE (maThanNhan = %d)", id);
            state.executeUpdate(query);
            System.out.println("Da xoa than nhan thanh cong!");
        }catch(Exception e){
            System.out.println("Da xoa than nhan khong thanh cong: " + e.getMessage());
        }
    }
    
//    Cập nhật thông tin của một thân nhân
    public void capNhatTN(ThanNhan tn, int maNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            state.executeUpdate(tn.capNhatSQL(maNV));
            System.out.println("Cap nhat than nhan thanh cong!");
            }catch(Exception e){
                System.out.println("Cap nhat than nhan khong thanh cong: " + e.getMessage());
            }
    }
    
//    PHÒNG BAN
//    Thêm mới một phòng ban
    public void themPhongBan(PhongBan pb) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("INSERT INTO phongban(maPhongBan, tenPhongBan, maQuanLy) VALUES (%d, '%s', %d)", 
                    pb.getMaPhongBan(), pb.getTenPhongBan(), pb.getMaQuanLy());
            state.executeUpdate(query);
            System.out.println("Them phong ban moi thanh cong!");
        }catch(Exception e){
            System.out.println("Them phong ban khong thanh cong: " + e.getMessage());
        }
    }
    
//    Lấy danh sách các phòng ban
    public void layPhongBan() throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM phongban");
            ResultSet rs = state.executeQuery(query);
            ganDuLieu("phongban", rs);
        } catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    Xóa thông tin một phòng ban
    public void xoaPhongBan(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("DELETE FROM phongban WHERE (maPhongBan = %d)", id);
            state.executeUpdate(query);
            System.out.println("Da xoa phong ban thanh cong!");
        }catch(Exception e){
            System.out.println("Xoa phong ban khong thanh cong: " + e.getMessage());
        }
    }
    
//    Tìm thông tin một phòng ban
    public Object timPhongBan(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM phongban WHERE (maPhongBan = %d)", id);
            ResultSet rs = state.executeQuery(query);
            while(rs.next()){
                PhongBan pb = new PhongBan();
                pb.setMaPhongBan(rs.getInt("maPhongBan"));
                pb.setTenPhongBan(rs.getString("tenPhongBan"));
                pb.setMaQuanLy(rs.getInt("maQuanLy"));
                return pb;
            }
        }catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
        return "";
    }
    
//    Cập nhật thông tin của một phòng ban
    public void capNhatPB(PhongBan pb) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("UPDATE phongban SET tenPhongBan = '%s', maQuanLy = %d WHERE (maPhongBan = %d)",
                    pb.getTenPhongBan(), pb.getMaQuanLy(), pb.getMaPhongBan());
            state.executeUpdate(query);
            System.out.println("Cap nhat phong ban thanh cong!");
            }catch(Exception e){
                System.out.println("Cap nhat phong ban khong thanh cong: " + e.getMessage());
            }
    }
    
//    Lấy danh sách nhân viên của một phòng ban
    public void layNVPhongBan(int pb, String loaiNV) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM %s WHERE phongBan = %d", loaiNV, pb);
            ResultSet rs = state.executeQuery(query);
            ganDuLieu(loaiNV, rs);
        }catch(Exception e){
            System.out.println("Loi lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    DỰ ÁN
//    Lấy danh sách dự án
    public void layDuAn() throws SQLException{        
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM duan");
            ResultSet rs = state.executeQuery(query);
            ganDuLieu("duan", rs);
        }catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    Tìm thông tin một dự án
    public void timDuAn(String ten) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM duan WHERE tenDuAn LIKE '%s'", ten);
            ResultSet rs = state.executeQuery(query);
            ganDuLieu("duan", rs);
        }catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    Xóa thông tin môt dự án
    public void xoaDuAn(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("DELETE FROM duan WHERE (maDuAn = %d)", id);
            state.executeUpdate(query);
            System.out.println("Da xoa du an thanh cong!");
        }catch(Exception e){
            System.out.println("Da xoa du an khong thanh cong: " + e.getMessage());
        }
    }
    
//    Thêm mới một dự án
    public void themDuAn(DuAn da) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("INSERT INTO duan VALUE(%d, '%s', '%s', '%s', %d, %d)",
                    da.getMaDuAn(), da.getTenDuAn(), da.getThoiGianBD(), da.getThoiGianKT(), da.getTongKinhPhi(), da.getNguoiChuNhiem());
            state.executeUpdate(query);
            System.out.println("Them du an thanh cong!");
        }catch(Exception e){
            System.out.println("Them du an khong thanh cong: " + e.getMessage());
        }
    }
    
//    Tìm dự án theo thời gian bắt đầu
    public void timThoiGianBatDau(String bd) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM duan WHERE(thoiGianBD > '%s')", bd);
            ResultSet rs = state.executeQuery(query);
            ganDuLieu("duan", rs);
        } catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    Tìm dự án theo thời gian kết thúc
    public void timThoiGianKetThuc(String kt) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM duan WHERE(thoiGianKT < %s)", kt);
            ResultSet rs = state.executeQuery(query);
            ganDuLieu("duan", rs);
        }catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    Lấy danh sách nhân viên của một dự án
    public void layNhanVienDA(int id) throws SQLException{
        String query;
        ResultSet rs;
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            query = String.format("SELECT * FROM quanly ql, chitietduan c WHERE (ql.maNhanVien = c.maNhanVien AND c.maDuAn = %d AND c.chucVu = 'quanly')", id);
            rs = state.executeQuery(query);
            ganDuLieu("quanly", rs);
            
            query = String.format("SELECT * FROM laptrinhvien ltv, chitietduan c WHERE (ltv.maNhanVien = c.maNhanVien AND c.maDuAn = %d AND c.chucVu = 'laptrinhvien')", id);
            rs = state.executeQuery(query);
            ganDuLieu("laptrinhvien", rs);
            
            query = String.format("SELECT * FROM thietkevien tkv, chitietduan c WHERE (tkv.maNhanVien = c.maNhanVien AND c.maDuAn = %d AND c.chucVu = 'thietkevien')", id);
            rs = state.executeQuery(query);
            ganDuLieu("thietkevien", rs);
            
            query = String.format("SELECT * FROM kiemthuvien ktv, chitietduan c WHERE (ktv.maNhanVien = c.maNhanVien AND c.maDuAn = %d AND c.chucVu = 'kiemthuvien')", id);
            rs = state.executeQuery(query);
            ganDuLieu("kiemthuvien", rs);
        }catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    Cập nhật thông tin một dự án
    public void capNhatDA(DuAn da) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("UPDATE duan SET tenDuAn = '%s', thoiGianBD = '%s', thoiGianKT = '%s', tongKinhPhi = '%s', nguoiChuNhiem = %d WHERE (maDuAn = %d)",
                    da.getTenDuAn(), da.getThoiGianBD(), da.getThoiGianKT(), da.getTongKinhPhi(), da.getNguoiChuNhiem(), da.getMaDuAn());
            state.executeUpdate(query);
            System.out.println("Cap nhat du an thanh cong!");
            }catch(Exception e){
                System.out.println("Cap nhat du an khong thanh cong: " + e.getMessage());
            }
    }
    
//    Gán quản lý cho một dự án
    public void ganQuanLy(int maDA, int maQL) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("UPDATE duan SET nguoiChuNhiem = %d WHERE (maDuAn = %d)", maQL, maDA);
            state.executeUpdate(query);
            System.out.println("Gan quan ly thanh cong");
            }catch(Exception e){
                System.out.println("Gan quan ly khong thanh cong: " + e.getMessage());
            }
    }
    
//    Gán nhân viên cho một dự án
    public void ganNhanVien(int maDA, int maNV, String chucVu) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("INSERT INTO chitietduan(maDuAn, maNhanVien, chucVu) VALUE (%d, %d, '%s')", maDA, maNV, chucVu);
            state.executeUpdate(query);
            System.out.println("Gan nhan vien thanh cong");
            }catch(Exception e){
                System.out.println("Gan quan ly khong thanh cong: " + e.getMessage());
            }
    }
    
//    LƯƠNG BỔNG
//    Xem danh sách lương
    public void xemDanhSachLuong() throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM luong");
            ResultSet rs = state.executeQuery(query);
            ganDuLieu("luong", rs);
        }catch(Exception e){
            System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
        }
    }
    
//    Lấy lương của một nhân viên
    public Luong layLuongNV(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM luong WHERE maNhanVien = %d", id);
            ResultSet rs = state.executeQuery(query);
            while (rs.next()) {                
                Luong luong = new Luong(rs.getInt("maNhanVien"), rs.getDouble("tongLuong"), rs.getDouble("luongCoBan"), rs.getDouble("heSo"), rs.getDouble("congThem"));
                return luong;
            }
        } catch (Exception e){
            System.out.print("Lay du lieu khong thanh cong: " + e.getMessage());
        }
        Luong luong = new Luong();
        return luong;
    }
    
//    Lấy lương cao nhất
    public double layMaxLuong() throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT MAX(tongLuong) as maxLuong FROM luong");
            ResultSet rs = state.executeQuery(query);
            while (rs.next()) {                
                return rs.getDouble("maxLuong");
            }
        }catch(Exception e){
                System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
            }
        return 0;
    }
    
//    Lấy lương thấp nhất
    public double layMinLuong() throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT MIN(tongLuong) as minLuong FROM luong");
            ResultSet rs = state.executeQuery(query);
            while (rs.next()) {                
                return rs.getDouble("minLuong");
            }
        }catch(Exception e){
                System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
            }
        return 0;
    }
    
//    Tính lương bình quân
    public double layLuongBinhQuan() throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT avg(tongLuong) as luongBinhQuan FROM quanlyduan.luong;");
            ResultSet rs = state.executeQuery(query);
            while (rs.next()) {                
                return rs.getDouble("luongBinhQuan");
            }
            }catch(Exception e){
                System.out.println("Lay du lieu khong thanh cong: " + e.getMessage());
            }
        return 0;
    }
    
//    Thống kê số lương nhân viên có lương trên mức
    public int thongKeTrenLuong(double giaLuong) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT COUNT(*) AS soLuong FROM luong WHERE (tongLuong >= %.02f)", giaLuong);
            ResultSet rs = state.executeQuery(query);
            while (rs.next()) {                
                int sl = rs.getInt("soLuong");
                return sl;
            }
            } catch(Exception e){
                System.out.print("Lay du lieu khong thanh cong: " + e.getMessage());
            }
        return 0;
    }
    
//    Thống kê số lương nhân viên có lương dưới mức
    public int thongKeDuoiLuong(int giaLuong) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT COUNT(*) AS soLuong FROM luong WHERE (tongLuong < %d)", giaLuong);
            ResultSet rs = state.executeQuery(query);
            while (rs.next()) {                
                int sl = rs.getInt("soLuong");
                return sl;
            }
            } catch(Exception e){
                System.out.print("Lay du lieu khong thanh cong: " + e.getMessage());
            }
        return 0;
    }
    
//    Lưu thông tin lương vào bảng
    public void tinhLuong(Luong luong) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
            Statement state = connect.createStatement()){
            String query = String.format("INSERT INTO luong (maLuong, luongCoBan, maNhanVien, heSo, congThem, tongLuong) VALUES (%d, %.02f, %d, %.02f, %.02f, %.02f)",
                    luong.getMaLuong(), luong.getLuongCoBan(), luong.getMaNhanVien(), luong.getHeSo(), luong.getCongThem(), luong.getTongLuong());
            state.executeUpdate(query);
            System.out.println("Da them luong nhan vien thanh cong!");
            } catch(Exception e){
                System.out.println("Them luong nhan vien khong thanh cong: " + e.getMessage());
            }
    }
    
//    Lấy hệ số nhân viên
    public double layHeSo(String loai) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM heso WHERE (chucVu = '%s')", loai);
            ResultSet rs = state.executeQuery(query);
            HeSo hs = new HeSo();
            while (rs.next()) {                
                hs.setHeSo(rs.getDouble("heSo"));
            }
            return hs.getHeSo();
        }catch(Exception e){
                System.out.print("Lay du lieu khong thanh cong: " + e.getMessage());
            }
        return 0;
    }
    
//    Lấy lương cơ bản
    public double layLuongCB(String loai) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("SELECT * FROM loailuong WHERE (chucVu = '%s')", loai);
            ResultSet rs = state.executeQuery(query);
            while (rs.next()) {                
                LoaiLuong ll = new LoaiLuong();
                ll.setLuongCoBan(rs.getDouble("luongCoBan"));
                return ll.getLuongCoBan();
            }
        }catch(Exception e){
                System.out.print("Lay du lieu khong thanh cong: " + e.getMessage());
            }
        return 0;
    }
    
//    Thêm mới một hệ số
    public void themHeSo(double hs, String loai) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("INSERT INTO heso(heSo, chucVu) VALUE (%.02f, '%s')", hs, loai);
            state.executeUpdate(query);
            System.out.println("Them he so luong thanh cong!");
        }catch(Exception e){
            System.out.println("Them he so luong khong thanh cong: " + e.getMessage());
        }
    }
    
//    Thêm mới một lương cơ bản
    public void themLuongCB(double luongCB, String loai) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                Statement state = connect.createStatement()) {
            String query = String.format("INSERT INTO loailuong(luongCoBan, chucVu) VALUE (%.02f, '%s')", luongCB, loai);
            state.executeUpdate(query);
            System.out.println("Them luong co ban thanh cong!");
        }catch(Exception e){
            System.out.println("Them luong co ban khong thanh cong: " + e.getMessage());
        }
    }

//    XU LY NGHIEP VU
//    Kiểm tra số lượng phòng ban mà quản lý đang coi quản
    public int kiemTraQLPB(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                    Statement state = connect.createStatement()) {
                String query = String.format("SELECT COUNT(*) as soLuong FROM phongban WHERE (maQuanLy = %d)", id);
                ResultSet rs = state.executeQuery(query);
                while (rs.next()){
                    return rs.getInt("soLuong");
                }
            }catch(Exception e){
                System.out.println("Da xay ra loi: " + e.getMessage());
            }
        return -1;
    }
    
//    Kiểm tra số lương nhân viên tham gia một dự án
    public int ktSoLuongNV(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                    Statement state = connect.createStatement()) {
                String query = String.format("SELECT COUNT(*) as soLuong FROM chitietduan WHERE (maDuAn = %d)", id);
                ResultSet rs = state.executeQuery(query);
                while (rs.next()){
                    return rs.getInt("soLuong");
                }
            }catch(Exception e){
                System.out.println("Da xay ra loi: " + e.getMessage());
            }
        return -1;
    }
    
//    Kiểm tra số lượng dự án mà một nhan viên tham gia
    public int ktSoLuongDA(int id) throws SQLException{
        try (Connection connect = getConnection(url, username, password);
                    Statement state = connect.createStatement()) {
                String query = String.format("SELECT COUNT(*) as soLuong FROM chitietduan WHERE (maNhanVien = %d)", id);
                ResultSet rs = state.executeQuery(query);
                while (rs.next()){
                    return rs.getInt("soLuong");
                }
            }catch(Exception e){
                System.out.println("Da xay ra loi: " + e.getMessage());
            }
        return -1;
    }
    
//    Kiểm tra nhân viên có tồn tại hay không
    public int ktNhanVien(int id, String loaiNV){
        try (Connection connect = getConnection(url, username, password);
                    Statement state = connect.createStatement()) {
                String query = String.format("SELECT COUNT(*) as soLuong FROM %s WHERE (maNhanVien = %d)", loaiNV, id);
                ResultSet rs = state.executeQuery(query);
                while (rs.next()){
                    if (rs.getInt("soLuong") == 1) {
                        return 1; 
                    } else return 0;
                    
                }
            }catch(Exception e){
                System.out.println("Da xay ra loi: " + e.getMessage());
            }
        return -1;
    }
}