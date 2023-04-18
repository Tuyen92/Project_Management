/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

/**
 *
 * @author ADMIN
 */
public class KiemThuVien extends NhanVien{
    private static int demKTV = 304;
    private int error;

    {
        setMaNV(demKTV++);
    }
    
    public KiemThuVien(String hoTen, String gioiTinh, String ngaySinh, String email, String phongBan, int error) {
        super(hoTen, gioiTinh, ngaySinh, email, phongBan);
        this.error = error;
    }

    public KiemThuVien() {
    }

    @Override
    public double tinhCongThem() {
        return this.error * 200000;
    }

    @Override
    public String themSQL() {
        return String.format("INSERT INTO kiemthuvien(maNhanVien, hoTen, gioiTinh, ngaySinh, phongBan, email, error) VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d)", 
                    this.getMaNV(), this.getHoTen(), this.getGioiTinh(), this.getNgaySinh(), this.getPhongBan(), this.getEmail(), this.getError());
    }
    
    @Override
    public void nhapThongTin(){
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN KIEM THU VIEN ~~~~");
        super.nhapThongTin();
        System.out.print("Error: ");
        setError(s.nextInt());
    }
    
    @Override
    public void xuatThongTin(){
        System.out.printf("%d - %s      %s     %s       %s      %s      %d\n",
                this.getMaNV(), this.getHoTen(),  this.getGioiTinh(), this.getNgaySinh(), this.getEmail(), this.getPhongBan(), this.getError());
    }

    @Override
    public String capNhatSQL(int maNV) {
        return String.format("UPDATE laptrinhvien SET hoTen = '%s', ngaySinh = '%s', gioiTinh = '%s', email = '%s', phongBan = '%s', error = %d WHERE (maNhanVien = %d)",
                    this.getHoTen(), this.getNgaySinh(), this.getGioiTinh(), this.getEmail(), this.getPhongBan(), this.getError(), maNV);
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}