/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class tblDanhMuc {
    
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<DanhMuc> getAllDanhMuc() throws SQLException{
        List <DanhMuc> dmList = new ArrayList<DanhMuc>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM tblDanhMuc\n"
                + "WHERE deleted IS NULL";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            DanhMuc dm = new DanhMuc();
            dm.setMaDM(rs.getString("maDM"));
            dm.setTenDM(rs.getString("tenDM"));
            
            dmList.add(dm);
        }
        return dmList;
    }
    // hàm cập nhật
    public DanhMuc getDanhMucByID(int id) throws SQLException{
        String strID = String.valueOf(id);
        String sql = "SELECT * FROM tblDanhMuc WHERE maDM = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
            DanhMuc dm = new DanhMuc();
            dm.setMaDM(rs.getString("maDM"));
            dm.setTenDM(rs.getString("tenDM"));
            
            return dm;
        }
        return null;
    }
    
    // hamf Insert
    public void addDanhMuc(DanhMuc dm) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "INSERT INTO tblDanhMuc(maDM,tenDM) VALUES (?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, dm.getMaDM());
        preparedStatement.setString(2, dm.getTenDM());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham UPDATEs
    public void UpdateDanhMuc(DanhMuc dm) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "UPDATE tblDanhMuc SET maDM = ?, tenDM = ? WHERE maDM = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, dm.getMaDM());
        preparedStatement.setString(2, dm.getTenDM());
        preparedStatement.setString(3, dm.getMaDM());
        
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham DELETE
    public void DeleteDanhMuc(int id) throws SQLException{
        String strID = String.valueOf(id);
        Connection con = kn.ConnectDataBase();
        Statement stmt = con.createStatement();
        String sql = "UPDATE tblDanhMuc\n"
                + "SET deleted = " +1+ "\n"
                + "WHERE maDM = ?\n";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    
}
