package it.contrader.dao;

//import java.net.URL;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.URL;
import it.contrader.model.User;

/**
 */
public class URLDAO {

	private final String QUERY_INSERT = "INSERT INTO url (URLname, UserID) VALUES (?,?);";
	private final String QUERY_READ = "SELECT user.id, url.URLname FROM user INNER JOIN url ON user.id=url.UserID WHERE user.id = ?;";
	//private final String QUERY_ALL = "SELECT * FROM user";

	
	public void insert (URL url) {


		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_INSERT);
			
			statement.setString(1, url.getURLname());
			statement.setInt(2, url.getUserID());
			
			statement.execute();
			
		}
		
		catch (SQLException e) {
			
		}
	}
	
	public List<URL> read(int userID) {
		List<URL> urlsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_READ);
			URL url;
			while (resultSet.next()) {
				int URLID = resultSet.getInt("URLID");
				String URLname = resultSet.getString("URLname");
				url = new URL(URLID, URLname, userID);
				urlsList.add(url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return urlsList;
	}
}
