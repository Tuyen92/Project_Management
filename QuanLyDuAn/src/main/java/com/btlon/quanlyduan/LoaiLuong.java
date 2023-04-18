/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

/**
 *
 * @author ADMIN
 */
public class LoaiLuong {
    private static int dem = 5;
    private int maLoai;
    private double luongCoBan;
    private String chucVu;

    {
        this.maLoai = dem ++;
    }
    
    public LoaiLuong(double luongCoBan, String chucVu) {
        this.luongCoBan = luongCoBan;
        this.chucVu = chucVu;
    }

    public LoaiLuong(){
    }
    
    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }
}
