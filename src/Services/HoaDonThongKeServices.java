
package Services;

import DAO.tblHoaDon_tblChiTiet;
import Model.HoaDonThongKe;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author congt
 */
public class HoaDonThongKeServices {
    
    public tblHoaDon_tblChiTiet hd;
    
    public HoaDonThongKeServices(){
        hd = new tblHoaDon_tblChiTiet();
    }
    
    public List<HoaDonThongKe> getAllHoaDon() throws SQLException{
        return hd.getAllHoaDon();
    }
    
    public List<HoaDonThongKe> search(String StrDay) throws SQLException{
        return hd.searchDay(StrDay);
    }
    // thống kê top sản phẩm bán chạy
    public List<HoaDonThongKe> getAllThongKeTopBanChay(int top) throws SQLException{
        return hd.thongKeTopBanChay(top);
    }
    
    public List<HoaDonThongKe> getTongSanPhamDaBan() throws SQLException{
        return hd.thongKeTongSanPham();
    }
}
