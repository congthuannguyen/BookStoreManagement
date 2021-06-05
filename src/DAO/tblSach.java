/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Sach;
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
public class tblSach {
    
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<Sach> getAllSach() throws SQLException{
        List <Sach> sachList = new ArrayList<Sach>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT  maSach, tenSach, soLuongTon, d.tenDM as tenDanhMuc, t.tenTG as tenTacGia, giaBan, s.maDM as madanhmuc, s.maTG as matacgia, d.deleted as xoaDM\n"
                + "   FROM tblSach as s, tblTacGia as t, tblDanhMuc as d\n"
                + "WHERE s.maTG = t.maTG AND s.maDM = d.maDM AND s.deleted IS NULL";
        //
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            Sach sach = new Sach();
            if(rs.getInt("xoaDM") == 1){
                
                sach.setMaSach(rs.getString("maSach"));
                sach.setTenSach(rs.getString("tenSach"));
                sach.setSoLuongCon(rs.getInt("soLuongTon"));
                sach.setTenDM("NULL");
                sach.setTenTG(rs.getString("tenTacGia"));
                sach.setGiaBan(rs.getLong("giaBan"));
                sach.setMaDM(rs.getString("madanhmuc"));
                sach.setMaTG(rs.getString("matacgia"));
            }
            else{
                sach.setMaSach(rs.getString("maSach"));
                sach.setTenSach(rs.getString("tenSach"));
                sach.setSoLuongCon(rs.getInt("soLuongTon"));
                sach.setTenDM(rs.getString("tenDanhMuc"));
                sach.setTenTG(rs.getString("tenTacGia"));
                sach.setGiaBan(rs.getLong("giaBan"));
                sach.setMaDM(rs.getString("madanhmuc"));
                sach.setMaTG(rs.getString("matacgia"));
            }
            
            
            sachList.add(sach);
        }
        return sachList;
    }
    // hàm cập nhật
    public Sach getSachByID(int id) throws SQLException{
        String strID = String.valueOf(id);
        String sql = "SELECT * FROM tblSach WHERE maSach = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
            Sach s = new Sach();
            s.setMaSach(rs.getString("maSach"));
            s.setTenSach(rs.getString("tenSach"));
            s.setSoLuongCon(rs.getInt("soLuongTon"));
            s.setMaDM(rs.getString("maDM"));
            s.setMaTG(rs.getString("maTG"));
            s.setGiaBan(rs.getLong("giaBan"));
            
            return s;
        }
        return null;
    }
    
    // hamf Insert
    public void addSach(Sach s) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "INSERT INTO tblSach(maSach, tenSach, soLuongTon, maDM, maTG, giaBan) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, s.getMaSach());
        preparedStatement.setString(2, s.getTenSach());
        preparedStatement.setInt(3, s.getSoLuongCon());
        preparedStatement.setString(4, s.getMaDM());
        preparedStatement.setString(5, s.getMaTG());
        preparedStatement.setLong(6, s.getGiaBan());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham UPDATEs
    public void UpdateSach(Sach s) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "UPDATE tblSach SET maSach = ?, tenSach = ?, soLuongTon = ?, maDM = ?, maTG = ?, giaBan = ?\n"
                + "WHERE maSach = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, s.getMaSach());
        preparedStatement.setString(2, s.getTenSach());
        preparedStatement.setInt(3, s.getSoLuongCon());
        preparedStatement.setString(4, s.getMaDM());
        preparedStatement.setString(5, s.getMaTG());
        preparedStatement.setLong(6, s.getGiaBan());
        preparedStatement.setString(7, s.getMaSach());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham DELETE
    public void DeleteSach(int id) throws SQLException{
        String strID = String.valueOf(id);
        Connection con = kn.ConnectDataBase();
        Statement stmt = con.createStatement();
        String sql = "UPDATE tblSach\n"
                + "SET deleted = " +1+ "\n"
                + "WHERE maSach = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    
    
    // Hàm tìm kiếm theo title
    public List<Sach> searchTitle(String Strtitle) throws SQLException{
        List <Sach> List1 = new ArrayList<Sach>();
        String sql = "SELECT  maSach, tenSach, soLuongTon, d.tenDM as tenDanhMuc, t.tenTG as tenTacGia, giaBan\n" +
                "FROM tblSach as s, tblTacGia as t, tblDanhMuc as d\n"+
                "WHERE s.maTG = t.maTG AND s.maDM = d.maDM AND tenSach like N'%" + Strtitle + "%'";
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql); 
            
        while(rs.next()) {
                
            Sach s = new Sach();
            s.setMaSach(rs.getString("maSach"));
            s.setTenSach(rs.getString("tenSach"));
            s.setSoLuongCon(rs.getInt("soLuongTon"));
            s.setTenDM(rs.getString("tenDanhMuc"));
            s.setTenTG(rs.getString("tenTacGia"));
            s.setGiaBan(rs.getLong("giaBan"));
            
            List1.add(s);
        }
        return List1;
    }
    
}
