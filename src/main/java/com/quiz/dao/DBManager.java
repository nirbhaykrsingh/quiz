package com.quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
public static DBManager dbManager = null;
private Statement stmt = null;
private Connection conn = null;
private DBManager() throws ClassNotFoundException, SQLException {
	 Class.forName("org.h2.Driver");
      conn = DriverManager.getConnection("jdbc:h2:~/test","sa","");
     stmt = conn.createStatement();

}

public static DBManager getInstance() throws ClassNotFoundException, SQLException {
	if (dbManager == null)
		dbManager= new DBManager();
	return dbManager;
}
public Statement getStatement() {
	return stmt;
}
public void closeAll() throws SQLException {
	   stmt.close();
     conn.close();
}
}
