/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

/**
 *
 * @author ADMIN
 */
public class ThanNhan extends NhanVien{
    private static int demTN = 505;
    private String moiQuanHe;
    private int maNhanVien;
    
    {
        setMaNV(demTN++);
    }

    public ThanNhan(String hoTen, String gioiTinh, String ngaySinh, String email, String phongBan, String moiQuanHe, int maNhanVien) {
        super(hoTen, gioiTinh, ngaySinh, email, phongBan);
        this.moiQuanHe = moiQuanHe;
        this.maNhanVien = maNhanVien;
    }

    public ThanNhan() {
    }
    
    @Override
    public void nhapThongTin(){
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN THAN NHAN ~~~~");
        super.nhapThongTin();
        System.out.print("Moi quan he: ");
        setMoiQuanHe(s.nextLine());
        System.out.print("Ma nhan vien: ");
        setMaNhanVien(s.nextInt());
    }
    
    @Override
    public void xuatThongTin(){
        System.out.printf("%d - %s      %s     %s       %s      %d\n",
                this.getMaNV(), this.getHoTen(),  this.getGioiTinh(), this.getNgaySinh(), this.getMoiQuanHe(), this.getMaNhanVien());
    }

    @Override
    public String capNhatSQL(int maNV) {
        return String.format("UPDATE thannhan SET hoTen = '%s', ngaySinh = '%s', gioiTinh = '%s', moiQuanHe = '%s', maNhanVien = %d WHERE (maThanNhan = %d)",
                    this.getHoTen(), this.getNgaySinh(), this.getGioiTinh(), this.getMoiQuanHe(), this.getMaNhanVien(), maNV);
    }

    @Override
    public String themSQL() {
        return String.format("INSERT INTO thannhan(maThanNhan, hoTen, gioiTinh, ngaySinh, moiQuanHe, maNhanVien) VALUES (%d, '%s', '%s', '%s', '%s', %d)", 
                    this.getMaNV(), this.getHoTen(), this.getGioiTinh(), this.getNgaySinh(), this.getMoiQuanHe(), this.getMaNhanVien());
    }
    
    public String getMoiQuanHe() {
        return moiQuanHe;
    }

    public void setMoiQuanHe(String moiQuanHe) {
        this.moiQuanHe = moiQuanHe;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}
