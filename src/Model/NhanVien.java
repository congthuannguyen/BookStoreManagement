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
public class NhanVien {
    
    public String userName;
    public String tenNV;
    public String matKhau;
    public String dienThoai;
    public String Email;
    public String gioiTinh;
    public String DoB;
    public String chucVu;
    public long soDuTaiKhoan;
    
    public NhanVien(){
        
    }

    public NhanVien(String userName, String tenNV, String matKhau, String dienThoai, String Email, String gioiTinh, String DoB, String chucVu, long soDuTaiKhoan) {
        this.userName = userName;
        this.tenNV = tenNV;
        this.matKhau = matKhau;
        this.dienThoai = dienThoai;
        this.Email = Email;
        this.gioiTinh = gioiTinh;
        this.DoB = DoB;
        this.chucVu = chucVu;
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    public String getUserName() {
        return userName;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getDoB() {
        return DoB;
    }

    public String getChucVu() {
        return chucVu;
    }

    public long getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDoB(String DoB) {
        this.DoB = DoB;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setSoDuTaiKhoan(long soDuTaiKhoan) {
        this.soDuTaiKhoan = soDuTaiKhoan;
    }
    
    
    
}
