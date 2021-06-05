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
public class HoaDonBanHang {
    
    public String soHD;
    public String maKH;
    public String userNameNV;
    public String ngayBan;
    
    public HoaDonBanHang(){
        
    }

    public HoaDonBanHang(String soHD, String maKH, String userNameNV, String ngayBan) {
        this.soHD = soHD;
        this.maKH = maKH;
        this.userNameNV = userNameNV;
        this.ngayBan = ngayBan;
    }

    public String getSoHD() {
        return soHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getUserNameNV() {
        return userNameNV;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setUserNameNV(String userNameNV) {
        this.userNameNV = userNameNV;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }
    
    
    
}
