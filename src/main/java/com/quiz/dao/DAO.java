package com.quiz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO{
	 Statement stat;
     ResultSet rs;
    public DAO() throws ClassNotFoundException, SQLException{
    	 stat = DBManager.getInstance().getStatement();
     }
     
}
