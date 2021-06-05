/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.tblHoaDon;
import Model.DanhMuc;
import Model.HoaDonBanHang;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author congt
 */
public class HoaDonBanHangServices {
    public tblHoaDon hd;
    
    public HoaDonBanHangServices(){
        hd = new tblHoaDon();
    }
    
    public List<HoaDonBanHang> getAllHoaDonBanHang() throws SQLException{
        return hd.getAllHoaDonBanHang();
    }
    
    public void addHoaDonBanHang(HoaDonBanHang hdbh) throws SQLException{
        hd.addHoaDonBanHang(hdbh);
    }
    
}
