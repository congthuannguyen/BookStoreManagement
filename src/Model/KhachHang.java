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
public class KhachHang {
    
    public String maKH;
    public String tenKH;
    public String diaChiKH;
    public String dienThoai;
    public String Email;
    public Long soDuTaiKhoan;
    
    public KhachHang(){
        
    }

    public KhachHang(String maKH, String tenKH, String diaChiKH, String dienThoai, String Email, Long soDuTaiKhoan) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChiKH = diaChiKH;
        this.dienThoai = dienThoai;
        this.Email = Email;
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public Long getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSoDuTaiKhoan(Long soDuTaiKhoan) {
        this.soDuTaiKhoan = soDuTaiKhoan;
    }
    
    
}
