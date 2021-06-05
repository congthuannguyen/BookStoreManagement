/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author congt
 */
public class ChiTietHoaDon {
    
    public String maSach;
    public String tenSach;
    public String soHD;
    public int soLuongBan;
    public Long ThanhTien;
    public Long giaBan;
    
    public ChiTietHoaDon(){
        
    }

    public ChiTietHoaDon(String maSach, String tenSach, String soHD, int soLuongBan, Long ThanhTien, Long giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soHD = soHD;
        this.soLuongBan = soLuongBan;
        this.ThanhTien = ThanhTien;
        this.giaBan = giaBan;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getSoHD() {
        return soHD;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public Long getThanhTien() {
        return ThanhTien;
    }

    public Long getGiaBan() {
        return giaBan;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public void setThanhTien(Long ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

   
}
