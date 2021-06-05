/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.tblTacGia;
import Model.KhachHang;
import Model.TacGia;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author congt
 */
public class TacGiaServices {
    
    public tblTacGia tg;
    
    public TacGiaServices(){
        tg = new tblTacGia();
    }
    
    public List<TacGia> getAllTacGia() throws SQLException{
        return tg.getAllTacGia();
    }
    
    public void addTacGia(TacGia tacgia) throws SQLException{
        tg.addTacGia(tacgia);
    }
    
    public void deleteTacGia(int id) throws SQLException{
        tg.DeleteTacGia(id);
    }
    
    public TacGia getTacGiaById(int id) throws SQLException{
        return tg.getTacGiaByID(id);
    }
    
    public void update(TacGia tacgia) throws SQLException{
        tg.UpdateTacGia(tacgia);
    }
    
}
