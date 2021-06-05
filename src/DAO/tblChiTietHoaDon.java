/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChiTietHoaDon;
import Model.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congt
 */
public class tblChiTietHoaDon {
    
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<ChiTietHoaDon> getAllChiTietHoaDon() throws SQLException{
        List <ChiTietHoaDon> cthdList = new ArrayList<ChiTietHoaDon>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT s.giaBan as gia, c.maSach as maS, c.soHD as idHD, s.tenSach as tenS ,c.soLuongBan as SLBan, SUM(c.soLuongBan * s.giaBan) as thanhTien\n"
                + "FROM tblSach as s, tblChiTietHoaDon as c\n"
                + "WHERE s.maSach = c.maSach\n"
                + "GROUP BY s.giaBan, c.maSach, c.soHD, s.tenSach, c.soLuongBan";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMaSach(rs.getString("maS"));
            cthd.setSoHD(rs.getString("idHD"));
            cthd.setTenSach(rs.getString("tenS"));
            cthd.setSoLuongBan(rs.getInt("SLBan"));
            cthd.setThanhTien(rs.getLong("thanhTien"));
            cthd.setGiaBan(rs.getLong("gia"));
            
            cthdList.add(cthd);
        }
        return cthdList;
    }
    // hàm cập nhật
    public ChiTietHoaDon getChiTietHoaDonByKhoaChinh(String maSach, String soHD) throws SQLException{
        
        String sql = "SELECT * FROM tblChiTietHoaDon WHERE maSach = ? AND soHD = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, maSach);
        preparedStatement.setString(2, soHD);
        
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMaSach(rs.getString("maSach"));
            cthd.setSoHD(rs.getString("soHD"));
            cthd.setSoLuongBan(rs.getInt("soLuongBan"));
            
            return cthd;
        }
        return null;
    }
    
    // hamf Insert
    public void addChiTietHoaDon(ChiTietHoaDon cthd) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "INSERT INTO tblChiTietHoaDon(maSach,soHD,soLuongBan) VALUES (?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, cthd.getMaSach());
        preparedStatement.setString(2, cthd.getSoHD());
        preparedStatement.setLong(3, cthd.getSoLuongBan());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
//    // ham UPDATEs
    public void UpdateChiTietHoaDon(ChiTietHoaDon cthd) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "UPDATE tblChiTietHoaDon SET maSach = ?, soHD = ?, soLuongBan = ?  WHERE maSach = ? AND soHD = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, cthd.getMaSach());
        preparedStatement.setString(2, cthd.getSoHD());
        preparedStatement.setInt(3, cthd.getSoLuongBan());
        preparedStatement.setString(4, cthd.getMaSach());
        preparedStatement.setString(5, cthd.getSoHD());
        
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
//    // ham DELETE
    public void DeleteChiTietHoaDon(String maSach, String soHD) throws SQLException{
        Connection con = kn.ConnectDataBase();
        Statement stmt = con.createStatement();
        String sql = "DELETE FROM tblChiTietHoaDon WHERE maSach = ? AND soHD = ?" ;
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, maSach);
        preparedStatement.setString(2, soHD);
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // tìm kiếm theo số hóa đơn
    public List<ChiTietHoaDon> searchSoHD(String soHD) throws SQLException{
        List <ChiTietHoaDon> List1 = new ArrayList<ChiTietHoaDon>();
        String sql = "SELECT s.giaBan as gia, c.maSach as maS, c.soHD as idHD, s.tenSach as tenS ,c.soLuongBan as SLBan, SUM(c.soLuongBan * s.giaBan) as thanhTien\n"
                + "FROM tblSach as s, tblChiTietHoaDon as c\n"
                + "WHERE s.maSach = c.maSach AND soHD like N'%" +soHD+ "%'\n"
                + "GROUP BY s.giaBan, c.maSach, c.soHD, s.tenSach, c.soLuongBan";

        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql); 
            
        while(rs.next()) {
                
             ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMaSach(rs.getString("maS"));
            cthd.setSoHD(rs.getString("idHD"));
            cthd.setTenSach(rs.getString("tenS"));
            cthd.setSoLuongBan(rs.getInt("SLBan"));
            cthd.setThanhTien(rs.getLong("thanhTien"));
            cthd.setGiaBan(rs.getLong("gia"));
            
            List1.add(cthd);
        }
        return List1;
    }
    
    
}
