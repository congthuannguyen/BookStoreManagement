/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.KhachHang;
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
public class tblKhachHang {
    
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<KhachHang> getAllKhachHang() throws SQLException{
        List <KhachHang> khList = new ArrayList<KhachHang>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM tblKhachHang";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            KhachHang kh = new KhachHang();
            kh.setMaKH(rs.getString("maKH"));
            kh.setTenKH(rs.getString("tenKH"));      
            kh.setDiaChiKH(rs.getString("diaChiKH"));
            kh.setDienThoai(rs.getString("dienThoai"));
            kh.setEmail(rs.getString("Email"));
            kh.setSoDuTaiKhoan(rs.getLong("soDuTaiKhoan"));
            
            khList.add(kh);
        }
        return khList;
    }
    // hàm cập nhật
    public KhachHang getKhachHangByID(int id) throws SQLException{
        String strID = String.valueOf(id);
        String sql = "SELECT * FROM tblKhachHang WHERE maKH = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
            KhachHang kh = new KhachHang();
            kh.setMaKH(rs.getString("maKH"));
            kh.setTenKH(rs.getString("tenKH"));      
            kh.setDiaChiKH(rs.getString("diaChiKH"));
            kh.setDienThoai(rs.getString("dienThoai"));
            kh.setEmail(rs.getString("Email"));
            kh.setSoDuTaiKhoan(rs.getLong("soDuTaiKhoan"));
            
            return kh;
        }
        return null;
    }
    
    // hamf Insert
    public void addKhachHang(KhachHang kh) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "INSERT INTO tblKhachHang(maKH, tenKH, diaChiKH, dienThoai, Email, soDuTaiKhoan) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, kh.getMaKH());
        preparedStatement.setString(2, kh.getTenKH());
        preparedStatement.setString(3, kh.getDiaChiKH());
        preparedStatement.setString(4, kh.getDienThoai());
        preparedStatement.setString(5, kh.getEmail());
        preparedStatement.setLong(6, kh.getSoDuTaiKhoan());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham UPDATEs
    public void UpdateKhachHang(KhachHang kh) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "UPDATE tblKhachHang SET maKH = ?, tenKH = ?, diaChiKH = ?, dienThoai = ?, Email = ?, soDuTaiKhoan = ?"
                + " WHERE maKH = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, kh.getMaKH());
        preparedStatement.setString(2, kh.getTenKH());
        preparedStatement.setString(3, kh.getDiaChiKH());
        preparedStatement.setString(4, kh.getDienThoai());
        preparedStatement.setString(5, kh.getEmail());
        preparedStatement.setLong(6, kh.getSoDuTaiKhoan());
        preparedStatement.setString(7, kh.getMaKH());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham DELETE
    public void DeleteKhachHang(int id) throws SQLException{
        String strID = String.valueOf(id);
        Connection con = kn.ConnectDataBase();
        Statement stmt = con.createStatement();
        String sql = "DELETE FROM tblKhachHang WHERE maKH = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    
    // Hàm tìm kiếm theo title
    public List<KhachHang> searchTitle(String Strtitle) throws SQLException{
        List <KhachHang> List1 = new ArrayList<KhachHang>();
        String sql = "SELECT * FROM tblKhachHang    WHERE tenKH like N'%" + Strtitle + "%'";

        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql); 
            
        while(rs.next()) {
                
            KhachHang kh = new KhachHang();
            kh.setMaKH(rs.getString("maKH"));
            kh.setTenKH(rs.getString("tenKH"));      
            kh.setDiaChiKH(rs.getString("diaChiKH"));
            kh.setDienThoai(rs.getString("dienThoai"));
            kh.setEmail(rs.getString("Email"));
            kh.setSoDuTaiKhoan(rs.getLong("soDuTaiKhoan"));
            
            List1.add(kh);
        }
        return List1;
    }
    
}
