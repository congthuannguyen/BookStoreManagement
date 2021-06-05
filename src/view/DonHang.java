/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.ChiTietHoaDon;
import Model.DanhMuc;
import Model.HoaDonBanHang;
import Model.HoaDonThongKe;
import Model.KhachHang;
import Model.NhanVien;
import Model.Sach;
import Model.TacGia;
import Services.ChiTietHoaDonServices;
import Services.DanhMucServices;
import Services.HoaDonBanHangServices;
import Services.HoaDonThongKeServices;
import Services.KhachHangServices;
import Services.NhanVienServices;
import Services.SachSerVices;
import Services.TacGiaServices;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author congt
 */
public class DonHang extends javax.swing.JFrame {

    /**
     * Creates new form DonHang
     */
    public String maSach = "";
    // lay du lieu hoa don
    HoaDonThongKe hd;
    HoaDonThongKeServices hdServices;
    // phan sach
    DanhMucServices dmServices;
    DanhMuc dm;
    SachSerVices sachServices;
    TacGiaServices tgServices;
    DefaultTableModel defaultTableModle;
    Sach sach;
    // phan hoa don
    KhachHangServices khServices;
    KhachHang kh;
    NhanVienServices nvServices;
    NhanVien nv;
    //
    HoaDonBanHang hdbh;
    HoaDonBanHangServices hdbhServices;
    // chi tiet hoa don
    ChiTietHoaDon cthd;
    ChiTietHoaDonServices cthdServices;
   
    // de lam id tu tang
    int i = 1;
    
    public DonHang() throws SQLException {
        sachServices = new SachSerVices();
        dmServices= new DanhMucServices();
        tgServices = new TacGiaServices();
        khServices = new KhachHangServices();
        nvServices = new NhanVienServices();
        hdServices = new HoaDonThongKeServices();
        hdbhServices = new HoaDonBanHangServices();
        initComponents();
        
        // lay ten sach
        List<Sach> sachList = sachServices.getAllSach();
            for (Sach s:sachList){
                cbTenSach.addItem(s.getTenSach());
                if(cbTenSach.getSelectedItem().toString().equals(s.getTenSach())){
                    // Lay Danh Muc
                    maSach = s.getMaSach().trim();
                    List<DanhMuc> dmList = dmServices.getAllDanhMuc();
                        for (DanhMuc dm:dmList){
                           if(dm.getMaDM().equals(s.getMaDM())){
                               jTFDanhMuc.setText(dm.getTenDM());
                               
                           }
                        }
                     // Lay tac gia
                    List<TacGia> tgList = tgServices.getAllTacGia();
                        for (TacGia tg:tgList){
                            if(tg.getMaTG().equals(s.getMaTG())){
                               jTFTacGia.setText(tg.getTenTG());
                           }
                        }
                    // đổ dữ liệu giá tiền
                    jTFGiaBan.setText("" + s.getGiaBan());
                }
            }
        // phan hoa don
        List<KhachHang> khList = khServices.getAllKhachHang();
            for (KhachHang kh:khList){
                cbKhachHang.addItem(kh.getTenKH());
            }
        List<NhanVien> nvList = nvServices.getAllNhanVien();
            for (NhanVien nv:nvList){
                cbNhanVien.addItem(nv.getTenNV());
            }
        // Do du lieu chi tiet don hang vao ban  
        cthdServices = new ChiTietHoaDonServices();
            defaultTableModle = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
            tableChiTietDonHang.setModel(defaultTableModle);
            
            defaultTableModle.addColumn("Id");
            defaultTableModle.addColumn("Mã Sách");
            defaultTableModle.addColumn("Mã Đơn Hàng");
            defaultTableModle.addColumn("Tên Sách");
            defaultTableModle.addColumn("Giá Bán");
            defaultTableModle.addColumn("Số Lượng Bán");
            defaultTableModle.addColumn("Thành Tiền");
            
            List<ChiTietHoaDon> cthdList = cthdServices.getAllChiTietHoaDon();
            for (ChiTietHoaDon cthd:cthdList){
                defaultTableModle.addRow(new Object[]{i++,cthd.getMaSach(),cthd.getSoHD(),cthd.getTenSach(),cthd.getGiaBan(),cthd.getSoLuongBan(),cthd.getThanhTien()});
                cbSoHoaDon.addItem(cthd.getSoHD());
            }
            // Đếm
            int count = tableChiTietDonHang.getRowCount();
            jTFCount.setText("");
            jTFCount.setText("" + count);
            // Lấy số hóa đơn
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbKhachHang = new javax.swing.JComboBox<>();
        cbNhanVien = new javax.swing.JComboBox<>();
        jTFNgayBan = new javax.swing.JTextField();
        jTFSoHD = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbTenSach = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTFThanhTien = new javax.swing.JTextField();
        jTFSoLuongBan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTFGiaBan = new javax.swing.JTextField();
        jTFDanhMuc = new javax.swing.JTextField();
        jTFTacGia = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableChiTietDonHang = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        cbSoHoaDon = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jTFCount = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đơn Hàng");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("PHẦN MỀM QUẢN LÝ BÁN SÁCH");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(556, 556, 556)
                .addComponent(jLabel1)
                .addContainerGap(562, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Quản Lý Đơn Hàng");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Tên Khách Hàng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Ngày Bán");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Nhân Viên");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Đơn Hàng");

        cbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhachHangActionPerformed(evt);
            }
        });

        jTFNgayBan.setEnabled(false);
        jTFNgayBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNgayBanActionPerformed(evt);
            }
        });

        jTFSoHD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTFSoHD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFSoHD.setBorder(null);
        jTFSoHD.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFSoHD))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTFNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFSoHD, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Tên Sách");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Tác Giả");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Sách");

        cbTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenSachActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Danh Mục");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("Số Lượng Bán");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Thành Tiền");

        jTFThanhTien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTFThanhTien.setEnabled(false);
        jTFThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFThanhTienActionPerformed(evt);
            }
        });

        jTFSoLuongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFSoLuongBanActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setText("Giá Bán");

        jTFGiaBan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTFGiaBan.setEnabled(false);

        jTFDanhMuc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTFDanhMuc.setEnabled(false);
        jTFDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDanhMucActionPerformed(evt);
            }
        });

        jTFTacGia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTFTacGia.setEnabled(false);

        jButton13.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\build\\classes\\Images\\Favourites.png")); // NOI18N
        jButton13.setText(" Tính Thành Tiền");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jTFTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addComponent(jLabel15))
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(jLabel9)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFSoLuongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel13)
                .addGap(37, 37, 37)
                .addComponent(jTFThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTFDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11)
                        .addComponent(jTFSoLuongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(jTFGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTFThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\build\\classes\\Images\\Add.png")); // NOI18N
        jButton7.setText("Đơn Hàng");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\build\\classes\\Images\\Add to basket.png")); // NOI18N
        jButton9.setText(" Mua Sách");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\build\\classes\\Images\\Price list.png")); // NOI18N
        jButton10.setText(" Xem Tất Cả Đơn Hàng");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\build\\classes\\Images\\Edit.png")); // NOI18N
        jButton11.setText(" Sửa Lịch Sử Mua Sách");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\build\\classes\\Images\\Delete.png")); // NOI18N
        jButton12.setText("Xóa Lịch Sử Mua Sách");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\build\\classes\\Images\\Refresh.png")); // NOI18N
        jButton14.setText(" Làm Mới");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(38, 38, 38)
                .addComponent(jButton14)
                .addGap(45, 45, 45)
                .addComponent(jButton7)
                .addGap(46, 46, 46)
                .addComponent(jButton9)
                .addGap(37, 37, 37)
                .addComponent(jButton11)
                .addGap(30, 30, 30)
                .addComponent(jButton12)
                .addGap(30, 30, 30))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton14))
                .addContainerGap())
        );

        tableChiTietDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableChiTietDonHang);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Mã Đơn Hàng");

        cbSoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSoHoaDonActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Tổng số");

        jTFCount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTFCount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFCount.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(cbSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(26, 26, 26)
                        .addComponent(jTFCount, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cbSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTFCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(233, 233, 233))))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\src\\Images\\User.png")); // NOI18N
        jButton1.setText(" Tài Khoản");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\src\\Images\\List.png")); // NOI18N
        jButton2.setText(" Danh Mục");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\src\\Images\\Address book.png")); // NOI18N
        jButton3.setText(" Sách ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\src\\Images\\Price list.png")); // NOI18N
        jButton4.setText(" Sách Bán");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\src\\Images\\Best.png")); // NOI18N
        jButton5.setText(" Thống Kê ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 153, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\src\\Images\\Users.png")); // NOI18N
        jButton6.setText(" Khách Hàng");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(153, 51, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\congt\\OneDrive\\Documents\\NetBeansProjects\\QuanLyBanSach\\src\\Images\\Log out.png")); // NOI18N
        jButton8.setText("Log Out");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            new HomePage().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Category().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Products().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new ThongKe().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new Customer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTFThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFThanhTienActionPerformed

    private void cbTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenSachActionPerformed
        // Xu ly cho phan sach
        try {
            String maDM = "";
            String maTG = "";
            // TODO add your handling code here:
            List<Sach> sachList = sachServices.getAllSach();
            for (Sach s:sachList){
                if(s.getTenSach().equals(cbTenSach.getSelectedItem().toString())){
                    maDM = s.getMaDM().trim();
                    maTG = s.getMaTG().trim();
                    // đổ dữ liệu giá tiền
                    jTFGiaBan.setText("" + s.getGiaBan());
                }
            }
            // Lay Danh Muc
            List<DanhMuc> dmList = dmServices.getAllDanhMuc();
            for (DanhMuc dm:dmList){
                if(dm.getMaDM().equals(maDM)){
                    jTFDanhMuc.setText(dm.getTenDM());
                }
            }
            // Lay tac gia
            List<TacGia> tgList = tgServices.getAllTacGia();
            for (TacGia tg:tgList){
                if(tg.getMaTG().equals(maTG)){
                    jTFTacGia.setText(tg.getTenTG());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cbTenSachActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            // Lấy Ngày
            jTFNgayBan.setText("");
            String date = (new SimpleDateFormat("dd-MM-yyyy")).format(jDateChooser1.getDate());
            jTFNgayBan.setText(date);
            // TODO add your handling code here:
            String soHD = "";
            String userNameNV = "";
            // Lấy mã khách hàng
            String maKH = "";
            List<KhachHang> khList = khServices.getAllKhachHang();
            for (KhachHang kh:khList){
                if(cbKhachHang.getSelectedItem().toString().equals(kh.getTenKH())){
                    maKH = kh.getMaKH();
                }
            }
            // Lay ma Nhan vien
            List<NhanVien> nvList = nvServices.getAllNhanVien();
            for (NhanVien nv:nvList){
                if(cbNhanVien.getSelectedItem().toString().equals(nv.getTenNV()))
                    userNameNV = nv.getUserName();
            }
            // random soHD
            int code = (int) Math.floor(((Math.random() * 899999) + 100000));
            int code1;
            List<HoaDonBanHang> hdbhList = hdbhServices.getAllHoaDonBanHang();
            for (HoaDonBanHang hdbh:hdbhList){
                if(!hdbh.getSoHD().equals(String.valueOf(code))){
                    soHD = String.valueOf(code);
                }
                else{
                    code = (int) Math.floor(((Math.random() * 899999) + 100000));
                }
                
            }
            
            // Lưu dữ liệu
            if (jTFNgayBan.getText().equals("")){
                JOptionPane.showMessageDialog(DonHang.this, "Ngày Bán Không Nhận Giá Trị Rỗng","Lỗi",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try {
                    HoaDonBanHang hdbh = new HoaDonBanHang();
                    hdbhServices = new HoaDonBanHangServices();
                    hdbh.setSoHD(soHD);
                    // truyenSoHoaDon
                    jTFSoHD.setText("");
                    jTFSoHD.setText(soHD);
                    hdbh.setMaKH(maKH);
                    hdbh.setNgayBan(jTFNgayBan.getText().trim());
                    hdbh.setUserNameNV(userNameNV);
                    
                    hdbhServices.addHoaDonBanHang(hdbh);
                } catch (SQLException ex) {
                    Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTFDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDanhMucActionPerformed

    private void cbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKhachHangActionPerformed

    private void jTFSoLuongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFSoLuongBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFSoLuongBanActionPerformed

    private void cbSoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSoHoaDonActionPerformed
        try {
            // TODO add your handling code here:
            i = 1;
            
            List<ChiTietHoaDon> cthdList = cthdServices.search(cbSoHoaDon.getSelectedItem().toString());
            defaultTableModle.setRowCount(0);
            for (ChiTietHoaDon cthd:cthdList){
                defaultTableModle.addRow(new Object[]{i++,cthd.getMaSach(),cthd.getSoHD(),cthd.getTenSach(),cthd.getGiaBan(),cthd.getSoLuongBan(),cthd.getThanhTien()});
            }
            // Đếm
            int count = tableChiTietDonHang.getRowCount();
            jTFCount.setText("");
            jTFCount.setText("" + count);
        } catch (SQLException ex) {
            Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbSoHoaDonActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            // TODO add your handling code here:
            new ListHoaDon().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String maSach = "";
        i =1;
        try {
            // TODO add your handling code here:
            
            // lay ma sach
            List<Sach> sachList = sachServices.getAllSach();
            for (Sach s:sachList){
                if(cbTenSach.getSelectedItem().toString().equals(s.getTenSach()))
                    maSach = s.getMaSach();
            }
            if(jTFSoLuongBan.getText().equals("") || jTFSoHD.getText().equals(""))
                JOptionPane.showMessageDialog(DonHang.this, "Số Hóa Đơn Hoặc Số Lượng Bán Đang Rỗng","Lỗi",JOptionPane.ERROR_MESSAGE);
            else{
                try {
                    ChiTietHoaDon cthd = new ChiTietHoaDon();
                    cthdServices = new ChiTietHoaDonServices();
                    cthd.setMaSach(maSach);
                    cthd.setSoHD(String.valueOf(jTFSoHD.getText()));
                    cthd.setSoLuongBan(Integer.parseInt(jTFSoLuongBan.getText().trim()));
                    
                    cthdServices.addChiTietHoaDon(cthd);
                } catch (SQLException ex) {
                    Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                // làm mới table
                defaultTableModle.setRowCount(0);
                List<ChiTietHoaDon> cthdList = cthdServices.getAllChiTietHoaDon();
                for (ChiTietHoaDon cthd:cthdList){
                    defaultTableModle.addRow(new Object[]{i++,cthd.getMaSach(),cthd.getSoHD(),cthd.getTenSach(),cthd.getGiaBan(),cthd.getSoLuongBan(),cthd.getThanhTien()});
                    cbSoHoaDon.addItem(cthd.getSoHD());
                }
                // Đếm
                int count = tableChiTietDonHang.getRowCount();
                jTFCount.setText("");
                jTFCount.setText("" + count);
                }
        } catch (SQLException ex) {
            Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        i = 1;
        
        //
        try {
            // TODO add your handling code here:
            
            jTFNgayBan.setText("");
            jTFSoLuongBan.setText("");
            jTFThanhTien.setText("");
            defaultTableModle.setRowCount(0);
            List<ChiTietHoaDon> cthdList = cthdServices.getAllChiTietHoaDon();
            for (ChiTietHoaDon cthd:cthdList){
                defaultTableModle.addRow(new Object[]{i++,cthd.getMaSach(),cthd.getSoHD(),cthd.getTenSach(),cthd.getGiaBan(),cthd.getSoLuongBan(),cthd.getThanhTien()});
                //cbSoHoaDon.addItem(cthd.getSoHD());
            }
            // Đếm
            int count = tableChiTietDonHang.getRowCount();
            jTFCount.setText("");
            jTFCount.setText("" + count);
            
        } catch (SQLException ex) {
            Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        // lam moi combo hoadon
        //
        try{
            
        List<ChiTietHoaDon> cthdList = cthdServices.getAllChiTietHoaDon();
            for (ChiTietHoaDon cthd:cthdList){
                cbSoHoaDon.addItem(cthd.getSoHD());
            }
        }catch(Exception e){}
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(jTFSoLuongBan.getText().equals(""))
        {
            System.out.println("Lỗi!");
        }
        else{
            jTFThanhTien.setText("");
            int soLuong = Integer.parseInt(jTFSoLuongBan.getText().trim());
            Long giaBan = Long.parseLong(jTFGiaBan.getText().trim());
            Long thanhTien = soLuong*giaBan;
            jTFThanhTien.setText("" + thanhTien);
        }
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        i = 1;
        int row = tableChiTietDonHang.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(DonHang.this, "Vui Lòng Chọn 1 Hàng Để Xóa","Lỗi",JOptionPane.ERROR_MESSAGE);
        } else{
            int confirm = JOptionPane.showConfirmDialog(DonHang.this, "Bạn Chắc Chắn Muốn Xóa Không!","Thông Báo",JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION){
                try {
                    String maSach = String.valueOf(tableChiTietDonHang.getValueAt(row,1));
                    String soHD = String.valueOf(tableChiTietDonHang.getValueAt(row,2));
                    try {
                        cthdServices.deleteChiTietHoaDon(maSach,soHD);
                    } catch (SQLException ex) {
                        Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //lam moi
                    defaultTableModle.setRowCount(0);
                    List<ChiTietHoaDon> cthdList = cthdServices.getAllChiTietHoaDon();
                    for (ChiTietHoaDon cthd:cthdList){
                        defaultTableModle.addRow(new Object[]{i++,cthd.getMaSach(),cthd.getSoHD(),cthd.getTenSach(),cthd.getGiaBan(),cthd.getSoLuongBan(),cthd.getThanhTien()});
                        cbSoHoaDon.addItem(cthd.getSoHD());
                    }
                    // Đếm
                    int count = tableChiTietDonHang.getRowCount();
                    jTFCount.setText("");
                    jTFCount.setText("" + count);
                } catch (SQLException ex) {
                    Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int row = tableChiTietDonHang.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(DonHang.this, "Vui Lòng Chọn 1 Hàng Để Edit","Lỗi",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String maSach = String.valueOf(tableChiTietDonHang.getValueAt(row,1));
            String soHD = String.valueOf(tableChiTietDonHang.getValueAt(row,2));
            try{
                new EditDonHang(maSach,soHD).setVisible(true);
                this.dispose();
            } catch(Exception e){}
            
        }
                   
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTFNgayBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNgayBanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTFNgayBanActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbKhachHang;
    private javax.swing.JComboBox<String> cbNhanVien;
    private javax.swing.JComboBox<String> cbSoHoaDon;
    private javax.swing.JComboBox<String> cbTenSach;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFCount;
    private javax.swing.JTextField jTFDanhMuc;
    private javax.swing.JTextField jTFGiaBan;
    private javax.swing.JTextField jTFNgayBan;
    private javax.swing.JTextField jTFSoHD;
    private javax.swing.JTextField jTFSoLuongBan;
    private javax.swing.JTextField jTFTacGia;
    private javax.swing.JTextField jTFThanhTien;
    private javax.swing.JTable tableChiTietDonHang;
    // End of variables declaration//GEN-END:variables
}
