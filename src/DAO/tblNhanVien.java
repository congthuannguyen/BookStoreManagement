/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.NhanVien;
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
public class tblNhanVien {
    // kết nối database
    JTDS_Connection kn = new JTDS_Connection();
    Connection con = kn.ConnectDataBase();
    
    // lay du lieu - tao list
    public List<NhanVien> getAllNhanVien() throws SQLException{
        List <NhanVien> nvList = new ArrayList<NhanVien>();
        ResultSet rs  = null;
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM tblNhanVien";
        rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            NhanVien nv = new NhanVien();
            nv.setUserName(rs.getString("userName"));
            nv.setTenNV(rs.getString("tenNV"));
            nv.setMatKhau(rs.getString("matKhau"));
            nv.setDienThoai(rs.getString("dienThoai"));
            nv.setEmail(rs.getString("Email"));
            nv.setGioiTinh(rs.getString("gioiTinh"));
            nv.setDoB(rs.getString("DoB"));
            nv.setChucVu(rs.getString("chucVu"));
            nv.setSoDuTaiKhoan(rs.getLong("soDuTaiKhoan"));
            
            nvList.add(nv);
        }
        return nvList;
    }
}
