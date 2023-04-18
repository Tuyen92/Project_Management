/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

/**
 *
 * @author ADMIN
 */
public class Luong {
    private static int dem = 1;
    private int maLuong;
    private int maNhanVien;
    private double tongLuong;
    private double luongCoBan;
    private double heSo;
    private double congThem;

    {
        this.maLuong = dem++;
    }

    public Luong(int maNhanVien, double tongLuong, double luongCoBan, double heSo, double congThem) {
        this.maNhanVien = maNhanVien;
        this.tongLuong = tongLuong;
        this.luongCoBan = luongCoBan;
        this.heSo = heSo;
        this.congThem = congThem;
    }

    public Luong(){
    }

    @Override
    public String toString() {
        return String.format("Ma nhan vien: %d\nLuong: %.02f\nChi tiet luong: %.02f * %.02f + %.02f\n", maNhanVien, tongLuong, luongCoBan, heSo, congThem);
    }

    public static int getDem() {
        return dem;
    }

    public static void setDem(int dem) {
        Luong.dem = dem;
    }

    public int getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(int maLuong) {
        this.maLuong = maLuong;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public double getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(double tongLuong) {
        this.tongLuong = tongLuong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    public double getCongThem() {
        return congThem;
    }

    public void setCongThem(double congThem) {
        this.congThem = congThem;
    }
}
