/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.tblNhanVien;
import Model.NhanVien;
import java.sql.SQLException;
import java.util.List;
import view.Login;

/**
 *
 * @author congt
 */
public class NhanVienServices {
     private tblNhanVien nhanVienDAO;
     public Login login;
    
    public NhanVienServices(){
        nhanVienDAO = new tblNhanVien();
    }
    
    public List<NhanVien> getAllNhanVien() throws SQLException{
        return nhanVienDAO.getAllNhanVien();
    }
    
}
