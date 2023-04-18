/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

/**
 *
 * @author ADMIN
 */
public class QuanLy extends NhanVien{
    private static int demQL = 104;
    private String ngayNhamChuc;
    private String phongBan1;
    private String phongBan2;
    
    {
        setMaNV(demQL++);
    }

    public QuanLy(String hoTen, String gioiTinh, String ngaySinh, String email, String phongBan, String ngayNhamChuc, String phongBan1, String phongBan2) {
        super(hoTen, gioiTinh, ngaySinh, email, phongBan);
        this.ngayNhamChuc = ngayNhamChuc;
        this.phongBan1 = phongBan1;
        this.phongBan2 = phongBan2;
    }

    public QuanLy() {
    }
    
    @Override
    public void nhapThongTin(){
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN QUAN LY ~~~~");
        super.nhapThongTin();
        System.out.print("Ngay nham chuc: ");
        setNgayNhamChuc(s.nextLine());
        System.out.print("Phong ban 1: ");
        setPhongBan1(s.nextLine());
        System.out.print("Phong ban 2: ");
        setPhongBan2(s.nextLine());
    }

    @Override
    public void xuatThongTin(){
        System.out.printf("%d - %s      %s     %s       %s      %s      %s      %s      %s\n",
                this.getMaNV(), this.getHoTen(), this.getGioiTinh(), this.getNgaySinh(), this.getEmail(), this.getPhongBan(), this.getNgayNhamChuc(), this.getPhongBan1(), this.getPhongBan2());
    }
    
    @Override
    public double tinhCongThem(){
        return 0;
    }

    @Override
    public String themSQL() {
        return String.format("INSERT INTO quanly(maNhanVien, hoTen, gioiTinh, ngaySinh, email, phongBan, ngayNhamChuc, phongBan1, phongBan2) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                this.getMaNV(), this.getHoTen(), this.getGioiTinh(), this.getNgaySinh(), this.getEmail(), this.getPhongBan(), this.getNgayNhamChuc(), this.getPhongBan1(), this.getPhongBan2());
    }

    @Override
    public String capNhatSQL(int maNV) {
        return String.format("UPDATE quanly SET hoTen = '%s', ngaySinh = '%s', gioiTinh = '%s', email = '%s', phongBan = '%s', phongBan1 = '%s', phongBan2 = '%s', ngayNhamChuc = '%s' WHERE (maNhanVien = %d)",
                    this.getHoTen(), this.getNgaySinh(), this.getGioiTinh(), this.getEmail(), this.getPhongBan(), this.getPhongBan1(), this.getPhongBan2(), this.getNgayNhamChuc(), maNV);
    }
    
    public String getNgayNhamChuc() {
        return ngayNhamChuc;
    }

    public void setNgayNhamChuc(String ngayNhamChuc) {
        this.ngayNhamChuc = ngayNhamChuc;
    }

    public String getPhongBan1() {
        return phongBan1;
    }

    public void setPhongBan1(String phongBan1) {
        this.phongBan1 = phongBan1;
    }

    public String getPhongBan2() {
        return phongBan2;
    }

    public void setPhongBan2(String phongBan2) {
        this.phongBan2 = phongBan2;
    }
}
