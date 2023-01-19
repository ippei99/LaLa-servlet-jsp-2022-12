package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Mutter> findAll(){
		List<Mutter> mutterList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT id, name, text, date FROM mutter ORDER BY id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("name");
				String text = rs.getString("text");
				String fd = rs.getString("date");
				Mutter mutter = new Mutter(id, userName, text, fd);
				mutterList.add(mutter);
			}
			
		} catch(SQLException e){
			e.printStackTrace();
			return null;			
		}
		return mutterList;
	} // findAll() end
	
	public boolean create(Mutter mutter) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = "INSERT INTO MUTTER(NAME, TEXT, DATE) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			pStmt.setString(3, mutter.getFd());
			
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
