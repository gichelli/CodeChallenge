package com.gissella.Ms3Challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Insert {

	private boolean on;

	/**
	 * Insert valid data
	 *
	 */
	public void insertValid(List<String[]> list) {
		String url = "jdbc:sqlite:C:/Users/Gichelli/eclipse-workspace/Ms3Challenge/sqlite/codingChallenge.db";
		String sql = "INSERT OR REPLACE INTO users (A, B, C, D,E,F,G,H,I,J) VALUES(?,?,?,?,?,?,?,?,?,?)";
		int i = 0;

		try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);
			for (int x = 0; x < 6001; x++) {
				if (Arrays.binarySearch(ParseContents.invalidIndex, i) < 0) {
					pstmt.setString(1, list.get(i)[0]);// name
					pstmt.setString(2, list.get(i)[1]);// lastname
					pstmt.setString(3, list.get(i)[2]);// email
					pstmt.setString(4, list.get(i)[3]);// gender
					pstmt.setString(5, list.get(i)[4]);// etc
					pstmt.setString(6, list.get(i)[5]);
					pstmt.setString(7, list.get(i)[6]);
					pstmt.setString(8, list.get(i)[7]);
					pstmt.setString(9, list.get(i)[8]);
					pstmt.setString(10, list.get(i)[9]);
					pstmt.addBatch();
				}
				i++;
			}
			pstmt.executeBatch();
			conn.commit();
			conn.close();
			// add the rest of not valid records to invalid table
			// InsertAplication app = new InsertAplication();
			// app.insertInvalid(list);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "insert into column error");
		}
	}
	
	/**
	 * Insert invalid data
	 *
	 */
	public void insertInvalid(List<String[]> list) {
		String url = "jdbc:sqlite:C:/Users/Gichelli/eclipse-workspace/Ms3Challenge/sqlite/codingChallenge_bad.db";
		String sql = "INSERT OR REPLACE INTO invalid (A, B, C, D,E,F,G,H,I,J) VALUES(?,?,?,?,?,?,?,?,?,?)";
		int i = 0;

		try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);
			for (int x = 0; x < 6001; x++) {
				if (Arrays.binarySearch(ParseContents.invalidIndex, i) >= 0) {
					pstmt.setString(1, list.get(i)[0]);// name
					pstmt.setString(2, list.get(i)[1]);// lastname
					pstmt.setString(3, list.get(i)[2]);// email
					pstmt.setString(4, list.get(i)[3]);// gender
					pstmt.setString(5, list.get(i)[4]);// etc
					pstmt.setString(6, list.get(i)[5]);
					pstmt.setString(7, list.get(i)[6]);
					pstmt.setString(8, list.get(i)[7]);
					pstmt.setString(9, list.get(i)[8]);
					pstmt.setString(10, list.get(i)[9]);
					pstmt.addBatch();
				}
				i++;
			}
			pstmt.executeBatch();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
