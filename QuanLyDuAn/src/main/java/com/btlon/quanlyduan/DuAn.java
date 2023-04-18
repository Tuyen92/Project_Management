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
public class DuAn {
    Scanner s = new Scanner(System.in);
    
    private static int dem = 5;
    private int maDuAn;
    private String tenDuAn;
    private String thoiGianBD;
    private String thoiGianKT;
    private int tongKinhPhi;
    private int nguoiChuNhiem;
    
    {
        this.maDuAn = dem++;
    }

    public DuAn(int maDuAn, String tenDuAn, String thoiGianBD, String thoiGianKT, int tongKinhPhi, int nguoiChuNhiem) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.thoiGianBD = thoiGianBD;
        this.thoiGianKT = thoiGianKT;
        this.tongKinhPhi = tongKinhPhi;
        this.nguoiChuNhiem = nguoiChuNhiem;
    }
    
    public DuAn(){
    }
    
    public void nhapDuAn(){
        System.out.println("");
        System.out.println("~~~~ NHAP THONG TIN DU AN ~~~~");
        System.out.print("Ten du an: ");
        setTenDuAn(s.nextLine());
        System.out.print("Thoi gian bat dau (yyyy-mm-dd): ");
        setThoiGianBD(s.nextLine());
        System.out.print("Thoi gian ket thuc (yyyy-mm-dd): ");
        setThoiGianKT(s.nextLine());
        System.out.print("Tong kinh phi: ");
        setTongKinhPhi(s.nextInt());
        System.out.print("Ma nguoi chu nhiem: ");
        setNguoiChuNhiem(s.nextInt());
    }
    
    public void xuatDuAn(){
        System.out.printf("%d - %s      %s     %s       %d      %d\n",
                this.getMaDuAn(), this.getTenDuAn(),  this.getThoiGianBD(), this.getThoiGianKT(), this.getTongKinhPhi(), this.getNguoiChuNhiem());
    }
    
    public int getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(int maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getThoiGianBD() {
        return thoiGianBD;
    }

    public void setThoiGianBD(String thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public String getThoiGianKT() {
        return thoiGianKT;
    }

    public void setThoiGianKT(String thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
    }

    public int getTongKinhPhi() {
        return tongKinhPhi;
    }

    public void setTongKinhPhi(int tongKinhPhi) {
        this.tongKinhPhi = tongKinhPhi;
    }

    public int getNguoiChuNhiem() {
        return nguoiChuNhiem;
    }

    public void setNguoiChuNhiem(int nguoiChuNhiem) {
        this.nguoiChuNhiem = nguoiChuNhiem;
    }
}
