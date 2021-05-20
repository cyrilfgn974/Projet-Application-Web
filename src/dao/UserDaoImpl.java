package dao;


import java.sql.*;
import java.util.List;


import javax.websocket.Session;

import entities.User;


public class UserDaoImpl {
    public boolean login(String username, String password)  {

		boolean status=false;
		try {
			String db_url = "jdbc:hsqldb:hsql://localhost/xdb";
			String db_user = "sa";
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con=DriverManager.getConnection(db_url,db_user,null);
			PreparedStatement ps=con.prepareStatement("select * from REG where USERNAME=? and PASSWORD=?");
			ps.setString(1,username);
			ps.setString(2,password);
			
            ResultSet rs=ps.executeQuery();
            status = rs.next();
            return status;


		} catch (Exception ex) {
			return false;
		}

	}
}
