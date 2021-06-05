/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.tblDanhMuc;
import Model.DanhMuc;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author congt
 */
public class DanhMucServices {
    private tblDanhMuc dm;
    
    public DanhMucServices(){
        dm = new tblDanhMuc();
    }
    
    public List<DanhMuc> getAllDanhMuc() throws SQLException{
        return dm.getAllDanhMuc();
    }
    
    public void addDanhMuc(DanhMuc danhmuc) throws SQLException{
        dm.addDanhMuc(danhmuc);
    }
    
    public void deleteDanhMuc(int id) throws SQLException{
        dm.DeleteDanhMuc(id);
    }
    
    public DanhMuc getDanhMucById(int id) throws SQLException{
        return dm.getDanhMucByID(id);
    }
    
    public void update(DanhMuc danhmuc) throws SQLException{
        dm.UpdateDanhMuc(danhmuc);
    }
}
