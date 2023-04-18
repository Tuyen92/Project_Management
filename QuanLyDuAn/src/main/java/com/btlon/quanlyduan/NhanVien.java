/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public abstract class NhanVien {

    Scanner s = new Scanner(System.in); 
    
    private static int dem = 7;
    private int maNV;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String email;
    private String phongBan;

    {
        this.maNV = dem++;
    }
    
    public NhanVien(String hoTen, String gioiTinh, String ngaySinh, String email, String phongBan) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.phongBan = phongBan;
    }

    public NhanVien() {
    }
    
    public void nhapThongTin(){
        System.out.print("Ho ten: ");
        setHoTen(s.nextLine());
        System.out.print("Ngay sinh (yyyy-mm-dd): ");
        setNgaySinh(s.nextLine());
        System.out.print("Gioi tinh: ");
        setGioiTinh(s.nextLine());
        System.out.print("Email: ");
        setEmail(s.nextLine());
        System.out.print("Phong Ban: ");
        setPhongBan(s.nextLine());
    }
    
    public void xuatThongTin(){
        System.out.printf("%d - %s      %s     %s       %s      %s\n",
                this.getMaNV(), this.getHoTen(),  this.getGioiTinh(), this.getNgaySinh(), this.getEmail(), this.getPhongBan());
    }
    
    public double tinhCongThem(){
        return 0;
    }
    
    public String themSQL(){
        return "";
    }
    
    public String capNhatSQL(int maNV){
        return "";
    }
    
    public double tinhLuong(double luongCoBan, double heSo){
        double tongLuong = 0;
        tongLuong = luongCoBan * heSo + tinhCongThem();
        return tongLuong;
    }
    
    public static int getDem() {
        return dem;
    }

    public static void setDem(int dem) {
        NhanVien.dem = dem;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
}
