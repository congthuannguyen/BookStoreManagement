/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DanhMuc;
import Model.TacGia;
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
public class tblTacGia {
    
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<TacGia> getAllTacGia() throws SQLException{
        List <TacGia> tgList = new ArrayList<TacGia>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM tblTacGia\n"
                + "WHERE deleted IS NULL";
        //
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            TacGia tg = new TacGia();
            tg.setMaTG(rs.getString("maTG"));
            tg.setTenTG(rs.getString("tenTG"));
            tg.setLienLac(rs.getString("lienLac"));
            
            tgList.add(tg);
        }
        return tgList;
    }
    // hàm cập nhật
    public TacGia getTacGiaByID(int id) throws SQLException{
        String strID = String.valueOf(id);
        String sql = "SELECT * FROM tblTacGia WHERE maTG = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
            TacGia tg = new TacGia();
            tg.setMaTG(rs.getString("maTG"));
            tg.setTenTG(rs.getString("tenTG"));
            tg.setLienLac(rs.getString("lienLac"));
            
            return tg;
        }
        return null;
    }
    
    // hamf Insert
    public void addTacGia(TacGia tg) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "INSERT INTO tblTacGia(maTG,tenTG,lienLac) VALUES (?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, tg.getMaTG());
        preparedStatement.setString(2, tg.getTenTG());
        preparedStatement.setString(3, tg.getLienLac());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham UPDATEs
    public void UpdateTacGia(TacGia tg) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "UPDATE tblTacGia SET maTG = ?, tenTG = ?, lienLac = ? WHERE maTG = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, tg.getMaTG());
        preparedStatement.setString(2, tg.getTenTG());
        preparedStatement.setString(3, tg.getLienLac());
        preparedStatement.setString(4, tg.getMaTG());
        
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham DELETE
    public void DeleteTacGia(int id) throws SQLException{
        String strID = String.valueOf(id);
        Connection con = kn.ConnectDataBase();
        Statement stmt = con.createStatement();
        String sql = "UPDATE tblTacGia\n"
                + "SET deleted = " +1+ "\n"
                + "WHERE maTG = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
}
