/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.tblKhachHang;
import Model.KhachHang;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author congt
 */
public class KhachHangServices {
    
    private tblKhachHang kh;
    
    public KhachHangServices(){
        kh = new tblKhachHang();
    }
    
    public List<KhachHang> getAllKhachHang() throws SQLException{
        return kh.getAllKhachHang();
    }
    
    public void addKhachHang(KhachHang khachhang) throws SQLException{
        kh.addKhachHang(khachhang);
    }
    
    public void deleteKhachHang(int id) throws SQLException{
        kh.DeleteKhachHang(id);
    }
    
    public KhachHang getKhachHangById(int id) throws SQLException{
        return kh.getKhachHangByID(id);
    }
    
    public void update(KhachHang khachhang) throws SQLException{
        kh.UpdateKhachHang(khachhang);
    }
    
    public List<KhachHang> search(String Strtitle) throws SQLException{
        return kh.searchTitle(Strtitle);
    }
    
}
