/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

/**
 *
 * @author ADMIN
 */
public class ThietKeVien extends NhanVien{
    private static int demTKV = 404;
    private int bonus;

    {
        setMaNV(demTKV++);
    }
    
    public ThietKeVien(String hoTen, String gioiTinh, String ngaySinh, String phongBan, String email, int bonus) {
        super(hoTen, gioiTinh, ngaySinh, email, phongBan);
        this.bonus = bonus;
    }

    public ThietKeVien() {
    }
    
    @Override
    public void nhapThongTin(){
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN THIET KE VIEN ~~~~");
        super.nhapThongTin();
        System.out.print("Bonus: ");
        setBonus(s.nextInt());
    }
    
    @Override
    public void xuatThongTin(){
        System.out.printf("%d - %s      %s     %s       %s      %s      %d\n",
                this.getMaNV(), this.getHoTen(),  this.getGioiTinh(), this.getNgaySinh(), this.getEmail(), this.getPhongBan(), this.getBonus());
    }

    @Override
    public double tinhCongThem() {
        return this.bonus;
    }

    @Override
    public String capNhatSQL(int maNV) {
        return String.format("UPDATE thietkevien SET hoTen = '%s', ngaySinh = '%s', gioiTinh = '%s', email = '%s', phongBan = '%s', bonus = %d WHERE (maNhanVien = %d)",
                    this.getHoTen(), this.getNgaySinh(), this.getGioiTinh(), this.getEmail(), this.getPhongBan(), this.getBonus(), maNV);
    }

    @Override
    public String themSQL() {
        return String.format("INSERT INTO thietkevien(maNhanVien, hoTen, gioiTinh, ngaySinh, phongBan, email, bonus) VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d)", 
                    this.getMaNV(), this.getHoTen(), this.getGioiTinh(), this.getNgaySinh(), this.getPhongBan(), this.getEmail(), this.getBonus());
    }
    
    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
