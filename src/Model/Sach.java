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
public class Sach {
    
    // Thuộc Tính bảng sách
    public String maSach;
    public String tenSach;
    public int soLuongCon;
    public String maDM;
    public String maTG;
    public long giaBan;
    // Thuộc tính bản danh mục
    public String tenDM;
    // Thuộc tính bản tác giả
    public String tenTG;
    
    public Sach(){
        
    }

    public Sach(String maSach, String tenSach, int soLuongCon, String maDM, String maTG, String tenDM, String tenTG, long giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuongCon = soLuongCon;
        this.maDM = maDM;
        this.maTG = maTG;
        this.tenDM = tenDM;
        this.tenTG = tenTG;
        this.giaBan = giaBan;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public String getMaDM() {
        return maDM;
    }

    public String getMaTG() {
        return maTG;
    }

    public String getTenDM() {
        return tenDM;
    }

    public String getTenTG() {
        return tenTG;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    
}
