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
public class Menu {
    
    Scanner s = new Scanner(System.in); 
    int choose = 0;
            
    public void MainMenu() throws SQLException{
        do {    
            System.out.println("");
            System.out.println("======================");
            System.out.println("  QUAN LY DU AN");
            System.out.println("======================");
            System.out.println("");
            System.out.println("~~~~  CHUC NANG CHINH ~~~~");
            System.out.println(" 1.  Quan ly du an");
            System.out.println(" 2.  Quan ly nhan vien, than nhan");
            System.out.println(" 3.  Quan ly luong bong, phong ban");
            System.out.println(" 0.  Thoat");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Chon: ");
            choose = s.nextByte();
            if (choose < 4)
                MenuHandle(choose);
            else{
                System.out.print("Nhap sai vui long nhap lai!");
                System.out.println("");
            }  
        } while (choose != 0);
    }
    
    public void ProjectMenu() throws SQLException{
        do {     
            System.out.println("");
            System.out.println("~~~~  QUAN LY DU AN ~~~~");
            System.out.println(" 1.  Them moi du an");
            System.out.println(" 2.  Cap nhat du an");
            System.out.println(" 3.  Xoa du an");
            System.out.println(" 4.  Xem danh sach du an");
            System.out.println(" 5.  Xem danh sach nhan vien cua mot du an");
            System.out.println(" 6.  Tim du an");
            System.out.println(" 7.  Tim du an theo thoi gian");
            System.out.println(" 8.  Them nhan vien vao du an");
            System.out.println(" 9.  Them quan ly vao du an");
            System.out.println(" 10. Sap xep du an theo kinh phi");
            System.out.println(" 11. Xuat file danh sach du an");
            System.out.println(" 0.  Tro ve");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Chon: ");
            choose = s.nextByte();
            if (choose < 12)
                MenuDuAn(choose);
            else{
                System.out.print("Nhap sai vui long nhap lai!");
                System.out.println("");
            }    
        } while (choose != 0);
        if (choose == 0)
            MainMenu();
    }
    
    public void EmployeeMenu() throws SQLException{
        do {   
            System.out.println("");
            System.out.println("~~~~  QUAN LY NHAN VIEN & THAN NHAN ~~~~");
            System.out.println(" 1.  Them moi nhan vien");
            System.out.println(" 2.  Cap nhat nhan vien");
            System.out.println(" 3.  Xoa nhan vien");
            System.out.println(" 4.  Xem danh sach nhan vien");
            System.out.println(" 5.  Xem danh sach du an cua mot nhan vien");
            System.out.println(" 6.  Xem danh sach than nhan cua mot nhan vien");
            System.out.println(" 7.  Tim nhan vien");
            System.out.println(" 8.  Them than nhan mot nhan vien");
            System.out.println(" 9.  Cap nhat than nhan mot nhan vien");
            System.out.println(" 10. Xoa than nhan mot nhan vien");
            System.out.println(" 11. Tim than nhan cua nhan vien");
            System.out.println(" 12. Xem danh sach than nhan");
            System.out.println(" 13. Xuat file danh sach nhan vien");
            System.out.println(" 0.  Tro ve");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Chon: ");
            choose = s.nextByte();
            if (choose < 14)
                MenuNhanVien(choose);
            else{
                System.out.print("Nhap sai vui long nhap lai!");
                System.out.println("");
            }
        } while (choose != 0);
        if (choose == 0)
            MainMenu();
    }
    
    public void PayrollMenu() throws SQLException{
        do {    
            System.out.println("");
            System.out.println("~~~~  QUAN LY LUONG BONG & PHONG BAN ~~~~");
            System.out.println(" 1.  Tinh & them luong nhan vien");
            System.out.println(" 2.  Xem danh sach luong");
            System.out.println(" 3.  Xem luong mot nhan vien");
            System.out.println(" 4.  Them phong ban");
            System.out.println(" 5.  Sua phong ban");
            System.out.println(" 6.  Xoa phong ban");
            System.out.println(" 7.  Xem danh sach cac phong ban");
            System.out.println(" 8.  Xem danh sach nhan vien cua mot phong ban");
            System.out.println(" 9.  Tim phong ban");
            System.out.println(" 10. Thong ke luong");
            System.out.println(" 11. Xuat file danh sach luong");
            System.out.println(" 0.  Tro ve");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Choose: ");
            choose = s.nextByte();
            if (choose < 12)
                MenuPhu(choose);
            else{
                System.out.print("Nhap sai vui long nhap lai!");
                System.out.println("");
            }

        } while (choose != 0);
        if (choose == 0)
            MainMenu();
    }
    
    public void MenuHandle(int c) throws SQLException{
        switch (c) {
            case 1:
                ProjectMenu();
            case 2:
                EmployeeMenu();
            case 3:
                PayrollMenu();
        }
    }
    
    public void MenuNhanVien(int c) throws SQLException{
        QuanLyNV qlnv = new QuanLyNV();
        switch (c) {
            case 1 -> qlnv.themNV();
            case 2 -> qlnv.capNhatNV();
            case 3 -> qlnv.xoaNV();
            case 4 -> qlnv.xemDanhSachNV();
            case 5 -> qlnv.layDuAnNV();
            case 6 -> qlnv.layThanNhanNV();
            case 7 -> qlnv.xuLyTim();
            case 8 -> qlnv.themThanNhan();
            case 9 -> qlnv.capNhatTN();
            case 10 -> qlnv.xoaTN();
            case 11 -> qlnv.timTN();
            case 12 -> qlnv.xemDanhSachTN();
            case 13 -> qlnv.xuatFileNV();
        }
    }
    
    public void MenuDuAn(int c) throws SQLException{
        QuanLyDA qlda = new QuanLyDA();
        switch (c) {
            case 1 -> qlda.themDuAn();
            case 2 -> qlda.capNhatDA();
            case 3 -> qlda.xoaDuAn();
            case 4 -> qlda.layDuAn();
            case 5 -> qlda.layNhanvienDA();
            case 6 -> qlda.timDuAn();
            case 7 -> qlda.timDuAnTheoThoiGian();
            case 8 -> qlda.ganNhanVien();
            case 9 -> qlda.ganQuanLy();
            case 10 -> qlda.sapXepDA();
            case 11 -> qlda.xuatFileDA();
        }
    }
    
    public void MenuPhu(int c) throws SQLException{
        QuanLyLuong qll = new QuanLyLuong();
        QuanLyNV qlnv = new QuanLyNV();
        switch (c) {
            case 1 -> qll.nhapLuong();
            case 2 -> qll.xemDanhSachLuong();
            case 3 -> qll.layLuongNV();
            case 4 -> qll.themPhongBan();
            case 5 -> qll.capNhatPB();
            case 6 -> qll.xoaPhongBan();
            case 7 -> qll.layPhongBan();
            case 8 -> qlnv.layNhanVienPB();
            case 9 -> qll.timPhongBan();
            case 10 -> qll.thongKeLuong();
            case 11 -> qll.xuatFileLuong();
        }
    }
}
