/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DanhMuc;
import Model.NhaXuatBan;
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
public class tblNhaXuatBan {
    
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<NhaXuatBan> getAllNXB() throws SQLException{
        List <NhaXuatBan> nxbList = new ArrayList<NhaXuatBan>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM tblNhaXuatBan\n"
                + "WHERE deleted IS NULL";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.setMaNXB(rs.getString("maNXB"));
            nxb.setTenNXB(rs.getString("tenNXB"));
            nxb.setDiaChiNXB(rs.getString("diaChiNXB"));
            nxb.setDienThoai(rs.getString("dienThoai"));            
            
            nxbList.add(nxb);
        }
        return nxbList;
    }
    // hàm cập nhật
    public NhaXuatBan getNhaXuatBanByID(int id) throws SQLException{
        String strID = String.valueOf(id);
        String sql = "SELECT * FROM tblNhaXuatBan WHERE maNXB = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.setMaNXB(rs.getString("maNXB"));
            nxb.setTenNXB(rs.getString("tenNXB"));
            nxb.setDiaChiNXB(rs.getString("diaChiNXB"));
            nxb.setDienThoai(rs.getString("dienThoai"));            
            
            
            return nxb;
        }
        return null;
    }
    
    // hamf Insert
    public void addNhaXuatBan(NhaXuatBan nxb) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "INSERT INTO tblNhaXuatBan(maNXB,tenNXB,diaChiNXB,dienThoai) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, nxb.getMaNXB());
        preparedStatement.setString(2, nxb.getTenNXB());
        preparedStatement.setString(3, nxb.getDiaChiNXB());
        preparedStatement.setString(4, nxb.getDienThoai());

        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham UPDATEs
    public void UpdateNXB(NhaXuatBan nxb) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "UPDATE tblNhaXuatBan SET maNXB = ?,tenNXB = ?,diaChiNXB = ?,dienThoai = ? WHERE maNXB = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, nxb.getMaNXB());
        preparedStatement.setString(2, nxb.getTenNXB());
        preparedStatement.setString(3, nxb.getDiaChiNXB());
        preparedStatement.setString(4, nxb.getDienThoai());
        preparedStatement.setString(5, nxb.getMaNXB());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    // ham DELETE
    public void DeleteNXB(int id) throws SQLException{
        String strID = String.valueOf(id);
        Connection con = kn.ConnectDataBase();
        Statement stmt = con.createStatement();
        String sql = "UPDATE tblNhaXuatBan\n"
                + "SET deleted = " +1+ "\n"
                + "WHERE maNXB = ?\n";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, strID);
        
        int rs = preparedStatement.executeUpdate();
        
        System.out.println(rs);
    }
}
