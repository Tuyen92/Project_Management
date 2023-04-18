/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btlon.quanlyduan;

/**
 *
 * @author ADMIN
 */
public class HeSo {
    private static int dem = 5;
    private int maHeSo;
    private String viTri;
    private double heSo;
    
    {
        this.maHeSo = dem ++;
    }

    public HeSo(String viTri, double heSo) {
        this.viTri = viTri;
        this.heSo = heSo;
    }

    public HeSo(){
    }
    
    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    public int getMaHeSo() {
        return maHeSo;
    }

    public void setMaHeSo(int maHeSo) {
        this.maHeSo = maHeSo;
    }
}
