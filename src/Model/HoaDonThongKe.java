
package Model;

/**
 *
 * @author congt
 */
public class HoaDonThongKe {
    //
    public int TongSoLuongBan;
    // Thuộc tính bản HoaDonThongKe
    public String soHD;
    public String maKH;
    public String userNameNV;
    public String ngayBan;
    // Thuộc tính bản chiTietHoaDon
            //public String soHD;
    public int soLuongBan;
    // Thuộc tính thuộc bản sách
    public String maSach;
    public String tenSach;
    public Long giaBan;
    
    public long thanhTien;
    
    public HoaDonThongKe(){
        
    }

    public HoaDonThongKe(int TongSoLuongBan, String soHD, String maKH, String userNameNV, String ngayBan, int soLuongBan, String maSach, String tenSach, Long giaBan, long thanhTien) {
        this.TongSoLuongBan = TongSoLuongBan;
        this.soHD = soHD;
        this.maKH = maKH;
        this.userNameNV = userNameNV;
        this.ngayBan = ngayBan;
        this.soLuongBan = soLuongBan;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public int getTongSoLuongBan() {
        return TongSoLuongBan;
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

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public Long getGiaBan() {
        return giaBan;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setTongSoLuongBan(int TongSoLuongBan) {
        this.TongSoLuongBan = TongSoLuongBan;
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

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    
    
}
