/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author congt
 */
public class JTDS_Connection {
    private  Connection con = null;

	public Connection ConnectDataBase() {
		String url = "net.sourceforge.jtds.jdbc.Driver";
		try {
			Class.forName(url);
			String dbUrl = "jdbc:jtds:sqlserver://NguyenCongThuan:1433/ManageBooks_Java";
			con = DriverManager.getConnection(dbUrl);
		} catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                    //Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
                    
		}
                return con;
    }
}
