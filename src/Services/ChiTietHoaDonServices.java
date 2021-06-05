/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.tblChiTietHoaDon;
import DAO.tblDanhMuc;
import Model.ChiTietHoaDon;
import Model.DanhMuc;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author congt
 */
public class ChiTietHoaDonServices {
    
    tblChiTietHoaDon cthd;
    
    public ChiTietHoaDonServices(){
        cthd = new tblChiTietHoaDon();
    }
    
    public List<ChiTietHoaDon> getAllChiTietHoaDon() throws SQLException{
        return cthd.getAllChiTietHoaDon();
    }
    
    public void addChiTietHoaDon(ChiTietHoaDon hd) throws SQLException{
        cthd.addChiTietHoaDon(hd);
    }
    
    public void deleteChiTietHoaDon(String maSach, String soHD) throws SQLException{
        cthd.DeleteChiTietHoaDon(maSach,soHD);
    }
    
     public ChiTietHoaDon getChiTietHoaDonByKhoaChinh(String maSach, String soHD) throws SQLException{
        return cthd.getChiTietHoaDonByKhoaChinh(maSach,soHD);
    }
    
    public void update(ChiTietHoaDon hd) throws SQLException{
        cthd.UpdateChiTietHoaDon(hd);
    }
    
    public List<ChiTietHoaDon> search(String soHD) throws SQLException{
        return cthd.searchSoHD(soHD);
    }
}
