/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class PhongBan {
    Scanner s = new Scanner(System.in); 
    
    private static int dem = 5;
    private int maPhongBan;
    private String tenPhongBan;
    private int maQuanLy;
    
    {
        this.maPhongBan = dem++;
    }

    public PhongBan(int maPhongBan, String tenPhongBan, int maQuanLy) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.maQuanLy = maQuanLy;
    }

    public PhongBan(){
    }
    
    public void nhapPhongBan() throws SQLException{
        ConnectMySQL sql = new ConnectMySQL();
        System.out.println("");
        System.out.println("~~~~    NHAP THONG TIN PHONG BAN    ~~~~");
        System.out.print("Ten phong ban: ");
        setTenPhongBan(s.nextLine());
        System.out.print("Ma quan ly: ");
        int id = s.nextInt();
        if (sql.kiemTraQLPB(id) == 2)
            System.out.println("Ma quan ly da quan ly toi da 2 phong ban");
        else{ if (sql.kiemTraQLPB(id) == -1) {
                System.out.println("Them phong ban khong thanh cong");
            }else
                setMaQuanLy(id);
                
        }
    }

    @Override
    public String toString() {
        return String.format("%d - %s      %d\n",
                this.getMaPhongBan(), this.getTenPhongBan(),  this.getMaQuanLy());
    }
    
    public int getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(int maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public int getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(int maQuanLy) {
        this.maQuanLy = maQuanLy;
    }
}
