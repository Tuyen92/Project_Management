/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

/**
 *
 * @author ADMIN
 */
public class LapTrinhVien extends NhanVien{
    private static int demLTV = 204;
    private double overTime;
    
    {
        setMaNV(demLTV++);
    }

    public LapTrinhVien(String hoTen, String gioiTinh, String ngaySinh, String email, String phongBan, double overTime) {
        super(hoTen, gioiTinh, ngaySinh, email, phongBan);
        this.overTime = overTime;
    }

    public LapTrinhVien() {
    }
    
    @Override
    public void nhapThongTin(){
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN LAP TRINH VIEN ~~~~");
        super.nhapThongTin();
        System.out.print("Over-time(hours): ");
        setOverTime(s.nextDouble());
    }
    
    @Override
    public void xuatThongTin(){
        System.out.printf("%d - %s      %s     %s       %s      %s      %.02f\n",
                this.getMaNV(), this.getHoTen(),  this.getGioiTinh(), this.getNgaySinh(), this.getEmail(), this.getPhongBan(), this.getOverTime());
    }

    @Override
    public double tinhCongThem() {
        return this.overTime * 50000;
    }

    @Override
    public String themSQL() {
        return String.format("INSERT INTO laptrinhvien(maNhanVien, hoTen, gioiTinh, ngaySinh, phongBan, email, overTime) VALUES (%d, '%s', '%s', '%s', '%s', '%s', %.02f)", 
                    this.getMaNV(), this.getHoTen(), this.getGioiTinh(), this.getNgaySinh(), this.getPhongBan(), this.getEmail(), this.getOverTime());
    }

    @Override
    public String capNhatSQL(int maNV) {
        return String.format("UPDATE laptrinhvien SET hoTen = '%s', ngaySinh = '%s', gioiTinh = '%s', email = '%s', phongBan = '%s', overTime = %.02f WHERE (maNhanVien = %d)",
                    this.getHoTen(), this.getNgaySinh(), this.getGioiTinh(), this.getEmail(), this.getPhongBan(), this.getOverTime(), maNV);
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }
}
