/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.HoaDonThongKe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congt
 */
public class tblHoaDon_tblChiTiet {
    
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<HoaDonThongKe> getAllHoaDon() throws SQLException{
        List <HoaDonThongKe> hdList = new ArrayList<HoaDonThongKe>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT h.soHD as soHoaDon, s.maSach as maS, s.tenSach as tenS, h.ngayBan as ngayban, s.giaBan as gia, c.soLuongBan as SLBan, SUM(s.giaBan * c.soLuongBan) as thanhTien\n"
                + "FROM tblSach as s, tblHoaDon as h, tblChiTietHoaDon as c\n"
                + "WHERE s.maSach = c.maSach AND h.soHD = c.soHD\n"
                + "GROUP BY h.soHD,s.maSach,s.tenSach,h.ngayBan,s.giaBan,c.soLuongBan";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            HoaDonThongKe hd = new HoaDonThongKe();
            hd.setSoHD(rs.getString("soHoaDon"));
            hd.setMaSach(rs.getString("maS"));
            hd.setTenSach(rs.getString("tenS"));
            hd.setNgayBan(rs.getString("ngayban"));
            hd.setGiaBan(rs.getLong("gia"));
            hd.setSoLuongBan(rs.getInt("SLBan"));
            hd.setThanhTien(rs.getLong("thanhTien"));
            
            hdList.add(hd);
        }
        return hdList;
    }
    
    // Thống kê Theo Ngày
    public List<HoaDonThongKe> searchDay(String StrDay) throws SQLException{
        List <HoaDonThongKe> List1 = new ArrayList<HoaDonThongKe>();
        String sql = "SELECT DISTINCT h.soHD as soHoaDon, s.maSach as maS, s.tenSach as tenS, h.ngayBan as ngayban, s.giaBan as gia, c.soLuongBan as SLBan, SUM(s.giaBan * c.soLuongBan) as thanhTien\n"
                + "FROM tblSach as s, tblHoaDon as h, tblChiTietHoaDon as c\n"
                + "WHERE s.maSach = c.maSach AND h.soHD = c.soHD AND h.ngayBan like N'%" + StrDay + "%'"
                + "GROUP BY h.soHD,s.maSach,s.tenSach,h.ngayBan,s.giaBan,c.soLuongBan";
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql); 
            
        while(rs.next()) {
                
            HoaDonThongKe hd = new HoaDonThongKe();
            hd.setSoHD(rs.getString("soHoaDon"));
            hd.setMaSach(rs.getString("maS"));
            hd.setTenSach(rs.getString("tenS"));
            hd.setNgayBan(rs.getString("ngayban"));
            hd.setGiaBan(rs.getLong("gia"));
            hd.setSoLuongBan(rs.getInt("SLBan"));
            hd.setThanhTien(rs.getLong("thanhTien"));
            
            List1.add(hd);
        }
        return List1;
    }
    // thống kê top sản phẩm bán chạy
    public List<HoaDonThongKe> thongKeTopBanChay(int top) throws SQLException{
        List <HoaDonThongKe> List2 = new ArrayList<HoaDonThongKe>();
        String sql = "SELECT s.maSach as maS, s.tenSach as tenS, s.giaBan as gia, SUM(c.soLuongBan) as SLBan\n"
                + "FROM tblSach as s, tblChiTietHoaDon as c\n"
                + "WHERE s.maSach = c.maSach\n"
                + "GROUP BY s.maSach,s.tenSach,s.giaBan\n"
                + "HAVING\n"
                + "SUM(c.soLuongBan) in (SELECT DISTINCT TOP ("+ top + ")  SUM(soLuongBan) as soLuong from tblChiTietHoaDon\n"
                + "GROUP BY maSach)\n"
                + "ORDER BY SLBan desc";
        
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql); 
            
        while(rs.next()) {
                
            HoaDonThongKe hd = new HoaDonThongKe();
            hd.setMaSach(rs.getString("maS"));
            hd.setTenSach(rs.getString("tenS"));
            hd.setGiaBan(rs.getLong("gia"));
            hd.setSoLuongBan(rs.getInt("SLBan"));
            
            List2.add(hd);
        }
        return List2;
    }
    // Thống kê tổng số lượng sản phẩm đã bán
    public List<HoaDonThongKe> thongKeTongSanPham() throws SQLException{
        List <HoaDonThongKe> List2 = new ArrayList<HoaDonThongKe>();
        String sql = "SELECT maSach, soHD, SUM(soLuongBan) as tongSoLuong\n"
                + "FROM tblChiTietHoaDon \n"
                + "GROUP BY maSach, soHD";
          
        
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql); 
            
        while(rs.next()) {
                
            HoaDonThongKe hd = new HoaDonThongKe();
            hd.setTongSoLuongBan(rs.getInt("tongSoLuong"));
            
            List2.add(hd);
        }
        return List2;
    }
}
