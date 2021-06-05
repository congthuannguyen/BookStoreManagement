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
public class NhaXuatBan {
    
    public String maNXB;
    public String tenNXB;
    public String diaChiNXB;
    public String dienThoai;
    
    public NhaXuatBan(){
        
    }

    public NhaXuatBan(String maNXB, String tenNXB, String diaChiNXB, String dienThoai) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChiNXB = diaChiNXB;
        this.dienThoai = dienThoai;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public String getDiaChiNXB() {
        return diaChiNXB;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public void setDiaChiNXB(String diaChiNXB) {
        this.diaChiNXB = diaChiNXB;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    
    
}
