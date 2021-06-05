/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.tblSach;
import Model.DanhMuc;
import Model.Sach;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author congt
 */
public class SachSerVices {
    private tblSach sach;
    
    public SachSerVices(){
        sach = new tblSach();
    }
    
    public List<Sach> getAllSach() throws SQLException {
        return sach.getAllSach();
    }
    
    public void addSach(Sach s) throws SQLException{
        sach.addSach(s);
    }
    
    public void deleteSach(int id) throws SQLException{
        sach.DeleteSach(id);
    }
    
    public Sach getSachcById(int id) throws SQLException{
        return sach.getSachByID(id);
    }
    
    public void update(Sach s) throws SQLException{
        sach.UpdateSach(s);
    }
    
    
    public List<Sach> search(String Strtitle) throws SQLException{
        return sach.searchTitle(Strtitle);
    }
}
