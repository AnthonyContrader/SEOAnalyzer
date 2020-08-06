package it.contrader.dao;

//import java.net.URL;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.contrader.model.*;
import it.contrader.utils.ConnectionSingleton;

/**
 */
public class URLDAO {

	private final String QUERY_INSERT = "INSERT INTO url (URLname, UserID) VALUES (?,?);";
	//private final String QUERY_READ = "SELECT user.id, url.URLname FROM user INNER JOIN url ON user.id=url.UserID WHERE user.id = ?;";
	private final String QUERY_READ = "SELECT user.id, url.URLname FROM user,url WHERE user.id=url.UserID AND user.id = ?;";
	//private final String QUERY_ALL = "SELECT * FROM user";
	private final String QUERY_READADMIN = "SELECT user.id, user.username, url.URLname FROM user,url WHERE user.id=url.UserID ;";

	
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
			PreparedStatement statement = connection.prepareStatement(QUERY_READ);
			//Statement statement = connection.createStatement();
			//System.out.println("ciao2");
			statement.setInt(1, userID);
			ResultSet resultSet = statement.executeQuery();
			
			URL url;
			while (resultSet.next()) {
				String URLname = resultSet.getString("URLname");
				url = new URL(URLname, userID);
				urlsList.add(url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collections.reverse(urlsList);
		
		return urlsList;
	}
	
	public List readAdmin() {
		List<String> recordList = new ArrayList<String>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_READADMIN);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String record = resultSet.getString("id") + "," + resultSet.getString("username") + "," + resultSet.getString("URLname");
				recordList.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recordList;
	}
}
