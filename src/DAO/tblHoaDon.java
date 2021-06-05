/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DanhMuc;
import Model.HoaDonBanHang;
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
public class tblHoaDon {
    
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<HoaDonBanHang> getAllHoaDonBanHang() throws SQLException{
        List <HoaDonBanHang> hdList = new ArrayList<HoaDonBanHang>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM tblHoaDon";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            HoaDonBanHang hd = new HoaDonBanHang();
            hd.setSoHD(rs.getString("soHD"));
            hd.setMaKH(rs.getString("maKH"));
            hd.setUserNameNV(rs.getString("userName"));
            hd.setNgayBan(rs.getString("ngayBan"));
            
            hdList.add(hd);
        }
        return hdList;
    }
    
    // hamf Insert
    public void addHoaDonBanHang(HoaDonBanHang hd) throws SQLException{
        Connection con = kn.ConnectDataBase();
        String sql = "INSERT INTO tblHoaDon(soHD, maKH, userName, ngayBan) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, hd.getSoHD());
        preparedStatement.setString(2, hd.getMaKH());
        preparedStatement.setString(3, hd.getUserNameNV());
        preparedStatement.setString(4, hd.getNgayBan());
        
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
    }
    
}
