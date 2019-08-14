package com.gissella.Ms3Challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Create tables for database containing valid entries and invalid entries.
 */
public class NewTable {

/*
 * Create table for valid entries
 */
	public void validTableEntries() {
		// SQLite connection string -- use the path used in machine used for project
		//"jdbc:sqlite:C:...
		String url = "jdbc:sqlite:C:/Users/Gichelli/eclipse-workspace/Ms3Challenge/sqlite/codingChallenge.db";
		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS users (\n"
				+ "	A NOT NULL,\n" + "	B NOT NULL,\n" + "	C NOT NULL UNIQUE\n," + "	D NOT NULL,\n"
				+ "	E NOT NULL,\n" + "	F NOT NULL,\n" + "	G NOT NULL,\n" + "	H NOT NULL,\n" + "	I NOT NULL,\n"
				+ "	J NOT NULL" + ");";
		//establish connection
		try (Connection toSql = DriverManager.getConnection(url); Statement stmt = toSql.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println("newtable error");
			System.out.println(e.getMessage());
		}
	}

	public void invalidTableEntries() {
		// SQLite connection string
		//The SQLite JDBC driver allows you to load an SQLite database from the file system using the following connection string.
		String url = "jdbc:sqlite:C:/Users/Gichelli/eclipse-workspace/Ms3Challenge/sqlite/codingChallenge_bad.db";

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS invalid (\n" 
				+ "	A NOT NULL,\n" + "	B NOT NULL,\n"	+ "	C NOT NULL UNIQUE,\n" + "	D NOT NULL,\n" 
				+ "	E NOT NULL,\n" + "	F NOT NULL,\n" + "	G NOT NULL,\n"	+ "	H NOT NULL,\n" + "	I NOT NULL,\n" 
				+ "	J NOT NULL\n" + ");";
		//establish connection
		try (Connection toSql = DriverManager.getConnection(url); Statement stmt = toSql.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "createNewTableInvalidEntries error");
		}
	}
}