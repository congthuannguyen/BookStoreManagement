/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.tblDanhMuc;
import DAO.tblNhaXuatBan;
import Model.DanhMuc;
import Model.NhaXuatBan;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author congt
 */
public class NhaXuatBanServices {
    
    private tblNhaXuatBan nxb;
    
    public NhaXuatBanServices(){
        nxb = new tblNhaXuatBan();
    }
    
    public List<NhaXuatBan> getAllNXB() throws SQLException{
        return nxb.getAllNXB();
    }
    
    public void addNXB(NhaXuatBan nhaxuatban) throws SQLException{
        nxb.addNhaXuatBan(nhaxuatban);
    }
    
    public void deleteNXB(int id) throws SQLException{
        nxb.DeleteNXB(id);
    }
    
    public NhaXuatBan getNXBById(int id) throws SQLException{
        return nxb.getNhaXuatBanByID(id);
    }
    
    public void update(NhaXuatBan nhaxuatban) throws SQLException{
        nxb.UpdateNXB(nhaxuatban);
    }
    
}
